package com.example.demo.service;

import com.example.demo.entity.Position;
import com.example.demo.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class PositionService {
    @Autowired
    private PositionMapper positionMapper;

    public boolean add(int fundid,int securityid,int quantity){
        Position position =new Position();
        position.setFundId(fundid);
        position.setSecurityId(securityid);
        position.setQuantity(quantity);
        Date date = new Date();

        position.setDate(date);
        return 1==positionMapper.insert(position);
    }
}
