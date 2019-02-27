package com.allianz.pa.dao;

import com.allianz.pa.entity.WipPrlPartPlanFlights;
import com.allianz.pa.entity.WipPrlPartPlanFlightsKey;

public interface WipPrlPartPlanFlightsMapper {
    int deleteByPrimaryKey(WipPrlPartPlanFlightsKey key);

    int insert(WipPrlPartPlanFlights record);

    int insertSelective(WipPrlPartPlanFlights record);

    WipPrlPartPlanFlights selectByPrimaryKey(WipPrlPartPlanFlightsKey key);

    int updateByPrimaryKeySelective(WipPrlPartPlanFlights record);

    int updateByPrimaryKey(WipPrlPartPlanFlights record);
}