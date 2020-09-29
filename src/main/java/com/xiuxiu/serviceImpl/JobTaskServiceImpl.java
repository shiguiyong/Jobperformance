package com.xiuxiu.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiuxiu.mapper.EmployeesMapper;
import com.xiuxiu.mapper.EmployeetaskMapper;
import com.xiuxiu.pojo.*;
import com.xiuxiu.service.JobTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author stone
 * @date 2020/9/9 000912:11
 */
@Service
@Transactional
public class JobTaskServiceImpl implements JobTaskService{
    @Autowired
    private  EmployeesMapper employeesMapper;//员工号
    @Autowired
    private   EmployeetaskMapper taskMapper; // 任务号


    @Override
    public Result login( Employees employees) {
        EmployeesExample example = new EmployeesExample();
        example.createCriteria().andAccountEqualTo(employees.getAccount());
        List<Employees> list = employeesMapper.selectByExample(example);
        if(list.size()==0){
            return  new Result(2,"您输入的员工账号不存在，请仔细核对");
        }
        Employees empl = list.get(0);
        if(employees.getPassword().equals(empl.getPassword())){
            return new Result(1,empl.getId().toString());
        }
        return new Result(2,"您输入的密码错误，请仔细核对");
    }
    @Override
    public  Employees findEmployees(Integer id) {
        Employees employees = employeesMapper.selectByPrimaryKey(id);
        return  employees;
    }

    @Override
    public int updateEmployees(Employees employees) {
        return employeesMapper.updateByPrimaryKey(employees);
    }

    @Override
    public Employees updateEmp(Employees employees) {
        int update = employeesMapper.updateByPrimaryKeySelective(employees);
        if(update == 1){
            Employees emp = employeesMapper.selectByPrimaryKey(employees.getId());
            return emp;
        }
        return  null;

    }

    @Override
    public PageInfo selectJobTask(Integer pageNum,Conditions conditions) {
        PageHelper.startPage(pageNum,20);
        List<Map> list = taskMapper.selectJobTask(conditions);
       /* for (Employeetask employeetask : list) {
            Map map = taskMapper.getPercent(employeetask.getSerialnumber());
            map.put("task",employeetask);
            maplist.add(map);
        }*/
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }

    @Override
    public PageInfo selectJobTaskDetails(Integer pageNum, Conditions conditions) {
        PageHelper.startPage(pageNum,20);
        List<Employeetask> list = taskMapper.selectJobTaskDetails(conditions);
        for (Employeetask employeetask : list) {
            if(employeetask.getClaimtime()!=null &&employeetask.getClaimtime()!= ""){
                String claimtime = employeetask.getClaimtime();//认领时间
                String subclaimtime = claimtime.substring(claimtime.lastIndexOf(",") + 1);
                employeetask.setClaimtime(subclaimtime);
            }
            if(employeetask.getSubtime()!=null &&employeetask.getSubtime()!= ""){
                String subtime = employeetask.getSubtime();//提交时间
                String subsubtime = subtime.substring(subtime.lastIndexOf(",") + 1);
                employeetask.setSubtime(subsubtime);
            }
            if(employeetask.getConfirmtime()!=null&&employeetask.getConfirmtime()!=""){
                String confirmtime = employeetask.getConfirmtime();//审核时间
                String subconfirmtime = confirmtime.substring(confirmtime.lastIndexOf(",") + 1);
                employeetask.setConfirmtime(subconfirmtime);
            }

        }
        PageInfo<Employeetask> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Result addOrUpdateTask(Employeetask task,MultipartFile file) {
        long currentTimeMillis = System.currentTimeMillis();
        //一个月只有一个任务单号
        String serialnumber = taskMapper.getSerialnumber(task.getEmpid());
        if(serialnumber == null || serialnumber == ""){
            serialnumber = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        if(task.getTasktitle()==""){
            return  new Result(2,"请填写事务标题");
        }
        if(task.getTaskdetails()==""){
            return  new Result(2,"请补充事务详情");
        }
        if(task.getEmpname()==""){
            return  new Result(2,"请补充事务分配人");
        }
        int i = 0;
        String path = "D:\\job\\";
        if(!file.isEmpty()){
            File wenjianjia  = new File(path+"images"+"/"+"task"+task.getEmpid()+"/"+currentTimeMillis+"/");
            if (!wenjianjia.exists()) {
                wenjianjia.mkdirs();
            }
            String filepath="images"+"/"+"task"+task.getEmpid()+"/"+currentTimeMillis+"/"+task.getEmpid()+"_"+file.getOriginalFilename();
            File newFile= new  File(path+filepath);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
            try {
                file.transferTo(newFile);
                task.setImage(filepath);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if(task.getId()!= null){
            task.setAllottime(sdf.format(date));
            i = taskMapper.updateByPrimaryKeySelective(task);
        }else {
            task.setAddtime(sdf.format(date));
            task.setAllottime(sdf.format(date));
            task.setStatus(2);
            task.setSerialnumber(serialnumber);
            i = taskMapper.insert(task);
        }

        if(i == 1){
            return  new Result(1,"操作成功");
        }
        return  new Result(2,"操作失败");
    }

    @Override
    public List<Employees> getEmployees() {
        EmployeesExample example = new EmployeesExample();
        List<Employees> employees = employeesMapper.selectByExample(example);
        return employees;
    }

    @Override
    public Employeetask getTaskById(Integer id) {
        Employeetask employeetask = taskMapper.selectByPrimaryKey(id);
        return  employeetask;
    }

    @Override
    public Result upload( String remark, Integer id,MultipartFile files) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        Employeetask task = taskMapper.selectByPrimaryKey(id);
        Integer empid = task.getEmpid();//员工Id
        if(remark!=""&& remark !=null){
            task.setRemark(remark);
        }
        String path = "D:\\job\\";
         if(!files.isEmpty()){
             File wenjianjia  = new File(path+"files"+"/"+"task"+empid+"/"+currentTimeMillis+"/");
             if (!wenjianjia.exists()) {
                 wenjianjia.mkdirs();
             }
             String filepath="files"+"/"+"task"+empid+"/"+currentTimeMillis+"/"+task.getId()+"_"+files.getOriginalFilename();
             File newFile= new  File(path+filepath);
             //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
             System.out.println(path+filepath);
             files.transferTo(newFile);
             task.setFileurl(filepath);
         }
         if(task.getStatus().equals(3)){
             task.setStatus(4);
         }
        if(task.getStatus().equals(6)){
            task.setStatus(1);
        }

         task.setSubtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//提交时间
        int update = taskMapper.updateByPrimaryKey(task);
        if(update==1){
            return  new Result(1,"提交成功");
        }
        return  new Result(2,"提交失败");
    }

    @Override
    public Result updateclaimStatus(Integer id) {
        String claimtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Employeetask task = taskMapper.selectByPrimaryKey(id);
        if(task.getStatus().equals(2)){
            task.setStatus(3);
            task.setClaimtime(claimtime);

        }
        if(task.getStatus().equals(5)){
           String time = task.getClaimtime()+","+claimtime;
            task.setStatus(6);
            task.setClaimtime(time);
        }
        int update = taskMapper.updateByPrimaryKey(task);
        if(update == 1){
            return  new Result(1,"操作成功");
        }
        return new Result(1,"操作失败");
    }

    @Override
    public List<String> lookImages(Integer id) {
        Employeetask task = taskMapper.selectByPrimaryKey(id);
        String image = task.getImage();
        String[] split = image.split(",");
        List<String> list = Arrays.asList(split);
        return list;
    }

    @Override
    public Result checkStatus(Integer id, Integer type,String remark, MultipartFile file) throws IOException {
        long currentTimeMillis =System.currentTimeMillis();
        Employeetask task = taskMapper.selectByPrimaryKey(id);
        String path = "D:\\job\\";
        String message="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String confirmtime = sdf.format(new Date());
        int status = 0 ;
        String endtime = task.getEndtime();
        String subtime = task.getSubtime();
        long value = 0l;
        try {
            Date end = sdf.parse(endtime);
            Date sub = sdf.parse(subtime);
            value   =  end.getTime()- sub.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(!file.isEmpty()){
            File wenjianjia  = new File(path+"files"+"/"+"taskrework"+task.getEmpid()+"/"+currentTimeMillis+"/");
            if (!wenjianjia.exists()) {
                wenjianjia.mkdirs();
            }
            String filepath="files"+"/"+"taskrework"+task.getEmpid()+"/"+currentTimeMillis+"/"+task.getId()+"_"+file.getOriginalFilename();
            File newFile= new  File(path+filepath);
            //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
         file.transferTo(newFile);
         task.setReworkurl(filepath);


        }

            if(type.equals(1)){
                if(task.getStatus().equals(1)){
                    if(value>=0l){
                        status = 7;
                    }else {
                        status = 9;
                    }
                }else {
                    //通过
                    if(value>=0l){
                        status = 7;
                    }else {
                        status = 8;
                    }
                }

                message="审核成功";
            }else {
                //打回
                status = 5;
                message="打回成功";

            }

        if(remark!="" && remark !=null){
            task.setReworkremark(remark);
        }
        task.setCheckman("林山");
        task.setStatus(status);
        if(task.getConfirmtime()==""||task.getConfirmtime()==null){
            task.setConfirmtime(confirmtime);
        }else {
            task.setConfirmtime(task.getConfirmtime()+","+confirmtime);
        }
        taskMapper.updateByPrimaryKey(task);
        return new Result(status,message);
    }


}
