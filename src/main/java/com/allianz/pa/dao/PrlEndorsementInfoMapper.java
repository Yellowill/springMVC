package com.allianz.pa.dao;

import com.allianz.pa.entity.PrlEndorsementInfo;
import com.allianz.pa.entity.PrlEndorsementInfoKey;

public interface PrlEndorsementInfoMapper {
    int deleteByPrimaryKey(PrlEndorsementInfoKey key);

    int insert(PrlEndorsementInfo record);

    int insertSelective(PrlEndorsementInfo record);

    PrlEndorsementInfo selectByPrimaryKey(PrlEndorsementInfoKey key);

    int updateByPrimaryKeySelective(PrlEndorsementInfo record);

    int updateByPrimaryKey(PrlEndorsementInfo record);
}