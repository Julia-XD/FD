package com.example.demo.controller;

import com.example.demo.service.FundManagerService;
import com.example.demo.service.FundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fund")
@Api(value = "Fund CRUD" ,tags = {"FundController"})
public class FundController {
    @Autowired
    private FundService fundService;

    @Autowired
    private FundManagerService fundManagerService;

    @ApiOperation(value = "Add a fund ",notes = "Add a fund Api")
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
