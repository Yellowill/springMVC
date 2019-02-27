package com.allianz.pa.dao;

import com.allianz.pa.entity.WipPartitions;
import com.allianz.pa.entity.WipPartitionsKey;

public interface WipPartitionsMapper {
    int deleteByPrimaryKey(WipPartitionsKey key);

    int insert(WipPartitions record);

    int insertSelective(WipPartitions record);

    WipPartitions selectByPrimaryKey(WipPartitionsKey key);

    int updateByPrimaryKeySelective(WipPartitions record);

    int updateByPrimaryKey(WipPartitions record);
}