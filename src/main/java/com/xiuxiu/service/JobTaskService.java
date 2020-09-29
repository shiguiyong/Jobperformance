package com.xiuxiu.service;

import com.github.pagehelper.PageInfo;
import com.xiuxiu.pojo.Conditions;
import com.xiuxiu.pojo.Employees;
import com.xiuxiu.pojo.Employeetask;
import com.xiuxiu.pojo.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author stone
 * @date 2020/9/9 000912:11
 */
public interface JobTaskService {

     Result login(Employees employees);

     Employees  findEmployees(Integer id);
     int  updateEmployees(Employees employees);


    Employees updateEmp(Employees employees);

    //所有任务
    PageInfo selectJobTask(Integer pageNum, Conditions conditions);
    PageInfo selectJobTaskDetails(Integer pageNum, Conditions conditions);

    Result addOrUpdateTask(Employeetask employeetask,MultipartFile file);

    List<Employees> getEmployees();

   Employeetask getTaskById(Integer id);


    Result  upload( String remark, Integer id,MultipartFile file) throws IOException;

    Result updateclaimStatus(Integer id);
    List<String> lookImages(Integer id);

    Result checkStatus(Integer id,Integer type,String remark, MultipartFile file) throws IOException;


}
