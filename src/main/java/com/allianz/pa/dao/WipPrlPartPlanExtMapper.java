package com.allianz.pa.dao;

import com.allianz.pa.entity.WipPrlPartPlanExt;
import com.allianz.pa.entity.WipPrlPartPlanExtKey;

public interface WipPrlPartPlanExtMapper {
    int deleteByPrimaryKey(WipPrlPartPlanExtKey key);

    int insert(WipPrlPartPlanExt record);

    int insertSelective(WipPrlPartPlanExt record);

    WipPrlPartPlanExt selectByPrimaryKey(WipPrlPartPlanExtKey key);

    int updateByPrimaryKeySelective(WipPrlPartPlanExt record);

    int updateByPrimaryKey(WipPrlPartPlanExt record);
}