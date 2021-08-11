package com.example.demo.service;

import com.example.demo.entity.FundManager;
import com.example.demo.entity.Security;
import com.example.demo.mapper.SecurityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Autowired
    private SecurityMapper securityMapper;

    public boolean add(String symbol){
        Security security = new Security();
        security.setSymbol(symbol);


        return 1==securityMapper.insert(security);
    }
}
