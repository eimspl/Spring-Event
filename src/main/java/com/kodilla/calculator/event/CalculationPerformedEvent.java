package com.kodilla.calculator.event;

import com.kodilla.calculator.domain.CalculationDto;
import com.kodilla.calculator.domain.CalculationType;
import org.springframework.context.ApplicationEvent;

public class CalculationPerformedEvent extends ApplicationEvent {
    double num1;
    double num2;
    CalculationType operation;
    double result;

    public CalculationPerformedEvent(Object source, CalculationDto calculationDto, Double result) {
        super(source);
        this.num1 = calculationDto.getNum1();
        this.num2 = calculationDto.getNum2();
        this.operation = calculationDto.getOperation();
        this.result = result;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResult() {
        return result;
    }

    public CalculationType getOperation() {
        return operation;
    }
}