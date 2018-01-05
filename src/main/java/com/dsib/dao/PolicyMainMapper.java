package com.dsib.dao;

import com.dsib.entity.PolicyMain;

public interface PolicyMainMapper {
    int deleteByPrimaryKey(String businessNo);

    int insert(PolicyMain record);

    int insertSelective(PolicyMain record);

    PolicyMain selectByPrimaryKey(String businessNo);

    int updateByPrimaryKeySelective(PolicyMain record);

    int updateByPrimaryKey(PolicyMain record);

	PolicyMain findByPolicyNo(String policyNo);
}