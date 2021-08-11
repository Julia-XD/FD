package com.example.demo.controller;

import com.example.demo.service.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
