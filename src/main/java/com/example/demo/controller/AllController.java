/**
 * @author Xiaohan Chen
 */
package com.example.demo.controller;

import com.example.demo.entity.All;
import com.example.demo.service.AllService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fundManagement")
public class AllController {
    @Autowired
    private AllService allService;

    //查询
    @GetMapping("/list")
    public List<All> selectAll(){
        return  allService.selectAll();
    }

}
