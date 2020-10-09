package com.xiuxiu.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiuxiu.mapper.ApplyforempMapper;
import com.xiuxiu.mapper.AttendanceMapper;
import com.xiuxiu.mapper.VisitorvolumeMapper;
import com.xiuxiu.pojo.Applyforemp;
import com.xiuxiu.pojo.Attendance;
import com.xiuxiu.pojo.Result;
import com.xiuxiu.pojo.Visitorvolume;
import com.xiuxiu.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author stone
 * @date 2020/9/14 001414:12
 */
@Service
@Transactional
public class FlowServiceImpl  implements FlowService {
    @Autowired
    private VisitorvolumeMapper mapper;

    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private ApplyforempMapper applyMapper;
    @Override
    public Result insertVisitorvolume(Visitorvolume visitorvolume) {
        int insert = mapper.insert(visitorvolume);
        return new Result(insert,"");
    }

    @Override
    public PageInfo getVisitorvolume(Integer pageNum, Visitorvolume visitorvolume) {
        PageHelper.startPage(pageNum,20);
        List<Visitorvolume> list = mapper.getVisitorvolume(visitorvolume);
        PageInfo<Visitorvolume> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Result shangban(Attendance attendance) {
        //String ipstring="222.182.52.236";
        String ipstring="106.83.138.108";
        if(!ipstring.equals(attendance.getIp())){
            return  new Result(2,"只能连公司WIFI打卡");
        }
        Date date = new Date();
        String addtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String useragent = attendance.getUseragent();
        useragent = useragent.substring(useragent.indexOf("(")+1,useragent.indexOf(")"));
        attendance.setUseragent(useragent);
        Attendance oldattendance = attendanceMapper.getAttendance(attendance.getUseragent(), "上班");
        if(null != oldattendance){
            return  new Result(2,"你的设备已经打过上班卡了，一天只能打一次");
        }

        String serialnumber = attendanceMapper.getSerialnumber(attendance.getEmpid());
        if(null == serialnumber ||"".equals(serialnumber)){
            serialnumber= new SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS").format(date);
        }
        Calendar shang = Calendar.getInstance();
        shang.set(Calendar.HOUR_OF_DAY,9);
        shang.set(Calendar.MINUTE,1);
        shang.set(Calendar.SECOND,0);
        long shangtime = shang.getTime().getTime();
        long time = date.getTime();
        if(time<shangtime){
            attendance.setStatus(1);
            attendance.setLessminute(0);
        }else {
            int minutenum = (int) ((time+60000-shangtime)/1000/60);
            attendance.setLessminute(minutenum);
            attendance.setStatus(2);
        }
        attendance.setMoreminute(0);
        attendance.setWeeknum(new SimpleDateFormat("EEEE").format(date));
        attendance.setAddtime(addtime);
        attendance.setDatevar(date);
        attendance.setSerialnumber(serialnumber);
        attendance.setType("上班");
        int insert = attendanceMapper.insert(attendance);
        return new Result(1,"打卡成功");
    }

    @Override
    public Result xiaban(Attendance attendance) {
        //String ipstring="222.182.52.236";
        String ipstring="106.83.138.108";
        if(!ipstring.equals(attendance.getIp())){
            return  new Result(2,"只能连公司WIFI打卡");
        }
        Date date = new Date();
        String addtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String useragent = attendance.getUseragent();
        useragent = useragent.substring(useragent.indexOf("(")+1,useragent.indexOf(")"));
        attendance.setUseragent(useragent);
        Attendance oldattendance = attendanceMapper.getAttendance(attendance.getUseragent(), "下班");
        if(null != oldattendance){
            return  new Result(2,"你的设备已经打过下班卡了，一天只能打一次");
        }
        String serialnumber = attendanceMapper.getSerialnumber(attendance.getEmpid());
        if(null == serialnumber ||"".equals(serialnumber)){
            serialnumber= new SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS").format(date);
        }
        Calendar xia = Calendar.getInstance();
        xia.set(Calendar.HOUR_OF_DAY,18);
        xia.set(Calendar.MINUTE,0);
        xia.set(Calendar.SECOND,0);
        long xiatime = xia.getTime().getTime();
        long time = date.getTime();
        if(time<xiatime){
            int minutenum = (int) ((xiatime+60000-time)/1000/60);
            attendance.setMoreminute(minutenum);
            attendance.setStatus(3);
        }else {
            attendance.setStatus(1);
            int moretime = (int) ((time-xiatime)/1000/60);
            attendance.setMoreminute(moretime);
        }
        attendance.setLessminute(0);
        attendance.setWeeknum(new SimpleDateFormat("EEEE").format(date));

        attendance.setAddtime(addtime);
        attendance.setDatevar(date);
        attendance.setSerialnumber(serialnumber);
        attendance.setType("下班");
        int insert = attendanceMapper.insert(attendance);
        return new Result(1,"打卡成功");
    }

    @Override
    public PageInfo queryAllAttendancedetails(Integer pageNum, Attendance attendance) {
        PageHelper.startPage(pageNum,20);
        if(attendance.getSerialnumber().equals("null")){
            attendance.setSerialnumber("");
        }
        List<Attendance> list = attendanceMapper.queryAllAttendancedetails(attendance);
        PageInfo<Attendance> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo queryAllAttendance(Integer pageNum, Attendance attendance) {
        PageHelper.startPage(pageNum,11);
        List<Map> list = attendanceMapper.queryAllAttendance(attendance);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }

    @Override
    public Result writeApplication(Applyforemp applyforemp) {
        Date date = new Date();
        String serialnumber = applyMapper.getSerialnumber(applyforemp.getEmpid());
        if(serialnumber == null || serialnumber == ""){
             serialnumber = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        applyforemp.setAddtime(sdf.format(date));
        applyforemp.setSerialnumber(serialnumber);
        applyforemp.setStatus(1);
        int insert = applyMapper.insert(applyforemp);
        return new Result(1,"提交成功,等待审核");
    }

    @Override
    public Result confirmApplication(Integer id, Integer status,Double money) {
        Applyforemp apply = applyMapper.selectByPrimaryKey(id);
        apply.setStatus(status);
        if(status==3){
            apply.setMoney(new BigDecimal(0));
        }else {
            apply.setMoney(new BigDecimal(money));
        }
        apply.setConfirmman("林山");
        apply.setConfirmtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        applyMapper.updateByPrimaryKey(apply);
        return new Result(1,"操作成功");
    }

    @Override
    public PageInfo queryApplicationDetails(Integer pageNum,Applyforemp applyforemp) {
        PageHelper.startPage(pageNum,20);
        if("null".equals(applyforemp.getSerialnumber())){
            applyforemp.setSerialnumber("");
        }
        List<Applyforemp> list = applyMapper.queryApplicationDetails(applyforemp);
        PageInfo<Applyforemp> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo queryApplication(Integer pageNum,Applyforemp applyforemp) {
        PageHelper.startPage(pageNum,11);
        List<Map> list = applyMapper.queryApplication(applyforemp);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}
