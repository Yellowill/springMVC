package com.allianz.pa.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.allianz.pa.common.util.JsonUtil;
import com.allianz.pa.dto.common.JsonRequest;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.common.standard.AgencyVO;
import com.allianz.pa.dto.request.endorsement.common.EndorsementBody;
import com.allianz.pa.dto.request.endorsement.common.EndorsementInsured;
import com.allianz.pa.dto.request.endorsement.common.EndorsementPlan;
import com.allianz.pa.dto.request.endorsement.common.EndorsementPolicy;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) {
//		JsonRequestHead requestHead = new JsonRequestHead();
//		requestHead.setRequestType("1234");
//		AgencyVO ag = new AgencyVO();
//		ag.setAgencyCode("AC000006");
//		EndorsementPolicy endorsementPolicy = new EndorsementPolicy();
//		endorsementPolicy.setPolicyRef("201-1-543-18-010967-000-00-001");
//		EndorsementPlan plan = new EndorsementPlan();
//		EndorsementPlan plan2 = new EndorsementPlan();
//		EndorsementInsured insured = new EndorsementInsured();
//		insured.setEmail("testEmail");
//		EndorsementInsured insured2 = new EndorsementInsured();
//		insured2.setEmail("testEmail2");
//		List insuredList = new ArrayList();
//		List insuredList2 = new ArrayList();
//		insuredList.add(insured);
//		plan.setInsuredList(insuredList);
//		plan.setPlanCode("P5-ALLTESTRRT");
//		insuredList2.add(insured2);
//		plan2.setInsuredList(insuredList2);
//		plan2.setPlanCode("P5-ALLTESTRRT222");
//		List planList = new ArrayList();
//		planList.add(plan);
//		planList.add(plan2);
//		EndorsementBody body = new EndorsementBody();
//		body.setPolicy(endorsementPolicy);
//		body.setPlanList(planList);
//		body.setAgency(ag);
//		JsonRequest jsonRequest = new JsonRequest();
//		jsonRequest.setHead(requestHead);
//		jsonRequest.setBody(body);
//		JSONObject.toJSONString(jsonRequest);
		String str = "{\r\n" + 
				"	'head': {\r\n" + 
				"		'requestId': 'rk-endr-990001541762381241-39157',\r\n" + 
				"		'requestType': 'G001',\r\n" + 
				"		'user': 'BA100276_03',\r\n" + 
				"		'password': '1F19om4Q6hLcZiOtX9XpdQ',\r\n" + 
				"		'sign': 'Sign TODO...'\r\n" + 
				"	},\r\n" + 
				"	'body': {\r\n" + 
				"		'policy': {\r\n" + 
				"			'policyRef': '201-1-543-18-010967-000-00-001'\r\n" + 
				"		},\r\n" + 
				"		'agency': {\r\n" + 
				"			'agencyCode': 'AC000006'\r\n" + 
				"		},\r\n" + 
				"		'planList': [{\r\n" + 
				"				'planCode': 'P5-ALLTESTRRT',\r\n" + 
				"				'insuredList': [{\r\n" + 
				"						'insuredId': 'P0A600000001',\r\n" + 
				"						'insuredName': '曹操1',\r\n" + 
				"						'insuredType': '2',\r\n" + 
				"						'effectiveDate': '20190421000000',\r\n" + 
				"						'expireDate': '20190628000000',\r\n" + 
				"						'idType': '2',\r\n" + 
				"						'idNumber': 'E0A600000001',\r\n" + 
				"						'birthDate': '20080212000000',\r\n" + 
				"						'mobile': '15000000001',\r\n" + 
				"						'email': 'test@xxxxx.com',\r\n" + 
				"						'gender': 'F',\r\n" + 
				"						'beneficialType': '1',\r\n" + 
				"						'occupation': 'A01',\r\n" + 
				"						'actionCode': 'A',\r\n" + 
				"						'beneficiaryList': []\r\n" + 
				"					},\r\n" + 
				"					{\r\n" + 
				"						'insuredId': 'P0A600000002',\r\n" + 
				"						'insuredName': '曹操2',\r\n" + 
				"						'insuredType': '2',\r\n" + 
				"						'effectiveDate': '20190421000000',\r\n" + 
				"						'expireDate': '20190628000000',\r\n" + 
				"						'idType': '2',\r\n" + 
				"						'idNumber': 'E0A600000002',\r\n" + 
				"						'birthDate': '20080212000000',\r\n" + 
				"						'mobile': '15000000002',\r\n" + 
				"						'email': 'test@xxxxx.com',\r\n" + 
				"						'gender': 'M',\r\n" + 
				"						'beneficialType': '1',\r\n" + 
				"						'occupation': 'A01',\r\n" + 
				"						'actionCode': 'A',\r\n" + 
				"						'beneficiaryList': []\r\n" + 
				"					}\r\n" + 
				"				]\r\n" + 
				"			},\r\n" + 
				"			{\r\n" + 
				"				'planCode': 'PA222-zzzzz',\r\n" + 
				"				'insuredList': [{\r\n" + 
				"					'insuredId': 'P2B00000001',\r\n" + 
				"					'insuredName': '张三1',\r\n" + 
				"					'insuredType': '2',\r\n" + 
				"					'effectiveDate': '20190421000000',\r\n" + 
				"					'expireDate': '20190628000000',\r\n" + 
				"					'idType': '2',\r\n" + 
				"					'idNumber': 'E2A600000001',\r\n" + 
				"					'birthDate': '20080212000000',\r\n" + 
				"					'mobile': '15000000003',\r\n" + 
				"					'email': 'test@xxxxx.com',\r\n" + 
				"					'gender': 'M',\r\n" + 
				"					'beneficialType': '1',\r\n" + 
				"					'occupation': 'A01',\r\n" + 
				"					'actionCode': 'A',\r\n" + 
				"					'beneficiaryList': []\r\n" + 
				"				}]\r\n" + 
				"			}\r\n" + 
				"		]\r\n" + 
				"	}\r\n" + 
				"}";
		JSONObject jsonObject = JSONObject.parseObject(str);
		System.out.println(jsonObject.get("body").toString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			EndorsementBody body2 = mapper.readValue(jsonObject.get("body").toString(), EndorsementBody.class);
			//JSONObject.parseObject(jsonObject.get("body").toString(),EndorsementBody.class);
			System.out.println(body2.getPolicy().getPolicyRef());
			System.out.println(body2.getAgency().getAgencyCode());
			//EndorsementBody body2 = (EndorsementBody) jsonRequest2.getBody();
			body2 = JSONObject.parseObject(jsonObject.get("body").toString(),EndorsementBody.class);
			System.out.println(body2.getPolicy().getPolicyRef());
			System.out.println(body2.getAgency().getAgencyCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
//		EndorsementBody的机构为
//		protected EndorsementPolicy policy;	    
//	    protected List<EndorsementPlan> planList;   
//	    protected AgencyVO agency;
	}

}
