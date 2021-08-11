package com.example.demo.service;

import com.example.demo.entity.FundManager;
import com.example.demo.mapper.FundManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FundManagerService {

    @Autowired
    private FundManagerMapper fundManagerMapper;

    public List<FundManager> list(){
        return fundManagerMapper.selectByExample(null);
    }
}
