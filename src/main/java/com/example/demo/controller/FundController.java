package com.example.demo.controller;

import com.example.demo.entity.Fund;
import com.example.demo.entity.FundManager;
import com.example.demo.service.FundManagerService;
import com.example.demo.service.FundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fund")
@Api(value = "Fund CRUD", tags = {"FundController"})
public class FundController {
    @Autowired
    private FundService fundService;

    @Autowired
    private FundManagerService fundManagerService;


    //查询
    @GetMapping("/list")
    public List<Fund> list() {
        return fundService.list();
    }

    @GetMapping("/list-name/{name}")
    public List<Fund> list1(@PathVariable String name) {
        return fundService.list1(name);
    }

    @GetMapping("/list-employeeid/{id}")
    public List<Fund> list2(@PathVariable int id) {
        return fundService.list2(id);
    }

    @GetMapping("/list-fundid/{id}")
    public List<Fund> list3(@PathVariable int id) {
        return fundService.list3(id);
    }

    //增加
    @ApiOperation(value = "Add a fund ", notes = "Add a fund Api")
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public boolean add(int employeeId, String name) {
        //先判断employeeid存在吗
        if (!fundManagerService.isFundManager(employeeId)) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } else {
            boolean flag = fundService.add(employeeId, name);
            return flag;
        }
    }

    //@PostMapping("/save")
    //    public CommonResp save(@Valid @RequestBody DocSaveReq req) {
    //        CommonResp resp = new CommonResp<>();
    //        docService.save(req);
    //        return resp;
    //    }
    @RequestMapping(value = "/post-json", method = RequestMethod.POST)
    public boolean add1(@RequestBody Fund fund) {
        if (!fundManagerService.isFundManager(fund.getEmployeeId())) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } else {
            boolean flag = fundService.add(fund.getEmployeeId(),fund.getName());
            return flag;
        }

    }



        //修改
        @RequestMapping(value = "/update", method = RequestMethod.PUT)
        public boolean update ( int fundId, int employeeId, String name){
            //先判断fundid存在吗
            //先判断employeeid存在吗
            if (!fundService.isFund(fundId)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            } else {
                if (!fundManagerService.isFundManager(employeeId)) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return false;
                } else {
                    boolean flag = fundService.update(fundId, employeeId, name);
                    return flag;
                }
            }
        }

        //删除
        @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
        public boolean delete ( int fundId){
            //先判断fundid存在吗
            //先判断employeeid存在吗
            if (!fundService.isFund(fundId)) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            } else {

                boolean flag = fundService.delete(fundId);
                return flag;

            }
        }
    }


