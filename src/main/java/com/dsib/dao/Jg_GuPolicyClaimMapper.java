package com.dsib.dao;

import java.util.List;

import com.dsib.entity.Jg_GuPolicyClaim;

public interface Jg_GuPolicyClaimMapper {
    int deleteByPrimaryKey(String businessno);

    int insert(Jg_GuPolicyClaim record);

    int insertSelective(Jg_GuPolicyClaim record);

    Jg_GuPolicyClaim selectByPrimaryKey(String businessno);

    int updateByPrimaryKeySelective(Jg_GuPolicyClaim record);

    int updateByPrimaryKey(Jg_GuPolicyClaim record);

	void deleteByReportNo(String reportNo);
	
	List<Jg_GuPolicyClaim> findByReportNo(String reportno);
}