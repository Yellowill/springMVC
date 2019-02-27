package com.allianz.pa.dao;

import com.allianz.pa.entity.PrlThirdpInterfPolData;
import com.allianz.pa.entity.PrlThirdpInterfPolDataKey;

public interface PrlThirdpInterfPolDataMapper {
    int deleteByPrimaryKey(PrlThirdpInterfPolDataKey key);

    int insert(PrlThirdpInterfPolData record);

    int insertSelective(PrlThirdpInterfPolData record);

    PrlThirdpInterfPolData selectByPrimaryKey(PrlThirdpInterfPolDataKey key);

    int updateByPrimaryKeySelective(PrlThirdpInterfPolData record);

    int updateByPrimaryKey(PrlThirdpInterfPolData record);
}