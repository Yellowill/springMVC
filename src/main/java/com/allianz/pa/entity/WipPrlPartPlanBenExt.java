package com.allianz.pa.entity;

import java.math.BigDecimal;

public class WipPrlPartPlanBenExt extends WipPrlPartPlanBenExtKey {
    private String actionCode;

    private Integer versionNo;

    private Long objectId;

    private String topIndicator;

    private Integer previousVersion;

    private Integer reversingVersion;

    private String benefitCode;

    private String benefitName;

    private BigDecimal sumInsured;

    private String limit;

    private BigDecimal policySi;

    private String subLimitType;

    private BigDecimal subLimit;

    private Integer deductibleDays;

    private Integer maxPaymentDays;

    private BigDecimal dailyPaymentAmt;

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public Integer getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getTopIndicator() {
		return topIndicator;
	}

	public void setTopIndicator(String topIndicator) {
		this.topIndicator = topIndicator;
	}

	public Integer getPreviousVersion() {
		return previousVersion;
	}

	public void setPreviousVersion(Integer previousVersion) {
		this.previousVersion = previousVersion;
	}

	public Integer getReversingVersion() {
		return reversingVersion;
	}

	public void setReversingVersion(Integer reversingVersion) {
		this.reversingVersion = reversingVersion;
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

	public BigDecimal getPolicySi() {
		return policySi;
	}

	public void setPolicySi(BigDecimal policySi) {
		this.policySi = policySi;
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