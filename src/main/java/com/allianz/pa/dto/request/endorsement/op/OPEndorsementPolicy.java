package com.allianz.pa.dto.request.endorsement.op;

import java.util.Date;

import com.allianz.pa.dto.common.JsonRequestBody;

public class OPEndorsementPolicy extends JsonRequestBody{
	private String agencyPolicyRef;

	private String policyRef;
	
    private String changeDesc;
    
    //批改生效日期
    private Date endorseEffectiveDate;
    
    //批改类型
    private String endorsementType;

	public String getAgencyPolicyRef() {
		return agencyPolicyRef;
	}

	public void setAgencyPolicyRef(String agencyPolicyRef) {
		this.agencyPolicyRef = agencyPolicyRef;
	}

	public String getPolicyRef() {
		return policyRef;
	}

	public void setPolicyRef(String policyRef) {
		this.policyRef = policyRef;
	}

	public String getChangeDesc() {
		return changeDesc;
	}

	public void setChangeDesc(String changeDesc) {
		this.changeDesc = changeDesc;
	}

	public Date getEndorseEffectiveDate() {
		return endorseEffectiveDate;
	}

	public void setEndorseEffectiveDate(Date endorseEffectiveDate) {
		this.endorseEffectiveDate = endorseEffectiveDate;
	}

	public String getEndorsementType() {
		return endorsementType;
	}

	public void setEndorsementType(String endorsementType) {
		this.endorsementType = endorsementType;
	}
}
