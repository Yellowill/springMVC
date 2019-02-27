package com.allianz.pa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.allianz.pa.common.annotation.RequestType;
import com.allianz.pa.common.bean.PartnerInfo;
import com.allianz.pa.common.bean.PlanInfo;
import com.allianz.pa.common.bean.QueryResultObject;
import com.allianz.pa.common.bean.UserInfo;
import com.allianz.pa.common.consant.PolicyConst;
import com.allianz.pa.common.util.Beans;
import com.allianz.pa.common.util.ResourceUtil;
import com.allianz.pa.dto.common.JsonRequest;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.common.standard.CompanyInfoVO;
import com.allianz.pa.dto.common.standard.PolicyHolderVO;
import com.allianz.pa.dto.request.endorsement.common.EndorsementBody;
import com.allianz.pa.dto.request.endorsement.common.EndorsementPlan;
import com.allianz.pa.dto.request.endorsement.common.EndorsementPolicy;
import com.allianz.pa.dto.request.policyconfirm.group.GPConfirmBody;
import com.allianz.pa.dto.request.policyconfirm.group.GPPolicy;
import com.allianz.pa.service.AbstractPolicyGroupService;
import com.allianz.pa.service.PolicyCheckService;

@Service("policyCheckService")
public class PolicyCheckServiceImpl extends AbstractPolicyGroupService implements PolicyCheckService {
	private static final Logger log = Logger.getLogger(PolicyCheckServiceImpl.class);
	
	@Resource
	DataSourceTransactionManager transactionManager;
	
	@RequestType(AbstractPolicyGroupService.INIT+PolicyConst.RequestType.REQ_TYPE_POLICYCHECK_GROUP)
	public Object initEndorForThird(JsonRequest jsonRequest) {
		initGPEndorsement(jsonRequest);
		return null;
	}
	
	@RequestType(AbstractPolicyGroupService.EXECUTE+PolicyConst.RequestType.REQ_TYPE_POLICYCHECK_GROUP)
	public QueryResultObject executeEndorsementOTI(JsonRequest jsonRequest) {
		JsonRequestHead requestHead = jsonRequest.getHead();
		EndorsementBody body = (EndorsementBody) jsonRequest.getBody();
		UserInfo user = commonService.getUserInfo(requestHead.getUser());
    	//团险批改校验
    	validateInsuredInfo(jsonRequest);
    	//非团险校验(包含黑名单校验)
    	validatePolicy(user,jsonRequest);
    	//校验渠道
    	validateAgency(body.getAgency().getAgencyCode());
    	//校验机构
    	validateInstitution(user.getUserCode());
    	
    	//确认没有错误信息才去计算保费
    	if(Beans.isNotEmpty(errorList)) {
    		return null;
    	}
		log.info("---核保接口保费计算---");
		QueryResultObject prePolicy = commonService.getPolicyInfoByRef(body.getPolicy().getPolicyRef());
		Long contractId = prePolicy.getContractId();
		
		return calculateTotalPreium(jsonRequest,contractId);
	}
	
	@RequestType(AbstractPolicyGroupService.INIT+PolicyConst.RequestType.REQ_TYPE_CONFIRMCHECK_GROUP)
	public Object initNewPolicyContractForOTI(JsonRequest jsonRequest) {
		initGPOP(jsonRequest);
		//团险批改校验--setPlanCode
		validateInsuredInfo(jsonRequest);
		JsonRequestHead requestHead = jsonRequest.getHead();
		GPConfirmBody body = (GPConfirmBody) jsonRequest.getBody();
		EndorsementPolicy policy = body.getPolicy();
		PolicyHolderVO holder= body.getPolicyHolder();
		UserInfo user = commonService.getUserInfo(requestHead.getUser());
        if(Beans.isNotEmpty(holder.getPhEmail()) && !Beans.checkEmail(holder.getPhEmail())){
			setErrorInfo(errorList,"1116",ResourceUtil.errorCodeMsg("1116"));
        }
        PartnerInfo agencyInfo = commonService.getAgencyInfo(body.getAgency().getAgencyCode());
		PlanInfo planVo = commonService.getAssignedPlanInfoByPlanCode(user.getUserCode(), agencyInfo.getPartId(), user.getBranchCode(), policy.getPlanCode(), new java.sql.Date(policy.getEffectiveDate().getTime()));
		if(Beans.isEmpty(planVo)) {
			setErrorInfo(errorList,"1007",ResourceUtil.errorCodeMsg("1007"));
		}
        if(Beans.isNotEmpty(user.getBranchCode()) && !commonService.checkBranchEffective(user.getBranchCode())){
            setErrorInfo(errorList,"1355",ResourceUtil.errorCodeMsg("1355"));
        }
    	//非团险校验(包含黑名单校验)
    	validatePolicy(user,jsonRequest);
    	//校验渠道
    	validateAgency(body.getAgency().getAgencyCode());
    	//校验机构
    	validateInstitution(user.getUserCode());
		return null;
	}
	
	@RequestType(AbstractPolicyGroupService.EXECUTE+PolicyConst.RequestType.REQ_TYPE_CONFIRMCHECK_GROUP)
	public QueryResultObject executeNewPolicyContractForOTI(JsonRequest jsonRequest) {
    	
    	//确认没有错误信息才去计算保费
    	if(Beans.isNotEmpty(errorList)) {
    		return null;
    	}
		log.info("---核保接口保费计算---");
		
		return calculateTotalPreium(jsonRequest,null);
	}
}
