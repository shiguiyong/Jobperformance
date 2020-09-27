package com.xiuxiu.pojo;

import java.math.BigDecimal;

public class Monthlybill {
    private Integer id;

    private String duration;

    private Integer empid;

    private String empname;

    private BigDecimal present;

    private BigDecimal reducepresent;

    private BigDecimal performance;

    private Double performancepercent;

    private BigDecimal yuperformance;

    private BigDecimal basic;

    private BigDecimal addwork;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
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

    public BigDecimal getPresent() {
        return present;
    }

    public void setPresent(BigDecimal present) {
        this.present = present;
    }

    public BigDecimal getReducepresent() {
        return reducepresent;
    }

    public void setReducepresent(BigDecimal reducepresent) {
        this.reducepresent = reducepresent;
    }

    public BigDecimal getPerformance() {
        return performance;
    }

    public void setPerformance(BigDecimal performance) {
        this.performance = performance;
    }

    public Double getPerformancepercent() {
        return performancepercent;
    }

    public void setPerformancepercent(Double performancepercent) {
        this.performancepercent = performancepercent;
    }

    public BigDecimal getYuperformance() {
        return yuperformance;
    }

    public void setYuperformance(BigDecimal yuperformance) {
        this.yuperformance = yuperformance;
    }

    public BigDecimal getBasic() {
        return basic;
    }

    public void setBasic(BigDecimal basic) {
        this.basic = basic;
    }

    public BigDecimal getAddwork() {
        return addwork;
    }

    public void setAddwork(BigDecimal addwork) {
        this.addwork = addwork;
    }
}