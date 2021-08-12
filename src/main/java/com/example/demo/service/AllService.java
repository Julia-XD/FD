/**
 * @author Xiaohan Chen
 */
package com.example.demo.service;

import com.example.demo.entity.All;
import com.example.demo.mapper.AllMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllService {
    @Autowired
    private AllMapper allMapper;

    public List<All>  selectAll(){
        return allMapper.selectAll();
    }
}
