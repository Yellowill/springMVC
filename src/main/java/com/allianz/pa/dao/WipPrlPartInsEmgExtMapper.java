package com.allianz.pa.dao;

import java.util.List;

import com.allianz.pa.entity.WipPrlPartInsEmgExt;
import com.allianz.pa.entity.WipPrlPartInsEmgExtKey;

public interface WipPrlPartInsEmgExtMapper {
    int deleteByPrimaryKey(WipPrlPartInsEmgExtKey key);

    int insert(WipPrlPartInsEmgExt record);

    int insertSelective(WipPrlPartInsEmgExt record);

    WipPrlPartInsEmgExt selectByPrimaryKey(WipPrlPartInsEmgExtKey key);

    int updateByPrimaryKeySelective(WipPrlPartInsEmgExt record);

    int updateByPrimaryKey(WipPrlPartInsEmgExt record);
    
    public int insertByBatch(List<WipPrlPartInsEmgExt> emergencyContactBigList);
}