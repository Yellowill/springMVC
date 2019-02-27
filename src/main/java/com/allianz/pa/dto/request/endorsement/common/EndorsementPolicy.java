package com.allianz.pa.dto.request.endorsement.common;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EndorsementPolicy {

	private String policyRef;
	
	@Pattern(regexp="^(Y|N)$",message="1099")
	private String issueFlag;
	 //批改生效日期
    private Date endorseEffectiveDate;
    //批改类型
    private String endorsementType;
    
    private String agencyPolicyRef;
        
    private Date issueDate;

    private Date effectiveDate;

    private Date expireDate;

    private Integer groupSize;
    
    private String destination;
    
    private String remark;
    
    private String planCode;
    
	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Integer getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(Integer groupSize) {
		this.groupSize = groupSize;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getIssueFlag() {
		return issueFlag;
	}

	public void setIssueFlag(String issueFlag) {
		this.issueFlag = issueFlag;
	}

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

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
}
