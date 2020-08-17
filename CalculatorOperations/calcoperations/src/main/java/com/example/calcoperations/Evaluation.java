package com.example.calcoperations;

import android.widget.Toast;

public class Evaluation {

    private static double result;

    public static double evaluateEquation(double operand1,double operand2,String operator){
        switch (operator){
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if(operand2 == 0){
                    result = Double.parseDouble(null);
                }else{
                    result = operand1 / operand2;
                }
                break;
            default:
                break;

        }
        return result;
    }

    public static double evaluateEquation(double operand1,String operator){
        switch (operator){
            case "sin":
                result = Math.sin(operand1);
                break;
            case "cos":
                result = Math.cos(operand1);
                break;
            case "tan":
                result = Math.tan(operand1);
                break;
            default:
                break;

        }
        return result;
    }
}
