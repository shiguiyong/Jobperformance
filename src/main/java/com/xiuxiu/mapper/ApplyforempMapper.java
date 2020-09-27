package com.xiuxiu.mapper;

import com.xiuxiu.pojo.Applyforemp;
import com.xiuxiu.pojo.ApplyforempExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ApplyforempMapper {
    int countByExample(ApplyforempExample example);

    int deleteByExample(ApplyforempExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Applyforemp record);

    int insertSelective(Applyforemp record);

    List<Applyforemp> selectByExample(ApplyforempExample example);

    Applyforemp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Applyforemp record, @Param("example") ApplyforempExample example);

    int updateByExample(@Param("record") Applyforemp record, @Param("example") ApplyforempExample example);

    int updateByPrimaryKeySelective(Applyforemp record);

    int updateByPrimaryKey(Applyforemp record);

    String  getSerialnumber(int empid);



    List<Applyforemp> queryApplicationDetails(@Param("applys")Applyforemp applyforemp);
    List<Map> queryApplication(@Param("applys")Applyforemp applyforemp);

    Applyforemp queryAddWork(Integer empid);
    Applyforemp queryQingjia(Integer empid);
}