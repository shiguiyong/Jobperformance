package com.xiuxiu.service;

import com.github.pagehelper.PageInfo;
import com.xiuxiu.pojo.Applyforemp;
import com.xiuxiu.pojo.Attendance;
import com.xiuxiu.pojo.Result;
import com.xiuxiu.pojo.Visitorvolume;

import javax.servlet.http.HttpSession;

/**
 * @author stone
 * @date 2020/9/14 001414:11
 */
public interface FlowService {

    Result insertVisitorvolume(Visitorvolume visitorvolume);

    PageInfo getVisitorvolume(Integer pageNum, Visitorvolume visitorvolume);

    Result shangban( Attendance attendance);
    Result xiaban( Attendance attendance);
    PageInfo queryAllAttendancedetails( Integer pageNum,Attendance attendance);
    PageInfo queryAllAttendance( Integer pageNum,Attendance attendance);

    Result writeApplication(Applyforemp applyforemp);

    Result confirmApplication(Integer id,Integer status,Double money);
    PageInfo queryApplicationDetails(Integer pageNum,Applyforemp applyforemp);
    PageInfo queryApplication(Integer pageNum,Applyforemp applyforemp);

}
