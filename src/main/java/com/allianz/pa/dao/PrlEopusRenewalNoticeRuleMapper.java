package com.allianz.pa.dao;

import com.allianz.pa.entity.PrlEopusRenewalNoticeRule;

public interface PrlEopusRenewalNoticeRuleMapper {
    int deleteByPrimaryKey(Short renewalNoticeRuleId);

    int insert(PrlEopusRenewalNoticeRule record);

    int insertSelective(PrlEopusRenewalNoticeRule record);

    PrlEopusRenewalNoticeRule selectByPrimaryKey(Short renewalNoticeRuleId);

    int updateByPrimaryKeySelective(PrlEopusRenewalNoticeRule record);

    int updateByPrimaryKey(PrlEopusRenewalNoticeRule record);
}