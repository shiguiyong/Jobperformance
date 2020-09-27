package com.xiuxiu.pojo;

import java.util.ArrayList;
import java.util.List;

public class EmployeetaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeetaskExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSerialnumberIsNull() {
            addCriterion("serialnumber is null");
            return (Criteria) this;
        }

        public Criteria andSerialnumberIsNotNull() {
            addCriterion("serialnumber is not null");
            return (Criteria) this;
        }

        public Criteria andSerialnumberEqualTo(String value) {
            addCriterion("serialnumber =", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotEqualTo(String value) {
            addCriterion("serialnumber <>", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberGreaterThan(String value) {
            addCriterion("serialnumber >", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberGreaterThanOrEqualTo(String value) {
            addCriterion("serialnumber >=", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberLessThan(String value) {
            addCriterion("serialnumber <", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberLessThanOrEqualTo(String value) {
            addCriterion("serialnumber <=", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberLike(String value) {
            addCriterion("serialnumber like", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotLike(String value) {
            addCriterion("serialnumber not like", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberIn(List<String> values) {
            addCriterion("serialnumber in", values, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotIn(List<String> values) {
            addCriterion("serialnumber not in", values, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberBetween(String value1, String value2) {
            addCriterion("serialnumber between", value1, value2, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotBetween(String value1, String value2) {
            addCriterion("serialnumber not between", value1, value2, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andTasktitleIsNull() {
            addCriterion("tasktitle is null");
            return (Criteria) this;
        }

        public Criteria andTasktitleIsNotNull() {
            addCriterion("tasktitle is not null");
            return (Criteria) this;
        }

        public Criteria andTasktitleEqualTo(String value) {
            addCriterion("tasktitle =", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleNotEqualTo(String value) {
            addCriterion("tasktitle <>", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleGreaterThan(String value) {
            addCriterion("tasktitle >", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleGreaterThanOrEqualTo(String value) {
            addCriterion("tasktitle >=", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleLessThan(String value) {
            addCriterion("tasktitle <", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleLessThanOrEqualTo(String value) {
            addCriterion("tasktitle <=", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleLike(String value) {
            addCriterion("tasktitle like", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleNotLike(String value) {
            addCriterion("tasktitle not like", value, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleIn(List<String> values) {
            addCriterion("tasktitle in", values, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleNotIn(List<String> values) {
            addCriterion("tasktitle not in", values, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleBetween(String value1, String value2) {
            addCriterion("tasktitle between", value1, value2, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTasktitleNotBetween(String value1, String value2) {
            addCriterion("tasktitle not between", value1, value2, "tasktitle");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsIsNull() {
            addCriterion("taskdetails is null");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsIsNotNull() {
            addCriterion("taskdetails is not null");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsEqualTo(String value) {
            addCriterion("taskdetails =", value, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsNotEqualTo(String value) {
            addCriterion("taskdetails <>", value, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsGreaterThan(String value) {
            addCriterion("taskdetails >", value, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsGreaterThanOrEqualTo(String value) {
            addCriterion("taskdetails >=", value, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsLessThan(String value) {
            addCriterion("taskdetails <", value, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsLessThanOrEqualTo(String value) {
            addCriterion("taskdetails <=", value, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsLike(String value) {
            addCriterion("taskdetails like", value, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsNotLike(String value) {
            addCriterion("taskdetails not like", value, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsIn(List<String> values) {
            addCriterion("taskdetails in", values, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsNotIn(List<String> values) {
            addCriterion("taskdetails not in", values, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsBetween(String value1, String value2) {
            addCriterion("taskdetails between", value1, value2, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andTaskdetailsNotBetween(String value1, String value2) {
            addCriterion("taskdetails not between", value1, value2, "taskdetails");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNull() {
            addCriterion("empid is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("empid is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(Integer value) {
            addCriterion("empid =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(Integer value) {
            addCriterion("empid <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(Integer value) {
            addCriterion("empid >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("empid >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(Integer value) {
            addCriterion("empid <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(Integer value) {
            addCriterion("empid <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<Integer> values) {
            addCriterion("empid in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<Integer> values) {
            addCriterion("empid not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(Integer value1, Integer value2) {
            addCriterion("empid between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(Integer value1, Integer value2) {
            addCriterion("empid not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNull() {
            addCriterion("empName is null");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNotNull() {
            addCriterion("empName is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnameEqualTo(String value) {
            addCriterion("empName =", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotEqualTo(String value) {
            addCriterion("empName <>", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThan(String value) {
            addCriterion("empName >", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThanOrEqualTo(String value) {
            addCriterion("empName >=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThan(String value) {
            addCriterion("empName <", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThanOrEqualTo(String value) {
            addCriterion("empName <=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLike(String value) {
            addCriterion("empName like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotLike(String value) {
            addCriterion("empName not like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameIn(List<String> values) {
            addCriterion("empName in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotIn(List<String> values) {
            addCriterion("empName not in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameBetween(String value1, String value2) {
            addCriterion("empName between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotBetween(String value1, String value2) {
            addCriterion("empName not between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(String value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(String value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(String value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(String value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(String value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(String value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLike(String value) {
            addCriterion("starttime like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotLike(String value) {
            addCriterion("starttime not like", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<String> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<String> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(String value1, String value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(String value1, String value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(String value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(String value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(String value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(String value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(String value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(String value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLike(String value) {
            addCriterion("endtime like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotLike(String value) {
            addCriterion("endtime not like", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<String> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<String> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(String value1, String value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(String value1, String value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andWorkhoursIsNull() {
            addCriterion("workhours is null");
            return (Criteria) this;
        }

        public Criteria andWorkhoursIsNotNull() {
            addCriterion("workhours is not null");
            return (Criteria) this;
        }

        public Criteria andWorkhoursEqualTo(Double value) {
            addCriterion("workhours =", value, "workhours");
            return (Criteria) this;
        }

        public Criteria andWorkhoursNotEqualTo(Double value) {
            addCriterion("workhours <>", value, "workhours");
            return (Criteria) this;
        }

        public Criteria andWorkhoursGreaterThan(Double value) {
            addCriterion("workhours >", value, "workhours");
            return (Criteria) this;
        }

        public Criteria andWorkhoursGreaterThanOrEqualTo(Double value) {
            addCriterion("workhours >=", value, "workhours");
            return (Criteria) this;
        }

        public Criteria andWorkhoursLessThan(Double value) {
            addCriterion("workhours <", value, "workhours");
            return (Criteria) this;
        }

        public Criteria andWorkhoursLessThanOrEqualTo(Double value) {
            addCriterion("workhours <=", value, "workhours");
            return (Criteria) this;
        }

        public Criteria andWorkhoursIn(List<Double> values) {
            addCriterion("workhours in", values, "workhours");
            return (Criteria) this;
        }

        public Criteria andWorkhoursNotIn(List<Double> values) {
            addCriterion("workhours not in", values, "workhours");
            return (Criteria) this;
        }

        public Criteria andWorkhoursBetween(Double value1, Double value2) {
            addCriterion("workhours between", value1, value2, "workhours");
            return (Criteria) this;
        }

        public Criteria andWorkhoursNotBetween(Double value1, Double value2) {
            addCriterion("workhours not between", value1, value2, "workhours");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(String value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(String value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(String value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(String value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(String value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(String value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLike(String value) {
            addCriterion("addtime like", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotLike(String value) {
            addCriterion("addtime not like", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<String> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<String> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(String value1, String value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(String value1, String value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAllottimeIsNull() {
            addCriterion("allottime is null");
            return (Criteria) this;
        }

        public Criteria andAllottimeIsNotNull() {
            addCriterion("allottime is not null");
            return (Criteria) this;
        }

        public Criteria andAllottimeEqualTo(String value) {
            addCriterion("allottime =", value, "allottime");
            return (Criteria) this;
        }

        public Criteria andAllottimeNotEqualTo(String value) {
            addCriterion("allottime <>", value, "allottime");
            return (Criteria) this;
        }

        public Criteria andAllottimeGreaterThan(String value) {
            addCriterion("allottime >", value, "allottime");
            return (Criteria) this;
        }

        public Criteria andAllottimeGreaterThanOrEqualTo(String value) {
            addCriterion("allottime >=", value, "allottime");
            return (Criteria) this;
        }

        public Criteria andAllottimeLessThan(String value) {
            addCriterion("allottime <", value, "allottime");
            return (Criteria) this;
        }

        public Criteria andAllottimeLessThanOrEqualTo(String value) {
            addCriterion("allottime <=", value, "allottime");
            return (Criteria) this;
        }

        public Criteria andAllottimeLike(String value) {
            addCriterion("allottime like", value, "allottime");
            return (Criteria) this;
        }

        public Criteria andAllottimeNotLike(String value) {
            addCriterion("allottime not like", value, "allottime");
            return (Criteria) this;
        }

        public Criteria andAllottimeIn(List<String> values) {
            addCriterion("allottime in", values, "allottime");
            return (Criteria) this;
        }

        public Criteria andAllottimeNotIn(List<String> values) {
            addCriterion("allottime not in", values, "allottime");
            return (Criteria) this;
        }

        public Criteria andAllottimeBetween(String value1, String value2) {
            addCriterion("allottime between", value1, value2, "allottime");
            return (Criteria) this;
        }

        public Criteria andAllottimeNotBetween(String value1, String value2) {
            addCriterion("allottime not between", value1, value2, "allottime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeIsNull() {
            addCriterion("claimtime is null");
            return (Criteria) this;
        }

        public Criteria andClaimtimeIsNotNull() {
            addCriterion("claimtime is not null");
            return (Criteria) this;
        }

        public Criteria andClaimtimeEqualTo(String value) {
            addCriterion("claimtime =", value, "claimtime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeNotEqualTo(String value) {
            addCriterion("claimtime <>", value, "claimtime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeGreaterThan(String value) {
            addCriterion("claimtime >", value, "claimtime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeGreaterThanOrEqualTo(String value) {
            addCriterion("claimtime >=", value, "claimtime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeLessThan(String value) {
            addCriterion("claimtime <", value, "claimtime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeLessThanOrEqualTo(String value) {
            addCriterion("claimtime <=", value, "claimtime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeLike(String value) {
            addCriterion("claimtime like", value, "claimtime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeNotLike(String value) {
            addCriterion("claimtime not like", value, "claimtime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeIn(List<String> values) {
            addCriterion("claimtime in", values, "claimtime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeNotIn(List<String> values) {
            addCriterion("claimtime not in", values, "claimtime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeBetween(String value1, String value2) {
            addCriterion("claimtime between", value1, value2, "claimtime");
            return (Criteria) this;
        }

        public Criteria andClaimtimeNotBetween(String value1, String value2) {
            addCriterion("claimtime not between", value1, value2, "claimtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeIsNull() {
            addCriterion("subtime is null");
            return (Criteria) this;
        }

        public Criteria andSubtimeIsNotNull() {
            addCriterion("subtime is not null");
            return (Criteria) this;
        }

        public Criteria andSubtimeEqualTo(String value) {
            addCriterion("subtime =", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeNotEqualTo(String value) {
            addCriterion("subtime <>", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeGreaterThan(String value) {
            addCriterion("subtime >", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeGreaterThanOrEqualTo(String value) {
            addCriterion("subtime >=", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeLessThan(String value) {
            addCriterion("subtime <", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeLessThanOrEqualTo(String value) {
            addCriterion("subtime <=", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeLike(String value) {
            addCriterion("subtime like", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeNotLike(String value) {
            addCriterion("subtime not like", value, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeIn(List<String> values) {
            addCriterion("subtime in", values, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeNotIn(List<String> values) {
            addCriterion("subtime not in", values, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeBetween(String value1, String value2) {
            addCriterion("subtime between", value1, value2, "subtime");
            return (Criteria) this;
        }

        public Criteria andSubtimeNotBetween(String value1, String value2) {
            addCriterion("subtime not between", value1, value2, "subtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeIsNull() {
            addCriterion("confirmtime is null");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeIsNotNull() {
            addCriterion("confirmtime is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeEqualTo(String value) {
            addCriterion("confirmtime =", value, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeNotEqualTo(String value) {
            addCriterion("confirmtime <>", value, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeGreaterThan(String value) {
            addCriterion("confirmtime >", value, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeGreaterThanOrEqualTo(String value) {
            addCriterion("confirmtime >=", value, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeLessThan(String value) {
            addCriterion("confirmtime <", value, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeLessThanOrEqualTo(String value) {
            addCriterion("confirmtime <=", value, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeLike(String value) {
            addCriterion("confirmtime like", value, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeNotLike(String value) {
            addCriterion("confirmtime not like", value, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeIn(List<String> values) {
            addCriterion("confirmtime in", values, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeNotIn(List<String> values) {
            addCriterion("confirmtime not in", values, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeBetween(String value1, String value2) {
            addCriterion("confirmtime between", value1, value2, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andConfirmtimeNotBetween(String value1, String value2) {
            addCriterion("confirmtime not between", value1, value2, "confirmtime");
            return (Criteria) this;
        }

        public Criteria andCheckmanIsNull() {
            addCriterion("checkman is null");
            return (Criteria) this;
        }

        public Criteria andCheckmanIsNotNull() {
            addCriterion("checkman is not null");
            return (Criteria) this;
        }

        public Criteria andCheckmanEqualTo(String value) {
            addCriterion("checkman =", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanNotEqualTo(String value) {
            addCriterion("checkman <>", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanGreaterThan(String value) {
            addCriterion("checkman >", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanGreaterThanOrEqualTo(String value) {
            addCriterion("checkman >=", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanLessThan(String value) {
            addCriterion("checkman <", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanLessThanOrEqualTo(String value) {
            addCriterion("checkman <=", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanLike(String value) {
            addCriterion("checkman like", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanNotLike(String value) {
            addCriterion("checkman not like", value, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanIn(List<String> values) {
            addCriterion("checkman in", values, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanNotIn(List<String> values) {
            addCriterion("checkman not in", values, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanBetween(String value1, String value2) {
            addCriterion("checkman between", value1, value2, "checkman");
            return (Criteria) this;
        }

        public Criteria andCheckmanNotBetween(String value1, String value2) {
            addCriterion("checkman not between", value1, value2, "checkman");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andFileurlIsNull() {
            addCriterion("fileurl is null");
            return (Criteria) this;
        }

        public Criteria andFileurlIsNotNull() {
            addCriterion("fileurl is not null");
            return (Criteria) this;
        }

        public Criteria andFileurlEqualTo(String value) {
            addCriterion("fileurl =", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotEqualTo(String value) {
            addCriterion("fileurl <>", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlGreaterThan(String value) {
            addCriterion("fileurl >", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlGreaterThanOrEqualTo(String value) {
            addCriterion("fileurl >=", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlLessThan(String value) {
            addCriterion("fileurl <", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlLessThanOrEqualTo(String value) {
            addCriterion("fileurl <=", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlLike(String value) {
            addCriterion("fileurl like", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotLike(String value) {
            addCriterion("fileurl not like", value, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlIn(List<String> values) {
            addCriterion("fileurl in", values, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotIn(List<String> values) {
            addCriterion("fileurl not in", values, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlBetween(String value1, String value2) {
            addCriterion("fileurl between", value1, value2, "fileurl");
            return (Criteria) this;
        }

        public Criteria andFileurlNotBetween(String value1, String value2) {
            addCriterion("fileurl not between", value1, value2, "fileurl");
            return (Criteria) this;
        }

        public Criteria andReworkremarkIsNull() {
            addCriterion("reworkremark is null");
            return (Criteria) this;
        }

        public Criteria andReworkremarkIsNotNull() {
            addCriterion("reworkremark is not null");
            return (Criteria) this;
        }

        public Criteria andReworkremarkEqualTo(String value) {
            addCriterion("reworkremark =", value, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkremarkNotEqualTo(String value) {
            addCriterion("reworkremark <>", value, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkremarkGreaterThan(String value) {
            addCriterion("reworkremark >", value, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkremarkGreaterThanOrEqualTo(String value) {
            addCriterion("reworkremark >=", value, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkremarkLessThan(String value) {
            addCriterion("reworkremark <", value, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkremarkLessThanOrEqualTo(String value) {
            addCriterion("reworkremark <=", value, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkremarkLike(String value) {
            addCriterion("reworkremark like", value, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkremarkNotLike(String value) {
            addCriterion("reworkremark not like", value, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkremarkIn(List<String> values) {
            addCriterion("reworkremark in", values, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkremarkNotIn(List<String> values) {
            addCriterion("reworkremark not in", values, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkremarkBetween(String value1, String value2) {
            addCriterion("reworkremark between", value1, value2, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkremarkNotBetween(String value1, String value2) {
            addCriterion("reworkremark not between", value1, value2, "reworkremark");
            return (Criteria) this;
        }

        public Criteria andReworkurlIsNull() {
            addCriterion("reworkurl is null");
            return (Criteria) this;
        }

        public Criteria andReworkurlIsNotNull() {
            addCriterion("reworkurl is not null");
            return (Criteria) this;
        }

        public Criteria andReworkurlEqualTo(String value) {
            addCriterion("reworkurl =", value, "reworkurl");
            return (Criteria) this;
        }

        public Criteria andReworkurlNotEqualTo(String value) {
            addCriterion("reworkurl <>", value, "reworkurl");
            return (Criteria) this;
        }

        public Criteria andReworkurlGreaterThan(String value) {
            addCriterion("reworkurl >", value, "reworkurl");
            return (Criteria) this;
        }

        public Criteria andReworkurlGreaterThanOrEqualTo(String value) {
            addCriterion("reworkurl >=", value, "reworkurl");
            return (Criteria) this;
        }

        public Criteria andReworkurlLessThan(String value) {
            addCriterion("reworkurl <", value, "reworkurl");
            return (Criteria) this;
        }

        public Criteria andReworkurlLessThanOrEqualTo(String value) {
            addCriterion("reworkurl <=", value, "reworkurl");
            return (Criteria) this;
        }

        public Criteria andReworkurlLike(String value) {
            addCriterion("reworkurl like", value, "reworkurl");
            return (Criteria) this;
        }

        public Criteria andReworkurlNotLike(String value) {
            addCriterion("reworkurl not like", value, "reworkurl");
            return (Criteria) this;
        }

        public Criteria andReworkurlIn(List<String> values) {
            addCriterion("reworkurl in", values, "reworkurl");
            return (Criteria) this;
        }

        public Criteria andReworkurlNotIn(List<String> values) {
            addCriterion("reworkurl not in", values, "reworkurl");
            return (Criteria) this;
        }

        public Criteria andReworkurlBetween(String value1, String value2) {
            addCriterion("reworkurl between", value1, value2, "reworkurl");
            return (Criteria) this;
        }

        public Criteria andReworkurlNotBetween(String value1, String value2) {
            addCriterion("reworkurl not between", value1, value2, "reworkurl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}