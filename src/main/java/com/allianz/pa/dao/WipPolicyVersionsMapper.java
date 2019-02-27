package com.allianz.pa.dao;

import com.allianz.pa.entity.WipPolicyVersions;

public interface WipPolicyVersionsMapper {
    int deleteByPrimaryKey(Long contractId);

    int insert(WipPolicyVersions record);

    int insertSelective(WipPolicyVersions record);

    WipPolicyVersions selectByPrimaryKey(Long contractId);

    int updateByPrimaryKeySelective(WipPolicyVersions record);

    int updateByPrimaryKey(WipPolicyVersions record);
}