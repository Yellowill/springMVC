package com.allianz.pa.dto.request.endorsement.common;

import java.util.List;

import javax.validation.Valid;

import com.allianz.pa.dto.common.JsonRequestBody;
import com.allianz.pa.dto.common.standard.AgencyVO;

public class EndorsementBody extends JsonRequestBody  {

	@Valid
    protected EndorsementPolicy policy;
    
	@Valid
    protected List<EndorsementPlan> planList;
    
	@Valid
    protected AgencyVO agency;

	public List<EndorsementPlan> getPlanList() {
		return planList;
	}

	public void setPlanList(List<EndorsementPlan> planList) {
		this.planList = planList;
	}

	public EndorsementPolicy getPolicy() {
		return policy;
	}

	public void setPolicy(EndorsementPolicy policy) {
		this.policy = policy;
	}

	public AgencyVO getAgency() {
		return agency;
	}

	public void setAgency(AgencyVO agency) {
		this.agency = agency;
	}

}
