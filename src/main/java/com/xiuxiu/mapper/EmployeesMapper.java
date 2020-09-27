package com.xiuxiu.mapper;
import com.xiuxiu.pojo.Employees;
import com.xiuxiu.pojo.EmployeesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeesMapper {
    int countByExample(EmployeesExample example);

    int deleteByExample(EmployeesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employees record);

    int insertSelective(Employees record);

    List<Employees> selectByExample(EmployeesExample example);

    Employees selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employees record, @Param("example") EmployeesExample example);

    int updateByExample(@Param("record") Employees record, @Param("example") EmployeesExample example);

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);
    List<Employees> empsheet(@Param("emp")Employees emp);
}