package com.zufrost.learn;

import com.zufrost.learn.entity.StringExpression;
import com.zufrost.learn.service.ConsoleReadWrite;

public class Calculator {
    public static void main(String[] args) {
//        MathematicalExpression mathematicalExpression = new MathematicalExpression();
//        mathematicalExpression.setStringKindExpression("1 + 2 * 3");
//        System.out.println(mathematicalExpression.toString());
//        System.out.println(mathematicalExpression.hashCode());
        StringExpression stringExpression = new StringExpression();
        stringExpression.setStringExpression(new ConsoleReadWrite().readStringExpressionFromConsole());
        System.out.println(stringExpression.getStringExpression());
        System.out.println(stringExpression);
    }
}
