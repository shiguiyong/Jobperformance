package com.xiuxiu.pojo;

/**
 * @author stone
 * @date 2020/9/9 000912:15
 */
public class Conditions {

    private String serialnumber;//同一期任务

    private Integer status;//完成状态

    private Integer taskId;//任务账号

    private Integer employeeId;//员工id

    private String addtime;//发布或者修改时间

    private String dateType;//时间类型

    private String starttime;//起始时间

    private String endtime;//结束时间

    private String taskTitle;//任务title

    private String employeeName;//员工名

    private Double workovertime;//加班时长

    @Override
    public String toString() {
        return "Conditions{" +
                "serialnumber='" + serialnumber + '\'' +
                ", status=" + status +
                ", taskId=" + taskId +
                ", employeeId=" + employeeId +
                ", addtime='" + addtime + '\'' +
                ", dateType='" + dateType + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", taskTitle='" + taskTitle + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", workovertime=" + workovertime +
                '}';
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getWorkovertime() {
        return workovertime;
    }

    public void setWorkovertime(Double workovertime) {
        this.workovertime = workovertime;
    }
}
