package com.dsib.dao;

import com.dsib.entity.ClaimInsured;
import com.dsib.entity.ClaimInsuredKey;

public interface ClaimInsuredMapper {
    int deleteByPrimaryKey(ClaimInsuredKey key);

    int insert(ClaimInsured record);

    int insertSelective(ClaimInsured record);

    ClaimInsured selectByPrimaryKey(ClaimInsuredKey key);

    int updateByPrimaryKeySelective(ClaimInsured record);

    int updateByPrimaryKey(ClaimInsured record);
}