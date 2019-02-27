package com.allianz.pa.dao;

import com.allianz.pa.entity.WipIpLinks;
import com.allianz.pa.entity.WipIpLinksKey;

public interface WipIpLinksMapper {
    int deleteByPrimaryKey(WipIpLinksKey key);

    int insert(WipIpLinks record);

    int insertSelective(WipIpLinks record);

    WipIpLinks selectByPrimaryKey(WipIpLinksKey key);

    int updateByPrimaryKeySelective(WipIpLinks record);

    int updateByPrimaryKey(WipIpLinks record);
}