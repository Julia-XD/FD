package com.example.demo.controller;

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

    @GetMapping("/list1/{name}")
    public List<FundManager> list1(@PathVariable String name){
        //System.out.print(name);

        return fundManagerService.list1(name);
    }
}
