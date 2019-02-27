package com.allianz.pa.dao;


import com.allianz.pa.entity.WipPolicyContracts;

public interface WipPolicyContractsMapper{
    int deleteByPrimaryKey(Long contractId);

    int insert(WipPolicyContracts record);

    int insertSelective(WipPolicyContracts record);

    WipPolicyContracts selectByPrimaryKey(Long contractId);

    int updateByPrimaryKey(WipPolicyContracts record);
	
	WipPolicyContracts getWipPolicyContracts(long contractId);
	
	int updateByPrimaryKeySelective(WipPolicyContracts record);
}