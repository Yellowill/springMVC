package com.allianz.pa.dto.common.standard;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgencyVO {
    public AgencyVO() {
        super();
    }
    
    @NotNull(message="0001")
    protected String agencyCode;
    
    protected String salesName;
    
    protected String salesLicenseNo;
    
    protected String staffCode;
    
    /** 子账号 */
    private String childAccount;
    

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
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

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getChildAccount() {
		return childAccount;
	}

	public void setChildAccount(String childAccount) {
		this.childAccount = childAccount;
	}
    
    

}
