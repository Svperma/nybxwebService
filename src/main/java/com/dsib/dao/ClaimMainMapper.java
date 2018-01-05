package com.dsib.dao;

import com.dsib.entity.ClaimMain;

public interface ClaimMainMapper {
    int deleteByPrimaryKey(String businessNo);

    int insert(ClaimMain record);

    int insertSelective(ClaimMain record);

    ClaimMain selectByPrimaryKey(String businessNo);

    int updateByPrimaryKeySelective(ClaimMain record);

    int updateByPrimaryKey(ClaimMain record);

	ClaimMain findByReportNo(String reportNo);
}