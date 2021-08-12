/**
 * @author Xiang Dong
 */
package com.example.demo.controller;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.Exception.NullValueException;
import com.example.demo.entity.Position;
import com.example.demo.service.FundService;
import com.example.demo.service.PositionService;
import com.example.demo.service.SecurityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private FundService fundService;
    @Autowired
    private SecurityService securityService;

    // Get
    @GetMapping("/list")
    public List<Position> list() {
        return positionService.list();
    }

    @GetMapping("/list-positionid/{id}")
    public List<Position> list1(@PathVariable int id) {
        return positionService.list1(id);
    }

    @GetMapping("/list-securityid/{id}")
    public List<Position> list2(@PathVariable int id) {
        return positionService.list2(id);
    }

    @GetMapping("/list-fundid/{id}")
    public List<Position> list3(@PathVariable int id) {
        return positionService.list3(id);
    }

    @GetMapping("/list-quantitiy/{quantity}")
    public List<Position> list4(@PathVariable int quantity) {
        return positionService.list4(quantity);
    }
/*
    @GetMapping("/list-date/{date}")
    public List<Position> list5(@PathVariable String date) {

        return positionService.list5(date);
    }*/


    //add
    @ApiOperation(value = "Add a position ", notes = "Add a position Api")
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public boolean add(Integer securityId, Integer fundId, Integer quantity){
        if(securityId==null||fundId==null||quantity==null){
            throw new NullValueException("security or fundid or quantity");
        }

        //check if fundId exists
        if(!fundService.isFund(fundId)) {
           throw new NotFoundException("fundid");
        }else {
            //check if securityId exists
            if(!securityService.isSecurity(securityId)) {
                throw new NotFoundException("security");
            }else {
                return positionService.add(securityId, fundId, quantity);
            }

        }
    }

    //update
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean update(Integer positionId, Integer securityId, Integer fundId, Integer quantity){
        if(positionId==null||securityId==null||fundId==null||quantity==null){
            throw new NullValueException("positionId or security or fundid or quantity");
        }

        //check if positionId exists
        if (!positionService.isPosition(positionId)){
           throw new NotFoundException("positionid");
        } else {
            //check if securityId exists
            if (!securityService.isSecurity(securityId)) {
              throw new NotFoundException("securityid");
            } else {
                //check if fundId exists
                if (!fundService.isFund(fundId)) {
                    throw new NotFoundException("fundid");
                } else {
                    boolean flag = positionService.update(positionId, securityId, quantity, fundId);
                    return flag;
                }
            }
        }
    }

    //delete
    @RequestMapping(value = "/delete/{positionId}", method = RequestMethod.DELETE)
    public boolean delete (int positionId){
        //first check if positionId exists
        if (!positionService.isPosition(positionId)) {
           throw new NotFoundException("positionid");
        } else {
            boolean flag = positionService.delete(positionId);
            return flag;
        }
    }



}
