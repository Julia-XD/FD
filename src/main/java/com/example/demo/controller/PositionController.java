package com.example.demo.controller;

import com.example.demo.service.FundService;
import com.example.demo.service.PositionService;
import com.example.demo.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private FundService fundService;
    @Autowired
    private SecurityService securityService;
    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public boolean add(int fundid,int securityid,int quantity ){
        //先判断fundid存在吗
        if(!fundService.isFund(fundid)) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }else {
            //判断securityid存在吗
            if(!securityService.isSecurity(securityid)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }else {
               return positionService.add(fundid,securityid,quantity);


            }

        }
    }
}
