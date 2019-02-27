package com.allianz.pa.entity;

import java.util.Date;

public class PrlEopusRenewalNoticeList extends PrlEopusRenewalNoticeListKey {
    private String policyRef;

    private String prpName;

    private String prpIdNo;

    private String prpEmail;

    private String prpPhone;

    private Date firstNoticeTime;

    private String firstNoticeSmsStatus;

    private String firstNoticeEmailStatus;

    private Date secondNoticeTime;

    private String secondNoticeSmsStatus;

    private String secondNoticeEmailStatus;

    private Date thirdNoticeTime;

    private String thirdNoticeSmsStatus;

    private String thirdNoticeEmailStatus;

    private String noticeSmsContent;

    private String noticeEmailSubject;

    private String noticeProcess;

    private Date createdDate;

    private Date lastUpdatedDate;

    private String remark;

    private String errorMessage;

    private Date fourthNoticeTime;

    private String fourthNoticeSmsStatus;

    private String fourthNoticeEmailStatus;

    private Date fifthNoticeTime;

    private String fifthNoticeSmsStatus;

    private String fifthNoticeEmailStatus;

    private String bizType;

    private Long newContractId;

    private String newPolicyRef;

    private String debitRequestSn;

    private String debitResponseCode;

    private String debitResponseMsg;

    private String noticeEmailContent;

    public String getPolicyRef() {
        return policyRef;
    }

    public void setPolicyRef(String policyRef) {
        this.policyRef = policyRef == null ? null : policyRef.trim();
    }

    public String getPrpName() {
        return prpName;
    }

    public void setPrpName(String prpName) {
        this.prpName = prpName == null ? null : prpName.trim();
    }

    public String getPrpIdNo() {
        return prpIdNo;
    }

    public void setPrpIdNo(String prpIdNo) {
        this.prpIdNo = prpIdNo == null ? null : prpIdNo.trim();
    }

    public String getPrpEmail() {
        return prpEmail;
    }

    public void setPrpEmail(String prpEmail) {
        this.prpEmail = prpEmail == null ? null : prpEmail.trim();
    }

    public String getPrpPhone() {
        return prpPhone;
    }

    public void setPrpPhone(String prpPhone) {
        this.prpPhone = prpPhone == null ? null : prpPhone.trim();
    }

    public Date getFirstNoticeTime() {
        return firstNoticeTime;
    }

    public void setFirstNoticeTime(Date firstNoticeTime) {
        this.firstNoticeTime = firstNoticeTime;
    }

    public String getFirstNoticeSmsStatus() {
        return firstNoticeSmsStatus;
    }

    public void setFirstNoticeSmsStatus(String firstNoticeSmsStatus) {
        this.firstNoticeSmsStatus = firstNoticeSmsStatus == null ? null : firstNoticeSmsStatus.trim();
    }

    public String getFirstNoticeEmailStatus() {
        return firstNoticeEmailStatus;
    }

    public void setFirstNoticeEmailStatus(String firstNoticeEmailStatus) {
        this.firstNoticeEmailStatus = firstNoticeEmailStatus == null ? null : firstNoticeEmailStatus.trim();
    }

    public Date getSecondNoticeTime() {
        return secondNoticeTime;
    }

    public void setSecondNoticeTime(Date secondNoticeTime) {
        this.secondNoticeTime = secondNoticeTime;
    }

    public String getSecondNoticeSmsStatus() {
        return secondNoticeSmsStatus;
    }

    public void setSecondNoticeSmsStatus(String secondNoticeSmsStatus) {
        this.secondNoticeSmsStatus = secondNoticeSmsStatus == null ? null : secondNoticeSmsStatus.trim();
    }

    public String getSecondNoticeEmailStatus() {
        return secondNoticeEmailStatus;
    }

    public void setSecondNoticeEmailStatus(String secondNoticeEmailStatus) {
        this.secondNoticeEmailStatus = secondNoticeEmailStatus == null ? null : secondNoticeEmailStatus.trim();
    }

    public Date getThirdNoticeTime() {
        return thirdNoticeTime;
    }

    public void setThirdNoticeTime(Date thirdNoticeTime) {
        this.thirdNoticeTime = thirdNoticeTime;
    }

    public String getThirdNoticeSmsStatus() {
        return thirdNoticeSmsStatus;
    }

    public void setThirdNoticeSmsStatus(String thirdNoticeSmsStatus) {
        this.thirdNoticeSmsStatus = thirdNoticeSmsStatus == null ? null : thirdNoticeSmsStatus.trim();
    }

    public String getThirdNoticeEmailStatus() {
        return thirdNoticeEmailStatus;
    }

    public void setThirdNoticeEmailStatus(String thirdNoticeEmailStatus) {
        this.thirdNoticeEmailStatus = thirdNoticeEmailStatus == null ? null : thirdNoticeEmailStatus.trim();
    }

    public String getNoticeSmsContent() {
        return noticeSmsContent;
    }

    public void setNoticeSmsContent(String noticeSmsContent) {
        this.noticeSmsContent = noticeSmsContent == null ? null : noticeSmsContent.trim();
    }

    public String getNoticeEmailSubject() {
        return noticeEmailSubject;
    }

    public void setNoticeEmailSubject(String noticeEmailSubject) {
        this.noticeEmailSubject = noticeEmailSubject == null ? null : noticeEmailSubject.trim();
    }

    public String getNoticeProcess() {
        return noticeProcess;
    }

    public void setNoticeProcess(String noticeProcess) {
        this.noticeProcess = noticeProcess == null ? null : noticeProcess.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
    }

    public Date getFourthNoticeTime() {
        return fourthNoticeTime;
    }

    public void setFourthNoticeTime(Date fourthNoticeTime) {
        this.fourthNoticeTime = fourthNoticeTime;
    }

    public String getFourthNoticeSmsStatus() {
        return fourthNoticeSmsStatus;
    }

    public void setFourthNoticeSmsStatus(String fourthNoticeSmsStatus) {
        this.fourthNoticeSmsStatus = fourthNoticeSmsStatus == null ? null : fourthNoticeSmsStatus.trim();
    }

    public String getFourthNoticeEmailStatus() {
        return fourthNoticeEmailStatus;
    }

    public void setFourthNoticeEmailStatus(String fourthNoticeEmailStatus) {
        this.fourthNoticeEmailStatus = fourthNoticeEmailStatus == null ? null : fourthNoticeEmailStatus.trim();
    }

    public Date getFifthNoticeTime() {
        return fifthNoticeTime;
    }

    public void setFifthNoticeTime(Date fifthNoticeTime) {
        this.fifthNoticeTime = fifthNoticeTime;
    }

    public String getFifthNoticeSmsStatus() {
        return fifthNoticeSmsStatus;
    }

    public void setFifthNoticeSmsStatus(String fifthNoticeSmsStatus) {
        this.fifthNoticeSmsStatus = fifthNoticeSmsStatus == null ? null : fifthNoticeSmsStatus.trim();
    }

    public String getFifthNoticeEmailStatus() {
        return fifthNoticeEmailStatus;
    }

    public void setFifthNoticeEmailStatus(String fifthNoticeEmailStatus) {
        this.fifthNoticeEmailStatus = fifthNoticeEmailStatus == null ? null : fifthNoticeEmailStatus.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public Long getNewContractId() {
        return newContractId;
    }

    public void setNewContractId(Long newContractId) {
        this.newContractId = newContractId;
    }

    public String getNewPolicyRef() {
        return newPolicyRef;
    }

    public void setNewPolicyRef(String newPolicyRef) {
        this.newPolicyRef = newPolicyRef == null ? null : newPolicyRef.trim();
    }

    public String getDebitRequestSn() {
        return debitRequestSn;
    }

    public void setDebitRequestSn(String debitRequestSn) {
        this.debitRequestSn = debitRequestSn == null ? null : debitRequestSn.trim();
    }

    public String getDebitResponseCode() {
        return debitResponseCode;
    }

    public void setDebitResponseCode(String debitResponseCode) {
        this.debitResponseCode = debitResponseCode == null ? null : debitResponseCode.trim();
    }

    public String getDebitResponseMsg() {
        return debitResponseMsg;
    }

    public void setDebitResponseMsg(String debitResponseMsg) {
        this.debitResponseMsg = debitResponseMsg == null ? null : debitResponseMsg.trim();
    }

    public String getNoticeEmailContent() {
        return noticeEmailContent;
    }

    public void setNoticeEmailContent(String noticeEmailContent) {
        this.noticeEmailContent = noticeEmailContent == null ? null : noticeEmailContent.trim();
    }
}