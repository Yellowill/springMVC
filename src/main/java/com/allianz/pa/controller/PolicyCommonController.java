package com.allianz.pa.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.allianz.pa.common.consant.PolicyConst;
import com.allianz.pa.common.util.Beans;
import com.allianz.pa.common.util.JsonUtil;
import com.allianz.pa.common.util.ThirdPartyCommonUtil;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.common.JsonResponse;
import com.allianz.pa.service.AbstractService;

@Controller
public class PolicyCommonController {
private static final Logger log = Logger.getLogger(PolicyRestController.class);
	
	@RequestMapping("/OTI-azcn-policy")
	public void issuePolicy(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HashMap<String, Object> params = new HashMap<String, Object>();
		request.setCharacterEncoding(PolicyConst.ENCODING);
		JsonResponse jResponse = null;
		JSONObject jsonObject = null;
		JsonRequestHead requestHead = null;
		try {
			String requestJsonString = IOUtils.toString(request.getInputStream(),PolicyConst.ENCODING);
			log.info("request json: " + requestJsonString);
			jsonObject = JSONObject.parseObject(requestJsonString);
		} catch (Exception e) {
            log.error(e);
            handleResponse(response,"invalid request json context!");
            return;
		}
		try {
			requestHead = JsonUtil.toObject(jsonObject.get("head").toString(), JsonRequestHead.class);
			log.info("requestType: "+requestHead.getRequestType());
			//doBizOperation
			AbstractService abstractService = AbstractService.findProcessService(requestHead.getRequestType());
			if (Beans.isEmpty(abstractService)) {
				jResponse= ThirdPartyCommonUtil.createErrorResponse(requestHead,PolicyConst.ErrorCode.wrongRequest.value);
				handleResponse(response, jResponse);
				return;
			}
			params.put(PolicyConst.REMOTE_ADDRESS, this.getIpAddr(request));
			jResponse = (JsonResponse)abstractService.doProcess(jsonObject, params);
		} catch (Exception e) {
			log.error(e);
			if(Beans.isNotEmpty(requestHead)){
				if(e instanceof ValidationException) {
					String[] strArr = e.getMessage().split(",");
					jResponse= ThirdPartyCommonUtil.createErrorResponse(requestHead,strArr[0],strArr[1]);
				}else {
					jResponse= ThirdPartyCommonUtil.createErrorResponse(requestHead,PolicyConst.ErrorCode.systemerror.value);
				}
			}else{
				 handleResponse(response, "process error");
				 return;
			}
		}
		handleResponse(response, jResponse);
	}
	
	
    @SuppressWarnings("restriction")
	private void handleResponse(HttpServletResponse response, Object msg) throws Exception {
        String contentType = PolicyConst.HTML_CONTENT_TYPE;
        String retStr = null;
        if(msg instanceof String){
        	retStr = (String)msg;
            log.info("response string :"+msg);
        }else if(msg instanceof JsonResponse){
        	contentType = PolicyConst.JSON_CONTENT_TYPE;
            retStr= JsonUtil.toJson(msg);
            log.info("response jsonStr :"+retStr);
        }else{
        	retStr = "system error";
        }
        response.setCharacterEncoding(PolicyConst.ENCODING);
        response.setContentType(contentType);
        response.getWriter().write(retStr);
        response.getWriter().flush();
    }
    
    @SuppressWarnings("restriction")
	private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknow".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
