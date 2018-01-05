package com.dsib.dao;

import com.dsib.entity.PolicyApplicant;

public interface PolicyApplicantMapper {
    int deleteByPrimaryKey(String businessNo);

    int insert(PolicyApplicant record);

    int insertSelective(PolicyApplicant record);

    PolicyApplicant selectByPrimaryKey(String businessNo);

    int updateByPrimaryKeySelective(PolicyApplicant record);

    int updateByPrimaryKey(PolicyApplicant record);
}