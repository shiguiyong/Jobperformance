package com.xiuxiu.pojo;

import java.math.BigDecimal;

public class Employees {
    private Integer id;

    private String account;

    private String password;

    private String name;

    private String role;

    private String status;

    private BigDecimal present;

    private BigDecimal reducepresent;

    private BigDecimal performance;

    private Double performancepercent;

    private BigDecimal yuperformance;

    private BigDecimal basic;

    private BigDecimal addwork;

    private String openid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }
}