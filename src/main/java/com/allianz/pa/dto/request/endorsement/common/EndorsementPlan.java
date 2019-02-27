package com.allianz.pa.dto.request.endorsement.common;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class EndorsementPlan {

	@NotNull(message="0001")
    private String planCode;
    
	@Valid
	@NotNull(message="0001")
    protected List<EndorsementInsured>  insuredList;

	public List<EndorsementInsured> getInsuredList() {
		return insuredList;
	}

	public void setInsuredList(List<EndorsementInsured> insuredList) {
		this.insuredList = insuredList;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

}
