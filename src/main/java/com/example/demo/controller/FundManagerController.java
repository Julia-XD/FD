/**
 * @author Xuan Chen
 */
package com.example.demo.controller;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.Exception.NullValueException;
import com.example.demo.entity.FundManager;
import com.example.demo.service.FundManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fundManager")
public class FundManagerController {
    @Autowired
    private FundManagerService fundManagerService;

    @GetMapping("/list")
    public List<FundManager> list(){
        return fundManagerService.list();
    }

   @GetMapping("/list-name/{name}")
    public List<FundManager> list1(@PathVariable String name){
        return fundManagerService.list1(name);
    }

    @GetMapping("/list-id/{id}")
    public List<FundManager> list2(@PathVariable int id){
        return fundManagerService.list2(id);
    }

    /*@RequestMapping(value = "/post",method = RequestMethod.POST)
    public boolean add(String name){
        boolean flag = fundManagerService.add(name);
        return flag;
    }*/

    //add
    @RequestMapping(value = "/post-json", method = RequestMethod.POST)
    public boolean add(@RequestBody FundManager fundManager) {
        if(fundManager.getFirstname()==null||fundManager.getLastname()==null){
            throw new NullValueException("name");
        }
        boolean flag = fundManagerService.add(fundManager.getFirstname() + " " + fundManager.getLastname());
        return flag;
    }

    //update
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean update (Integer employeeId, String firstname,String lastname){
        if(employeeId==null||firstname==null||lastname==null){
            throw new NullValueException("paprameters");
        }

        String name=firstname+" "+lastname;
        //先判断employeeid存在吗
        if (!fundManagerService.isFundManager(employeeId)) {
            throw new NotFoundException("employeeId");
        } else {
            boolean flag = fundManagerService.update(employeeId, name);
            return flag;
        }
    }

    //delete
    @RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.DELETE)
    public boolean delete (@PathVariable int employeeId){
        //先判断employeeid存在吗
        if (!fundManagerService.isFundManager(employeeId)) {
           throw new NotFoundException("employeeId");
        } else {

            boolean flag = fundManagerService.delete(employeeId);
            return flag;

        }
    }
}
