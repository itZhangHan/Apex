package com.els.bean;

import java.util.ArrayList;
import java.util.List;

public class JhddPositionimgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JhddPositionimgExample() {
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

        public Criteria andPositionidIsNull() {
            addCriterion("positionId is null");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNotNull() {
            addCriterion("positionId is not null");
            return (Criteria) this;
        }

        public Criteria andPositionidEqualTo(Integer value) {
            addCriterion("positionId =", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotEqualTo(Integer value) {
            addCriterion("positionId <>", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThan(Integer value) {
            addCriterion("positionId >", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("positionId >=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThan(Integer value) {
            addCriterion("positionId <", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThanOrEqualTo(Integer value) {
            addCriterion("positionId <=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidIn(List<Integer> values) {
            addCriterion("positionId in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotIn(List<Integer> values) {
            addCriterion("positionId not in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidBetween(Integer value1, Integer value2) {
            addCriterion("positionId between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotBetween(Integer value1, Integer value2) {
            addCriterion("positionId not between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andImgoneIsNull() {
            addCriterion("imgOne is null");
            return (Criteria) this;
        }

        public Criteria andImgoneIsNotNull() {
            addCriterion("imgOne is not null");
            return (Criteria) this;
        }

        public Criteria andImgoneEqualTo(String value) {
            addCriterion("imgOne =", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneNotEqualTo(String value) {
            addCriterion("imgOne <>", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneGreaterThan(String value) {
            addCriterion("imgOne >", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneGreaterThanOrEqualTo(String value) {
            addCriterion("imgOne >=", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneLessThan(String value) {
            addCriterion("imgOne <", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneLessThanOrEqualTo(String value) {
            addCriterion("imgOne <=", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneLike(String value) {
            addCriterion("imgOne like", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneNotLike(String value) {
            addCriterion("imgOne not like", value, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneIn(List<String> values) {
            addCriterion("imgOne in", values, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneNotIn(List<String> values) {
            addCriterion("imgOne not in", values, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneBetween(String value1, String value2) {
            addCriterion("imgOne between", value1, value2, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgoneNotBetween(String value1, String value2) {
            addCriterion("imgOne not between", value1, value2, "imgone");
            return (Criteria) this;
        }

        public Criteria andImgtwoIsNull() {
            addCriterion("imgTwo is null");
            return (Criteria) this;
        }

        public Criteria andImgtwoIsNotNull() {
            addCriterion("imgTwo is not null");
            return (Criteria) this;
        }

        public Criteria andImgtwoEqualTo(String value) {
            addCriterion("imgTwo =", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoNotEqualTo(String value) {
            addCriterion("imgTwo <>", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoGreaterThan(String value) {
            addCriterion("imgTwo >", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoGreaterThanOrEqualTo(String value) {
            addCriterion("imgTwo >=", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoLessThan(String value) {
            addCriterion("imgTwo <", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoLessThanOrEqualTo(String value) {
            addCriterion("imgTwo <=", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoLike(String value) {
            addCriterion("imgTwo like", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoNotLike(String value) {
            addCriterion("imgTwo not like", value, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoIn(List<String> values) {
            addCriterion("imgTwo in", values, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoNotIn(List<String> values) {
            addCriterion("imgTwo not in", values, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoBetween(String value1, String value2) {
            addCriterion("imgTwo between", value1, value2, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgtwoNotBetween(String value1, String value2) {
            addCriterion("imgTwo not between", value1, value2, "imgtwo");
            return (Criteria) this;
        }

        public Criteria andImgthreeIsNull() {
            addCriterion("imgThree is null");
            return (Criteria) this;
        }

        public Criteria andImgthreeIsNotNull() {
            addCriterion("imgThree is not null");
            return (Criteria) this;
        }

        public Criteria andImgthreeEqualTo(String value) {
            addCriterion("imgThree =", value, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgthreeNotEqualTo(String value) {
            addCriterion("imgThree <>", value, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgthreeGreaterThan(String value) {
            addCriterion("imgThree >", value, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgthreeGreaterThanOrEqualTo(String value) {
            addCriterion("imgThree >=", value, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgthreeLessThan(String value) {
            addCriterion("imgThree <", value, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgthreeLessThanOrEqualTo(String value) {
            addCriterion("imgThree <=", value, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgthreeLike(String value) {
            addCriterion("imgThree like", value, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgthreeNotLike(String value) {
            addCriterion("imgThree not like", value, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgthreeIn(List<String> values) {
            addCriterion("imgThree in", values, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgthreeNotIn(List<String> values) {
            addCriterion("imgThree not in", values, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgthreeBetween(String value1, String value2) {
            addCriterion("imgThree between", value1, value2, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgthreeNotBetween(String value1, String value2) {
            addCriterion("imgThree not between", value1, value2, "imgthree");
            return (Criteria) this;
        }

        public Criteria andImgfourIsNull() {
            addCriterion("imgFour is null");
            return (Criteria) this;
        }

        public Criteria andImgfourIsNotNull() {
            addCriterion("imgFour is not null");
            return (Criteria) this;
        }

        public Criteria andImgfourEqualTo(String value) {
            addCriterion("imgFour =", value, "imgfour");
            return (Criteria) this;
        }

        public Criteria andImgfourNotEqualTo(String value) {
            addCriterion("imgFour <>", value, "imgfour");
            return (Criteria) this;
        }

        public Criteria andImgfourGreaterThan(String value) {
            addCriterion("imgFour >", value, "imgfour");
            return (Criteria) this;
        }

        public Criteria andImgfourGreaterThanOrEqualTo(String value) {
            addCriterion("imgFour >=", value, "imgfour");
            return (Criteria) this;
        }

        public Criteria andImgfourLessThan(String value) {
            addCriterion("imgFour <", value, "imgfour");
            return (Criteria) this;
        }

        public Criteria andImgfourLessThanOrEqualTo(String value) {
            addCriterion("imgFour <=", value, "imgfour");
            return (Criteria) this;
        }

        public Criteria andImgfourLike(String value) {
            addCriterion("imgFour like", value, "imgfour");
            return (Criteria) this;
        }

        public Criteria andImgfourNotLike(String value) {
            addCriterion("imgFour not like", value, "imgfour");
            return (Criteria) this;
        }

        public Criteria andImgfourIn(List<String> values) {
            addCriterion("imgFour in", values, "imgfour");
            return (Criteria) this;
        }

        public Criteria andImgfourNotIn(List<String> values) {
            addCriterion("imgFour not in", values, "imgfour");
            return (Criteria) this;
        }

        public Criteria andImgfourBetween(String value1, String value2) {
            addCriterion("imgFour between", value1, value2, "imgfour");
            return (Criteria) this;
        }

        public Criteria andImgfourNotBetween(String value1, String value2) {
            addCriterion("imgFour not between", value1, value2, "imgfour");
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