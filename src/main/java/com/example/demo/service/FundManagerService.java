package com.example.demo.service;

import com.example.demo.entity.FundManager;
import com.example.demo.entity.FundManagerExample;
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

    public List<FundManager> list1(String name){
        String[] strs=name.split(" ");
        String firstname = strs[0].toString();
        String lastname = strs[1].toString();
        FundManagerExample fundManagerExample = new FundManagerExample();
        FundManagerExample.Criteria criteria = fundManagerExample.createCriteria();
        criteria.andFirstnameLike("%"+firstname+"%");

        FundManagerExample.Criteria criteria1 = fundManagerExample.createCriteria();
        criteria1.andFirstnameLike("%"+lastname+"%");
        fundManagerExample.or(criteria1);
        return fundManagerMapper.selectByExample(fundManagerExample);
    }

    public List<FundManager> list2(int id ){
        FundManagerExample fundManagerExample = new FundManagerExample();
        FundManagerExample.Criteria criteria = fundManagerExample.createCriteria();
        criteria.andEmployeeIdEqualTo(id);
        return fundManagerMapper.selectByExample(fundManagerExample);
    }
}
