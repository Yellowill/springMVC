package com.allianz.pa.dao;

import java.util.List;

import com.allianz.pa.entity.WipPrlPartInsBenExt;
import com.allianz.pa.entity.WipPrlPartInsBenExtKey;

public interface WipPrlPartInsBenExtMapper {
    int deleteByPrimaryKey(WipPrlPartInsBenExtKey key);

    int insert(WipPrlPartInsBenExt record);

    int insertSelective(WipPrlPartInsBenExt record);

    WipPrlPartInsBenExt selectByPrimaryKey(WipPrlPartInsBenExtKey key);

    int updateByPrimaryKeySelective(WipPrlPartInsBenExt record);

    int updateByPrimaryKey(WipPrlPartInsBenExt record);
    
    public int insertByBatch(List<WipPrlPartInsBenExt> beneficiaryBigList);
}