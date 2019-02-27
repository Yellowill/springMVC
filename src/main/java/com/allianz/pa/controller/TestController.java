package com.allianz.pa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.allianz.pa.dto.common.JsonRequest;
import com.allianz.pa.dto.common.JsonResponse;
import com.allianz.pa.entity.PrlCommonQuotePolicyAll;

@SuppressWarnings("restriction")
@Controller
@RequestMapping("/test")
public class TestController {
	
	//@Autowired
	//private CommonQueryService commonQueryService;

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public String doRegister(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		return String.format("test/result?id=%d", id);
	}

	@RequestMapping("/index")
	public String register(HttpServletRequest request, Model model) {
		return "test/query";
	}

	@RequestMapping("/result")
	public String profile(HttpServletRequest request, Model model) {
		/*PrlCommonQuotePolicyAll t2 = new PrlCommonQuotePolicyAll();
		t2.setContractId(1231231231);
		boolean a = testService.insert(t2);
		System.out.println(a);
		PrlCommonQuotePolicyAll user = new PrlCommonQuotePolicyAll();
		// 插入 User (插入成功会自动回写主键到实体类)
		user.setContractId(10);
		user.insert();*/
		String idStr = request.getParameter("id");
		if (null != idStr && !"".equals(idStr.trim())) {
			PrlCommonQuotePolicyAll testModel = new PrlCommonQuotePolicyAll();
			testModel.setPolicyRef("201-1-593-18-0000059201-01");
			model.addAttribute("testModel", testModel);
			return null;
		} else {
			return "test/index";
		}
	}
	
	@RequestMapping("/validate")
	public JsonResponse validate(@Valid @RequestBody JsonRequest request) {
		JsonResponse jResponse = null;
		return jResponse;
	}

}
