package com.example.demo.controller;

import com.example.demo.entity.FundManager;
import com.example.demo.service.FundManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FundManagerController {
    @Autowired
    private FundManagerService fundManagerService;

    @GetMapping("/fundManager/list")
    public List<FundManager> list(){
        return fundManagerService.list();
    }
}
