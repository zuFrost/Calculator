package com.zufrost.learn.entity;

public class StringExpression {
    private String stringExpression;

    public StringExpression() {
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

