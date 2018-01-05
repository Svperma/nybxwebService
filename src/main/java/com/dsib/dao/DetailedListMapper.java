package com.dsib.dao;

import com.dsib.entity.DetailedList;
import com.dsib.entity.DetailedListKey;

public interface DetailedListMapper {
    int deleteByPrimaryKey(DetailedListKey key);

    int insert(DetailedList record);

    int insertSelective(DetailedList record);

    DetailedList selectByPrimaryKey(DetailedListKey key);

    int updateByPrimaryKeySelective(DetailedList record);

    int updateByPrimaryKey(DetailedList record);
}