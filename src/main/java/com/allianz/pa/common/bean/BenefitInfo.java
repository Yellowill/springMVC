package com.allianz.pa.common.bean;

import java.math.BigDecimal;

public class BenefitInfo {
	private Integer benefitId;
	
	private String benefitCode;

	private String benefitName;

	private BigDecimal sumInsured;

	private String limit;

	private Integer policySiFlag;

	private String subLimitType;

	private BigDecimal subLimit;

	private Integer deductibleDays;

	private Integer maxPaymentDays;

	private BigDecimal dailyPaymentAmt;

	public Integer getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(Integer benefitId) {
		this.benefitId = benefitId;
	}

	public String getBenefitCode() {
		return benefitCode;
	}

	public void setBenefitCode(String benefitCode) {
		this.benefitCode = benefitCode;
	}

	public String getBenefitName() {
		return benefitName;
	}

	public void setBenefitName(String benefitName) {
		this.benefitName = benefitName;
	}

	public BigDecimal getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(BigDecimal sumInsured) {
		this.sumInsured = sumInsured;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public Integer getPolicySi() {
		return policySiFlag;
	}

	public void setPolicySi(Integer policySi) {
		this.policySiFlag = policySi;
	}

	public String getSubLimitType() {
		return subLimitType;
	}

	public void setSubLimitType(String subLimitType) {
		this.subLimitType = subLimitType;
	}

	public BigDecimal getSubLimit() {
		return subLimit;
	}

	public void setSubLimit(BigDecimal subLimit) {
		this.subLimit = subLimit;
	}

	public Integer getDeductibleDays() {
		return deductibleDays;
	}

	public void setDeductibleDays(Integer deductibleDays) {
		this.deductibleDays = deductibleDays;
	}

	public Integer getMaxPaymentDays() {
		return maxPaymentDays;
	}

	public void setMaxPaymentDays(Integer maxPaymentDays) {
		this.maxPaymentDays = maxPaymentDays;
	}

	public BigDecimal getDailyPaymentAmt() {
		return dailyPaymentAmt;
	}

	public void setDailyPaymentAmt(BigDecimal dailyPaymentAmt) {
		this.dailyPaymentAmt = dailyPaymentAmt;
	}
}
