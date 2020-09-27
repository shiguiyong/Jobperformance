package com.xiuxiu.controller;

import com.github.pagehelper.PageInfo;
import com.xiuxiu.pojo.*;
import com.xiuxiu.service.FlowService;
import com.xiuxiu.utils.JsonpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author stone
 * @date 2020/9/14 001414:11
 */
@Controller
@RequestMapping("/flow")
public class FlowController {
    @Autowired
    private FlowService service;


    @RequestMapping(value = "insertVolume",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String insertVolume(String callback,Visitorvolume volume){
        Result result = service.insertVisitorvolume(volume);
        return JsonpUtils.Result(callback,result);
    }

    @RequestMapping("/getVolume")
    @ResponseBody
    public PageInfo getVolume(Integer pageNum,Visitorvolume volume){
        PageInfo pageInfo = service.getVisitorvolume(pageNum,volume);
        return  pageInfo;
    }


    @RequestMapping("/shangban")
    @ResponseBody
    public Result shangban(HttpSession session, Attendance attendance){
        Employees employees = (Employees) session.getAttribute("employees");
        attendance.setEmpid(employees.getId());
        attendance.setName(employees.getName());
        return service.shangban(attendance);

    }

    @RequestMapping("/xiaban")
    @ResponseBody
    public Result xiaban(HttpSession session, Attendance attendance){
        Employees employees = (Employees) session.getAttribute("employees");
        attendance.setEmpid(employees.getId());
        attendance.setName(employees.getName());
        return  service.xiaban(attendance);
    }

    @RequestMapping("/queryAllAttendance")
    @ResponseBody
    public PageInfo queryAllAttendance(HttpSession session,Integer pageNum,Attendance attendance) {
        Employees employees = (Employees) session.getAttribute("employees");
        attendance.setEmpid(employees.getId());
        if (employees.getRole().equals("manage")) {
            attendance.setEmpid(null);
        }else {
            attendance.setName(null);
        }
        return service.queryAllAttendance(pageNum, attendance);
    }


    @RequestMapping("/queryAllAttendancedetails")
    @ResponseBody
    public PageInfo queryAllAttendancedetails(HttpSession session,Integer pageNum,Attendance attendance) {
        Employees employees = (Employees) session.getAttribute("employees");
        if (employees.getRole().equals("manage")) {
            attendance.setEmpid(null);
        }else {
            attendance.setEmpid(employees.getId());
            attendance.setName(null);
        }
        return service.queryAllAttendancedetails(pageNum, attendance);
    }

    @RequestMapping("/writeApplication")
    @ResponseBody
    public Result writeApplication(HttpSession session, Applyforemp applyforemp) {
        Employees employees = (Employees) session.getAttribute("employees");
        applyforemp.setEmpid(employees.getId());
        applyforemp.setEmpname(employees.getName());
        return service.writeApplication(applyforemp);
    }

    @RequestMapping("/confirmApplication")
    @ResponseBody
    public Result confirmApplication(HttpSession session,Integer id,Integer status,Double money) {
        Employees employees = (Employees) session.getAttribute("employees");
       if(employees.getRole().equals("manage")){
         return   service.confirmApplication(id,status,money);
       }
        return new Result(2,"你无权审核,请耐心等待");
    }

    @RequestMapping("/queryApplicationDetails")
    @ResponseBody
    public PageInfo queryApplicationDetails(HttpSession session,Integer pageNum, Applyforemp applyforemp) {
        Employees employees = (Employees) session.getAttribute("employees");
        if(employees.getRole().equals("manage")){
            applyforemp.setEmpid(null);
        }else {
            applyforemp.setEmpid(employees.getId());
            applyforemp.setEmpname(null);
        }
        return service.queryApplicationDetails(pageNum,applyforemp);
    }
    @RequestMapping("/queryApplication")
    @ResponseBody
    public PageInfo queryApplication(HttpSession session,Integer pageNum, Applyforemp applyforemp) {
        Employees employees = (Employees) session.getAttribute("employees");
        applyforemp.setEmpid(employees.getId());
        if(employees.getRole().equals("manage")){
            applyforemp.setEmpid(null);
        }else {
            applyforemp.setEmpname(null);
        }
        return service.queryApplication(pageNum,applyforemp);
    }




}
