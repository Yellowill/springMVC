package com.allianz.pa.entity;

import java.math.BigDecimal;
import java.util.Date;

public class WipPolicyVersions {
    private Long contractId;

    private Short productId;

    private Short prodVersion;

    private Integer versionNo;

    private Integer previousVersion;

    private Integer reversingVersion;

    private String topIndicator;

    private String ediRouteInfo;

    private String username;

    private Long userPartnerId;

    private Short adjustmentCommission;

    private String adjustmentCommissionSwf;

    private Date businessStartDate;

    private Date businessEndDate;

    private String overrideIndicator;

    private BigDecimal proRationFactor;

    private String moveCode;

    private String movementReasonCode;

    private String movementReasonText;

    private String changeDescription;

    private Short fullTermPremium;

    private String fullTermPremiumSwf;

    private Short adjustmentPremium;

    private String adjustmentPremiumSwf;

    private Short unearnedPremiumIn;

    private String unearnedPremiumInSwf;

    private Short unearnedPremiumOut;

    private String unearnedPremiumOutSwf;

    private Date systemStartDate;

    private Date systemEndDate;

    private String internalExternalIndicator;

    private String subMovementType;

    private String manualReinsCoinsIndicator;

    private String contractStatus;

    private Long regressBatchId;

    private Long movementBatchId;

    private String extUser;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Short getProductId() {
        return productId;
    }

    public void setProductId(Short productId) {
        this.productId = productId;
    }

    public Short getProdVersion() {
        return prodVersion;
    }

    public void setProdVersion(Short prodVersion) {
        this.prodVersion = prodVersion;
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
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

    public String getTopIndicator() {
        return topIndicator;
    }

    public void setTopIndicator(String topIndicator) {
        this.topIndicator = topIndicator == null ? null : topIndicator.trim();
    }

    public String getEdiRouteInfo() {
        return ediRouteInfo;
    }

    public void setEdiRouteInfo(String ediRouteInfo) {
        this.ediRouteInfo = ediRouteInfo == null ? null : ediRouteInfo.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Long getUserPartnerId() {
        return userPartnerId;
    }

    public void setUserPartnerId(Long userPartnerId) {
        this.userPartnerId = userPartnerId;
    }

    public Short getAdjustmentCommission() {
        return adjustmentCommission;
    }

    public void setAdjustmentCommission(Short adjustmentCommission) {
        this.adjustmentCommission = adjustmentCommission;
    }

    public String getAdjustmentCommissionSwf() {
        return adjustmentCommissionSwf;
    }

    public void setAdjustmentCommissionSwf(String adjustmentCommissionSwf) {
        this.adjustmentCommissionSwf = adjustmentCommissionSwf == null ? null : adjustmentCommissionSwf.trim();
    }

    public Date getBusinessStartDate() {
        return businessStartDate;
    }

    public void setBusinessStartDate(Date businessStartDate) {
        this.businessStartDate = businessStartDate;
    }

    public Date getBusinessEndDate() {
        return businessEndDate;
    }

    public void setBusinessEndDate(Date businessEndDate) {
        this.businessEndDate = businessEndDate;
    }

    public String getOverrideIndicator() {
        return overrideIndicator;
    }

    public void setOverrideIndicator(String overrideIndicator) {
        this.overrideIndicator = overrideIndicator == null ? null : overrideIndicator.trim();
    }

    public BigDecimal getProRationFactor() {
        return proRationFactor;
    }

    public void setProRationFactor(BigDecimal proRationFactor) {
        this.proRationFactor = proRationFactor;
    }

    public String getMoveCode() {
        return moveCode;
    }

    public void setMoveCode(String moveCode) {
        this.moveCode = moveCode == null ? null : moveCode.trim();
    }

    public String getMovementReasonCode() {
        return movementReasonCode;
    }

    public void setMovementReasonCode(String movementReasonCode) {
        this.movementReasonCode = movementReasonCode == null ? null : movementReasonCode.trim();
    }

    public String getMovementReasonText() {
        return movementReasonText;
    }

    public void setMovementReasonText(String movementReasonText) {
        this.movementReasonText = movementReasonText == null ? null : movementReasonText.trim();
    }

    public String getChangeDescription() {
        return changeDescription;
    }

    public void setChangeDescription(String changeDescription) {
        this.changeDescription = changeDescription == null ? null : changeDescription.trim();
    }

    public Short getFullTermPremium() {
        return fullTermPremium;
    }

    public void setFullTermPremium(Short fullTermPremium) {
        this.fullTermPremium = fullTermPremium;
    }

    public String getFullTermPremiumSwf() {
        return fullTermPremiumSwf;
    }

    public void setFullTermPremiumSwf(String fullTermPremiumSwf) {
        this.fullTermPremiumSwf = fullTermPremiumSwf == null ? null : fullTermPremiumSwf.trim();
    }

    public Short getAdjustmentPremium() {
        return adjustmentPremium;
    }

    public void setAdjustmentPremium(Short adjustmentPremium) {
        this.adjustmentPremium = adjustmentPremium;
    }

    public String getAdjustmentPremiumSwf() {
        return adjustmentPremiumSwf;
    }

    public void setAdjustmentPremiumSwf(String adjustmentPremiumSwf) {
        this.adjustmentPremiumSwf = adjustmentPremiumSwf == null ? null : adjustmentPremiumSwf.trim();
    }

    public Short getUnearnedPremiumIn() {
        return unearnedPremiumIn;
    }

    public void setUnearnedPremiumIn(Short unearnedPremiumIn) {
        this.unearnedPremiumIn = unearnedPremiumIn;
    }

    public String getUnearnedPremiumInSwf() {
        return unearnedPremiumInSwf;
    }

    public void setUnearnedPremiumInSwf(String unearnedPremiumInSwf) {
        this.unearnedPremiumInSwf = unearnedPremiumInSwf == null ? null : unearnedPremiumInSwf.trim();
    }

    public Short getUnearnedPremiumOut() {
        return unearnedPremiumOut;
    }

    public void setUnearnedPremiumOut(Short unearnedPremiumOut) {
        this.unearnedPremiumOut = unearnedPremiumOut;
    }

    public String getUnearnedPremiumOutSwf() {
        return unearnedPremiumOutSwf;
    }

    public void setUnearnedPremiumOutSwf(String unearnedPremiumOutSwf) {
        this.unearnedPremiumOutSwf = unearnedPremiumOutSwf == null ? null : unearnedPremiumOutSwf.trim();
    }

    public Date getSystemStartDate() {
        return systemStartDate;
    }

    public void setSystemStartDate(Date systemStartDate) {
        this.systemStartDate = systemStartDate;
    }

    public Date getSystemEndDate() {
        return systemEndDate;
    }

    public void setSystemEndDate(Date systemEndDate) {
        this.systemEndDate = systemEndDate;
    }

    public String getInternalExternalIndicator() {
        return internalExternalIndicator;
    }

    public void setInternalExternalIndicator(String internalExternalIndicator) {
        this.internalExternalIndicator = internalExternalIndicator == null ? null : internalExternalIndicator.trim();
    }

    public String getSubMovementType() {
        return subMovementType;
    }

    public void setSubMovementType(String subMovementType) {
        this.subMovementType = subMovementType == null ? null : subMovementType.trim();
    }

    public String getManualReinsCoinsIndicator() {
        return manualReinsCoinsIndicator;
    }

    public void setManualReinsCoinsIndicator(String manualReinsCoinsIndicator) {
        this.manualReinsCoinsIndicator = manualReinsCoinsIndicator == null ? null : manualReinsCoinsIndicator.trim();
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus == null ? null : contractStatus.trim();
    }

    public Long getRegressBatchId() {
        return regressBatchId;
    }

    public void setRegressBatchId(Long regressBatchId) {
        this.regressBatchId = regressBatchId;
    }

    public Long getMovementBatchId() {
        return movementBatchId;
    }

    public void setMovementBatchId(Long movementBatchId) {
        this.movementBatchId = movementBatchId;
    }

    public String getExtUser() {
        return extUser;
    }

    public void setExtUser(String extUser) {
        this.extUser = extUser == null ? null : extUser.trim();
    }
}