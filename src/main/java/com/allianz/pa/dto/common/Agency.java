package com.allianz.pa.dto.common;

public class Agency {
    private String agencyCode;

    private String staffCode;
    
    private String subAccount;
    
    private String salesName;

    private String salesLicenseNo;
    
    private String salesTelephone;

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getSubAccount() {
		return subAccount;
	}

	public void setSubAccount(String subAccount) {
		this.subAccount = subAccount;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public String getSalesLicenseNo() {
		return salesLicenseNo;
	}

	public void setSalesLicenseNo(String salesLicenseNo) {
		this.salesLicenseNo = salesLicenseNo;
	}

	public String getSalesTelephone() {
		return salesTelephone;
	}

	public void setSalesTelephone(String salesTelephone) {
		this.salesTelephone = salesTelephone;
	}
}
