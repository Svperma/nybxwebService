package com.dsib.dao;

import com.dsib.entity.PolicyInsured;

public interface PolicyInsuredMapper {
    int deleteByPrimaryKey(String businessNo);

    int insert(PolicyInsured record);

    int insertSelective(PolicyInsured record);

    PolicyInsured selectByPrimaryKey(String businessNo);

    int updateByPrimaryKeySelective(PolicyInsured record);

    int updateByPrimaryKey(PolicyInsured record);
}