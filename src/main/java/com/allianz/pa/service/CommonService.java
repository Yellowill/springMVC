package com.allianz.pa.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.allianz.pa.common.bean.AppParameterInfo;
import com.allianz.pa.common.bean.BenefitInfo;
import com.allianz.pa.common.bean.PartnerInfo;
import com.allianz.pa.common.bean.PlanInfo;
import com.allianz.pa.common.bean.QueryResultObject;
import com.allianz.pa.common.bean.UserInfo;
import com.allianz.pa.dto.common.JsonRequest;
import com.allianz.pa.dto.common.JsonRequestHead;
import com.allianz.pa.dto.common.JsonResponse;
import com.allianz.pa.dto.common.standard.InsuredPremium;
import com.allianz.pa.dto.common.standard.UnderwritingDecision;
import com.allianz.pa.entity.PrlThirdpInterfPolData;
import com.allianz.pa.entity.PrlThirdpInterfPolDataKey;

public interface CommonService {
	public QueryResultObject getPolicyInfoBycontractId(long contractId);
	
	public Map<String, Object> newBusiness(Map<String, Object> inParam);
	
	public UserInfo getUserInfo(String userCode);
	
	public PartnerInfo getAgencyInfo(String agencyCode);
	
	public PlanInfo getAssignedPlanInfoByPlanCode(String userCode,Integer partId,String branchCode,String planCode,java.sql.Date effectiveDate);
	
	public List<QueryResultObject> customQuery(String sql);
	
	public QueryResultObject getAgencySalesInfo(Integer partId,long contractId);
	
	public PartnerInfo getCustomerInfo(String customerCode);
	
	public PartnerInfo getTPAInfo(Integer partId);
	
	public Map<String, Object> getCommissionRate(Map<String, Object> inParam);
	
	public long getSequenceValue(String  sequenceName);
	
	public List<BenefitInfo> getPlanBenefitInfo(Integer planId,Integer planVersionNo);
	
	public Map<String, Object> preIssuePolicy4Others(Map<String, Object> inParam);

	public Map<String, Object> issuePolicy4Others(Map<String, Object> inParam);
	
	public Integer doBookingSettle4Others(long contractId);
	
	public Map<String, Object> preIssuePolicyForOTI(Map<String, Object> inParam);

	public Map<String, Object> issuePolicyForOTI(Map<String, Object> inParam);
	
	public Integer doBookingSettleForOTI(long contractId);
	
	public BigDecimal getExchRate(String currency,Date effectDate);
	
	public String getPolicyOriginator(long contractId);
	
	public String validateUserPassword(String userCode, String encryptionPassword,String remoteHost);
	
	public JsonResponse getAllreadySuccessPolicy(JsonRequestHead head, long contractId);
	
	public QueryResultObject getSuccessPolicy(long contractId);
	
	public Long validatePolicyIsExist(String userCode, String policyOriginator);
	
	public Integer abortEndorsement(long contractId);
	
	public void deleteErrorData(long contractId);
	
	public Long invokeUpdate4OP(JsonRequest jr);
	
	public Boolean getBackDateFlag(String userCode);
	
	public Boolean checkBranchEffective(String branchCode);
	
	public PlanInfo getPlanInfoByPlanIdAndVersionNo(Integer planId, Integer versionNo);
	
	public PrlThirdpInterfPolData getPrlThirdpInterfPolDataByPk(String requestId, String userCode) ;

	public Integer savePrlThirdpInterfPolData(PrlThirdpInterfPolData polData);

	public Integer updatePrlThirdpInterfPolData(PrlThirdpInterfPolData polData);
	
	public Integer updatePrlThirdpInterfPolDataWithCurrentSqlSession(PrlThirdpInterfPolData polData);
	
	public String getMaxVersionPolicyNo(String policyRef);
	
	public AppParameterInfo getAppParameter(String appName, String key);
	
	public Long validateOTIPolicyExist(Map<String, Object> inParam);
	
	public List<InsuredPremium> getInsuredListByContractId(long contractId);
	
	public List<UnderwritingDecision>getUnderwritingDecisionList(Map<String, Object> inParam);
	
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

	public Long invokeUpdateOTI(JsonRequest jsonRequest);
	
	public String getInsuredType( Map<String, Object> param);

	public Map<String, Object> getAgeScopeOfPlan(String planCode);

	public List<Map<String, Object>> getInsuredTypes();
	
	public BigDecimal getCheckTotalPremium(Map<String, Object> inParam);

	public void deleteOTIErrorData(long contractId);

	public Integer abortOTIEndorsement(long contractId);
}
