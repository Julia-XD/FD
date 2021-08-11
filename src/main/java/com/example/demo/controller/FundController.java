package com.example.demo.controller;

import com.example.demo.service.FundManagerService;
import com.example.demo.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fund")
public class FundController {
    @Autowired
    private FundService fundService;

    @Autowired
    private FundManagerService fundManagerService;


    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public boolean add(int employeeId,String name){
        //先判断employeeid存在吗
        if(!fundManagerService.isFundManager(employeeId)) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }else {
            boolean flag = fundService.add(employeeId,name);
            return flag;
        }
    }
}
