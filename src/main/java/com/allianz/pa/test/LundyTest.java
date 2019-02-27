package com.allianz.pa.test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.allianz.pa.common.bean.QueryResultObject;
import com.allianz.pa.common.consant.PolicyConst;
import com.allianz.pa.common.util.Beans;
import com.allianz.pa.common.util.DateUtils;
import com.allianz.pa.common.util.JsonUtil;
import com.allianz.pa.dao.PrlCommonQuotePolicyAllMapper;
import com.allianz.pa.dao.WipInterestedPartiesMapper;
import com.allianz.pa.dto.common.Agency;
import com.allianz.pa.dto.common.JsonRequest;
import com.allianz.pa.dto.common.JsonRequestBody;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.common.standard.AgencyVO;
import com.allianz.pa.dto.request.endorsement.common.EndorsementBody;
import com.allianz.pa.dto.request.endorsement.common.EndorsementPlan;
import com.allianz.pa.dto.request.endorsement.op.OPEndorsementBody;
import com.allianz.pa.dto.request.endorsement.op.OPEndorsementInsuredRisk;
import com.allianz.pa.dto.request.endorsement.op.OPEndorsementPolicy;
import com.allianz.pa.dto.request.policyconfirm.op.OPConfirmBody;
import com.allianz.pa.dto.request.policyconfirm.op.OPInsured;
import com.allianz.pa.dto.request.policyconfirm.op.OPInsuredRisk;
import com.allianz.pa.dto.request.policyconfirm.op.OPPolicy;
import com.allianz.pa.dto.request.policyconfirm.op.OPPolicyHolder;
import com.allianz.pa.entity.PrlCommonQuotePolicyAll;
import com.allianz.pa.entity.WipInterestedParties;
import com.allianz.pa.entity.WipIpLinks;
import com.allianz.pa.entity.WipIpLinksKey;
import com.allianz.pa.entity.WipPolicyContracts;
import com.allianz.pa.entity.WipPrlIpExt;
import com.allianz.pa.entity.WipPrlIpExtKey;
import com.allianz.pa.service.CommonService;
import com.allianz.pa.service.PolicyService;

public class LundyTest {

	private PolicyService policyService;
	private CommonService commonService;
	
	@Resource
	private PrlCommonQuotePolicyAllMapper prlCommonQuotePolicyAllMapper;

	@Before
	public void before() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring-mybatis.xml" });
		policyService = (PolicyService) context.getBean("policyService");
		commonService = (CommonService) context.getBean("commonService");
		prlCommonQuotePolicyAllMapper = (PrlCommonQuotePolicyAllMapper) context.getBean("prlCommonQuotePolicyAllMapper");
	}

	/*@Test
	@Transactional
	@Rollback(false)
	public void addUser() {
		PrlCommonQuotePolicyAll t = testService.getById(153016l);
		t.setLuaValue1("test");
		PrlCommonQuotePolicyAll t2 = new PrlCommonQuotePolicyAll();
		t2.setContractId(1231231231l);
		int a = testService.insert(t2);
		System.out.println(a);
		System.out.println(t.getPolicyRef());
	}*/
	
	@Test
	@Transactional
	@Rollback(false)
	public void testPolicy() {
		/*WipPolicyContracts wipPolicyContracts =policyService.getWipPolicyContracts(10623742l);
		System.out.println(wipPolicyContracts.getContractCurrency());
		WipInterestedParties wipInterestedParties = wipPolicyContracts.getWipInterestedParties4PRP();
		System.out.println(wipInterestedParties.getIpNo());
		wipPolicyContracts.setContractCurrency("RMB1");
		policyService.updateWipPolicyContracts(wipPolicyContracts);
		System.out.println(wipPolicyContracts.getContractCurrency());
		System.out.println(wipInterestedParties.getCustomerNameText());
		wipInterestedParties.setCustomerNameText("TEST");
		policyService.updateWipInterestedParties(wipInterestedParties);
		System.out.println(wipInterestedParties.getCustomerNameText());
		WipIpLinksKey wipIpLinksKey =new WipIpLinksKey();
		wipIpLinksKey.setContractId(wipInterestedParties.getContractId());
		wipIpLinksKey.setIpLinkNo(wipInterestedParties.getIpNo());
		wipIpLinksKey.setIpNo(wipInterestedParties.getIpNo());
		WipIpLinks wipIpLinks = policyService.getWipIpLinks(wipIpLinksKey);
		WipPrlIpExtKey wipPrlIpExtKey =new WipPrlIpExtKey();
		wipPrlIpExtKey.setContractId(wipInterestedParties.getContractId());
		wipPrlIpExtKey.setIpNo(wipInterestedParties.getIpNo());
		WipPrlIpExt wipPrlIpExt = policyService.getWipPrlIpExt(wipPrlIpExtKey);
		wipInterestedParties.setWipIpLinks(wipIpLinks);
		wipInterestedParties.setWipPrlIpExt(wipPrlIpExt);
		wipIpLinks.setCoverNo(123);
		wipPrlIpExt.setRemark("TEST");
		policyService.updateWipIpLinks(wipIpLinks);
		policyService.updateWipPrlIpExt(wipPrlIpExt);
		System.out.println(wipIpLinks.getCoverNo());
		System.out.println(wipPrlIpExt.getRemark());*/
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testCommon() {
		/*QueryResultObject qbo = commonQueryService.getPolicyRefBycontractId(10623742l);
		System.out.println(qbo.getPolicyRef());*/
	}
	
	@Test
	public void testJson() throws Exception {
		JsonRequest jr = new JsonRequest();
		
		JsonRequestHead head = new JsonRequestHead();
		head.setRequestId("requestId12345678");
		head.setUser("BA000081_02");
		head.setPassword("bc0TYXab4UjcZiOtX9XpdQ");
		head.setSign("加密字符串待出单成功后再开发");
		head.setRequestType(PolicyConst.RequestType.REQ_TYPE_POLICYCONFIRM_OP);
		jr.setHead(head);
		
		OPConfirmBody body = new OPConfirmBody();
		jr.setBody(body);
		
		OPPolicy policy = new OPPolicy();
		policy.setPlanCode("TestBrokenScreen1");
		policy.setAgencyPolicyRef("JD2017062059110669977");
		policy.setEffectiveDate(DateUtils.parse4yyyyMMddHHmmss("2018-08-08 10:10:10"));
		policy.setExpireDate(DateUtils.parse4yyyyMMddHHmmss("2019-08-08 10:10:10"));
		policy.setIssueDate(DateUtils.parse4yyyyMMddHHmmss("2018-08-07 10:10:10"));
		policy.setRemark("备注");
		body.setPolicy(policy);
		
		Agency agency = new Agency();
		agency.setAgencyCode("BA000081");
		body.setAgency(agency);
		
		OPPolicyHolder policyHolder = new OPPolicyHolder();
		policyHolder.setBirthDate(DateUtils.parse4yyyyMMddHHmmss("1988-08-08 00:00:00"));
		policyHolder.setClientRef("I");
		policyHolder.setHotlineTelNo("13609043689");
		policyHolder.setInsuredBusiness("安联财产保险公司");
		policyHolder.setLongName("AZCN");
		policyHolder.setOverrideAddress("珠江新城IFC");
		policyHolder.setPeriodOfInsurance("510505");
		policyHolder.setPolicyNo("E1234556");
		policyHolder.setRemark("test@allian.com");
		policyHolder.setReqElecFaPiao("Y");
		policyHolder.setRoleTypeId(3);
		body.setPolicyHolder(policyHolder);
		
		ArrayList<OPInsured> insuredsList = new ArrayList<OPInsured>();
		body.setInsuredList(insuredsList);
		
		OPInsured insured1 = new OPInsured();
		insured1.setName("被保险人1");
		insured1.setBeneficialType("1");
		insured1.setDob(DateUtils.parse4yyyyMMddHHmmss("1988-08-08 00:00:00"));
		insured1.setInsuredType("1");
		insured1.setMobileNo("13609043689");
		insured1.setPartInsuredId("1");
		insured1.setIdNo("E1234556");
		insured1.setEmail("test@allian.com");
		insured1.setIdType(3);
		insured1.setSex("M");
		insured1.setJdAccount("jd_52105b057bdb2");
		insuredsList.add(insured1);
		
		List<OPInsuredRisk> insuredRiskList11 = new ArrayList<OPInsuredRisk>();
		OPInsuredRisk OTIInsuredRisk111 = new OPInsuredRisk();
		OTIInsuredRisk111.setMallOrderId("123-111");
		OTIInsuredRisk111.setMallPolicyId("321");
		OTIInsuredRisk111.setProdCategory("手机");
		OTIInsuredRisk111.setProdBrand("苹果");
		OTIInsuredRisk111.setProdModel("7plus");
		OTIInsuredRisk111.setProdSize("4.5");
		OTIInsuredRisk111.setOrderPrice(new BigDecimal("4999.25"));
		OTIInsuredRisk111.setPolicyPrice(new BigDecimal("9.25"));
		OTIInsuredRisk111.setPremium(new BigDecimal("1.25"));
		OTIInsuredRisk111.setEquipmentId("98776654");
		OTIInsuredRisk111.setOrderDate(DateUtils.parse4yyyyMMddHHmmss("2018-08-07 08:10:10"));
		OTIInsuredRisk111.setGuaranteePeriodMonths(12);
		OTIInsuredRisk111.setPolicyPeriodMonths(12);
		OTIInsuredRisk111.setEffectiveDateTime(DateUtils.parse4yyyyMMddHHmmss("2018-08-08 10:10:10"));
		OTIInsuredRisk111.setEndDateTime(DateUtils.parse4yyyyMMddHHmmss("2019-08-08 10:10:10"));
		OTIInsuredRisk111.setThirdPartPin("d1241232312");
		OTIInsuredRisk111.setLocationTo("广东");
		OTIInsuredRisk111.setCityTo("广州");
		OTIInsuredRisk111.setAddressTo("白云区");
		OTIInsuredRisk111.setSumInsured(new BigDecimal("11.25"));
		insuredRiskList11.add(OTIInsuredRisk111);
		
		OPInsuredRisk OTIInsuredRisk112 = new OPInsuredRisk();
		OTIInsuredRisk112.setMallOrderId("123-112");
		OTIInsuredRisk112.setMallPolicyId("321");
		OTIInsuredRisk112.setProdCategory("手机");
		OTIInsuredRisk112.setProdBrand("苹果");
		OTIInsuredRisk112.setProdModel("7plus");
		OTIInsuredRisk112.setProdSize("4.5");
		OTIInsuredRisk112.setOrderPrice(new BigDecimal("4999.25"));
		OTIInsuredRisk112.setPolicyPrice(new BigDecimal("9.25"));
		OTIInsuredRisk112.setPremium(new BigDecimal("1.25"));
		OTIInsuredRisk112.setEquipmentId("98776654");
		OTIInsuredRisk112.setOrderDate(DateUtils.parse4yyyyMMddHHmmss("2018-08-07 08:10:10"));
		OTIInsuredRisk112.setGuaranteePeriodMonths(12);
		OTIInsuredRisk112.setPolicyPeriodMonths(12);
		OTIInsuredRisk112.setEffectiveDateTime(DateUtils.parse4yyyyMMddHHmmss("2018-08-08 10:10:10"));
		OTIInsuredRisk112.setEndDateTime(DateUtils.parse4yyyyMMddHHmmss("2019-08-08 10:10:10"));
		OTIInsuredRisk112.setThirdPartPin("d1241232312");
		OTIInsuredRisk112.setLocationTo("广东");
		OTIInsuredRisk112.setCityTo("广州");
		OTIInsuredRisk112.setAddressTo("白云区");
		OTIInsuredRisk112.setSumInsured(new BigDecimal("16.25"));
		insuredRiskList11.add(OTIInsuredRisk112);
		//insured1.setInsuredRiskList(insuredRiskList11);
		
		OPInsured insured2 = new OPInsured();
		insured2.setName("被保险人2");
		insured2.setBeneficialType("1");
		insured2.setDob(DateUtils.parse4yyyyMMddHHmmss("1988-08-08 00:00:00"));
		insured1.setInsuredType("1");
		insured1.setMobileNo("13609043689");
		insured1.setPartInsuredId("1");
		insured1.setIdNo("E1234556");
		insured1.setEmail("test@allian.com");
		insured1.setIdType(3);
		insured1.setSex("M");
		insured1.setJdAccount("jd_52105b057bdb2");
		insuredsList.add(insured2);
		
		List<OPInsuredRisk> insuredRiskList21 = new ArrayList<OPInsuredRisk>();
		OPInsuredRisk OTIInsuredRisk211 = new OPInsuredRisk();
		OTIInsuredRisk211.setMallOrderId("123-211");
		OTIInsuredRisk211.setMallPolicyId("321");
		OTIInsuredRisk211.setProdCategory("手机");
		OTIInsuredRisk211.setProdBrand("苹果");
		OTIInsuredRisk211.setProdModel("7plus");
		OTIInsuredRisk211.setProdSize("4.5");
		OTIInsuredRisk211.setOrderPrice(new BigDecimal("4999.25"));
		OTIInsuredRisk211.setPolicyPrice(new BigDecimal("9.25"));
		OTIInsuredRisk211.setPremium(new BigDecimal("1.25"));
		OTIInsuredRisk211.setEquipmentId("98776654");
		OTIInsuredRisk211.setOrderDate(DateUtils.parse4yyyyMMddHHmmss("2018-08-07 08:10:10"));
		OTIInsuredRisk211.setGuaranteePeriodMonths(12);
		OTIInsuredRisk211.setPolicyPeriodMonths(12);
		OTIInsuredRisk211.setEffectiveDateTime(DateUtils.parse4yyyyMMddHHmmss("2018-08-08 10:10:10"));
		OTIInsuredRisk211.setEndDateTime(DateUtils.parse4yyyyMMddHHmmss("2019-08-08 10:10:10"));
		OTIInsuredRisk211.setThirdPartPin("d1241232312");
		OTIInsuredRisk211.setLocationTo("广东");
		OTIInsuredRisk211.setCityTo("广州");
		OTIInsuredRisk211.setAddressTo("白云区");
		insuredRiskList21.add(OTIInsuredRisk211);
		
		OPInsuredRisk OTIInsuredRisk212 = new OPInsuredRisk();
		OTIInsuredRisk212.setMallOrderId("123-212");
		OTIInsuredRisk212.setMallPolicyId("321");
		OTIInsuredRisk212.setProdCategory("手机");
		OTIInsuredRisk212.setProdBrand("苹果");
		OTIInsuredRisk212.setProdModel("7plus");
		OTIInsuredRisk212.setProdSize("4.5");
		OTIInsuredRisk212.setOrderPrice(new BigDecimal("4999.25"));
		OTIInsuredRisk212.setPolicyPrice(new BigDecimal("9.25"));
		OTIInsuredRisk212.setPremium(new BigDecimal("1.25"));
		OTIInsuredRisk212.setEquipmentId("98776654");
		OTIInsuredRisk212.setOrderDate(DateUtils.parse4yyyyMMddHHmmss("2018-08-07 08:10:10"));
		OTIInsuredRisk212.setGuaranteePeriodMonths(12);
		OTIInsuredRisk212.setPolicyPeriodMonths(12);
		OTIInsuredRisk212.setEffectiveDateTime(DateUtils.parse4yyyyMMddHHmmss("2018-08-08 10:10:10"));
		OTIInsuredRisk212.setEndDateTime(DateUtils.parse4yyyyMMddHHmmss("2019-08-08 10:10:10"));
		OTIInsuredRisk212.setThirdPartPin("d1241232312");
		OTIInsuredRisk212.setLocationTo("广东");
		OTIInsuredRisk212.setCityTo("广州");
		OTIInsuredRisk212.setAddressTo("白云区");
		
		OTIInsuredRisk212.setMallSku("MallSku");
		OTIInsuredRisk212.setMallPolicySku("123123");
		OTIInsuredRisk212.setAlEffectiveDate(DateUtils.parse4yyyyMMddHHmmss("2018-08-08 10:10:10"));
		OTIInsuredRisk212.setAlEndDate(DateUtils.parse4yyyyMMddHHmmss("2019-08-08 10:10:10"));
		OTIInsuredRisk212.setAlPeriodDays(30);
		OTIInsuredRisk212.setWtePeriodDays(30);
		OTIInsuredRisk212.setWholeWtePeriodDays(30);
		OTIInsuredRisk212.setMainPartWtePeriodDays(30);
		OTIInsuredRisk212.setGtStartDate(DateUtils.parse4yyyyMMddHHmmss("2018-08-08 10:10:10"));
		OTIInsuredRisk212.setGtEndDate(DateUtils.parse4yyyyMMddHHmmss("2019-08-08 10:10:10"));
		OTIInsuredRisk212.setServiceStartDate(DateUtils.parse4yyyyMMddHHmmss("2018-08-08 10:10:10"));
		OTIInsuredRisk212.setServiceEndDate(DateUtils.parse4yyyyMMddHHmmss("2019-08-08 10:10:10"));
		insuredRiskList21.add(OTIInsuredRisk212);
		insured2.setInsuredRiskList(insuredRiskList21);
		System.out.println(JsonUtil.toJson(jr));
	}
	
	@Test
	public void testIssuePolicy() throws Exception {
		JsonRequest jr = new JsonRequest();
		//policyService.issuePolicy4BrokenScreen(jr);
	}
	
	@Test
	public void testOPEndorsementJson() throws Exception {
		JsonRequest jr = new JsonRequest();
		
		JsonRequestHead head = new JsonRequestHead();
		head.setRequestId("requestId12345678");
		head.setUser("BA000081");
		head.setPassword("bc0TYXab4UjcZiOtX9XpdQ");
		head.setSign("加密字符串待出单成功后再开发");
		head.setRequestType("JD_Other_NewPolicy");
		jr.setHead(head);
		
		OPEndorsementBody body = new OPEndorsementBody();
		jr.setBody(body);
		
		OPEndorsementPolicy policy = new OPEndorsementPolicy();
		policy.setAgencyPolicyRef("JD2017062059110669977");
		policy.setPolicyRef("201-1-399-18-0000000062-00");
		policy.setChangeDesc("批单内容");
		body.setPolicy(policy);
		
		List<OPEndorsementInsuredRisk> list = new ArrayList<OPEndorsementInsuredRisk>();
		body.setInsuredRiskList(list);
		OPEndorsementInsuredRisk OTIInsuredRisk1 = new OPEndorsementInsuredRisk();
		OTIInsuredRisk1.setThirdPartPolicyNo("标的主键1");
		OTIInsuredRisk1.setActionCode("D");
		OTIInsuredRisk1.setMallOrderId("123-212");
		OTIInsuredRisk1.setMallPolicyId("321");
		OTIInsuredRisk1.setProdCategory("手机");
		OTIInsuredRisk1.setProdBrand("苹果");
		OTIInsuredRisk1.setProdModel("7plus");
		OTIInsuredRisk1.setProdSize("4.5");
		OTIInsuredRisk1.setOrderPrice(new BigDecimal("4999.25"));
		OTIInsuredRisk1.setPolicyPrice(new BigDecimal("9.25"));
		OTIInsuredRisk1.setPremium(new BigDecimal("1.25"));
		OTIInsuredRisk1.setEquipmentId("98776654");
		OTIInsuredRisk1.setOrderDate(DateUtils.parse4yyyyMMddHHmmss("2018-08-07 08:10:10"));
		OTIInsuredRisk1.setGuaranteePeriodMonths(12);
		OTIInsuredRisk1.setPolicyPeriodMonths(12);
		OTIInsuredRisk1.setEffectiveDateTime(DateUtils.parse4yyyyMMddHHmmss("2018-08-08 10:10:10"));
		OTIInsuredRisk1.setEndDateTime(DateUtils.parse4yyyyMMddHHmmss("2019-08-08 10:10:10"));
		OTIInsuredRisk1.setThirdPartPin("d1241232312");
		OTIInsuredRisk1.setLocationTo("广东");
		OTIInsuredRisk1.setCityTo("广州");
		OTIInsuredRisk1.setAddressTo("白云区");
		list.add(OTIInsuredRisk1);
		
		OPEndorsementInsuredRisk OTIInsuredRisk2 = new OPEndorsementInsuredRisk();
		OTIInsuredRisk2.setActionCode("A");
		OTIInsuredRisk2.setThirdPartPolicyNo("标的主键2");
		OTIInsuredRisk2.setMallOrderId("123-212");
		OTIInsuredRisk2.setMallPolicyId("321");
		OTIInsuredRisk2.setProdCategory("手机");
		OTIInsuredRisk2.setProdBrand("苹果");
		OTIInsuredRisk2.setProdModel("7plus");
		OTIInsuredRisk2.setProdSize("4.5");
		OTIInsuredRisk2.setOrderPrice(new BigDecimal("4999.25"));
		OTIInsuredRisk2.setPolicyPrice(new BigDecimal("9.25"));
		OTIInsuredRisk2.setPremium(new BigDecimal("1.25"));
		OTIInsuredRisk2.setEquipmentId("98776654");
		OTIInsuredRisk2.setOrderDate(DateUtils.parse4yyyyMMddHHmmss("2018-08-07 08:10:10"));
		OTIInsuredRisk2.setGuaranteePeriodMonths(12);
		OTIInsuredRisk2.setPolicyPeriodMonths(12);
		OTIInsuredRisk2.setEffectiveDateTime(DateUtils.parse4yyyyMMddHHmmss("2018-08-08 10:10:10"));
		OTIInsuredRisk2.setEndDateTime(DateUtils.parse4yyyyMMddHHmmss("2019-08-08 10:10:10"));
		OTIInsuredRisk2.setThirdPartPin("d1241232312");
		OTIInsuredRisk2.setLocationTo("广东");
		OTIInsuredRisk2.setCityTo("广州");
		OTIInsuredRisk2.setAddressTo("白云区");
		list.add(OTIInsuredRisk2);
		
		System.out.println(JsonUtil.toJson(jr));
	}
	
	@Test
	@Transactional(rollbackFor=Exception.class)
	public void testTransation() {
		policyService.testTX();
		/*PrlCommonQuotePolicyAll prlCommonQuotePolicyAll = new PrlCommonQuotePolicyAll();
        prlCommonQuotePolicyAll.setInsuredName("TEST");
        prlCommonQuotePolicyAll.setBranchCode("201");
        prlCommonQuotePolicyAll.setSalesCode("TEST");
        if(Beans.isEmpty(prlCommonQuotePolicyAll.getApplicationDate()) && Beans.isEmpty(prlCommonQuotePolicyAll.getIssueDate())){
        	prlCommonQuotePolicyAll.setApplicationDate(new Date());
        }
        prlCommonQuotePolicyAll.setSalesChannel("1743");
        prlCommonQuotePolicyAll.setContractCurrency("rm");
        prlCommonQuotePolicyAllMapper.insertSelective(prlCommonQuotePolicyAll);
        
		PrlCommonQuotePolicyAll prlCommonQuotePolicyAll2 = new PrlCommonQuotePolicyAll();
		prlCommonQuotePolicyAll2.setInsuredName("TEST");
        prlCommonQuotePolicyAll2.setBranchCode("201");
        prlCommonQuotePolicyAll2.setSalesCode("TEST");
        if(Beans.isEmpty(prlCommonQuotePolicyAll.getApplicationDate()) && Beans.isEmpty(prlCommonQuotePolicyAll.getIssueDate())){
        	prlCommonQuotePolicyAll2.setApplicationDate(new Date());
        }
        prlCommonQuotePolicyAll2.setSalesChannel("1743");
        prlCommonQuotePolicyAll2.setContractCurrency("rmrmrmrmrmrmrmrmrmrmrmrmrmrmrmrmrmrm");
        prlCommonQuotePolicyAllMapper.insertSelective(prlCommonQuotePolicyAll2);*/
	}
	
	@Test
	@Transactional(rollbackFor=Exception.class)
	public void testTransation2() {
		String file = "D:/reports/1.txt";
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			String jsonString = IOUtils.toString(new FileInputStream(file));
			JSONObject jsonObject = JSONObject.parseObject(jsonString);
			//JsonRequest jsonRequest =JsonUtil.toObject(jsonString, JsonRequest.class);
			//policyService.doProcess(jsonObject, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
	}
	
	public static void main(String[] args) {
		String jsonString = "{\r\n" + 
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
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		try {
			System.out.println(jsonObject.get("body").toString());
			JsonRequest jsonRequest = generateJsonRequest(jsonObject);
			System.out.println(JSONObject.toJSONString(jsonRequest));
			//G001
			System.out.println(jsonRequest.getHead().getRequestType());
			EndorsementBody body = (EndorsementBody) jsonRequest.getBody();
			List list = body.getPlanList();
			EndorsementPlan plan = (EndorsementPlan) list.get(0);
			System.out.println(plan.getPlanCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static JsonRequest generateJsonRequest(JSONObject jsonObject) throws Exception{
		    JsonRequest jsonRequest = new JsonRequest();
			JsonRequestHead requestHead = JsonUtil.toObject(jsonObject.get("head").toString(), JsonRequestHead.class);
			jsonRequest.setHead(requestHead);
			jsonRequest.setBody(JsonUtil.toObject(jsonObject.get("body").toString(), EndorsementBody.class));
			return jsonRequest;
	   }
}

