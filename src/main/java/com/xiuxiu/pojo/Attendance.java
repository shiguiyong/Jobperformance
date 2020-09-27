package com.xiuxiu.pojo;

import java.util.Date;

public class Attendance {
    private Integer id;

    private String serialnumber;

    private Integer empid;

    private String name;

    private String type;

    private Integer status;

    private String addtime;

    private Date datevar;

    private String weeknum;

    private String ip;

    private String address;

    private String fromsystem;

    private String useragent;

    private Integer lessminute;

    private Integer moreminute;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public Date getDatevar() {
        return datevar;
    }

    public void setDatevar(Date datevar) {
        this.datevar = datevar;
    }

    public String getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(String weeknum) {
        this.weeknum = weeknum == null ? null : weeknum.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getFromsystem() {
        return fromsystem;
    }

    public void setFromsystem(String fromsystem) {
        this.fromsystem = fromsystem == null ? null : fromsystem.trim();
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent == null ? null : useragent.trim();
    }

    public Integer getLessminute() {
        return lessminute;
    }

    public void setLessminute(Integer lessminute) {
        this.lessminute = lessminute;
    }

    public Integer getMoreminute() {
        return moreminute;
    }

    public void setMoreminute(Integer moreminute) {
        this.moreminute = moreminute;
    }
}