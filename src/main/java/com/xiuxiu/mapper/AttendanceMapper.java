package com.xiuxiu.mapper;

import com.xiuxiu.pojo.Attendance;
import com.xiuxiu.pojo.AttendanceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AttendanceMapper {
    int countByExample(AttendanceExample example);

    int deleteByExample(AttendanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    List<Attendance> selectByExample(AttendanceExample example);

    Attendance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Attendance record, @Param("example") AttendanceExample example);

    int updateByExample(@Param("record") Attendance record, @Param("example") AttendanceExample example);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);

    Attendance getAttendance(@Param("useragent")String  useragent,@Param("type")String type);

    String getSerialnumber(Integer empid);

    List<Attendance> queryAllAttendancedetails(@Param("attendance")Attendance attendance);
    List<Map> queryAllAttendance(@Param("attendance")Attendance attendance);
    //查迟到,早退
    Integer queryLateEarly(Integer empid);
}