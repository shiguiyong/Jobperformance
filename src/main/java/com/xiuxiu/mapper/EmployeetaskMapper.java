package com.xiuxiu.mapper;

import com.xiuxiu.pojo.Conditions;
import com.xiuxiu.pojo.Employeetask;
import com.xiuxiu.pojo.EmployeetaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface EmployeetaskMapper {
    int countByExample(EmployeetaskExample example);

    int deleteByExample(EmployeetaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employeetask record);

    int insertSelective(Employeetask record);

    List<Employeetask> selectByExample(EmployeetaskExample example);

    Employeetask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employeetask record, @Param("example") EmployeetaskExample example);

    int updateByExample(@Param("record") Employeetask record, @Param("example") EmployeetaskExample example);

    int updateByPrimaryKeySelective(Employeetask record);

    int updateByPrimaryKey(Employeetask record);

    List<Map> selectJobTask(@Param("conditions")Conditions conditions);
    List<Employeetask> selectJobTaskDetails(@Param("conditions")Conditions conditions);
    Map getPercent(String serialnumber);

    String  getSerialnumber(Integer empid);

    Integer  queryjixiao(Integer empid);



}