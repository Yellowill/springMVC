package com.allianz.pa.dto.request.policyconfirm.op;

import java.math.BigDecimal;
import java.util.Date;

public class OPPolicy {
    private String agencyPolicyRef;
    
    private String planCode;
        
    private Date issueDate;

    private Date effectiveDate;

    private Date expireDate;

	private String destination;
    
    private String groupSize;
    
    private String remark;
    
    private BigDecimal totalPremium;
    
    private String groupNo;
    
    private String installmentNumber;
    
    private String abroadDriveYn;
    
    private String renewalType;
    
    private String customPolicyType;
    
    private Boolean endorseFlag;
    
    private Date applicationDate;

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

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getGroupSize() {
		return groupSize;
	}

	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}

	public BigDecimal getTotalPremium() {
		return totalPremium;
	}

	public void setTotalPremium(BigDecimal totalPremium) {
		this.totalPremium = totalPremium;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber(String installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	public String getAbroadDriveYn() {
		return abroadDriveYn;
	}

	public void setAbroadDriveYn(String abroadDriveYn) {
		this.abroadDriveYn = abroadDriveYn;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRenewalType() {
		return renewalType;
	}

	public void setRenewalType(String renewalType) {
		this.renewalType = renewalType;
	}

	public String getCustomPolicyType() {
		return customPolicyType;
	}

	public void setCustomPolicyType(String customPolicyType) {
		this.customPolicyType = customPolicyType;
	}

	public Boolean getEndorseFlag() {
		return endorseFlag;
	}

	public void setEndorseFlag(Boolean endorseFlag) {
		this.endorseFlag = endorseFlag;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
}
