package com.qst.crop.service.impl;

import com.qst.crop.dao.AdviceDao;
import com.qst.crop.entity.Advice;
import com.qst.crop.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    private AdviceDao adviceDao;
    @Override
    public void add(Advice advice1) {
        adviceDao.insertSelective(advice1);
    }

    @Override
    public List<Advice> selectAll() {
        List<Advice> advice = adviceDao.selectAll();
        return advice;
    }
}
