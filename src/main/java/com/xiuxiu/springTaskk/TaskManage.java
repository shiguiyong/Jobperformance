package com.xiuxiu.springTaskk;
import com.xiuxiu.pojo.Result;
import com.xiuxiu.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TaskManage {
    @Autowired
    private EmployeesService service;
    public  void monthbill()  {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Result monthbill = service.monthbill();
            }
        }).start();

    }
    public  void recover()  {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Result recover = service.recover();
            }
        }).start();

    }




}
