package com.allianz.pa.dto.request.policyconfirm.group;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class GPPolicy {
	@NotNull(message="0001")
    private String agencyPolicyRef;
        
	@NotNull(message="0001")
    private Date issueDate;

	@NotNull(message="0001")
    private Date effectiveDate;

	@NotNull(message="0001")
    private Date expireDate;

	@NotNull(message="0001")
    private Integer groupSize;
    
    private String destination;
    
    private String remark;

	public String getAgencyPolicyRef() {
		return agencyPolicyRef;
	}

	public void setAgencyPolicyRef(String agencyPolicyRef) {
		this.agencyPolicyRef = agencyPolicyRef;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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
    

}
