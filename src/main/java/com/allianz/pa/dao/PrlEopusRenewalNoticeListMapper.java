package com.allianz.pa.dao;

import com.allianz.pa.entity.PrlEopusRenewalNoticeList;
import com.allianz.pa.entity.PrlEopusRenewalNoticeListKey;

public interface PrlEopusRenewalNoticeListMapper {
    int deleteByPrimaryKey(PrlEopusRenewalNoticeListKey key);

    int insert(PrlEopusRenewalNoticeList record);

    int insertSelective(PrlEopusRenewalNoticeList record);

    PrlEopusRenewalNoticeList selectByPrimaryKey(PrlEopusRenewalNoticeListKey key);

    int updateByPrimaryKeySelective(PrlEopusRenewalNoticeList record);

    int updateByPrimaryKeyWithBLOBs(PrlEopusRenewalNoticeList record);

    int updateByPrimaryKey(PrlEopusRenewalNoticeList record);
}