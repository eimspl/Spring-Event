package com.kodilla.calculator.domain;

public class CalculationDto {

    double num1;
    double num2;
    CalculationType operation;

    public CalculationDto(Character sign, double number1, double number2) {
        this.operation = CalculationType.valueOf(sign);
        this.num1 = number1;
        this.num2 = number2;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public CalculationType getOperation() {
        return operation;
    }
}
