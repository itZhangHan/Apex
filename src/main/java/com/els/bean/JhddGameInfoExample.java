package com.els.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JhddGameInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JhddGameInfoExample() {
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

        public Criteria andGameidIsNull() {
            addCriterion("gameId is null");
            return (Criteria) this;
        }

        public Criteria andGameidIsNotNull() {
            addCriterion("gameId is not null");
            return (Criteria) this;
        }

        public Criteria andGameidEqualTo(Integer value) {
            addCriterion("gameId =", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotEqualTo(Integer value) {
            addCriterion("gameId <>", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidGreaterThan(Integer value) {
            addCriterion("gameId >", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gameId >=", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidLessThan(Integer value) {
            addCriterion("gameId <", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidLessThanOrEqualTo(Integer value) {
            addCriterion("gameId <=", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidIn(List<Integer> values) {
            addCriterion("gameId in", values, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotIn(List<Integer> values) {
            addCriterion("gameId not in", values, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidBetween(Integer value1, Integer value2) {
            addCriterion("gameId between", value1, value2, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotBetween(Integer value1, Integer value2) {
            addCriterion("gameId not between", value1, value2, "gameid");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNull() {
            addCriterion("roomId is null");
            return (Criteria) this;
        }

        public Criteria andRoomidIsNotNull() {
            addCriterion("roomId is not null");
            return (Criteria) this;
        }

        public Criteria andRoomidEqualTo(Integer value) {
            addCriterion("roomId =", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotEqualTo(Integer value) {
            addCriterion("roomId <>", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThan(Integer value) {
            addCriterion("roomId >", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomId >=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThan(Integer value) {
            addCriterion("roomId <", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidLessThanOrEqualTo(Integer value) {
            addCriterion("roomId <=", value, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidIn(List<Integer> values) {
            addCriterion("roomId in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotIn(List<Integer> values) {
            addCriterion("roomId not in", values, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidBetween(Integer value1, Integer value2) {
            addCriterion("roomId between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andRoomidNotBetween(Integer value1, Integer value2) {
            addCriterion("roomId not between", value1, value2, "roomid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidIsNull() {
            addCriterion("playerOneId is null");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidIsNotNull() {
            addCriterion("playerOneId is not null");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidEqualTo(Integer value) {
            addCriterion("playerOneId =", value, "playeroneid");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidNotEqualTo(Integer value) {
            addCriterion("playerOneId <>", value, "playeroneid");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidGreaterThan(Integer value) {
            addCriterion("playerOneId >", value, "playeroneid");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidGreaterThanOrEqualTo(Integer value) {
            addCriterion("playerOneId >=", value, "playeroneid");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidLessThan(Integer value) {
            addCriterion("playerOneId <", value, "playeroneid");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidLessThanOrEqualTo(Integer value) {
            addCriterion("playerOneId <=", value, "playeroneid");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidIn(List<Integer> values) {
            addCriterion("playerOneId in", values, "playeroneid");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidNotIn(List<Integer> values) {
            addCriterion("playerOneId not in", values, "playeroneid");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidBetween(Integer value1, Integer value2) {
            addCriterion("playerOneId between", value1, value2, "playeroneid");
            return (Criteria) this;
        }

        public Criteria andPlayeroneidNotBetween(Integer value1, Integer value2) {
            addCriterion("playerOneId not between", value1, value2, "playeroneid");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameIsNull() {
            addCriterion("playerOneName is null");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameIsNotNull() {
            addCriterion("playerOneName is not null");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameEqualTo(String value) {
            addCriterion("playerOneName =", value, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameNotEqualTo(String value) {
            addCriterion("playerOneName <>", value, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameGreaterThan(String value) {
            addCriterion("playerOneName >", value, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameGreaterThanOrEqualTo(String value) {
            addCriterion("playerOneName >=", value, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameLessThan(String value) {
            addCriterion("playerOneName <", value, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameLessThanOrEqualTo(String value) {
            addCriterion("playerOneName <=", value, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameLike(String value) {
            addCriterion("playerOneName like", value, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameNotLike(String value) {
            addCriterion("playerOneName not like", value, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameIn(List<String> values) {
            addCriterion("playerOneName in", values, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameNotIn(List<String> values) {
            addCriterion("playerOneName not in", values, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameBetween(String value1, String value2) {
            addCriterion("playerOneName between", value1, value2, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeronenameNotBetween(String value1, String value2) {
            addCriterion("playerOneName not between", value1, value2, "playeronename");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgIsNull() {
            addCriterion("playerOneImg is null");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgIsNotNull() {
            addCriterion("playerOneImg is not null");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgEqualTo(String value) {
            addCriterion("playerOneImg =", value, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgNotEqualTo(String value) {
            addCriterion("playerOneImg <>", value, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgGreaterThan(String value) {
            addCriterion("playerOneImg >", value, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgGreaterThanOrEqualTo(String value) {
            addCriterion("playerOneImg >=", value, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgLessThan(String value) {
            addCriterion("playerOneImg <", value, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgLessThanOrEqualTo(String value) {
            addCriterion("playerOneImg <=", value, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgLike(String value) {
            addCriterion("playerOneImg like", value, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgNotLike(String value) {
            addCriterion("playerOneImg not like", value, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgIn(List<String> values) {
            addCriterion("playerOneImg in", values, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgNotIn(List<String> values) {
            addCriterion("playerOneImg not in", values, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgBetween(String value1, String value2) {
            addCriterion("playerOneImg between", value1, value2, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeroneimgNotBetween(String value1, String value2) {
            addCriterion("playerOneImg not between", value1, value2, "playeroneimg");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesIsNull() {
            addCriterion("playerOneLines is null");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesIsNotNull() {
            addCriterion("playerOneLines is not null");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesEqualTo(String value) {
            addCriterion("playerOneLines =", value, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesNotEqualTo(String value) {
            addCriterion("playerOneLines <>", value, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesGreaterThan(String value) {
            addCriterion("playerOneLines >", value, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesGreaterThanOrEqualTo(String value) {
            addCriterion("playerOneLines >=", value, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesLessThan(String value) {
            addCriterion("playerOneLines <", value, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesLessThanOrEqualTo(String value) {
            addCriterion("playerOneLines <=", value, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesLike(String value) {
            addCriterion("playerOneLines like", value, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesNotLike(String value) {
            addCriterion("playerOneLines not like", value, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesIn(List<String> values) {
            addCriterion("playerOneLines in", values, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesNotIn(List<String> values) {
            addCriterion("playerOneLines not in", values, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesBetween(String value1, String value2) {
            addCriterion("playerOneLines between", value1, value2, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronelinesNotBetween(String value1, String value2) {
            addCriterion("playerOneLines not between", value1, value2, "playeronelines");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreIsNull() {
            addCriterion("playerOneScore is null");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreIsNotNull() {
            addCriterion("playerOneScore is not null");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreEqualTo(String value) {
            addCriterion("playerOneScore =", value, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreNotEqualTo(String value) {
            addCriterion("playerOneScore <>", value, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreGreaterThan(String value) {
            addCriterion("playerOneScore >", value, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreGreaterThanOrEqualTo(String value) {
            addCriterion("playerOneScore >=", value, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreLessThan(String value) {
            addCriterion("playerOneScore <", value, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreLessThanOrEqualTo(String value) {
            addCriterion("playerOneScore <=", value, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreLike(String value) {
            addCriterion("playerOneScore like", value, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreNotLike(String value) {
            addCriterion("playerOneScore not like", value, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreIn(List<String> values) {
            addCriterion("playerOneScore in", values, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreNotIn(List<String> values) {
            addCriterion("playerOneScore not in", values, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreBetween(String value1, String value2) {
            addCriterion("playerOneScore between", value1, value2, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayeronescoreNotBetween(String value1, String value2) {
            addCriterion("playerOneScore not between", value1, value2, "playeronescore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidIsNull() {
            addCriterion("playerTwoId is null");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidIsNotNull() {
            addCriterion("playerTwoId is not null");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidEqualTo(Integer value) {
            addCriterion("playerTwoId =", value, "playertwoid");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidNotEqualTo(Integer value) {
            addCriterion("playerTwoId <>", value, "playertwoid");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidGreaterThan(Integer value) {
            addCriterion("playerTwoId >", value, "playertwoid");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("playerTwoId >=", value, "playertwoid");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidLessThan(Integer value) {
            addCriterion("playerTwoId <", value, "playertwoid");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidLessThanOrEqualTo(Integer value) {
            addCriterion("playerTwoId <=", value, "playertwoid");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidIn(List<Integer> values) {
            addCriterion("playerTwoId in", values, "playertwoid");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidNotIn(List<Integer> values) {
            addCriterion("playerTwoId not in", values, "playertwoid");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidBetween(Integer value1, Integer value2) {
            addCriterion("playerTwoId between", value1, value2, "playertwoid");
            return (Criteria) this;
        }

        public Criteria andPlayertwoidNotBetween(Integer value1, Integer value2) {
            addCriterion("playerTwoId not between", value1, value2, "playertwoid");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameIsNull() {
            addCriterion("playerTwoName is null");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameIsNotNull() {
            addCriterion("playerTwoName is not null");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameEqualTo(String value) {
            addCriterion("playerTwoName =", value, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameNotEqualTo(String value) {
            addCriterion("playerTwoName <>", value, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameGreaterThan(String value) {
            addCriterion("playerTwoName >", value, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameGreaterThanOrEqualTo(String value) {
            addCriterion("playerTwoName >=", value, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameLessThan(String value) {
            addCriterion("playerTwoName <", value, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameLessThanOrEqualTo(String value) {
            addCriterion("playerTwoName <=", value, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameLike(String value) {
            addCriterion("playerTwoName like", value, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameNotLike(String value) {
            addCriterion("playerTwoName not like", value, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameIn(List<String> values) {
            addCriterion("playerTwoName in", values, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameNotIn(List<String> values) {
            addCriterion("playerTwoName not in", values, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameBetween(String value1, String value2) {
            addCriterion("playerTwoName between", value1, value2, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwonameNotBetween(String value1, String value2) {
            addCriterion("playerTwoName not between", value1, value2, "playertwoname");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgIsNull() {
            addCriterion("playerTwoImg is null");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgIsNotNull() {
            addCriterion("playerTwoImg is not null");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgEqualTo(String value) {
            addCriterion("playerTwoImg =", value, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgNotEqualTo(String value) {
            addCriterion("playerTwoImg <>", value, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgGreaterThan(String value) {
            addCriterion("playerTwoImg >", value, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgGreaterThanOrEqualTo(String value) {
            addCriterion("playerTwoImg >=", value, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgLessThan(String value) {
            addCriterion("playerTwoImg <", value, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgLessThanOrEqualTo(String value) {
            addCriterion("playerTwoImg <=", value, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgLike(String value) {
            addCriterion("playerTwoImg like", value, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgNotLike(String value) {
            addCriterion("playerTwoImg not like", value, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgIn(List<String> values) {
            addCriterion("playerTwoImg in", values, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgNotIn(List<String> values) {
            addCriterion("playerTwoImg not in", values, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgBetween(String value1, String value2) {
            addCriterion("playerTwoImg between", value1, value2, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwoimgNotBetween(String value1, String value2) {
            addCriterion("playerTwoImg not between", value1, value2, "playertwoimg");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesIsNull() {
            addCriterion("playerTwoLines is null");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesIsNotNull() {
            addCriterion("playerTwoLines is not null");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesEqualTo(String value) {
            addCriterion("playerTwoLines =", value, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesNotEqualTo(String value) {
            addCriterion("playerTwoLines <>", value, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesGreaterThan(String value) {
            addCriterion("playerTwoLines >", value, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesGreaterThanOrEqualTo(String value) {
            addCriterion("playerTwoLines >=", value, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesLessThan(String value) {
            addCriterion("playerTwoLines <", value, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesLessThanOrEqualTo(String value) {
            addCriterion("playerTwoLines <=", value, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesLike(String value) {
            addCriterion("playerTwoLines like", value, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesNotLike(String value) {
            addCriterion("playerTwoLines not like", value, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesIn(List<String> values) {
            addCriterion("playerTwoLines in", values, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesNotIn(List<String> values) {
            addCriterion("playerTwoLines not in", values, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesBetween(String value1, String value2) {
            addCriterion("playerTwoLines between", value1, value2, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwolinesNotBetween(String value1, String value2) {
            addCriterion("playerTwoLines not between", value1, value2, "playertwolines");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreIsNull() {
            addCriterion("playerTwoScore is null");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreIsNotNull() {
            addCriterion("playerTwoScore is not null");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreEqualTo(String value) {
            addCriterion("playerTwoScore =", value, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreNotEqualTo(String value) {
            addCriterion("playerTwoScore <>", value, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreGreaterThan(String value) {
            addCriterion("playerTwoScore >", value, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreGreaterThanOrEqualTo(String value) {
            addCriterion("playerTwoScore >=", value, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreLessThan(String value) {
            addCriterion("playerTwoScore <", value, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreLessThanOrEqualTo(String value) {
            addCriterion("playerTwoScore <=", value, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreLike(String value) {
            addCriterion("playerTwoScore like", value, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreNotLike(String value) {
            addCriterion("playerTwoScore not like", value, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreIn(List<String> values) {
            addCriterion("playerTwoScore in", values, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreNotIn(List<String> values) {
            addCriterion("playerTwoScore not in", values, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreBetween(String value1, String value2) {
            addCriterion("playerTwoScore between", value1, value2, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayertwoscoreNotBetween(String value1, String value2) {
            addCriterion("playerTwoScore not between", value1, value2, "playertwoscore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidIsNull() {
            addCriterion("playerThreeId is null");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidIsNotNull() {
            addCriterion("playerThreeId is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidEqualTo(Integer value) {
            addCriterion("playerThreeId =", value, "playerthreeid");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidNotEqualTo(Integer value) {
            addCriterion("playerThreeId <>", value, "playerthreeid");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidGreaterThan(Integer value) {
            addCriterion("playerThreeId >", value, "playerthreeid");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("playerThreeId >=", value, "playerthreeid");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidLessThan(Integer value) {
            addCriterion("playerThreeId <", value, "playerthreeid");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidLessThanOrEqualTo(Integer value) {
            addCriterion("playerThreeId <=", value, "playerthreeid");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidIn(List<Integer> values) {
            addCriterion("playerThreeId in", values, "playerthreeid");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidNotIn(List<Integer> values) {
            addCriterion("playerThreeId not in", values, "playerthreeid");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidBetween(Integer value1, Integer value2) {
            addCriterion("playerThreeId between", value1, value2, "playerthreeid");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeidNotBetween(Integer value1, Integer value2) {
            addCriterion("playerThreeId not between", value1, value2, "playerthreeid");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameIsNull() {
            addCriterion("playerThreeName is null");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameIsNotNull() {
            addCriterion("playerThreeName is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameEqualTo(String value) {
            addCriterion("playerThreeName =", value, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameNotEqualTo(String value) {
            addCriterion("playerThreeName <>", value, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameGreaterThan(String value) {
            addCriterion("playerThreeName >", value, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameGreaterThanOrEqualTo(String value) {
            addCriterion("playerThreeName >=", value, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameLessThan(String value) {
            addCriterion("playerThreeName <", value, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameLessThanOrEqualTo(String value) {
            addCriterion("playerThreeName <=", value, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameLike(String value) {
            addCriterion("playerThreeName like", value, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameNotLike(String value) {
            addCriterion("playerThreeName not like", value, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameIn(List<String> values) {
            addCriterion("playerThreeName in", values, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameNotIn(List<String> values) {
            addCriterion("playerThreeName not in", values, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameBetween(String value1, String value2) {
            addCriterion("playerThreeName between", value1, value2, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreenameNotBetween(String value1, String value2) {
            addCriterion("playerThreeName not between", value1, value2, "playerthreename");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgIsNull() {
            addCriterion("playerThreeImg is null");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgIsNotNull() {
            addCriterion("playerThreeImg is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgEqualTo(String value) {
            addCriterion("playerThreeImg =", value, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgNotEqualTo(String value) {
            addCriterion("playerThreeImg <>", value, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgGreaterThan(String value) {
            addCriterion("playerThreeImg >", value, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgGreaterThanOrEqualTo(String value) {
            addCriterion("playerThreeImg >=", value, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgLessThan(String value) {
            addCriterion("playerThreeImg <", value, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgLessThanOrEqualTo(String value) {
            addCriterion("playerThreeImg <=", value, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgLike(String value) {
            addCriterion("playerThreeImg like", value, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgNotLike(String value) {
            addCriterion("playerThreeImg not like", value, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgIn(List<String> values) {
            addCriterion("playerThreeImg in", values, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgNotIn(List<String> values) {
            addCriterion("playerThreeImg not in", values, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgBetween(String value1, String value2) {
            addCriterion("playerThreeImg between", value1, value2, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreeimgNotBetween(String value1, String value2) {
            addCriterion("playerThreeImg not between", value1, value2, "playerthreeimg");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesIsNull() {
            addCriterion("playerThreeLines is null");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesIsNotNull() {
            addCriterion("playerThreeLines is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesEqualTo(String value) {
            addCriterion("playerThreeLines =", value, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesNotEqualTo(String value) {
            addCriterion("playerThreeLines <>", value, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesGreaterThan(String value) {
            addCriterion("playerThreeLines >", value, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesGreaterThanOrEqualTo(String value) {
            addCriterion("playerThreeLines >=", value, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesLessThan(String value) {
            addCriterion("playerThreeLines <", value, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesLessThanOrEqualTo(String value) {
            addCriterion("playerThreeLines <=", value, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesLike(String value) {
            addCriterion("playerThreeLines like", value, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesNotLike(String value) {
            addCriterion("playerThreeLines not like", value, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesIn(List<String> values) {
            addCriterion("playerThreeLines in", values, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesNotIn(List<String> values) {
            addCriterion("playerThreeLines not in", values, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesBetween(String value1, String value2) {
            addCriterion("playerThreeLines between", value1, value2, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreelinesNotBetween(String value1, String value2) {
            addCriterion("playerThreeLines not between", value1, value2, "playerthreelines");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreIsNull() {
            addCriterion("playerThreeScore is null");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreIsNotNull() {
            addCriterion("playerThreeScore is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreEqualTo(String value) {
            addCriterion("playerThreeScore =", value, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreNotEqualTo(String value) {
            addCriterion("playerThreeScore <>", value, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreGreaterThan(String value) {
            addCriterion("playerThreeScore >", value, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreGreaterThanOrEqualTo(String value) {
            addCriterion("playerThreeScore >=", value, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreLessThan(String value) {
            addCriterion("playerThreeScore <", value, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreLessThanOrEqualTo(String value) {
            addCriterion("playerThreeScore <=", value, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreLike(String value) {
            addCriterion("playerThreeScore like", value, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreNotLike(String value) {
            addCriterion("playerThreeScore not like", value, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreIn(List<String> values) {
            addCriterion("playerThreeScore in", values, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreNotIn(List<String> values) {
            addCriterion("playerThreeScore not in", values, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreBetween(String value1, String value2) {
            addCriterion("playerThreeScore between", value1, value2, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerthreescoreNotBetween(String value1, String value2) {
            addCriterion("playerThreeScore not between", value1, value2, "playerthreescore");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridIsNull() {
            addCriterion("playerFourId is null");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridIsNotNull() {
            addCriterion("playerFourId is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridEqualTo(Integer value) {
            addCriterion("playerFourId =", value, "playerfourid");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridNotEqualTo(Integer value) {
            addCriterion("playerFourId <>", value, "playerfourid");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridGreaterThan(Integer value) {
            addCriterion("playerFourId >", value, "playerfourid");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridGreaterThanOrEqualTo(Integer value) {
            addCriterion("playerFourId >=", value, "playerfourid");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridLessThan(Integer value) {
            addCriterion("playerFourId <", value, "playerfourid");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridLessThanOrEqualTo(Integer value) {
            addCriterion("playerFourId <=", value, "playerfourid");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridIn(List<Integer> values) {
            addCriterion("playerFourId in", values, "playerfourid");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridNotIn(List<Integer> values) {
            addCriterion("playerFourId not in", values, "playerfourid");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridBetween(Integer value1, Integer value2) {
            addCriterion("playerFourId between", value1, value2, "playerfourid");
            return (Criteria) this;
        }

        public Criteria andPlayerfouridNotBetween(Integer value1, Integer value2) {
            addCriterion("playerFourId not between", value1, value2, "playerfourid");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameIsNull() {
            addCriterion("playerFourName is null");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameIsNotNull() {
            addCriterion("playerFourName is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameEqualTo(String value) {
            addCriterion("playerFourName =", value, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameNotEqualTo(String value) {
            addCriterion("playerFourName <>", value, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameGreaterThan(String value) {
            addCriterion("playerFourName >", value, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameGreaterThanOrEqualTo(String value) {
            addCriterion("playerFourName >=", value, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameLessThan(String value) {
            addCriterion("playerFourName <", value, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameLessThanOrEqualTo(String value) {
            addCriterion("playerFourName <=", value, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameLike(String value) {
            addCriterion("playerFourName like", value, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameNotLike(String value) {
            addCriterion("playerFourName not like", value, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameIn(List<String> values) {
            addCriterion("playerFourName in", values, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameNotIn(List<String> values) {
            addCriterion("playerFourName not in", values, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameBetween(String value1, String value2) {
            addCriterion("playerFourName between", value1, value2, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfournameNotBetween(String value1, String value2) {
            addCriterion("playerFourName not between", value1, value2, "playerfourname");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgIsNull() {
            addCriterion("playerFourImg is null");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgIsNotNull() {
            addCriterion("playerFourImg is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgEqualTo(String value) {
            addCriterion("playerFourImg =", value, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgNotEqualTo(String value) {
            addCriterion("playerFourImg <>", value, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgGreaterThan(String value) {
            addCriterion("playerFourImg >", value, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgGreaterThanOrEqualTo(String value) {
            addCriterion("playerFourImg >=", value, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgLessThan(String value) {
            addCriterion("playerFourImg <", value, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgLessThanOrEqualTo(String value) {
            addCriterion("playerFourImg <=", value, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgLike(String value) {
            addCriterion("playerFourImg like", value, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgNotLike(String value) {
            addCriterion("playerFourImg not like", value, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgIn(List<String> values) {
            addCriterion("playerFourImg in", values, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgNotIn(List<String> values) {
            addCriterion("playerFourImg not in", values, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgBetween(String value1, String value2) {
            addCriterion("playerFourImg between", value1, value2, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourimgNotBetween(String value1, String value2) {
            addCriterion("playerFourImg not between", value1, value2, "playerfourimg");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesIsNull() {
            addCriterion("playerFourLines is null");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesIsNotNull() {
            addCriterion("playerFourLines is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesEqualTo(String value) {
            addCriterion("playerFourLines =", value, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesNotEqualTo(String value) {
            addCriterion("playerFourLines <>", value, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesGreaterThan(String value) {
            addCriterion("playerFourLines >", value, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesGreaterThanOrEqualTo(String value) {
            addCriterion("playerFourLines >=", value, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesLessThan(String value) {
            addCriterion("playerFourLines <", value, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesLessThanOrEqualTo(String value) {
            addCriterion("playerFourLines <=", value, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesLike(String value) {
            addCriterion("playerFourLines like", value, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesNotLike(String value) {
            addCriterion("playerFourLines not like", value, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesIn(List<String> values) {
            addCriterion("playerFourLines in", values, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesNotIn(List<String> values) {
            addCriterion("playerFourLines not in", values, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesBetween(String value1, String value2) {
            addCriterion("playerFourLines between", value1, value2, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourlinesNotBetween(String value1, String value2) {
            addCriterion("playerFourLines not between", value1, value2, "playerfourlines");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreIsNull() {
            addCriterion("playerFourScore is null");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreIsNotNull() {
            addCriterion("playerFourScore is not null");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreEqualTo(String value) {
            addCriterion("playerFourScore =", value, "playerfourscore");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreNotEqualTo(String value) {
            addCriterion("playerFourScore <>", value, "playerfourscore");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreGreaterThan(String value) {
            addCriterion("playerFourScore >", value, "playerfourscore");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreGreaterThanOrEqualTo(String value) {
            addCriterion("playerFourScore >=", value, "playerfourscore");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreLessThan(String value) {
            addCriterion("playerFourScore <", value, "playerfourscore");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreLessThanOrEqualTo(String value) {
            addCriterion("playerFourScore <=", value, "playerfourscore");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreLike(String value) {
            addCriterion("playerFourScore like", value, "playerfourscore");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreNotLike(String value) {
            addCriterion("playerFourScore not like", value, "playerfourscore");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreIn(List<String> values) {
            addCriterion("playerFourScore in", values, "playerfourscore");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreNotIn(List<String> values) {
            addCriterion("playerFourScore not in", values, "playerfourscore");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreBetween(String value1, String value2) {
            addCriterion("playerFourScore between", value1, value2, "playerfourscore");
            return (Criteria) this;
        }

        public Criteria andPlayerfourscoreNotBetween(String value1, String value2) {
            addCriterion("playerFourScore not between", value1, value2, "playerfourscore");
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