package com.allianz.pa.dao;

import com.allianz.pa.entity.WipPrlFirePartitionExt;
import com.allianz.pa.entity.WipPrlFirePartitionExtKey;

public interface WipPrlFirePartitionExtMapper {
    int deleteByPrimaryKey(WipPrlFirePartitionExtKey key);

    int insert(WipPrlFirePartitionExt record);

    int insertSelective(WipPrlFirePartitionExt record);

    WipPrlFirePartitionExt selectByPrimaryKey(WipPrlFirePartitionExtKey key);

    int updateByPrimaryKeySelective(WipPrlFirePartitionExt record);

    int updateByPrimaryKey(WipPrlFirePartitionExt record);
}