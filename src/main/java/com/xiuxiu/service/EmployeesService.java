package com.xiuxiu.service;

import com.xiuxiu.pojo.Employees;
import com.xiuxiu.pojo.Monthlybill;
import com.xiuxiu.pojo.Result;

import java.util.List;

/**
 * @author stone
 * @date 2020/9/24 002411:29
 */
public interface EmployeesService {

    Employees selectByOpenId(String openid);

    //每天统计

    Result monthbill();


    //实时更新账户信息

    Result  liveUpdate();

    List<Employees> empsheet(Employees employees);

    List<Monthlybill> billsheet(Monthlybill monthlybill);





}
