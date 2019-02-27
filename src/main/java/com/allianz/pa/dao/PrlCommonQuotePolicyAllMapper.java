package com.allianz.pa.dao;

import org.apache.ibatis.annotations.Param;

import com.allianz.pa.entity.PrlCommonQuotePolicyAll;

public interface PrlCommonQuotePolicyAllMapper {
    int insert(PrlCommonQuotePolicyAll record);

    int insertSelective(PrlCommonQuotePolicyAll record);
    
    PrlCommonQuotePolicyAll selectByContractId(long contractId);
    
    int updateByContractIdSelective(PrlCommonQuotePolicyAll record);
    
    void deleteByContractId(@Param("contractId") Long contractId);
}