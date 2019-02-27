package com.allianz.pa.dao;

import com.allianz.pa.entity.WipPrlPartPlanJdInsExt;
import com.allianz.pa.entity.WipPrlPartPlanJdInsExtKey;

public interface WipPrlPartPlanJdInsExtMapper {
    int deleteByPrimaryKey(WipPrlPartPlanJdInsExtKey key);

    int insert(WipPrlPartPlanJdInsExt record);

    int insertSelective(WipPrlPartPlanJdInsExt record);

    WipPrlPartPlanJdInsExt selectByPrimaryKey(WipPrlPartPlanJdInsExtKey key);

    int updateByPrimaryKeySelective(WipPrlPartPlanJdInsExt record);

    int updateByPrimaryKey(WipPrlPartPlanJdInsExt record);
}