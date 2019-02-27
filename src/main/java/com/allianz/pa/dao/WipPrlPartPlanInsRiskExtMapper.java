package com.allianz.pa.dao;

import org.apache.ibatis.annotations.Param;

import com.allianz.pa.entity.WipPrlPartPlanInsRiskExt;
import com.allianz.pa.entity.WipPrlPartPlanInsRiskExtKey;

public interface WipPrlPartPlanInsRiskExtMapper {
    int deleteByPrimaryKey(WipPrlPartPlanInsRiskExtKey key);

    int insert(WipPrlPartPlanInsRiskExt record);

    int insertSelective(WipPrlPartPlanInsRiskExt record);

    WipPrlPartPlanInsRiskExt selectByPrimaryKey(WipPrlPartPlanInsRiskExtKey key);

    int updateByPrimaryKeySelective(WipPrlPartPlanInsRiskExt record);

    int updateByPrimaryKey(WipPrlPartPlanInsRiskExt record);
    
    WipPrlPartPlanInsRiskExt selectByBusinessPK(@Param("contractId") Long contractId, @Param("thirdPartPolicyNo") String thirdPartPolicyNo);
}