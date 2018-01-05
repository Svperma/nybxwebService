package com.dsib.dao;

import com.dsib.entity.PolicyItemKind;
import com.dsib.entity.PolicyItemKindKey;

public interface PolicyItemKindMapper {
    int deleteByPrimaryKey(PolicyItemKindKey key);

    int insert(PolicyItemKind record);

    int insertSelective(PolicyItemKind record);

    PolicyItemKind selectByPrimaryKey(PolicyItemKindKey key);

    int updateByPrimaryKeySelective(PolicyItemKind record);

    int updateByPrimaryKey(PolicyItemKind record);
}