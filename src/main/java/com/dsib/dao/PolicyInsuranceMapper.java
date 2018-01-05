package com.dsib.dao;

import com.dsib.entity.PolicyInsurance;
import com.dsib.entity.PolicyInsuranceKey;

public interface PolicyInsuranceMapper {
    int deleteByPrimaryKey(PolicyInsuranceKey key);

    int insert(PolicyInsurance record);

    int insertSelective(PolicyInsurance record);

    PolicyInsurance selectByPrimaryKey(PolicyInsuranceKey key);

    int updateByPrimaryKeySelective(PolicyInsurance record);

    int updateByPrimaryKey(PolicyInsurance record);
}