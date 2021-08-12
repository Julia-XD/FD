/**
 * @author Bei Zhu
 */
package com.example.demo.controller;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.Exception.NullValueException;
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
        if(symbol==null){
            throw new NullValueException("symbol");
        }
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
    public boolean update(Integer securityId, String symbol){
        if(securityId==null||symbol==null){
            throw new NullValueException("securytyId or Symbol");
        }

        if (!securityService.isSecurity(securityId)){
            throw new NotFoundException("SecurityId");
        } else {
            boolean flag = securityService.update(securityId,symbol);
            return flag;
        }
    }


    //delete
    @RequestMapping(value = "/delete/{securityId}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable int securityId){
        if (!securityService.isSecurity(securityId)){
           throw new NotFoundException("SecurityId");
        } else {

            boolean flag = securityService.delete(securityId);
            return flag;
        }
    }

}
