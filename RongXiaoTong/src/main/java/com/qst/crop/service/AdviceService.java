package com.qst.crop.service;

import com.qst.crop.entity.Advice;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdviceService {
    void add(Advice advice1);

    List<Advice> selectAll();
}
