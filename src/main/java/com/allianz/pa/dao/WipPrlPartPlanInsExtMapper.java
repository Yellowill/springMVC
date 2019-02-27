package com.allianz.pa.dao;

import java.util.List;

import com.allianz.pa.entity.WipPrlPartPlanInsExt;
import com.allianz.pa.entity.WipPrlPartPlanInsExtKey;

public interface WipPrlPartPlanInsExtMapper {
    int deleteByPrimaryKey(WipPrlPartPlanInsExtKey key);

    int insert(WipPrlPartPlanInsExt record);

    int insertSelective(WipPrlPartPlanInsExt record);

    WipPrlPartPlanInsExt selectByPrimaryKey(WipPrlPartPlanInsExtKey key);

    int updateByPrimaryKeySelective(WipPrlPartPlanInsExt record);

    int updateByPrimaryKey(WipPrlPartPlanInsExt record);
    
    public int insertByBatch(List<WipPrlPartPlanInsExt> wipInsList);
    
    public int updateByBatchSelective(List<WipPrlPartPlanInsExt> wipInsList);
}