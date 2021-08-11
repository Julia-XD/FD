package com.example.demo.service;

import com.example.demo.entity.Fund;
import com.example.demo.entity.FundManager;
import com.example.demo.mapper.FundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundService {
    @Autowired
    private FundMapper fundMapper;
    public boolean add(int id,String name){
        Fund fund = new Fund();
        fund.setEmployeeId(id);
        fund.setName(name);
        int flag = fundMapper.insert(fund);

        return flag==1;
    }
    public boolean isFund(int id){
        Fund fund = fundMapper.selectByPrimaryKey(id);
        return fund!=null;
    }
}
