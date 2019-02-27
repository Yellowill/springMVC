package com.allianz.pa.dao;

import java.util.List;

import com.allianz.pa.entity.WipPrlPartPlanBenExt;
import com.allianz.pa.entity.WipPrlPartPlanBenExtKey;

public interface WipPrlPartPlanBenExtMapper {
    int deleteByPrimaryKey(WipPrlPartPlanBenExtKey key);

    int insert(WipPrlPartPlanBenExt record);

    int insertSelective(WipPrlPartPlanBenExt record);

    WipPrlPartPlanBenExt selectByPrimaryKey(WipPrlPartPlanBenExtKey key);

    int updateByPrimaryKeySelective(WipPrlPartPlanBenExt record);

    int updateByPrimaryKey(WipPrlPartPlanBenExt record);
    
    List<WipPrlPartPlanBenExt> selectByContractId(Long contractId);
}