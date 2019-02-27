package com.allianz.pa.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.allianz.pa.common.bean.AppParameterInfo;
import com.allianz.pa.common.bean.BenefitInfo;
import com.allianz.pa.common.bean.PartnerInfo;
import com.allianz.pa.common.bean.PlanInfo;
import com.allianz.pa.common.bean.QueryResultObject;
import com.allianz.pa.common.bean.UserInfo;
import com.allianz.pa.common.consant.PolicyConst;
import com.allianz.pa.common.exception.CustomException;
import com.allianz.pa.common.util.Beans;
import com.allianz.pa.common.util.DesEncodeUtil;
import com.allianz.pa.common.util.ThirdPartyCommonUtil;
import com.allianz.pa.controller.PolicyRestController;
import com.allianz.pa.dao.CommonMapper;
import com.allianz.pa.dao.PrlCommonQuotePolicyAllMapper;
import com.allianz.pa.dao.PrlThirdpInterfPolDataMapper;
import com.allianz.pa.dto.common.JsonRequest;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.common.JsonResponse;
import com.allianz.pa.dto.common.JsonResponseBody;
import com.allianz.pa.dto.common.standard.InsuredPremium;
import com.allianz.pa.dto.common.standard.UnderwritingDecision;
import com.allianz.pa.dto.request.endorsement.common.EndorsementBody;
import com.allianz.pa.dto.request.endorsement.common.EndorsementPolicy;
import com.allianz.pa.dto.request.endorsement.op.OPEndorsementBody;
import com.allianz.pa.dto.request.endorsement.op.OPEndorsementPolicy;
import com.allianz.pa.dto.request.policyconfirm.op.OPConfirmBody;
import com.allianz.pa.dto.request.policyconfirm.op.OPPolicy;
import com.allianz.pa.entity.PrlThirdpInterfPolData;
import com.allianz.pa.entity.PrlThirdpInterfPolDataKey;
import com.allianz.pa.service.CommonService;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	private static final Logger log = Logger.getLogger(CommonServiceImpl.class);
	@Resource
	private CommonMapper commonMapper;
	
	@Resource
	protected PrlThirdpInterfPolDataMapper prlThirdpInterfPolDataMapper;
	
	@Resource
	protected PrlCommonQuotePolicyAllMapper prlCommonQuotePolicyAllMapper;

	@Override
	@Transactional(readOnly=true)
	public QueryResultObject getPolicyInfoBycontractId(long contractId) {
		return commonMapper.getPolicyInfoBycontractId(contractId);
	}

	@Override
	@Transactional
	public Map<String, Object> newBusiness(Map<String, Object> inParam) {
		return commonMapper.newBusiness4Others(inParam);
	}

	@Override
	@Transactional(readOnly=true)
	public UserInfo getUserInfo(String userCode) {
		return commonMapper.getUserInfo(userCode);
	}

	@Override
	@Transactional(readOnly=true)
	public PartnerInfo getAgencyInfo(String agencyCode) {
		return commonMapper.getAgencyInfo(agencyCode);
	}

	@Override
	@Transactional(readOnly=true)
	public PlanInfo getAssignedPlanInfoByPlanCode(String userCode,
			Integer partId, String branchCode, String planCode,
			java.sql.Date effectiveDate) {
		return commonMapper.getAssignedPlanInfoByPlanCode(userCode,
				partId, branchCode, planCode, effectiveDate);
	}

	@Override
	@Transactional(readOnly=true)
	public List<QueryResultObject> customQuery(String sql) {
		return commonMapper.customQuery(sql);
	}

	@Override
	@Transactional(readOnly=true)
	public QueryResultObject getAgencySalesInfo(Integer partId, long contractId) {
		return commonMapper.getAgencySalesInfo(partId, contractId);
	}

	@Override
	@Transactional(readOnly=true)
	public PartnerInfo getCustomerInfo(String customerCode) {
		return commonMapper.getCustomerInfo(customerCode);
	}

	@Override
	@Transactional(readOnly=true)
	public PartnerInfo getTPAInfo(Integer partId) {
		return commonMapper.getTPAInfo(partId);
	}

	@Override
	@Transactional(readOnly=true)
	public Map<String, Object> getCommissionRate(Map<String, Object> inParam) {
		return commonMapper.getCommissionRate(inParam);
	}

	@Override
	@Transactional(readOnly=true)
	public long getSequenceValue(String sequenceName) {
		List<QueryResultObject> list = this.customQuery("select "
				+ sequenceName + ".nextval sequence_value from dual");
		return list.get(0).getSequenceValue();
	}

	@Override
	@Transactional(readOnly=true)
	public List<BenefitInfo> getPlanBenefitInfo(Integer planId,
			Integer planVersionNo) {
		return commonMapper.getPlanBenefitInfo(planId, planVersionNo);
	}

	@Override
	@Transactional
	public Map<String, Object> preIssuePolicy4Others(Map<String, Object> inParam) {
		return commonMapper.preIssuePolicy4Others(inParam);
	}

	@Override
	@Transactional
	public Map<String, Object> issuePolicy4Others(Map<String, Object> inParam) {
		return commonMapper.issuePolicy4Others(inParam);
	}

	@Override
	@Transactional
	public Integer doBookingSettle4Others(long contractId) {
		Map<String, Object> inParam = new HashMap<String, Object>();
		inParam.put("p_contract_id", contractId);
		inParam.put("p_result", null);
		commonMapper.doBookingSettle4Others(inParam);
		if (Beans.isNotEmpty(inParam.get("p_result"))) {
			return ((BigDecimal) inParam.get("p_result")).intValue();
		}
		return null;
	}

	@Override
	@Transactional
	public Map<String, Object> preIssuePolicyForOTI(Map<String, Object> inParam) {
		return commonMapper.preIssuePolicyForOTI(inParam);
	}

	@Override
	@Transactional
	public Map<String, Object> issuePolicyForOTI(Map<String, Object> inParam) {
		return commonMapper.issuePolicyForOTI(inParam);
	}

	@Override
	@Transactional
	public Integer doBookingSettleForOTI(long contractId) {
		Map<String, Object> inParam = new HashMap<String, Object>();
		inParam.put("p_contract_id", contractId);
		inParam.put("p_result", null);
		commonMapper.doBookingSettleForOTI(inParam);
		if (Beans.isNotEmpty(inParam.get("p_result"))) {
			return ((BigDecimal) inParam.get("p_result")).intValue();
		}
		return null;
	}
	@Override
	@Transactional(readOnly=true)
	public BigDecimal getExchRate(String currency,Date effectDate) {
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("PFM_CURR", currency);
        map.put("PTO_CURR", PolicyConst.RMB);
        map.put("PEFF_DATE", new java.sql.Date(effectDate.getTime()));
        map.put("PAMOUNT", 0);
        map.put("PEXCH_RATE", null);
        map.put("PCONVERTED_AMT", null);
        map.put("p_result", null);
		commonMapper.getExchRate(map);
		Object obj = map.get("PEXCH_RATE");
		if (Beans.isEmpty(obj)) {
			return null;
		}
		return new BigDecimal(obj.toString());
	}

	@Override
	@Transactional(readOnly=true)
	public String getPolicyOriginator(long contractId) {
		QueryResultObject qro = commonMapper.getPolicyOriginator(contractId);
		if(Beans.isNotEmpty(qro)){
			return qro.getPolicyOriginator();
		}
		return null;
	}

	@Override
	@Transactional
	public String validateUserPassword(String userCode, String encryptionPassword,String remoteHost) {
		log.info("userCode: "+userCode +" ,passWord密文: "+encryptionPassword);
		String errorCode=null;
		String password = null;
		try {
			password = DesEncodeUtil.getDesStringWithKey(encryptionPassword, PolicyConst.PASSWORD_KEY);
            if(Beans.isEmpty(password)){
            	log.error("密码解密失败.");
            	return PolicyConst.ErrorCode.DecryptionFail.value;
            }
        } catch (Exception e) {
            log.error("密码解密失败: ",e);
            return PolicyConst.ErrorCode.DecryptionFail.value;
        }
        log.info("passWord明文:"+password);
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("p_user_name", userCode);
        map.put("p_password", password);
        map.put("p_ret_status", null);
        map.put("p_fail_attempts", 0);
        map.put("p_client_ip_address", remoteHost);
        commonMapper.validateUserPassword(map);
		Object retStatus = map.get("p_ret_status");
		if(Beans.isEmpty(retStatus)){
			errorCode=PolicyConst.ErrorCode.loginFail.value;
		}else{
			if(!PolicyConst.LogOnError.success.value.equals(retStatus.toString()) && !PolicyConst.LogOnError.successButOutDate.value.equals(retStatus.toString()) ){
				if(PolicyConst.LogOnError.errorUserOrPass.value.equals(retStatus.toString())){
					errorCode = PolicyConst.ErrorCode.WrongUserCodeOrPassword.value;
				}else if(PolicyConst.LogOnError.userOrPassOutDate.value.equals(retStatus.toString())){
					errorCode = PolicyConst.ErrorCode.OutDateUserOrPassword.value;
				}else if(PolicyConst.LogOnError.userLocked.value.equals(retStatus.toString())){
					errorCode = PolicyConst.ErrorCode.UserLocked.value;
				}else{
					errorCode = PolicyConst.ErrorCode.loginFail.value;
				}
			}
		}
		return errorCode;
	}
	@Override
	@Transactional(readOnly=true)
	public QueryResultObject getSuccessPolicy(long contractId) {
		return commonMapper.getAllreadySuccessPolicyInfo(contractId);
	}

	@Override
	@Transactional(readOnly=true)
	public JsonResponse getAllreadySuccessPolicy(JsonRequestHead head, long contractId) {
		QueryResultObject qro = commonMapper.getAllreadySuccessPolicyInfo(contractId);
		JsonResponse jr = ThirdPartyCommonUtil.createErrorResponse(head, PolicyConst.ErrorCode.SUCCESS.value);
		JsonResponseBody body = new JsonResponseBody();
		body.setAgencyPolicyRef(qro.getPolicyOriginator());
		body.setPolicyRef(qro.getPolicyRef());
		body.setPolicyStatus(qro.getPolicyStatus());
		body.setTotalPremium(qro.getTotalPremium());
		body.setAdjustmentPremium(qro.getAdjustmentPremium());
		if(!head.getRequestType().equals(PolicyConst.RequestType.REQ_TYPE_ENDORSEMENT_GROUP)) {
			body.setSumInsured(qro.getSumInsured());
			body.setEffectiveDate(qro.getEffectiveDate());
			body.setExpireDate(qro.getExpireDate());
		}
		jr.setBody(body);
		return jr;
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long validatePolicyIsExist(String userCode, String policyOriginator) {
		QueryResultObject qro = commonMapper.validatePolicyIsExist(userCode, policyOriginator);
		if(Beans.isNotEmpty(qro) && Beans.isNotEmpty(qro.getContractId())){
			return qro.getContractId();
		}
		return null;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Integer abortEndorsement(long contractId) {
		Map<String, Object> inParam = new HashMap<String, Object>();
		inParam.put("p_contract_id", contractId);
		inParam.put("p_result", null);
		commonMapper.abortEndorsement(inParam);
		if (Beans.isNotEmpty(inParam.get("p_result"))) {
			return Integer.parseInt(inParam.get("p_result").toString());
		}
		return null;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteErrorData(long contractId) {
		Map<String, Object> inParam = new HashMap<String, Object>();
		inParam.put("p_contract_id", contractId);
		inParam.put("p_result", null);
		commonMapper.deleteErrorData(inParam);
		prlCommonQuotePolicyAllMapper.deleteByContractId(contractId);
	}
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public Integer abortOTIEndorsement(long contractId) {
		Map<String, Object> inParam = new HashMap<String, Object>();
		inParam.put("p_contract_id", contractId);
		inParam.put("p_result", null);
		commonMapper.abortOTIEndorsement(inParam);
		if (Beans.isNotEmpty(inParam.get("p_result"))) {
			return Integer.parseInt(inParam.get("p_result").toString());
		}
		return null;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteOTIErrorData(long contractId) {
		Map<String, Object> inParam = new HashMap<String, Object>();
		inParam.put("p_contract_id", contractId);
		inParam.put("p_result", null);
		commonMapper.deleteOTIErrorData(inParam);
		prlCommonQuotePolicyAllMapper.deleteByContractId(contractId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Long invokeUpdate4OP(JsonRequest jr) {
		JsonRequestHead head = jr.getHead();
		OPEndorsementPolicy policy = ((OPEndorsementBody)jr.getBody()).getPolicy();
		String endorsementType = PolicyConst.EndorsementType.changeObject.value;
		
		QueryResultObject pi = commonMapper.getPolicyInfoByPolicyRefAndUserCode(policy.getPolicyRef(), head.getUser());
		if (Beans.isEmpty(pi) || Beans.isEmpty(pi.getContractId())) {
			throw new CustomException(PolicyConst.ErrorCode.noRecord.value);
		}
        if(PolicyConst.PolicyStatus.EndorsementToBeCheck.value == pi.getPolicyStatus()){
            throw new CustomException("1184");
        }
        if(PolicyConst.PolicyStatus.InForce.value != pi.getPolicyStatus()){
            throw new CustomException("5046");
        }
        if (pi.getEffectiveDate().before(new Date()) && !this.getBackDateFlag(head.getUser())) {
        	throw new CustomException("1342");
		}
        
		Map<String, Object> inParam = new HashMap<String, Object>();
		inParam.put("p_result", null);
		inParam.put("p_contract_id", pi.getContractId());
		inParam.put("p_username", head.getUser());
		inParam.put("p_update_type", endorsementType);
		inParam.put("p_effective_date", new Date(pi.getEndorseEffectiveDate().getTime()+1000));
		
		commonMapper.invokeUpdate4OP(inParam);
        log.info("invokeUpdate4OP invokeUpdate result: " + inParam.get("p_result"));
        String result = String.valueOf(inParam.get("p_result"));
        if (PolicyConst.FunctionResult.error2.value.equals(result)) {
            throw new CustomException("1097");
        }
        if(!PolicyConst.FALSE.equals(result)){
            throw new CustomException("1185");
        }
        policy.setEndorsementType(endorsementType);
        policy.setEndorseEffectiveDate(pi.getEffectiveDate());
		return pi.getContractId();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Long invokeUpdateOTI(JsonRequest jsonRequest) {
		//ADF---initEndorForThird方法
		JsonRequestHead requestHead = jsonRequest.getHead();
		EndorsementBody body = (EndorsementBody) jsonRequest.getBody();
		EndorsementPolicy policy = body.getPolicy();
		QueryResultObject object = commonMapper.getPolicyInfoByRef(body.getPolicy().getPolicyRef());
		String endorsementType = PolicyConst.EndorsementType.changeObject.value;
		
        if(Beans.isEmpty(object)){
            throw new CustomException("1096");
        }
        if(!PolicyConst.PolicyStatus.InForce.value.equals(object.getPolicyStatus())){
            throw new CustomException("5046");
        }
        
        Date endorseEffectiveDate = new Date(commonMapper.findEndorseEffectiveDate(object.getContractId()).getTime()+ 1000);
        body.getPolicy().setEffectiveDate(endorseEffectiveDate);
        
		Map<String, Object> inParam = new HashMap<String, Object>();
		inParam.put("p_result", null);
		inParam.put("p_contract_id", object.getContractId());
		inParam.put("p_username", requestHead.getUser());
		inParam.put("p_update_type", endorsementType);
		inParam.put("p_effective_date", endorseEffectiveDate);
		
		commonMapper.invokeUpdateOTI(inParam);
        log.info("invokeUpdateOTI invokeUpdate result: " + inParam.get("p_result"));
        String result = String.valueOf(inParam.get("p_result"));
        if (PolicyConst.FunctionResult.error2.value.equals(result)) {
            throw new CustomException("1097");
        }
        policy.setEndorsementType(endorsementType);
        policy.setEndorseEffectiveDate(endorseEffectiveDate);
        
		return object.getContractId();
	}
	@Override
	@Transactional(readOnly=true)
	public Boolean getBackDateFlag(String userCode) {
		Map<String, Object> inParam = new HashMap<String, Object>();
		inParam.put("p_result", null);
		inParam.put("p_username", userCode);
		commonMapper.getBackDateFlag4OP(inParam);
		log.info("getBackDateFlag result: " + inParam.get("p_result"));
        String result = String.valueOf(inParam.get("p_result"));
        if(!PolicyConst.FALSE.equals(result)){
            return false;
        }
        return true;
	}
	
	@Override
	public Boolean checkBranchEffective(String branchCode) {
		Map<String, Object> inParam = new HashMap<String, Object>();
		inParam.put("p_result", null);
		inParam.put("branchCode", branchCode);
		commonMapper.checkBranchEffective(inParam);
		log.info("checkBranchEffective result: " + inParam.get("p_result"));//0 is Active ,1 Inactive
		String result = String.valueOf(inParam.get("p_result"));
        if(Beans.isNotEmpty(result) && PolicyConst.FALSE.equals(result.toString())){
            return true;
        }
        return false;
	}
	
	@Override
	@Transactional(readOnly=true)
	public PlanInfo getPlanInfoByPlanIdAndVersionNo(Integer planId, Integer versionNo) {
		return commonMapper.getPlanInfoByPlanIdAndVersionNo(planId, versionNo);
	}
	
	@Transactional(readOnly=true)
	public PrlThirdpInterfPolData getPrlThirdpInterfPolDataByPk(String requestId, String userCode) {
		PrlThirdpInterfPolDataKey key= new PrlThirdpInterfPolDataKey();
		key.setAgencyCode(userCode);
		key.setRequestId(requestId);
		return prlThirdpInterfPolDataMapper.selectByPrimaryKey(key);
	}

	@Transactional(propagation= Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Integer savePrlThirdpInterfPolData(PrlThirdpInterfPolData polData) {
		return prlThirdpInterfPolDataMapper.insertSelective(polData);
	}

	@Transactional(propagation= Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	public Integer updatePrlThirdpInterfPolData(PrlThirdpInterfPolData polData) {
		return prlThirdpInterfPolDataMapper.updateByPrimaryKeySelective(polData);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Integer updatePrlThirdpInterfPolDataWithCurrentSqlSession(PrlThirdpInterfPolData polData) {
		return prlThirdpInterfPolDataMapper.updateByPrimaryKeySelective(polData);
	}

	@Override
	public String getMaxVersionPolicyNo(String policyRef) {
		return commonMapper.getMaxVersionPolicyNo(policyRef);
	}

	@Override
	public AppParameterInfo getAppParameter(String appName, String key) {
		return commonMapper.getAppParameter(appName, key);
	}

	@Override
	public Long validateOTIPolicyExist(Map<String, Object> inParam) {
		return commonMapper.validateOTIPolicyExist(inParam);
	}

	@Override
	public List<InsuredPremium> getInsuredListByContractId(long contractId) {
		return commonMapper.getInsuredListByContractId(contractId);
	}

	@Override
	public List<UnderwritingDecision> getUnderwritingDecisionList(Map<String, Object> inParam) {
		return commonMapper.getUnderwritingDecisionList(inParam);
	}

	@Override
	public List<Map<String, Object>> getInsuredTypes() {
		return commonMapper.getInsuredTypes();
	}

	@Override
	public Map<String, Object> getAgeScopeOfPlan(String planCode) {
		return commonMapper.getAgeScopeOfPlan(planCode);
	}

	@Override
	public QueryResultObject getPolicyInfoByRef(String policyRef) {
		return commonMapper.getPolicyInfoByRef(policyRef);
	}

	@Override
	public PlanInfo getPlanInfo(Map<String, Object> param) {
		return commonMapper.getPlanInfo(param);
	}

	@Override
	public BigDecimal commonQueryCount(String sql) {
		return commonMapper.commonQueryCount(sql);
	}

	@Override
	public String getBlacklistByPolicy(long contractId) {
		return commonMapper.getBlacklistByPolicy(contractId);
	}

	@Override
	public PlanInfo getPlanInfoByContractId(Map<String, Object> param) {
		return commonMapper.getPlanInfoByContractId(param);
	}

	@Override
	public String getClientRef(long contractId) {
		return commonMapper.getClientRef(contractId);
	}

	@Override
	public Long getPartnerId(long contractId) {
		return commonMapper.getPartnerId(contractId);
	}

	@Override
	public String getPrpCode(long prpPartId) {
		return commonMapper.getPrpCode(prpPartId);
	}

	@Override
	public List<String> getACheckId(Map<String, Object> param) {
		return commonMapper.getACheckId(param);
	}

	@Override
	public List<String> getCDCheckId(Map<String, Object> param) {
		return commonMapper.getCDCheckId(param);
	}

	@Override
	public Map<String, Object> getOccupationByCode(String occupationCode) {
		return commonMapper.getOccupationByCode(occupationCode);
	}

	@Override
	public Date findEndorseEffectiveDate(long contractId) {
		return commonMapper.findEndorseEffectiveDate(contractId);
	}

	@Override
	public String getInsuredType(Map<String, Object> param) {
		return commonMapper.getInsuredType(param);
	}

	@Override
	public BigDecimal getCheckTotalPremium(Map<String, Object> inParam) {
		return commonMapper.getCheckTotalPremium(inParam);
	}

}
