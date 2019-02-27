package com.allianz.pa.dao;

import com.allianz.pa.entity.WipInterestedParties;
import com.allianz.pa.entity.WipInterestedPartiesKey;

public interface WipInterestedPartiesMapper {
    int deleteByPrimaryKey(WipInterestedPartiesKey key);

    int insert(WipInterestedParties record);

    int insertSelective(WipInterestedParties record);

    WipInterestedParties selectByPrimaryKey(WipInterestedPartiesKey key);

    int updateByPrimaryKeySelective(WipInterestedParties record);

    int updateByPrimaryKey(WipInterestedParties record);
}