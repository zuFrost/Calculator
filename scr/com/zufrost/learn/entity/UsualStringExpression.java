package com.zufrost.learn.entity;

public class UsualStringExpression {
    private String stringExpression;

    public UsualStringExpression() {
    }

    public String getStringExpression() {
        return stringExpression;
    }

    public void setStringExpression(String stringExpression) {
        this.stringExpression = stringExpression;
    }

    @Override
    public String toString() {
        return "StringExpression{" +
                "stringExpression='" + stringExpression + '\'' +
                '}';
    }
}

