package com.allianz.pa.entity;

public class WipInterestedParties extends WipInterestedPartiesKey {
    private String actionCode;

    private Integer versionNo;

    private Long objectId;

    private String topIndicator;

    private Integer previousVersion;

    private Integer reversingVersion;

    private String customerNameText;

    private Integer partnerId;

    private Long mailingAddressId;
    
    private WipIpLinks wipIpLinks;
    
    private WipPrlIpExt wipPrlIpExt;
    
    
	public WipIpLinks getWipIpLinks() {
		return wipIpLinks;
	}

	public void setWipIpLinks(WipIpLinks wipIpLinks) {
		this.wipIpLinks = wipIpLinks;
	}

	public WipPrlIpExt getWipPrlIpExt() {
		return wipPrlIpExt;
	}

	public void setWipPrlIpExt(WipPrlIpExt wipPrlIpExt) {
		this.wipPrlIpExt = wipPrlIpExt;
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

    public String getCustomerNameText() {
        return customerNameText;
    }

    public void setCustomerNameText(String customerNameText) {
        this.customerNameText = customerNameText == null ? null : customerNameText.trim();
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Long getMailingAddressId() {
        return mailingAddressId;
    }

    public void setMailingAddressId(Long mailingAddressId) {
        this.mailingAddressId = mailingAddressId;
    }
}