package com.zufrost.learn;

import com.zufrost.learn.entity.Result;
import com.zufrost.learn.entity.StringExpression;
import com.zufrost.learn.service.Compute;
import com.zufrost.learn.service.ConsoleReadWrite;
import com.zufrost.learn.service.ReversePolishNotationParser;
import com.zufrost.learn.service.Validator;


public class Calculator {
    public static void main(String[] args) {


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
                    result.setResult(Compute.calculation(ReversePolishNotationParser.parseToString(stringExpression.getStringExpression())));
                    consoleReadWrite.writeAnswerToConsole(result.getResult());

                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        } while (true);

    }
}
