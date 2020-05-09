package com.zufrost.learn.entity;

public class MathematicalExpression {

    private String stringKindExpression;

    public MathematicalExpression() {
    }

    public MathematicalExpression(String stringKindExpression) {
        this.stringKindExpression = stringKindExpression;
    }

    public String getStringKindExpression() {
        return stringKindExpression;
    }

    public void setStringKindExpression(String stringKindExpression) {
        this.stringKindExpression = stringKindExpression;
    }

    @Override
    public String toString() {
        return "MathematicalExpression{" +
                "stringKindExpression='" + stringKindExpression + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MathematicalExpression that = (MathematicalExpression) o;

        return stringKindExpression != null ? stringKindExpression.equals(that.stringKindExpression) : that.stringKindExpression == null;
    }

    @Override
    public int hashCode() {
        return stringKindExpression != null ? stringKindExpression.hashCode() : 0;
    }
}


