package com.zufrost.learn;

import com.zufrost.learn.entity.MathematicalExpression;

public class Calculator {
    public static void main(String[] args) {
        MathematicalExpression mathematicalExpression = new MathematicalExpression();
        mathematicalExpression.setStringKindExpression("1 + 2 * 3");
        System.out.println(mathematicalExpression.toString());
        System.out.println(mathematicalExpression.hashCode());
    }
}
