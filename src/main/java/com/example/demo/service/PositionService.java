/**
 * @author Xiang Dong
 */
package com.example.demo.service;

import com.example.demo.entity.Position;
import com.example.demo.entity.PositionExample;
import com.example.demo.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class PositionService {
    @Autowired
    private PositionMapper positionMapper;

    public boolean add(int securityid,int fundid,int quantity){
        Position position =new Position();
        position.setFundId(fundid);
        position.setSecurityId(securityid);
        position.setQuantity(quantity);
        Date date = new Date();

        position.setDate(date);
        return 1==positionMapper.insert(position);
    }

    public List<Position> list(){
        return positionMapper.selectByExample(null);
    }

    public List<Position> list1(int positionId){
        PositionExample positionExample = new PositionExample();
        PositionExample.Criteria criteria = positionExample.createCriteria();
        criteria.andPositionIdEqualTo(positionId);
        return positionMapper.selectByExample(positionExample);
    }

    public List<Position> list2(int securityId){
        PositionExample positionExample = new PositionExample();
        PositionExample.Criteria criteria = positionExample.createCriteria();
        criteria.andSecurityIdEqualTo(securityId);
        return positionMapper.selectByExample(positionExample);
    }

    public List<Position> list3(int fundId){
        PositionExample positionExample = new PositionExample();
        PositionExample.Criteria criteria = positionExample.createCriteria();
        criteria.andFundIdEqualTo(fundId);
        return positionMapper.selectByExample(positionExample);
    }

    public List<Position> list4(int quantity){
        PositionExample positionExample = new PositionExample();
        PositionExample.Criteria criteria = positionExample.createCriteria();
        criteria.andQuantityEqualTo(quantity);
        return positionMapper.selectByExample(positionExample);
    }

   /* public List<Position> list5(String date){

        PositionExample positionExample = new PositionExample();
        PositionExample.Criteria criteria = positionExample.createCriteria();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");//设置时间格式

        Date ts=null;

        try {
            ts = sdf.parse(date);

        } catch (ParseException e) {


            e.printStackTrace();

        }
        criteria.andDateEqualTo(ts);
        System.out.print("11111"+ts.toString());
        return positionMapper.selectByExample(positionExample);
    }*/

    public boolean isPosition(int id){
        Position position = positionMapper.selectByPrimaryKey(id);
        return position != null;
    }

    public boolean update(int positionId, int securityId, int quantity,  int fundId){
        Position position = new Position();
        Date date = new Date();
        position.setPositionId(positionId);
        position.setSecurityId(securityId);
        position.setQuantity(quantity);
        position.setDate(date);
        position.setFundId(fundId);

        return 1 == positionMapper.updateByPrimaryKey(position);
    }

    public boolean delete(int positionId){
        return 1 == positionMapper.deleteByPrimaryKey(positionId);
    }



}
