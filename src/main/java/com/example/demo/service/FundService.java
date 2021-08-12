/**
 * @author Xiaohan Chen
 */
package com.example.demo.service;

import com.example.demo.entity.Fund;
import com.example.demo.entity.FundExample;
import com.example.demo.entity.FundManager;
import com.example.demo.entity.FundManagerExample;
import com.example.demo.mapper.FundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundService {

    @Autowired
    private FundMapper fundMapper;

    public List<Fund> list(){
        return fundMapper.selectByExample(null);
    }

    public List<Fund> list1(String name){

        FundExample fundExample = new FundExample();
        FundExample.Criteria criteria = fundExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        return fundMapper.selectByExample(fundExample);
    }

    public List<Fund> list2(int id ){
        FundExample fundExample = new FundExample();
        FundExample.Criteria criteria = fundExample.createCriteria();
        criteria.andEmployeeIdEqualTo(id);
        return fundMapper.selectByExample(fundExample);
    }

    public List<Fund> list3(int id ){

        FundExample fundExample = new FundExample();
        FundExample.Criteria criteria = fundExample.createCriteria();
        criteria.andFundIdEqualTo(id);
        return fundMapper.selectByExample(fundExample);
    }


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

    public boolean update(int fundId,int employeeId,String name){
        Fund fund = new Fund();
        fund.setFundId(fundId);
        fund.setEmployeeId(employeeId);
        fund.setName(name);

        int flag = fundMapper.updateByPrimaryKey(fund);

        return flag==1;
    }
    public boolean delete(int fundId){


        int flag = fundMapper.deleteByPrimaryKey(fundId);

        return flag==1;
    }

}
