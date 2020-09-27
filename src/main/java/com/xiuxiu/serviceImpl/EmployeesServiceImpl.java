package com.xiuxiu.serviceImpl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.xiuxiu.mapper.*;
import com.xiuxiu.pojo.*;
import com.xiuxiu.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 * @author stone
 * @date 2020/9/24 002411:29
 */
@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    private EmployeesMapper mapper;
    @Autowired
    private MonthlybillMapper billMapper;
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private EmployeetaskMapper taskMapper;
    @Autowired
    private ApplyforempMapper applyMapper;
    //上月记录
    @Override
    public Result monthbill() {
       return liveUpdate();
    }

    @Override
    public Result liveUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = new Date();
        String duration = sdf.format(date);
        EmployeesExample example = new EmployeesExample();
        example.createCriteria().andRoleEqualTo("employee");
        List<Employees> list = mapper.selectByExample(example);
        int i =0;
        for (Employees emp : list) {
            Monthlybill bill = billMapper.queryBill(duration, emp.getId());
            if(bill==null){
                bill = new Monthlybill();
                bill.setEmpid(emp.getId());
                bill.setEmpname(emp.getName());
                bill.setDuration(duration);
                bill.setBasic(emp.getBasic());
                bill.setPresent(emp.getPresent());
                bill.setPerformance(emp.getPerformance());
                bill.setYuperformance(emp.getYuperformance());
                bill.setAddwork(new BigDecimal(0));
                bill.setReducepresent(new BigDecimal(0));
            }
            //查考勤
            Integer lateEarly = attendanceMapper.queryLateEarly(emp.getId());
            if(lateEarly!=null){
            if(!lateEarly.equals(0)){
                emp.setPresent(new BigDecimal(0));//扣除全勤
                bill.setPresent(new BigDecimal(0));//扣除全勤
                emp.setReducepresent(new BigDecimal(lateEarly));//
                bill.setReducepresent(new BigDecimal(lateEarly));//
            }else {
                emp.setPresent(new BigDecimal(100));
                bill.setPresent(new BigDecimal(100));
            }
            }else {
                emp.setPresent(new BigDecimal(100));
                bill.setPresent(new BigDecimal(100));
            }
            //查请假
            Applyforemp apply = applyMapper.queryQingjia(emp.getId());
            if(apply!=null){
                emp.setReducepresent(apply.getMoney().add(emp.getReducepresent()));
                bill.setReducepresent(apply.getMoney().add(emp.getReducepresent()));
            }

            //查绩效
            double performancepercent=1.0;
            BigDecimal performance = emp.getPerformance();
            Integer ji = taskMapper.queryjixiao(emp.getId());
            if(ji!=null){
                if(90<=ji &&ji<=100){
                    performancepercent=1.0;
                }
                if(80<=ji &&ji<90){
                    performancepercent=0.9;
                }
                if(70<=ji &&ji<80){
                    performancepercent=0.8;
                }
                if(60<=ji &&ji<70){
                    performancepercent=0.7;
                }
                if(50<=ji &&ji<60){
                    performancepercent=0.6;
                }
                if(40<=ji &&ji<50){
                    performancepercent=0.5;
                }
                if(30<=ji &&ji<40){
                    performancepercent=0.4;
                }
                if(20<=ji &&ji<30){
                    performancepercent=0.3;
                }
                if(10<=ji &&ji<20){
                    performancepercent=0.2;
                }
                if(0<ji &&ji<10){
                    performancepercent=0.1;
                }
                if(0==ji){
                    performancepercent=0.0;
                }
            }
            emp.setPerformancepercent(performancepercent);
            bill.setPerformancepercent(performancepercent);
            emp.setYuperformance(new BigDecimal(performancepercent).multiply(performance));
            bill.setYuperformance(new BigDecimal(performancepercent).multiply(performance));

            //查提成
            Applyforemp applyforemp = applyMapper.queryAddWork(emp.getId());
            if(applyforemp!=null){
                emp.setAddwork(applyforemp.getMoney());
                bill.setAddwork(applyforemp.getMoney());
            }
            i +=mapper.updateByPrimaryKey(emp);
            if(bill.getId()==null){
                billMapper.insert(bill);
            }else {
                billMapper.updateByPrimaryKey(bill);
            }
        }
        if(i == list.size()){
            return  new Result(1,"成功");
        }
        return  new Result(2,"失败");
    }

    @Override
    public List<Employees> empsheet(Employees employees) {
        return mapper.empsheet(employees);
    }

    @Override
    public List<Monthlybill> billsheet(Monthlybill monthlybill) {
        return billMapper.billsheet(monthlybill);

    }


}
