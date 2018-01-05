package com.dsib.dao;

import com.dsib.entity.PolicyOrganizer;

public interface PolicyOrganizerMapper {
    int deleteByPrimaryKey(String businessNo);

    int insert(PolicyOrganizer record);

    int insertSelective(PolicyOrganizer record);

    PolicyOrganizer selectByPrimaryKey(String businessNo);

    int updateByPrimaryKeySelective(PolicyOrganizer record);

    int updateByPrimaryKey(PolicyOrganizer record);
}