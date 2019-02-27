package com.allianz.pa.common.bean;

public class UserInfo {
    private String userCode;
    private String userName;
    private String branchCode;
    private Integer partnerId;
    private String parterRole;
    private String staffCode;
    private String luaHandlerEnabled;
    
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public Integer getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}
	public String getParterRole() {
		return parterRole;
	}
	public void setParterRole(String parterRole) {
		this.parterRole = parterRole;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getLuaHandlerEnabled() {
		return luaHandlerEnabled;
	}
	public void setLuaHandlerEnabled(String luaHandlerEnabled) {
		this.luaHandlerEnabled = luaHandlerEnabled;
	}
}
