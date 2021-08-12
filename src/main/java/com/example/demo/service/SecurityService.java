/**
 * @author Bei Zhu
 */
package com.example.demo.service;

import com.example.demo.entity.FundManager;
import com.example.demo.entity.Security;
import com.example.demo.entity.SecurityExample;
import com.example.demo.mapper.SecurityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {
    @Autowired
    private SecurityMapper securityMapper;

    public boolean add(String symbol){
        Security security = new Security();
        security.setSymbol(symbol);


        return 1==securityMapper.insert(security);
    }

    public boolean isSecurity(int id){
        Security security = securityMapper.selectByPrimaryKey(id);
        return security!=null;
    }

    //Bei Zhu
    public List<Security> list(){
        return securityMapper.selectByExample(null);
    }


    public List<Security> list1(int securityId){
        SecurityExample securityExample = new SecurityExample();
        SecurityExample.Criteria criteria = securityExample.createCriteria();
        criteria.andSecurityIdEqualTo(securityId);
        return securityMapper.selectByExample(securityExample);
    }


 /*   public boolean add(int id, String symbol){
        Security security = new Security();
        security.setSecurityId(id);
        security.setSymbol(symbol);
        return 1==securityMapper.insert(security);
    }*/




    public boolean update(int securityId, String symbol){
        Security security = new Security();
        security.setSecurityId(securityId);
        security.setSymbol(symbol);

        return 1==securityMapper.updateByPrimaryKey(security);

    }

    public boolean delete(int securityId){
        return 1==securityMapper.deleteByPrimaryKey(securityId);
    }


}
