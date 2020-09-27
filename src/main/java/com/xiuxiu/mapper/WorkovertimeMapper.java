package com.xiuxiu.mapper;

import com.xiuxiu.pojo.Workovertime;
import com.xiuxiu.pojo.WorkovertimeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkovertimeMapper {
    int countByExample(WorkovertimeExample example);

    int deleteByExample(WorkovertimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Workovertime record);

    int insertSelective(Workovertime record);

    List<Workovertime> selectByExample(WorkovertimeExample example);

    Workovertime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Workovertime record, @Param("example") WorkovertimeExample example);

    int updateByExample(@Param("record") Workovertime record, @Param("example") WorkovertimeExample example);

    int updateByPrimaryKeySelective(Workovertime record);

    int updateByPrimaryKey(Workovertime record);
}