package com.dsib.dao;

import com.dsib.entity.Jg_Insurance;
import com.dsib.entity.Jg_InsuranceKey;

public interface Jg_InsuranceMapper {
    int deleteByPrimaryKey(Jg_InsuranceKey key);

    int insert(Jg_Insurance record);

    int insertSelective(Jg_Insurance record);

    Jg_Insurance selectByPrimaryKey(Jg_InsuranceKey key);

    int updateByPrimaryKeySelective(Jg_Insurance record);

    int updateByPrimaryKey(Jg_Insurance record);

	void deleteByPolicyNo(Jg_InsuranceKey jg_InsuranceKey);
}