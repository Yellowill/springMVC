package com.allianz.pa.dto.request.endorsement.op;

import java.util.List;

import com.allianz.pa.dto.common.JsonRequestBody;

public class OPEndorsementBody extends JsonRequestBody {
	private OPEndorsementPolicy policy;
	
	private List<OPEndorsementInsuredRisk> insuredRiskList;

	public OPEndorsementPolicy getPolicy() {
		return policy;
	}

	public void setPolicy(OPEndorsementPolicy policy) {
		this.policy = policy;
	}

	public List<OPEndorsementInsuredRisk> getInsuredRiskList() {
		return insuredRiskList;
	}

	public void setInsuredRiskList(List<OPEndorsementInsuredRisk> insuredRiskList) {
		this.insuredRiskList = insuredRiskList;
	}
}
