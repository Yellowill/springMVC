package com.allianz.pa.entity;

public class WipPrlIpExtKey {
    public WipPrlIpExtKey() {
    	
	}

	private Long contractId;

    private Integer ipNo;

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
}