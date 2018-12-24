package com.baizhi.tss.service;

import com.baizhi.tss.dao.PoetryDAO;
import com.baizhi.tss.entity.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PoetryServiceImpl implements PoetryService {

    @Autowired
    private PoetryDAO poetryDAO;

    @Override
    public List<Poetry> queryAll() {
        return poetryDAO.findAll();
    }
}
