package com.allianz.pa.dto.common;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.allianz.pa.dto.common.standard.ErrorBean;
import com.allianz.pa.dto.common.standard.InsuredPremium;

public class JsonResponseBody {
    private String policyRef;
    
    private String agencyPolicyRef;
    
    private Integer policyStatus;

    private BigDecimal totalPremium;

    private BigDecimal sumInsured;
    
	private Date effectiveDate;

	private Date expireDate;
	
	private List<InsuredPremium> insuredPremiumList;
	
	private List<ErrorBean> errorList;
	 
	private BigDecimal adjustmentPremium;

	
	public BigDecimal getAdjustmentPremium() {
		return adjustmentPremium;
	}

	public void setAdjustmentPremium(BigDecimal adjustmentPremium) {
		this.adjustmentPremium = adjustmentPremium;
	}

	public List<InsuredPremium> getInsuredPremiumList() {
		return insuredPremiumList;
	}

	public void setInsuredPremiumList(List<InsuredPremium> insuredPremiumList) {
		this.insuredPremiumList = insuredPremiumList;
	}

	public List<ErrorBean> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<ErrorBean> errorList) {
		this.errorList = errorList;
	}

	public String getPolicyRef() {
		return policyRef;
	}

	public void setPolicyRef(String policyRef) {
		this.policyRef = policyRef;
	}

	public String getAgencyPolicyRef() {
		return agencyPolicyRef;
	}

	public void setAgencyPolicyRef(String agencyPolicyRef) {
		this.agencyPolicyRef = agencyPolicyRef;
	}

	public Integer getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(Integer policyStatus) {
		this.policyStatus = policyStatus;
	}

	public BigDecimal getTotalPremium() {
		return totalPremium;
	}

	public void setTotalPremium(BigDecimal totalPremium) {
		this.totalPremium = totalPremium;
	}

	public BigDecimal getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(BigDecimal sumInsured) {
		this.sumInsured = sumInsured;
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
}
