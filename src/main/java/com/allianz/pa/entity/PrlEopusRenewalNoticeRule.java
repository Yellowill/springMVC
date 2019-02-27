package com.allianz.pa.entity;

import java.util.Date;

public class PrlEopusRenewalNoticeRule {
    private Short renewalNoticeRuleId;

    private String renewalNoticeRuleName;

    private String agencyCode;

    private String groupPlanCode;

    private String renewalNoticeYn;

    private String noticeTemplate;

    private Short firstNeBeforeEnddateDays;

    private Short secondNeBeforeEnddateDays;

    private Short thirdNeBeforeEnddateDays;

    private String status;

    private String remark;

    private String createdUser;

    private String lastUpdatedUser;

    private Date createdDate;

    private Date lastUpdatedDate;

    private Short fourthNeBeforeEnddateDays;

    private Short fifthNeBeforeEnddateDays;

    private String autoRenewalNoticeYn;

    public Short getRenewalNoticeRuleId() {
        return renewalNoticeRuleId;
    }

    public void setRenewalNoticeRuleId(Short renewalNoticeRuleId) {
        this.renewalNoticeRuleId = renewalNoticeRuleId;
    }

    public String getRenewalNoticeRuleName() {
        return renewalNoticeRuleName;
    }

    public void setRenewalNoticeRuleName(String renewalNoticeRuleName) {
        this.renewalNoticeRuleName = renewalNoticeRuleName == null ? null : renewalNoticeRuleName.trim();
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode == null ? null : agencyCode.trim();
    }

    public String getGroupPlanCode() {
        return groupPlanCode;
    }

    public void setGroupPlanCode(String groupPlanCode) {
        this.groupPlanCode = groupPlanCode == null ? null : groupPlanCode.trim();
    }

    public String getRenewalNoticeYn() {
        return renewalNoticeYn;
    }

    public void setRenewalNoticeYn(String renewalNoticeYn) {
        this.renewalNoticeYn = renewalNoticeYn == null ? null : renewalNoticeYn.trim();
    }

    public String getNoticeTemplate() {
        return noticeTemplate;
    }

    public void setNoticeTemplate(String noticeTemplate) {
        this.noticeTemplate = noticeTemplate == null ? null : noticeTemplate.trim();
    }

    public Short getFirstNeBeforeEnddateDays() {
        return firstNeBeforeEnddateDays;
    }

    public void setFirstNeBeforeEnddateDays(Short firstNeBeforeEnddateDays) {
        this.firstNeBeforeEnddateDays = firstNeBeforeEnddateDays;
    }

    public Short getSecondNeBeforeEnddateDays() {
        return secondNeBeforeEnddateDays;
    }

    public void setSecondNeBeforeEnddateDays(Short secondNeBeforeEnddateDays) {
        this.secondNeBeforeEnddateDays = secondNeBeforeEnddateDays;
    }

    public Short getThirdNeBeforeEnddateDays() {
        return thirdNeBeforeEnddateDays;
    }

    public void setThirdNeBeforeEnddateDays(Short thirdNeBeforeEnddateDays) {
        this.thirdNeBeforeEnddateDays = thirdNeBeforeEnddateDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
    }

    public String getLastUpdatedUser() {
        return lastUpdatedUser;
    }

    public void setLastUpdatedUser(String lastUpdatedUser) {
        this.lastUpdatedUser = lastUpdatedUser == null ? null : lastUpdatedUser.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Short getFourthNeBeforeEnddateDays() {
        return fourthNeBeforeEnddateDays;
    }

    public void setFourthNeBeforeEnddateDays(Short fourthNeBeforeEnddateDays) {
        this.fourthNeBeforeEnddateDays = fourthNeBeforeEnddateDays;
    }

    public Short getFifthNeBeforeEnddateDays() {
        return fifthNeBeforeEnddateDays;
    }

    public void setFifthNeBeforeEnddateDays(Short fifthNeBeforeEnddateDays) {
        this.fifthNeBeforeEnddateDays = fifthNeBeforeEnddateDays;
    }

    public String getAutoRenewalNoticeYn() {
        return autoRenewalNoticeYn;
    }

    public void setAutoRenewalNoticeYn(String autoRenewalNoticeYn) {
        this.autoRenewalNoticeYn = autoRenewalNoticeYn == null ? null : autoRenewalNoticeYn.trim();
    }
}