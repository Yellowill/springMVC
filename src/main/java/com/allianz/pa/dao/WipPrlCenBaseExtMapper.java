package com.allianz.pa.dao;

import com.allianz.pa.entity.WipPrlCenBaseExt;

public interface WipPrlCenBaseExtMapper {
    int deleteByPrimaryKey(Long contractId);

    int insert(WipPrlCenBaseExt record);

    int insertSelective(WipPrlCenBaseExt record);

    WipPrlCenBaseExt selectByPrimaryKey(Long contractId);

    int updateByPrimaryKeySelective(WipPrlCenBaseExt record);

    int updateByPrimaryKey(WipPrlCenBaseExt record);
}