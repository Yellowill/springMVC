package com.allianz.pa.dao;

import com.allianz.pa.entity.WipPrlIpExt;
import com.allianz.pa.entity.WipPrlIpExtKey;

public interface WipPrlIpExtMapper {
    int deleteByPrimaryKey(WipPrlIpExtKey key);

    int insert(WipPrlIpExt record);

    int insertSelective(WipPrlIpExt record);

    WipPrlIpExt selectByPrimaryKey(WipPrlIpExtKey key);

    int updateByPrimaryKeySelective(WipPrlIpExt record);

    int updateByPrimaryKey(WipPrlIpExt record);
}