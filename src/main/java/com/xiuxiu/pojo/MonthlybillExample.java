package com.xiuxiu.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MonthlybillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonthlybillExample() {
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

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(String value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("duration like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("duration not like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<String> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<String> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNull() {
            addCriterion("empId is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("empId is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(Integer value) {
            addCriterion("empId =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(Integer value) {
            addCriterion("empId <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(Integer value) {
            addCriterion("empId >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("empId >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(Integer value) {
            addCriterion("empId <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(Integer value) {
            addCriterion("empId <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<Integer> values) {
            addCriterion("empId in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<Integer> values) {
            addCriterion("empId not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(Integer value1, Integer value2) {
            addCriterion("empId between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(Integer value1, Integer value2) {
            addCriterion("empId not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNull() {
            addCriterion("empname is null");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNotNull() {
            addCriterion("empname is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnameEqualTo(String value) {
            addCriterion("empname =", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotEqualTo(String value) {
            addCriterion("empname <>", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThan(String value) {
            addCriterion("empname >", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThanOrEqualTo(String value) {
            addCriterion("empname >=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThan(String value) {
            addCriterion("empname <", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThanOrEqualTo(String value) {
            addCriterion("empname <=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLike(String value) {
            addCriterion("empname like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotLike(String value) {
            addCriterion("empname not like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameIn(List<String> values) {
            addCriterion("empname in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotIn(List<String> values) {
            addCriterion("empname not in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameBetween(String value1, String value2) {
            addCriterion("empname between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotBetween(String value1, String value2) {
            addCriterion("empname not between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andPresentIsNull() {
            addCriterion("present is null");
            return (Criteria) this;
        }

        public Criteria andPresentIsNotNull() {
            addCriterion("present is not null");
            return (Criteria) this;
        }

        public Criteria andPresentEqualTo(BigDecimal value) {
            addCriterion("present =", value, "present");
            return (Criteria) this;
        }

        public Criteria andPresentNotEqualTo(BigDecimal value) {
            addCriterion("present <>", value, "present");
            return (Criteria) this;
        }

        public Criteria andPresentGreaterThan(BigDecimal value) {
            addCriterion("present >", value, "present");
            return (Criteria) this;
        }

        public Criteria andPresentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("present >=", value, "present");
            return (Criteria) this;
        }

        public Criteria andPresentLessThan(BigDecimal value) {
            addCriterion("present <", value, "present");
            return (Criteria) this;
        }

        public Criteria andPresentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("present <=", value, "present");
            return (Criteria) this;
        }

        public Criteria andPresentIn(List<BigDecimal> values) {
            addCriterion("present in", values, "present");
            return (Criteria) this;
        }

        public Criteria andPresentNotIn(List<BigDecimal> values) {
            addCriterion("present not in", values, "present");
            return (Criteria) this;
        }

        public Criteria andPresentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("present between", value1, value2, "present");
            return (Criteria) this;
        }

        public Criteria andPresentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("present not between", value1, value2, "present");
            return (Criteria) this;
        }

        public Criteria andReducepresentIsNull() {
            addCriterion("reducepresent is null");
            return (Criteria) this;
        }

        public Criteria andReducepresentIsNotNull() {
            addCriterion("reducepresent is not null");
            return (Criteria) this;
        }

        public Criteria andReducepresentEqualTo(BigDecimal value) {
            addCriterion("reducepresent =", value, "reducepresent");
            return (Criteria) this;
        }

        public Criteria andReducepresentNotEqualTo(BigDecimal value) {
            addCriterion("reducepresent <>", value, "reducepresent");
            return (Criteria) this;
        }

        public Criteria andReducepresentGreaterThan(BigDecimal value) {
            addCriterion("reducepresent >", value, "reducepresent");
            return (Criteria) this;
        }

        public Criteria andReducepresentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reducepresent >=", value, "reducepresent");
            return (Criteria) this;
        }

        public Criteria andReducepresentLessThan(BigDecimal value) {
            addCriterion("reducepresent <", value, "reducepresent");
            return (Criteria) this;
        }

        public Criteria andReducepresentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reducepresent <=", value, "reducepresent");
            return (Criteria) this;
        }

        public Criteria andReducepresentIn(List<BigDecimal> values) {
            addCriterion("reducepresent in", values, "reducepresent");
            return (Criteria) this;
        }

        public Criteria andReducepresentNotIn(List<BigDecimal> values) {
            addCriterion("reducepresent not in", values, "reducepresent");
            return (Criteria) this;
        }

        public Criteria andReducepresentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reducepresent between", value1, value2, "reducepresent");
            return (Criteria) this;
        }

        public Criteria andReducepresentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reducepresent not between", value1, value2, "reducepresent");
            return (Criteria) this;
        }

        public Criteria andPerformanceIsNull() {
            addCriterion("performance is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceIsNotNull() {
            addCriterion("performance is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceEqualTo(BigDecimal value) {
            addCriterion("performance =", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotEqualTo(BigDecimal value) {
            addCriterion("performance <>", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceGreaterThan(BigDecimal value) {
            addCriterion("performance >", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("performance >=", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceLessThan(BigDecimal value) {
            addCriterion("performance <", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("performance <=", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceIn(List<BigDecimal> values) {
            addCriterion("performance in", values, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotIn(List<BigDecimal> values) {
            addCriterion("performance not in", values, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("performance between", value1, value2, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("performance not between", value1, value2, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentIsNull() {
            addCriterion("performancepercent is null");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentIsNotNull() {
            addCriterion("performancepercent is not null");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentEqualTo(Double value) {
            addCriterion("performancepercent =", value, "performancepercent");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentNotEqualTo(Double value) {
            addCriterion("performancepercent <>", value, "performancepercent");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentGreaterThan(Double value) {
            addCriterion("performancepercent >", value, "performancepercent");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentGreaterThanOrEqualTo(Double value) {
            addCriterion("performancepercent >=", value, "performancepercent");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentLessThan(Double value) {
            addCriterion("performancepercent <", value, "performancepercent");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentLessThanOrEqualTo(Double value) {
            addCriterion("performancepercent <=", value, "performancepercent");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentIn(List<Double> values) {
            addCriterion("performancepercent in", values, "performancepercent");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentNotIn(List<Double> values) {
            addCriterion("performancepercent not in", values, "performancepercent");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentBetween(Double value1, Double value2) {
            addCriterion("performancepercent between", value1, value2, "performancepercent");
            return (Criteria) this;
        }

        public Criteria andPerformancepercentNotBetween(Double value1, Double value2) {
            addCriterion("performancepercent not between", value1, value2, "performancepercent");
            return (Criteria) this;
        }

        public Criteria andYuperformanceIsNull() {
            addCriterion("yuperformance is null");
            return (Criteria) this;
        }

        public Criteria andYuperformanceIsNotNull() {
            addCriterion("yuperformance is not null");
            return (Criteria) this;
        }

        public Criteria andYuperformanceEqualTo(BigDecimal value) {
            addCriterion("yuperformance =", value, "yuperformance");
            return (Criteria) this;
        }

        public Criteria andYuperformanceNotEqualTo(BigDecimal value) {
            addCriterion("yuperformance <>", value, "yuperformance");
            return (Criteria) this;
        }

        public Criteria andYuperformanceGreaterThan(BigDecimal value) {
            addCriterion("yuperformance >", value, "yuperformance");
            return (Criteria) this;
        }

        public Criteria andYuperformanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("yuperformance >=", value, "yuperformance");
            return (Criteria) this;
        }

        public Criteria andYuperformanceLessThan(BigDecimal value) {
            addCriterion("yuperformance <", value, "yuperformance");
            return (Criteria) this;
        }

        public Criteria andYuperformanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("yuperformance <=", value, "yuperformance");
            return (Criteria) this;
        }

        public Criteria andYuperformanceIn(List<BigDecimal> values) {
            addCriterion("yuperformance in", values, "yuperformance");
            return (Criteria) this;
        }

        public Criteria andYuperformanceNotIn(List<BigDecimal> values) {
            addCriterion("yuperformance not in", values, "yuperformance");
            return (Criteria) this;
        }

        public Criteria andYuperformanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yuperformance between", value1, value2, "yuperformance");
            return (Criteria) this;
        }

        public Criteria andYuperformanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yuperformance not between", value1, value2, "yuperformance");
            return (Criteria) this;
        }

        public Criteria andBasicIsNull() {
            addCriterion("basic is null");
            return (Criteria) this;
        }

        public Criteria andBasicIsNotNull() {
            addCriterion("basic is not null");
            return (Criteria) this;
        }

        public Criteria andBasicEqualTo(BigDecimal value) {
            addCriterion("basic =", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotEqualTo(BigDecimal value) {
            addCriterion("basic <>", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicGreaterThan(BigDecimal value) {
            addCriterion("basic >", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("basic >=", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicLessThan(BigDecimal value) {
            addCriterion("basic <", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicLessThanOrEqualTo(BigDecimal value) {
            addCriterion("basic <=", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicIn(List<BigDecimal> values) {
            addCriterion("basic in", values, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotIn(List<BigDecimal> values) {
            addCriterion("basic not in", values, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic between", value1, value2, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic not between", value1, value2, "basic");
            return (Criteria) this;
        }

        public Criteria andAddworkIsNull() {
            addCriterion("addwork is null");
            return (Criteria) this;
        }

        public Criteria andAddworkIsNotNull() {
            addCriterion("addwork is not null");
            return (Criteria) this;
        }

        public Criteria andAddworkEqualTo(BigDecimal value) {
            addCriterion("addwork =", value, "addwork");
            return (Criteria) this;
        }

        public Criteria andAddworkNotEqualTo(BigDecimal value) {
            addCriterion("addwork <>", value, "addwork");
            return (Criteria) this;
        }

        public Criteria andAddworkGreaterThan(BigDecimal value) {
            addCriterion("addwork >", value, "addwork");
            return (Criteria) this;
        }

        public Criteria andAddworkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("addwork >=", value, "addwork");
            return (Criteria) this;
        }

        public Criteria andAddworkLessThan(BigDecimal value) {
            addCriterion("addwork <", value, "addwork");
            return (Criteria) this;
        }

        public Criteria andAddworkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("addwork <=", value, "addwork");
            return (Criteria) this;
        }

        public Criteria andAddworkIn(List<BigDecimal> values) {
            addCriterion("addwork in", values, "addwork");
            return (Criteria) this;
        }

        public Criteria andAddworkNotIn(List<BigDecimal> values) {
            addCriterion("addwork not in", values, "addwork");
            return (Criteria) this;
        }

        public Criteria andAddworkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("addwork between", value1, value2, "addwork");
            return (Criteria) this;
        }

        public Criteria andAddworkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("addwork not between", value1, value2, "addwork");
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