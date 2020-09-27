package com.xiuxiu.pojo;

import java.util.ArrayList;
import java.util.List;

public class VisitorvolumeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitorvolumeExample() {
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

        public Criteria andNowurlIsNull() {
            addCriterion("nowurl is null");
            return (Criteria) this;
        }

        public Criteria andNowurlIsNotNull() {
            addCriterion("nowurl is not null");
            return (Criteria) this;
        }

        public Criteria andNowurlEqualTo(String value) {
            addCriterion("nowurl =", value, "nowurl");
            return (Criteria) this;
        }

        public Criteria andNowurlNotEqualTo(String value) {
            addCriterion("nowurl <>", value, "nowurl");
            return (Criteria) this;
        }

        public Criteria andNowurlGreaterThan(String value) {
            addCriterion("nowurl >", value, "nowurl");
            return (Criteria) this;
        }

        public Criteria andNowurlGreaterThanOrEqualTo(String value) {
            addCriterion("nowurl >=", value, "nowurl");
            return (Criteria) this;
        }

        public Criteria andNowurlLessThan(String value) {
            addCriterion("nowurl <", value, "nowurl");
            return (Criteria) this;
        }

        public Criteria andNowurlLessThanOrEqualTo(String value) {
            addCriterion("nowurl <=", value, "nowurl");
            return (Criteria) this;
        }

        public Criteria andNowurlLike(String value) {
            addCriterion("nowurl like", value, "nowurl");
            return (Criteria) this;
        }

        public Criteria andNowurlNotLike(String value) {
            addCriterion("nowurl not like", value, "nowurl");
            return (Criteria) this;
        }

        public Criteria andNowurlIn(List<String> values) {
            addCriterion("nowurl in", values, "nowurl");
            return (Criteria) this;
        }

        public Criteria andNowurlNotIn(List<String> values) {
            addCriterion("nowurl not in", values, "nowurl");
            return (Criteria) this;
        }

        public Criteria andNowurlBetween(String value1, String value2) {
            addCriterion("nowurl between", value1, value2, "nowurl");
            return (Criteria) this;
        }

        public Criteria andNowurlNotBetween(String value1, String value2) {
            addCriterion("nowurl not between", value1, value2, "nowurl");
            return (Criteria) this;
        }

        public Criteria andFromurlIsNull() {
            addCriterion("fromurl is null");
            return (Criteria) this;
        }

        public Criteria andFromurlIsNotNull() {
            addCriterion("fromurl is not null");
            return (Criteria) this;
        }

        public Criteria andFromurlEqualTo(String value) {
            addCriterion("fromurl =", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlNotEqualTo(String value) {
            addCriterion("fromurl <>", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlGreaterThan(String value) {
            addCriterion("fromurl >", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlGreaterThanOrEqualTo(String value) {
            addCriterion("fromurl >=", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlLessThan(String value) {
            addCriterion("fromurl <", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlLessThanOrEqualTo(String value) {
            addCriterion("fromurl <=", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlLike(String value) {
            addCriterion("fromurl like", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlNotLike(String value) {
            addCriterion("fromurl not like", value, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlIn(List<String> values) {
            addCriterion("fromurl in", values, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlNotIn(List<String> values) {
            addCriterion("fromurl not in", values, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlBetween(String value1, String value2) {
            addCriterion("fromurl between", value1, value2, "fromurl");
            return (Criteria) this;
        }

        public Criteria andFromurlNotBetween(String value1, String value2) {
            addCriterion("fromurl not between", value1, value2, "fromurl");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpaddressIsNull() {
            addCriterion("ipaddress is null");
            return (Criteria) this;
        }

        public Criteria andIpaddressIsNotNull() {
            addCriterion("ipaddress is not null");
            return (Criteria) this;
        }

        public Criteria andIpaddressEqualTo(String value) {
            addCriterion("ipaddress =", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotEqualTo(String value) {
            addCriterion("ipaddress <>", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressGreaterThan(String value) {
            addCriterion("ipaddress >", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressGreaterThanOrEqualTo(String value) {
            addCriterion("ipaddress >=", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLessThan(String value) {
            addCriterion("ipaddress <", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLessThanOrEqualTo(String value) {
            addCriterion("ipaddress <=", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLike(String value) {
            addCriterion("ipaddress like", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotLike(String value) {
            addCriterion("ipaddress not like", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressIn(List<String> values) {
            addCriterion("ipaddress in", values, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotIn(List<String> values) {
            addCriterion("ipaddress not in", values, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressBetween(String value1, String value2) {
            addCriterion("ipaddress between", value1, value2, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotBetween(String value1, String value2) {
            addCriterion("ipaddress not between", value1, value2, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andLsframe2IsNull() {
            addCriterion("lsframe2 is null");
            return (Criteria) this;
        }

        public Criteria andLsframe2IsNotNull() {
            addCriterion("lsframe2 is not null");
            return (Criteria) this;
        }

        public Criteria andLsframe2EqualTo(String value) {
            addCriterion("lsframe2 =", value, "lsframe2");
            return (Criteria) this;
        }

        public Criteria andLsframe2NotEqualTo(String value) {
            addCriterion("lsframe2 <>", value, "lsframe2");
            return (Criteria) this;
        }

        public Criteria andLsframe2GreaterThan(String value) {
            addCriterion("lsframe2 >", value, "lsframe2");
            return (Criteria) this;
        }

        public Criteria andLsframe2GreaterThanOrEqualTo(String value) {
            addCriterion("lsframe2 >=", value, "lsframe2");
            return (Criteria) this;
        }

        public Criteria andLsframe2LessThan(String value) {
            addCriterion("lsframe2 <", value, "lsframe2");
            return (Criteria) this;
        }

        public Criteria andLsframe2LessThanOrEqualTo(String value) {
            addCriterion("lsframe2 <=", value, "lsframe2");
            return (Criteria) this;
        }

        public Criteria andLsframe2Like(String value) {
            addCriterion("lsframe2 like", value, "lsframe2");
            return (Criteria) this;
        }

        public Criteria andLsframe2NotLike(String value) {
            addCriterion("lsframe2 not like", value, "lsframe2");
            return (Criteria) this;
        }

        public Criteria andLsframe2In(List<String> values) {
            addCriterion("lsframe2 in", values, "lsframe2");
            return (Criteria) this;
        }

        public Criteria andLsframe2NotIn(List<String> values) {
            addCriterion("lsframe2 not in", values, "lsframe2");
            return (Criteria) this;
        }

        public Criteria andLsframe2Between(String value1, String value2) {
            addCriterion("lsframe2 between", value1, value2, "lsframe2");
            return (Criteria) this;
        }

        public Criteria andLsframe2NotBetween(String value1, String value2) {
            addCriterion("lsframe2 not between", value1, value2, "lsframe2");
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

        public Criteria andLsframeIsNull() {
            addCriterion("lsframe is null");
            return (Criteria) this;
        }

        public Criteria andLsframeIsNotNull() {
            addCriterion("lsframe is not null");
            return (Criteria) this;
        }

        public Criteria andLsframeEqualTo(String value) {
            addCriterion("lsframe =", value, "lsframe");
            return (Criteria) this;
        }

        public Criteria andLsframeNotEqualTo(String value) {
            addCriterion("lsframe <>", value, "lsframe");
            return (Criteria) this;
        }

        public Criteria andLsframeGreaterThan(String value) {
            addCriterion("lsframe >", value, "lsframe");
            return (Criteria) this;
        }

        public Criteria andLsframeGreaterThanOrEqualTo(String value) {
            addCriterion("lsframe >=", value, "lsframe");
            return (Criteria) this;
        }

        public Criteria andLsframeLessThan(String value) {
            addCriterion("lsframe <", value, "lsframe");
            return (Criteria) this;
        }

        public Criteria andLsframeLessThanOrEqualTo(String value) {
            addCriterion("lsframe <=", value, "lsframe");
            return (Criteria) this;
        }

        public Criteria andLsframeLike(String value) {
            addCriterion("lsframe like", value, "lsframe");
            return (Criteria) this;
        }

        public Criteria andLsframeNotLike(String value) {
            addCriterion("lsframe not like", value, "lsframe");
            return (Criteria) this;
        }

        public Criteria andLsframeIn(List<String> values) {
            addCriterion("lsframe in", values, "lsframe");
            return (Criteria) this;
        }

        public Criteria andLsframeNotIn(List<String> values) {
            addCriterion("lsframe not in", values, "lsframe");
            return (Criteria) this;
        }

        public Criteria andLsframeBetween(String value1, String value2) {
            addCriterion("lsframe between", value1, value2, "lsframe");
            return (Criteria) this;
        }

        public Criteria andLsframeNotBetween(String value1, String value2) {
            addCriterion("lsframe not between", value1, value2, "lsframe");
            return (Criteria) this;
        }

        public Criteria andIspcIsNull() {
            addCriterion("ispc is null");
            return (Criteria) this;
        }

        public Criteria andIspcIsNotNull() {
            addCriterion("ispc is not null");
            return (Criteria) this;
        }

        public Criteria andIspcEqualTo(String value) {
            addCriterion("ispc =", value, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspcNotEqualTo(String value) {
            addCriterion("ispc <>", value, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspcGreaterThan(String value) {
            addCriterion("ispc >", value, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspcGreaterThanOrEqualTo(String value) {
            addCriterion("ispc >=", value, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspcLessThan(String value) {
            addCriterion("ispc <", value, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspcLessThanOrEqualTo(String value) {
            addCriterion("ispc <=", value, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspcLike(String value) {
            addCriterion("ispc like", value, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspcNotLike(String value) {
            addCriterion("ispc not like", value, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspcIn(List<String> values) {
            addCriterion("ispc in", values, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspcNotIn(List<String> values) {
            addCriterion("ispc not in", values, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspcBetween(String value1, String value2) {
            addCriterion("ispc between", value1, value2, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspcNotBetween(String value1, String value2) {
            addCriterion("ispc not between", value1, value2, "ispc");
            return (Criteria) this;
        }

        public Criteria andIspadIsNull() {
            addCriterion("ispad is null");
            return (Criteria) this;
        }

        public Criteria andIspadIsNotNull() {
            addCriterion("ispad is not null");
            return (Criteria) this;
        }

        public Criteria andIspadEqualTo(String value) {
            addCriterion("ispad =", value, "ispad");
            return (Criteria) this;
        }

        public Criteria andIspadNotEqualTo(String value) {
            addCriterion("ispad <>", value, "ispad");
            return (Criteria) this;
        }

        public Criteria andIspadGreaterThan(String value) {
            addCriterion("ispad >", value, "ispad");
            return (Criteria) this;
        }

        public Criteria andIspadGreaterThanOrEqualTo(String value) {
            addCriterion("ispad >=", value, "ispad");
            return (Criteria) this;
        }

        public Criteria andIspadLessThan(String value) {
            addCriterion("ispad <", value, "ispad");
            return (Criteria) this;
        }

        public Criteria andIspadLessThanOrEqualTo(String value) {
            addCriterion("ispad <=", value, "ispad");
            return (Criteria) this;
        }

        public Criteria andIspadLike(String value) {
            addCriterion("ispad like", value, "ispad");
            return (Criteria) this;
        }

        public Criteria andIspadNotLike(String value) {
            addCriterion("ispad not like", value, "ispad");
            return (Criteria) this;
        }

        public Criteria andIspadIn(List<String> values) {
            addCriterion("ispad in", values, "ispad");
            return (Criteria) this;
        }

        public Criteria andIspadNotIn(List<String> values) {
            addCriterion("ispad not in", values, "ispad");
            return (Criteria) this;
        }

        public Criteria andIspadBetween(String value1, String value2) {
            addCriterion("ispad between", value1, value2, "ispad");
            return (Criteria) this;
        }

        public Criteria andIspadNotBetween(String value1, String value2) {
            addCriterion("ispad not between", value1, value2, "ispad");
            return (Criteria) this;
        }

        public Criteria andStandbyoneIsNull() {
            addCriterion("standbyone is null");
            return (Criteria) this;
        }

        public Criteria andStandbyoneIsNotNull() {
            addCriterion("standbyone is not null");
            return (Criteria) this;
        }

        public Criteria andStandbyoneEqualTo(String value) {
            addCriterion("standbyone =", value, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbyoneNotEqualTo(String value) {
            addCriterion("standbyone <>", value, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbyoneGreaterThan(String value) {
            addCriterion("standbyone >", value, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbyoneGreaterThanOrEqualTo(String value) {
            addCriterion("standbyone >=", value, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbyoneLessThan(String value) {
            addCriterion("standbyone <", value, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbyoneLessThanOrEqualTo(String value) {
            addCriterion("standbyone <=", value, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbyoneLike(String value) {
            addCriterion("standbyone like", value, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbyoneNotLike(String value) {
            addCriterion("standbyone not like", value, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbyoneIn(List<String> values) {
            addCriterion("standbyone in", values, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbyoneNotIn(List<String> values) {
            addCriterion("standbyone not in", values, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbyoneBetween(String value1, String value2) {
            addCriterion("standbyone between", value1, value2, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbyoneNotBetween(String value1, String value2) {
            addCriterion("standbyone not between", value1, value2, "standbyone");
            return (Criteria) this;
        }

        public Criteria andStandbytwoIsNull() {
            addCriterion("standbytwo is null");
            return (Criteria) this;
        }

        public Criteria andStandbytwoIsNotNull() {
            addCriterion("standbytwo is not null");
            return (Criteria) this;
        }

        public Criteria andStandbytwoEqualTo(String value) {
            addCriterion("standbytwo =", value, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbytwoNotEqualTo(String value) {
            addCriterion("standbytwo <>", value, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbytwoGreaterThan(String value) {
            addCriterion("standbytwo >", value, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbytwoGreaterThanOrEqualTo(String value) {
            addCriterion("standbytwo >=", value, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbytwoLessThan(String value) {
            addCriterion("standbytwo <", value, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbytwoLessThanOrEqualTo(String value) {
            addCriterion("standbytwo <=", value, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbytwoLike(String value) {
            addCriterion("standbytwo like", value, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbytwoNotLike(String value) {
            addCriterion("standbytwo not like", value, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbytwoIn(List<String> values) {
            addCriterion("standbytwo in", values, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbytwoNotIn(List<String> values) {
            addCriterion("standbytwo not in", values, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbytwoBetween(String value1, String value2) {
            addCriterion("standbytwo between", value1, value2, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbytwoNotBetween(String value1, String value2) {
            addCriterion("standbytwo not between", value1, value2, "standbytwo");
            return (Criteria) this;
        }

        public Criteria andStandbythrIsNull() {
            addCriterion("standbythr is null");
            return (Criteria) this;
        }

        public Criteria andStandbythrIsNotNull() {
            addCriterion("standbythr is not null");
            return (Criteria) this;
        }

        public Criteria andStandbythrEqualTo(String value) {
            addCriterion("standbythr =", value, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbythrNotEqualTo(String value) {
            addCriterion("standbythr <>", value, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbythrGreaterThan(String value) {
            addCriterion("standbythr >", value, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbythrGreaterThanOrEqualTo(String value) {
            addCriterion("standbythr >=", value, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbythrLessThan(String value) {
            addCriterion("standbythr <", value, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbythrLessThanOrEqualTo(String value) {
            addCriterion("standbythr <=", value, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbythrLike(String value) {
            addCriterion("standbythr like", value, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbythrNotLike(String value) {
            addCriterion("standbythr not like", value, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbythrIn(List<String> values) {
            addCriterion("standbythr in", values, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbythrNotIn(List<String> values) {
            addCriterion("standbythr not in", values, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbythrBetween(String value1, String value2) {
            addCriterion("standbythr between", value1, value2, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbythrNotBetween(String value1, String value2) {
            addCriterion("standbythr not between", value1, value2, "standbythr");
            return (Criteria) this;
        }

        public Criteria andStandbyfourIsNull() {
            addCriterion("standbyfour is null");
            return (Criteria) this;
        }

        public Criteria andStandbyfourIsNotNull() {
            addCriterion("standbyfour is not null");
            return (Criteria) this;
        }

        public Criteria andStandbyfourEqualTo(String value) {
            addCriterion("standbyfour =", value, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfourNotEqualTo(String value) {
            addCriterion("standbyfour <>", value, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfourGreaterThan(String value) {
            addCriterion("standbyfour >", value, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfourGreaterThanOrEqualTo(String value) {
            addCriterion("standbyfour >=", value, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfourLessThan(String value) {
            addCriterion("standbyfour <", value, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfourLessThanOrEqualTo(String value) {
            addCriterion("standbyfour <=", value, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfourLike(String value) {
            addCriterion("standbyfour like", value, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfourNotLike(String value) {
            addCriterion("standbyfour not like", value, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfourIn(List<String> values) {
            addCriterion("standbyfour in", values, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfourNotIn(List<String> values) {
            addCriterion("standbyfour not in", values, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfourBetween(String value1, String value2) {
            addCriterion("standbyfour between", value1, value2, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfourNotBetween(String value1, String value2) {
            addCriterion("standbyfour not between", value1, value2, "standbyfour");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveIsNull() {
            addCriterion("standbyfive is null");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveIsNotNull() {
            addCriterion("standbyfive is not null");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveEqualTo(String value) {
            addCriterion("standbyfive =", value, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveNotEqualTo(String value) {
            addCriterion("standbyfive <>", value, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveGreaterThan(String value) {
            addCriterion("standbyfive >", value, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveGreaterThanOrEqualTo(String value) {
            addCriterion("standbyfive >=", value, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveLessThan(String value) {
            addCriterion("standbyfive <", value, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveLessThanOrEqualTo(String value) {
            addCriterion("standbyfive <=", value, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveLike(String value) {
            addCriterion("standbyfive like", value, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveNotLike(String value) {
            addCriterion("standbyfive not like", value, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveIn(List<String> values) {
            addCriterion("standbyfive in", values, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveNotIn(List<String> values) {
            addCriterion("standbyfive not in", values, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveBetween(String value1, String value2) {
            addCriterion("standbyfive between", value1, value2, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbyfiveNotBetween(String value1, String value2) {
            addCriterion("standbyfive not between", value1, value2, "standbyfive");
            return (Criteria) this;
        }

        public Criteria andStandbysixIsNull() {
            addCriterion("standbysix is null");
            return (Criteria) this;
        }

        public Criteria andStandbysixIsNotNull() {
            addCriterion("standbysix is not null");
            return (Criteria) this;
        }

        public Criteria andStandbysixEqualTo(String value) {
            addCriterion("standbysix =", value, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysixNotEqualTo(String value) {
            addCriterion("standbysix <>", value, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysixGreaterThan(String value) {
            addCriterion("standbysix >", value, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysixGreaterThanOrEqualTo(String value) {
            addCriterion("standbysix >=", value, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysixLessThan(String value) {
            addCriterion("standbysix <", value, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysixLessThanOrEqualTo(String value) {
            addCriterion("standbysix <=", value, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysixLike(String value) {
            addCriterion("standbysix like", value, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysixNotLike(String value) {
            addCriterion("standbysix not like", value, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysixIn(List<String> values) {
            addCriterion("standbysix in", values, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysixNotIn(List<String> values) {
            addCriterion("standbysix not in", values, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysixBetween(String value1, String value2) {
            addCriterion("standbysix between", value1, value2, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysixNotBetween(String value1, String value2) {
            addCriterion("standbysix not between", value1, value2, "standbysix");
            return (Criteria) this;
        }

        public Criteria andStandbysevenIsNull() {
            addCriterion("standbyseven is null");
            return (Criteria) this;
        }

        public Criteria andStandbysevenIsNotNull() {
            addCriterion("standbyseven is not null");
            return (Criteria) this;
        }

        public Criteria andStandbysevenEqualTo(String value) {
            addCriterion("standbyseven =", value, "standbyseven");
            return (Criteria) this;
        }

        public Criteria andStandbysevenNotEqualTo(String value) {
            addCriterion("standbyseven <>", value, "standbyseven");
            return (Criteria) this;
        }

        public Criteria andStandbysevenGreaterThan(String value) {
            addCriterion("standbyseven >", value, "standbyseven");
            return (Criteria) this;
        }

        public Criteria andStandbysevenGreaterThanOrEqualTo(String value) {
            addCriterion("standbyseven >=", value, "standbyseven");
            return (Criteria) this;
        }

        public Criteria andStandbysevenLessThan(String value) {
            addCriterion("standbyseven <", value, "standbyseven");
            return (Criteria) this;
        }

        public Criteria andStandbysevenLessThanOrEqualTo(String value) {
            addCriterion("standbyseven <=", value, "standbyseven");
            return (Criteria) this;
        }

        public Criteria andStandbysevenLike(String value) {
            addCriterion("standbyseven like", value, "standbyseven");
            return (Criteria) this;
        }

        public Criteria andStandbysevenNotLike(String value) {
            addCriterion("standbyseven not like", value, "standbyseven");
            return (Criteria) this;
        }

        public Criteria andStandbysevenIn(List<String> values) {
            addCriterion("standbyseven in", values, "standbyseven");
            return (Criteria) this;
        }

        public Criteria andStandbysevenNotIn(List<String> values) {
            addCriterion("standbyseven not in", values, "standbyseven");
            return (Criteria) this;
        }

        public Criteria andStandbysevenBetween(String value1, String value2) {
            addCriterion("standbyseven between", value1, value2, "standbyseven");
            return (Criteria) this;
        }

        public Criteria andStandbysevenNotBetween(String value1, String value2) {
            addCriterion("standbyseven not between", value1, value2, "standbyseven");
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