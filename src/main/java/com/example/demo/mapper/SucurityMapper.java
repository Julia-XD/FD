package com.example.demo.mapper;

import com.example.demo.entity.Sucurity;
import com.example.demo.entity.SucurityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SucurityMapper {
    long countByExample(SucurityExample example);

    int deleteByExample(SucurityExample example);

    int deleteByPrimaryKey(Integer securityId);

    int insert(Sucurity record);

    int insertSelective(Sucurity record);

    List<Sucurity> selectByExample(SucurityExample example);

    Sucurity selectByPrimaryKey(Integer securityId);

    int updateByExampleSelective(@Param("record") Sucurity record, @Param("example") SucurityExample example);

    int updateByExample(@Param("record") Sucurity record, @Param("example") SucurityExample example);

    int updateByPrimaryKeySelective(Sucurity record);

    int updateByPrimaryKey(Sucurity record);
}