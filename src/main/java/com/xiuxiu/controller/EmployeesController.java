package com.xiuxiu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiuxiu.pojo.Employees;
import com.xiuxiu.pojo.Monthlybill;
import com.xiuxiu.pojo.Result;
import com.xiuxiu.pojo.Visitorvolume;
import com.xiuxiu.service.EmployeesService;
import com.xiuxiu.service.JobTaskService;
import com.xiuxiu.utils.JsonpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author stone
 * @date 2020/9/24 002411:28
 */
@Controller
@RequestMapping("/emp")
public class EmployeesController {
    @Autowired
    private EmployeesService service;

    @Autowired
    private JobTaskService jobservice;

    @RequestMapping("/billsheet")
    public String billsheet(HttpSession session, Monthlybill employees){
        Result result = service.liveUpdate();
        Employees emp = (Employees) session.getAttribute("employees");
        if(emp.getRole().equals("manage")){
            employees.setId(null);
        }else {
            employees.setId(emp.getId());
            employees.setEmpname("");
        }
        PageHelper.startPage(1,20);
        List<Monthlybill> empsheet = service.billsheet(employees);
        PageInfo<Monthlybill> pageInfo = new PageInfo<>(empsheet);
        session.setAttribute("pageInfo",pageInfo);
        return "jobtask/performancekList";
    }
    @RequestMapping("/billsheetAjax")
    @ResponseBody
    public PageInfo billsheetAjax(HttpSession session,Integer pageNum, Monthlybill employees){
        Employees emp = (Employees) session.getAttribute("employees");
        if(emp.getRole().equals("manage")){
            employees.setId(null);
        }else {
            employees.setId(emp.getId());
            employees.setEmpname("");
        }
        PageHelper.startPage(pageNum,20);
        List<Monthlybill> empsheet = service.billsheet(employees);
        PageInfo<Monthlybill> pageInfo = new PageInfo<>(empsheet);
        return pageInfo;
    }

    @RequestMapping("/empsheet")
    public String empsheet(HttpSession session){
        Employees emp = (Employees) session.getAttribute("employees");
        Employees employees = jobservice.findEmployees(emp.getId());
        session.setAttribute("employees",employees);
        return "jobtask/home";
    }


}
