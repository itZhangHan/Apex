package com.els.bean;

import java.util.ArrayList;
import java.util.List;

public class JhddUseReordsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JhddUseReordsExample() {
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

        public Criteria andUserecordidIsNull() {
            addCriterion("useRecordId is null");
            return (Criteria) this;
        }

        public Criteria andUserecordidIsNotNull() {
            addCriterion("useRecordId is not null");
            return (Criteria) this;
        }

        public Criteria andUserecordidEqualTo(Integer value) {
            addCriterion("useRecordId =", value, "userecordid");
            return (Criteria) this;
        }

        public Criteria andUserecordidNotEqualTo(Integer value) {
            addCriterion("useRecordId <>", value, "userecordid");
            return (Criteria) this;
        }

        public Criteria andUserecordidGreaterThan(Integer value) {
            addCriterion("useRecordId >", value, "userecordid");
            return (Criteria) this;
        }

        public Criteria andUserecordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("useRecordId >=", value, "userecordid");
            return (Criteria) this;
        }

        public Criteria andUserecordidLessThan(Integer value) {
            addCriterion("useRecordId <", value, "userecordid");
            return (Criteria) this;
        }

        public Criteria andUserecordidLessThanOrEqualTo(Integer value) {
            addCriterion("useRecordId <=", value, "userecordid");
            return (Criteria) this;
        }

        public Criteria andUserecordidIn(List<Integer> values) {
            addCriterion("useRecordId in", values, "userecordid");
            return (Criteria) this;
        }

        public Criteria andUserecordidNotIn(List<Integer> values) {
            addCriterion("useRecordId not in", values, "userecordid");
            return (Criteria) this;
        }

        public Criteria andUserecordidBetween(Integer value1, Integer value2) {
            addCriterion("useRecordId between", value1, value2, "userecordid");
            return (Criteria) this;
        }

        public Criteria andUserecordidNotBetween(Integer value1, Integer value2) {
            addCriterion("useRecordId not between", value1, value2, "userecordid");
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

        public Criteria andUserfromIsNull() {
            addCriterion("userFrom is null");
            return (Criteria) this;
        }

        public Criteria andUserfromIsNotNull() {
            addCriterion("userFrom is not null");
            return (Criteria) this;
        }

        public Criteria andUserfromEqualTo(String value) {
            addCriterion("userFrom =", value, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUserfromNotEqualTo(String value) {
            addCriterion("userFrom <>", value, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUserfromGreaterThan(String value) {
            addCriterion("userFrom >", value, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUserfromGreaterThanOrEqualTo(String value) {
            addCriterion("userFrom >=", value, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUserfromLessThan(String value) {
            addCriterion("userFrom <", value, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUserfromLessThanOrEqualTo(String value) {
            addCriterion("userFrom <=", value, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUserfromLike(String value) {
            addCriterion("userFrom like", value, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUserfromNotLike(String value) {
            addCriterion("userFrom not like", value, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUserfromIn(List<String> values) {
            addCriterion("userFrom in", values, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUserfromNotIn(List<String> values) {
            addCriterion("userFrom not in", values, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUserfromBetween(String value1, String value2) {
            addCriterion("userFrom between", value1, value2, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUserfromNotBetween(String value1, String value2) {
            addCriterion("userFrom not between", value1, value2, "userfrom");
            return (Criteria) this;
        }

        public Criteria andUsertoIsNull() {
            addCriterion("userTo is null");
            return (Criteria) this;
        }

        public Criteria andUsertoIsNotNull() {
            addCriterion("userTo is not null");
            return (Criteria) this;
        }

        public Criteria andUsertoEqualTo(String value) {
            addCriterion("userTo =", value, "userto");
            return (Criteria) this;
        }

        public Criteria andUsertoNotEqualTo(String value) {
            addCriterion("userTo <>", value, "userto");
            return (Criteria) this;
        }

        public Criteria andUsertoGreaterThan(String value) {
            addCriterion("userTo >", value, "userto");
            return (Criteria) this;
        }

        public Criteria andUsertoGreaterThanOrEqualTo(String value) {
            addCriterion("userTo >=", value, "userto");
            return (Criteria) this;
        }

        public Criteria andUsertoLessThan(String value) {
            addCriterion("userTo <", value, "userto");
            return (Criteria) this;
        }

        public Criteria andUsertoLessThanOrEqualTo(String value) {
            addCriterion("userTo <=", value, "userto");
            return (Criteria) this;
        }

        public Criteria andUsertoLike(String value) {
            addCriterion("userTo like", value, "userto");
            return (Criteria) this;
        }

        public Criteria andUsertoNotLike(String value) {
            addCriterion("userTo not like", value, "userto");
            return (Criteria) this;
        }

        public Criteria andUsertoIn(List<String> values) {
            addCriterion("userTo in", values, "userto");
            return (Criteria) this;
        }

        public Criteria andUsertoNotIn(List<String> values) {
            addCriterion("userTo not in", values, "userto");
            return (Criteria) this;
        }

        public Criteria andUsertoBetween(String value1, String value2) {
            addCriterion("userTo between", value1, value2, "userto");
            return (Criteria) this;
        }

        public Criteria andUsertoNotBetween(String value1, String value2) {
            addCriterion("userTo not between", value1, value2, "userto");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameIsNull() {
            addCriterion("gamePropsName is null");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameIsNotNull() {
            addCriterion("gamePropsName is not null");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameEqualTo(String value) {
            addCriterion("gamePropsName =", value, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameNotEqualTo(String value) {
            addCriterion("gamePropsName <>", value, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameGreaterThan(String value) {
            addCriterion("gamePropsName >", value, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameGreaterThanOrEqualTo(String value) {
            addCriterion("gamePropsName >=", value, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameLessThan(String value) {
            addCriterion("gamePropsName <", value, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameLessThanOrEqualTo(String value) {
            addCriterion("gamePropsName <=", value, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameLike(String value) {
            addCriterion("gamePropsName like", value, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameNotLike(String value) {
            addCriterion("gamePropsName not like", value, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameIn(List<String> values) {
            addCriterion("gamePropsName in", values, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameNotIn(List<String> values) {
            addCriterion("gamePropsName not in", values, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameBetween(String value1, String value2) {
            addCriterion("gamePropsName between", value1, value2, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropsnameNotBetween(String value1, String value2) {
            addCriterion("gamePropsName not between", value1, value2, "gamepropsname");
            return (Criteria) this;
        }

        public Criteria andGamepropstateIsNull() {
            addCriterion("gamePropState is null");
            return (Criteria) this;
        }

        public Criteria andGamepropstateIsNotNull() {
            addCriterion("gamePropState is not null");
            return (Criteria) this;
        }

        public Criteria andGamepropstateEqualTo(Byte value) {
            addCriterion("gamePropState =", value, "gamepropstate");
            return (Criteria) this;
        }

        public Criteria andGamepropstateNotEqualTo(Byte value) {
            addCriterion("gamePropState <>", value, "gamepropstate");
            return (Criteria) this;
        }

        public Criteria andGamepropstateGreaterThan(Byte value) {
            addCriterion("gamePropState >", value, "gamepropstate");
            return (Criteria) this;
        }

        public Criteria andGamepropstateGreaterThanOrEqualTo(Byte value) {
            addCriterion("gamePropState >=", value, "gamepropstate");
            return (Criteria) this;
        }

        public Criteria andGamepropstateLessThan(Byte value) {
            addCriterion("gamePropState <", value, "gamepropstate");
            return (Criteria) this;
        }

        public Criteria andGamepropstateLessThanOrEqualTo(Byte value) {
            addCriterion("gamePropState <=", value, "gamepropstate");
            return (Criteria) this;
        }

        public Criteria andGamepropstateIn(List<Byte> values) {
            addCriterion("gamePropState in", values, "gamepropstate");
            return (Criteria) this;
        }

        public Criteria andGamepropstateNotIn(List<Byte> values) {
            addCriterion("gamePropState not in", values, "gamepropstate");
            return (Criteria) this;
        }

        public Criteria andGamepropstateBetween(Byte value1, Byte value2) {
            addCriterion("gamePropState between", value1, value2, "gamepropstate");
            return (Criteria) this;
        }

        public Criteria andGamepropstateNotBetween(Byte value1, Byte value2) {
            addCriterion("gamePropState not between", value1, value2, "gamepropstate");
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