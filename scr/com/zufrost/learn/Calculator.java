package com.zufrost.learn;

import com.zufrost.learn.entity.StringExpression;
import com.zufrost.learn.service.ConsoleReadWrite;
import com.zufrost.learn.service.Validator;

public class Calculator {
    public static void main(String[] args) {

        StringExpression stringExpression = new StringExpression();
        stringExpression.setStringExpression(new ConsoleReadWrite().readStringExpressionFromConsole());
//        System.out.println(stringExpression.getStringExpression());
//        System.out.println(stringExpression);
        Validator validator = new Validator();

        if (validator.checkStringExpression(stringExpression.getStringExpression())) {
            System.out.println("проверка строки " + stringExpression.getStringExpression() + " на валидность прошла успешно");
        } else {
            System.out.println("проверка строки " + stringExpression.getStringExpression() + " на валидность не прошла");
        }
    }
}
