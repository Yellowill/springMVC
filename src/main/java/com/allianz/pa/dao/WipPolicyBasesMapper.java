package com.allianz.pa.dao;

import com.allianz.pa.entity.WipPolicyBases;

public interface WipPolicyBasesMapper {
    int deleteByPrimaryKey(Long contractId);

    int insert(WipPolicyBases record);

    int insertSelective(WipPolicyBases record);

    WipPolicyBases selectByPrimaryKey(Long contractId);

    int updateByPrimaryKeySelective(WipPolicyBases record);

    int updateByPrimaryKey(WipPolicyBases record);
}