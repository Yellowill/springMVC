package com.allianz.pa.entity;

import java.math.BigDecimal;

public class WipIpLinks extends WipIpLinksKey {
   	private String roleType;

    private String linkType;

    private String actionCode;

    private Integer versionNo;

    private Long objectId;

    private String topIndicator;

    private Integer previousVersion;

    private Integer reversingVersion;

    private String interestRank;

    private String interestReference;

    private BigDecimal interestAmount;

    private String typeOfInterest;

    private String coverCode;

    private Integer coverNo;

    private Integer partitionNo;

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType == null ? null : linkType.trim();
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode == null ? null : actionCode.trim();
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
        this.topIndicator = topIndicator == null ? null : topIndicator.trim();
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

    public String getInterestRank() {
        return interestRank;
    }

    public void setInterestRank(String interestRank) {
        this.interestRank = interestRank == null ? null : interestRank.trim();
    }

    public String getInterestReference() {
        return interestReference;
    }

    public void setInterestReference(String interestReference) {
        this.interestReference = interestReference == null ? null : interestReference.trim();
    }

    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(BigDecimal interestAmount) {
        this.interestAmount = interestAmount;
    }

    public String getTypeOfInterest() {
        return typeOfInterest;
    }

    public void setTypeOfInterest(String typeOfInterest) {
        this.typeOfInterest = typeOfInterest == null ? null : typeOfInterest.trim();
    }

    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode == null ? null : coverCode.trim();
    }

    public Integer getCoverNo() {
        return coverNo;
    }

    public void setCoverNo(Integer coverNo) {
        this.coverNo = coverNo;
    }

    public Integer getPartitionNo() {
        return partitionNo;
    }

    public void setPartitionNo(Integer partitionNo) {
        this.partitionNo = partitionNo;
    }
}