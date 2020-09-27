package com.xiuxiu.mapper;

import com.xiuxiu.pojo.Monthlybill;
import com.xiuxiu.pojo.MonthlybillExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MonthlybillMapper {
    int countByExample(MonthlybillExample example);

    int deleteByExample(MonthlybillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Monthlybill record);

    int insertSelective(Monthlybill record);

    List<Monthlybill> selectByExample(MonthlybillExample example);

    Monthlybill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Monthlybill record, @Param("example") MonthlybillExample example);

    int updateByExample(@Param("record") Monthlybill record, @Param("example") MonthlybillExample example);

    int updateByPrimaryKeySelective(Monthlybill record);

    int updateByPrimaryKey(Monthlybill record);

    Monthlybill queryBill(@Param("duration")String duration,@Param("empid")Integer empid);

    List<Monthlybill> billsheet(@Param("bill")Monthlybill bill);
}