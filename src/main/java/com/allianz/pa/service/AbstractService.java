package com.allianz.pa.service;

import java.lang.reflect.Method;
import java.util.HashMap;

import javax.annotation.Resource;




import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.allianz.pa.common.annotation.RequestType;
import com.allianz.pa.common.consant.PolicyConst;
import com.allianz.pa.common.exception.CustomException;
import com.allianz.pa.common.util.ApplicationContextUtil;
import com.allianz.pa.common.util.Beans;
import com.allianz.pa.common.util.JsonUtil;
import com.allianz.pa.common.util.ThirdPartyCommonUtil;
import com.allianz.pa.dto.common.JsonRequest;
import com.allianz.pa.dto.common.JsonRequestBody;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.common.JsonResponse;

public abstract class AbstractService {
	private static final Logger log = Logger.getLogger(AbstractService.class);
	
	@Resource
	protected CommonService commonService;
	
	@Transactional(rollbackFor=Exception.class)
	public Object doProcess(JSONObject jsonObject,HashMap<String, Object> params) throws Exception {
		JsonRequest request = generateJsonRequest(jsonObject, params);
		JsonResponse response = null;
        try {
        	checkJsonRequest(request);
            Object result = doBizOperation(request);
            response = generalResponse(request,result);
        } catch (Exception e) {
        	e.printStackTrace();
            response = generalResponse(request,e);
        }
        return response;
    }
    
   public abstract Object doBizOperation(JsonRequest request);
   
   private JsonResponse generalResponse(JsonRequest request,Object bizResult){
	   JsonRequest jsonRequest = (JsonRequest)request;
	    if(bizResult instanceof CustomException){
	    	CustomException ex = (CustomException)bizResult;
	        return  ThirdPartyCommonUtil.createErrorResponse(jsonRequest.getHead(),Beans.isEmpty(ex.getMessage())?PolicyConst.ErrorCode.systemerror.value : ex.getMessage(),ex.getValue());
	    }else if(bizResult instanceof JsonResponse){
	        return (JsonResponse)bizResult;
	    }else{
	        return ThirdPartyCommonUtil.createErrorResponse(jsonRequest.getHead(), PolicyConst.ErrorCode.systemerror.value);
	    }
   }
   
   private JsonRequest generateJsonRequest(JSONObject jsonObject,HashMap<String, Object> params) throws Exception{
	    JsonRequest jsonRequest = new JsonRequest();
		JsonRequestHead requestHead = JsonUtil.toObject(jsonObject.get("head").toString(), JsonRequestHead.class);
		log.info("request unique code: "+requestHead.getRequestId()+" ,requestType: "+requestHead.getRequestType());
		requestHead.setRemoteHost((String)params.get(PolicyConst.REMOTE_ADDRESS));
		jsonRequest.setHead(requestHead);
		jsonRequest.setBody((JsonRequestBody)JsonUtil.toObject(jsonObject.get("body").toString(), PolicyConst.RequestType4RequestBodyMap.get(requestHead.getRequestType())));
		return jsonRequest;
   }
   
   private void checkJsonRequest(JsonRequest jsonRequest){
	   JsonRequestHead head = jsonRequest.getHead();
	   //todo validateRequestContent 
	   //validate user-password
	   String validateErrorCode = commonService.validateUserPassword(head.getUser(), head.getPassword(), head.getRemoteHost());
       if(Beans.isNotEmpty(validateErrorCode)){
           throw new CustomException(validateErrorCode);
       }
   }
   public static Method findProcessMethod(Object bean, String requestType, String method_suffix) {
	   Method method = null;
	   RequestType rt = null;
	   for(Method m: bean.getClass().getDeclaredMethods()){
		   rt = m.getAnnotation(RequestType.class);
		   if (Beans.isNotEmpty(rt) && rt.value().equals(method_suffix+requestType)) {
			   method = m;
			   break;
		   }
	   }
	   if(Beans.isEmpty(method)){
		   throw new CustomException(PolicyConst.ErrorCode.wrongRequest.value);
	   }
	   return method;
   }
   
   public static AbstractService findProcessService(String requestType) {
       Class clazz = null;
       try {
    	   clazz= PolicyConst.RequestType4ServiceBeanMap.get(requestType);
           if(clazz == null)  return null;
           return (AbstractService)ApplicationContextUtil.getContext().getBean(clazz);
       } catch (Exception e) {
           log.error("FindProcessor Exception : ", e);
       } 
       return null;
   }
}

