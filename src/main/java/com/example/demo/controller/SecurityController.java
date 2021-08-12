package com.example.demo.controller;

import com.example.demo.entity.Security;
import com.example.demo.service.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Security")
public class SecurityController {
    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public boolean add(String symbol){
        boolean flag =securityService.add(symbol);
        return flag;
    }

    //select
    @GetMapping("/list")
    public List<Security> list() {

        return securityService.list();
    }

    @GetMapping("/list-srcurityid/{id}")
    public List<Security> list1(@PathVariable int id){
        return securityService.list1(id);
    }

    //update
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean update(int securityId, String symbol){
        if (!securityService.isSecurity(securityId)){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } else {
            boolean flag = securityService.update(securityId,symbol);
            return flag;
        }
    }


    //delete
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(int securityId){
        if (!securityService.isSecurity(securityId)){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } else {

            boolean flag = securityService.delete(securityId);
            return flag;
        }
    }

}
