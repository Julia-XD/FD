package com.example.demo.mapper;

import com.example.demo.entity.FundManager;
import com.example.demo.entity.FundManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundManagerMapper {
    long countByExample(FundManagerExample example);

    int deleteByExample(FundManagerExample example);

    int deleteByPrimaryKey(Integer employeeId);

    int insert(FundManager record);

    int insertSelective(FundManager record);

    List<FundManager> selectByExample(FundManagerExample example);

    FundManager selectByPrimaryKey(Integer employeeId);

    int updateByExampleSelective(@Param("record") FundManager record, @Param("example") FundManagerExample example);

    int updateByExample(@Param("record") FundManager record, @Param("example") FundManagerExample example);

    int updateByPrimaryKeySelective(FundManager record);

    int updateByPrimaryKey(FundManager record);
}