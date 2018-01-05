package com.dsib.dao;

import com.dsib.entity.Jg_GuPolicyMain;

public interface Jg_GuPolicyMainMapper {
    int deleteByPrimaryKey(String businessno);

    int insert(Jg_GuPolicyMain record);

    int insertSelective(Jg_GuPolicyMain record);

    Jg_GuPolicyMain selectByPrimaryKey(String businessno);

    int updateByPrimaryKeySelective(Jg_GuPolicyMain record);

    int updateByPrimaryKey(Jg_GuPolicyMain record);

	Jg_GuPolicyMain findByPolicyNo(String policyNo);
}