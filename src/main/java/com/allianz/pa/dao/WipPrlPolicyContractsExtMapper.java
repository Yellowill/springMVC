package com.allianz.pa.dao;

import com.allianz.pa.entity.WipPrlPolicyContractsExt;

public interface WipPrlPolicyContractsExtMapper {
    int deleteByPrimaryKey(Long contractId);

    int insert(WipPrlPolicyContractsExt record);

    int insertSelective(WipPrlPolicyContractsExt record);

    WipPrlPolicyContractsExt selectByPrimaryKey(Long contractId);

    int updateByPrimaryKeySelective(WipPrlPolicyContractsExt record);

    int updateByPrimaryKey(WipPrlPolicyContractsExt record);
}