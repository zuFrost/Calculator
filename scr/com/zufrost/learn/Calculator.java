package com.zufrost.learn;

import com.zufrost.learn.entity.StringExpression;
import com.zufrost.learn.service.Compute;
import com.zufrost.learn.service.ConsoleReadWrite;
import com.zufrost.learn.service.Parser;
import com.zufrost.learn.service.Validator;


public class Calculator {
    public static void main(String[] args) {

        StringExpression stringExpression = new StringExpression();
        stringExpression.setStringExpression(new ConsoleReadWrite().readStringExpressionFromConsole());

        try {
            if (Validator.checkStringExpression(stringExpression.getStringExpression())) {

                Double result = Compute.calculation(Parser.parseToString(stringExpression.getStringExpression()));
                System.out.println(result);

            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


    }
}
