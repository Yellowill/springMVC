package com.allianz.pa.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.allianz.pa.common.bean.AppParameterInfo;
import com.allianz.pa.common.bean.BenefitInfo;
import com.allianz.pa.common.bean.PartnerInfo;
import com.allianz.pa.common.bean.PlanInfo;
import com.allianz.pa.common.bean.QueryResultObject;
import com.allianz.pa.common.bean.UserInfo;
import com.allianz.pa.dto.common.standard.InsuredPremium;
import com.allianz.pa.dto.common.standard.UnderwritingDecision;

public interface CommonMapper {
	public QueryResultObject getPolicyInfoBycontractId(Long contractId);
	
	public Map<String, Object> newBusiness4Others(Map<String, Object> inParam);
	
	public UserInfo getUserInfo(String userCode);
	
	public PartnerInfo getAgencyInfo(String agencyCode);
	
	public PlanInfo getAssignedPlanInfoByPlanCode(String userCode,Integer partId,String branchCode,String planCode,java.sql.Date effectiveDate);
	
	public List<QueryResultObject> customQuery(String sql);
	
	public QueryResultObject getAgencySalesInfo(Integer partId,Long contractId);
	
	public PartnerInfo getCustomerInfo(String customerCode);
	
	public PartnerInfo getTPAInfo(Integer partId);
	
	public Map<String, Object> getCommissionRate(Map<String, Object> inParam);
	
	public List<BenefitInfo> getPlanBenefitInfo(Integer planId,Integer planVersionNo);
	
	public Map<String, Object> preIssuePolicy4Others(Map<String, Object> inParam);

	public Map<String, Object> issuePolicy4Others(Map<String, Object> inParam);
	
	public Map<String, Object> doBookingSettle4Others(Map<String, Object> inParam);
	
	public Map<String, Object> preIssuePolicyForOTI(Map<String, Object> inParam);

	public Map<String, Object> issuePolicyForOTI(Map<String, Object> inParam);
	
	public Map<String, Object> doBookingSettleForOTI(Map<String, Object> inParam);
	
	public Map<String, Object> getExchRate(Map<String, Object> inParam);
	
	public QueryResultObject getPolicyOriginator(Long contractId);
	
	public Map<String, Object> validateUserPassword(Map<String, Object> inParam);
	
	public QueryResultObject getAllreadySuccessPolicyInfo(Long contractId);
	
	public QueryResultObject validatePolicyIsExist(String userCode, String policyOriginator);
	
	public Map<String, Object> abortEndorsement(Map<String, Object> inParam);
	
	public void deleteErrorData(Map<String, Object> inParam);
	
	public Map<String, Object> invokeUpdate4OP(Map<String, Object> inParam);
	
	public QueryResultObject getPolicyInfoByPolicyRefAndUserCode(String policyRef, String userCode);
	
	public Map<String, Object> getBackDateFlag4OP(Map<String, Object> inParam);
	
	public Map<String, Object> checkBranchEffective(Map<String, Object> inParam);
	
	public PlanInfo getPlanInfoByPlanIdAndVersionNo(Integer planId, Integer versionNo);
	
	public String getMaxVersionPolicyNo(String policyRef);
	
	public AppParameterInfo getAppParameter(String appName, String key);
	
	public Long validateOTIPolicyExist(Map<String, Object> inParam);
	
	public List<InsuredPremium> getInsuredListByContractId(long contractId);
	
	public List<UnderwritingDecision>getUnderwritingDecisionList(Map<String, Object> inParam);
	
	public List<Map<String, Object>> getInsuredTypes();
	
	public Map<String, Object> getAgeScopeOfPlan(String planCode);
	
	public String getInsuredType( Map<String, Object> param);
	
	public QueryResultObject getPolicyInfoByRef(String policyRef);

	public PlanInfo getPlanInfo(Map<String, Object> param);

	public BigDecimal commonQueryCount(String sql);
	
	public String getBlacklistByPolicy(long contractId);

	public PlanInfo getPlanInfoByContractId(Map<String, Object> param);
	
	public String getClientRef(long contractId);
	
	public Long getPartnerId(long contractId);
	
	public String getPrpCode(long prpPartId);
	
	public List<String> getACheckId(Map<String, Object> param);
	
	public List<String> getCDCheckId(Map<String, Object> param);
	
	public Map<String, Object> getOccupationByCode(String occupationCode);
	
	public Date findEndorseEffectiveDate(long contractId);
	
	public Map<String, Object> invokeUpdateOTI(Map<String, Object> inParam);
	
	public BigDecimal getCheckTotalPremium(Map<String, Object> inParam);

	public void abortOTIEndorsement(Map<String, Object> inParam);

	public void deleteOTIErrorData(Map<String, Object> inParam);
}
