package com.zufrost.learn;

import com.zufrost.learn.entity.Result;
import com.zufrost.learn.entity.ReversePolishNotationExpression;
import com.zufrost.learn.entity.UsualStringExpression;
import com.zufrost.learn.service.ComputeFromReversePolishNotation;
import com.zufrost.learn.service.ConsoleReadWrite;
import com.zufrost.learn.service.ReversePolishNotationParser;
import com.zufrost.learn.service.Validator;


public class Calculator {
    public static void main(String[] args) {


        RunCalculating();


    }

    public static void RunCalculating() {
        ConsoleReadWrite consoleReadWrite = new ConsoleReadWrite();
        UsualStringExpression stringExpression = new UsualStringExpression();
        ReversePolishNotationExpression reversePolishNotationExpression = new ReversePolishNotationExpression();
        Result result = new Result();

        stringExpression.setStringExpression(consoleReadWrite.readStringExpressionFromConsole());
        try {
            Validator.checkStringExpression(stringExpression.getStringExpression());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        reversePolishNotationExpression.setStringExpression(ReversePolishNotationParser.parseToString(stringExpression.getStringExpression()));
        result.setResult(ComputeFromReversePolishNotation.calculate(reversePolishNotationExpression.getStringExpression()));
        consoleReadWrite.writeAnswerToConsole(result.getResult());


    }
}
