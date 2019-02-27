package com.allianz.pa.entity;

public class WipIpLinksKey {
    private Long contractId;

    private Integer ipNo;

    private Integer ipLinkNo;

    public WipIpLinksKey() {
	}

	public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Integer getIpNo() {
        return ipNo;
    }

    public void setIpNo(Integer ipNo) {
        this.ipNo = ipNo;
    }

    public Integer getIpLinkNo() {
        return ipLinkNo;
    }

    public void setIpLinkNo(Integer ipLinkNo) {
        this.ipLinkNo = ipLinkNo;
    }
}