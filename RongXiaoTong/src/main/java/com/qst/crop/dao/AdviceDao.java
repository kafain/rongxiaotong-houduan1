package com.qst.crop.dao;

import com.qst.crop.entity.Advice;

import java.util.List;

public interface AdviceDao {
    int insert(Advice record);

    int insertSelective(Advice record);

    List<Advice> selectAll();
}