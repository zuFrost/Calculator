package com.zufrost.learn;

import com.zufrost.learn.entity.Result;
import com.zufrost.learn.entity.StringExpression;
import com.zufrost.learn.service.Compute;
import com.zufrost.learn.service.ConsoleReadWrite;
import com.zufrost.learn.service.Parser;
import com.zufrost.learn.service.Validator;


public class Calculator {
    public static void main(String[] args) {

//        StringExpression stringExpression = new StringExpression();
//        ConsoleReadWrite consoleReadWrite = new ConsoleReadWrite();
//        stringExpression.setStringExpression(consoleReadWrite.readStringExpressionFromConsole());
//        Result result = new Result();
//
//        try {
//            if (Validator.checkStringExpression(stringExpression.getStringExpression())) {
//                result.setResult(Compute.calculation(Parser.parseToString(stringExpression.getStringExpression())));
//                consoleReadWrite.writeAnswerToConsole(result.getResult());
//
//            }
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }

        loopRunCalculating();


    }

    public static void loopRunCalculating() {
        StringExpression stringExpression = new StringExpression();
        ConsoleReadWrite consoleReadWrite = new ConsoleReadWrite();
        Result result = new Result();


        do {
            stringExpression.setStringExpression(consoleReadWrite.readStringExpressionFromConsole());
            try {
                if (Validator.checkStringExpression(stringExpression.getStringExpression())) {
                    result.setResult(Compute.calculation(Parser.parseToString(stringExpression.getStringExpression())));
                    consoleReadWrite.writeAnswerToConsole(result.getResult());

                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        } while (true);

    }
}
