package com.xiuxiu.pojo;

public class Employeetask {
    private Integer id;

    private String serialnumber;

    private String tasktitle;

    private String taskdetails;

    private Integer empid;

    private String empname;

    private Integer status;

    private String starttime;

    private String endtime;

    private Double workhours;

    private String addtime;

    private String allottime;

    private String claimtime;

    private String subtime;

    private String confirmtime;

    private String checkman;

    private String remark;

    private String image;

    private String fileurl;

    private String reworkremark;

    private String reworkurl;

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

    public String getTasktitle() {
        return tasktitle;
    }

    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle == null ? null : tasktitle.trim();
    }

    public String getTaskdetails() {
        return taskdetails;
    }

    public void setTaskdetails(String taskdetails) {
        this.taskdetails = taskdetails == null ? null : taskdetails.trim();
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public Double getWorkhours() {
        return workhours;
    }

    public void setWorkhours(Double workhours) {
        this.workhours = workhours;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public String getAllottime() {
        return allottime;
    }

    public void setAllottime(String allottime) {
        this.allottime = allottime == null ? null : allottime.trim();
    }

    public String getClaimtime() {
        return claimtime;
    }

    public void setClaimtime(String claimtime) {
        this.claimtime = claimtime == null ? null : claimtime.trim();
    }

    public String getSubtime() {
        return subtime;
    }

    public void setSubtime(String subtime) {
        this.subtime = subtime == null ? null : subtime.trim();
    }

    public String getConfirmtime() {
        return confirmtime;
    }

    public void setConfirmtime(String confirmtime) {
        this.confirmtime = confirmtime == null ? null : confirmtime.trim();
    }

    public String getCheckman() {
        return checkman;
    }

    public void setCheckman(String checkman) {
        this.checkman = checkman == null ? null : checkman.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public String getReworkremark() {
        return reworkremark;
    }

    public void setReworkremark(String reworkremark) {
        this.reworkremark = reworkremark == null ? null : reworkremark.trim();
    }

    public String getReworkurl() {
        return reworkurl;
    }

    public void setReworkurl(String reworkurl) {
        this.reworkurl = reworkurl == null ? null : reworkurl.trim();
    }
}