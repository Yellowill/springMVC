package com.allianz.pa.dto.request.policyconfirm.op;

import java.util.List;

import com.allianz.pa.common.bean.PartnerInfo;
import com.allianz.pa.common.bean.PlanInfo;
import com.allianz.pa.common.bean.UserInfo;
import com.allianz.pa.dto.common.Agency;
import com.allianz.pa.dto.common.JsonRequestBody;
import com.allianz.pa.dto.common.PreiumSettle;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class OPConfirmBody extends JsonRequestBody{
	private OPPolicy policy;

	private Agency agency;
	
	private OPPolicyHolder policyHolder;
	
	private List<OPInsured> insuredList;
	
	private PreiumSettle preiumSettle;
	
	@JsonIgnore
	private UserInfo user;
	
	@JsonIgnore
	private PartnerInfo agencyInfo;
	
	@JsonIgnore
	private PlanInfo planInfo;
	
	public OPPolicy getPolicy() {
		return policy;
	}

	public void setPolicy(OPPolicy policy) {
		this.policy = policy;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public OPPolicyHolder getPolicyHolder() {
		return policyHolder;
	}

	public void setPolicyHolder(OPPolicyHolder policyHolder) {
		this.policyHolder = policyHolder;
	}

	public List<OPInsured> getInsuredList() {
		return insuredList;
	}

	public void setInsuredList(List<OPInsured> insuredList) {
		this.insuredList = insuredList;
	}

	public PreiumSettle getPreiumSettle() {
		return preiumSettle;
	}

	public void setPreiumSettle(PreiumSettle preiumSettle) {
		this.preiumSettle = preiumSettle;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public PartnerInfo getAgencyInfo() {
		return agencyInfo;
	}

	public void setAgencyInfo(PartnerInfo agencyInfo) {
		this.agencyInfo = agencyInfo;
	}

	public PlanInfo getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(PlanInfo planInfo) {
		this.planInfo = planInfo;
	}
}
