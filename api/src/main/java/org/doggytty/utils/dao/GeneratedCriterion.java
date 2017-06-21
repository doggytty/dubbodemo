package org.doggytty.utils.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doggy on 17-6-21.
 */
public class GeneratedCriterion {
    private List<Criterion> criteria;

    protected GeneratedCriterion() {
        super();
        criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<Criterion> getAllCriteria() {
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

    public GeneratedCriterion andPropertyIsNull(String property) {
        addCriterion(String.format("%s is null", property));
        return this;
    }

    public GeneratedCriterion andPropertyIsNotNull(String property) {
        addCriterion(String.format("%s is not null", property));
        return this;
    }

    public GeneratedCriterion andPropertyEqualTo(String property, Object value) {
        addCriterion(String.format("%s =", property), value, property);
        return this;
    }

    public GeneratedCriterion andPropertyNotEqualTo(String property, Object value) {
        addCriterion(String.format("%s <>", property), value, property);
        return this;
    }

    public GeneratedCriterion andPropertyGreaterThan(String property, Object value) {
        addCriterion(String.format("%s >", property), value, property);
        return this;
    }

    public GeneratedCriterion andPropertyGreaterThanOrEqualTo(String property, Object value) {
        addCriterion(String.format("%s >=", property), value, property);
        return this;
    }

    public GeneratedCriterion andPropertyLessThan(String property, Object value) {
        addCriterion(String.format("%s <", property), value, property);
        return this;
    }

    public GeneratedCriterion andPropertyLessThanOrEqualTo(String property, Object value) {
        addCriterion(String.format("%s <=", property), value, property);
        return this;
    }

    public GeneratedCriterion andPropertyIn(String property, List<Object> values) {
        addCriterion(String.format("%s in", property), values, property);
        return this;
    }

    public GeneratedCriterion andPropertyNotIn(String property, List<Object> values) {
        addCriterion(String.format("%s not in", property), values, property);
        return this;
    }

    public GeneratedCriterion andPropertyBetween(String property, Object value1, Object value2) {
        addCriterion(String.format("%s between", property), value1, value2, property);
        return this;
    }

    public GeneratedCriterion andPropertyNotBetween(String property, Object value1, Object value2) {
        addCriterion(String.format("%s not between", property), value1, value2, property);
        return this;
    }

    public GeneratedCriterion andPropertyLike(String property, String value) {
        addCriterion(String.format("%s like", property), value, property);
        return this;
    }

    public GeneratedCriterion andPropertyNotLike(String property, String value) {
        addCriterion(String.format("%s not like", property), value, property);
        return this;
    }
}
