package com.kodilla.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public double add(double number1, double number2) {
        return number1 + number2;
    }

    public double delete(double number1, double number2) {
        return number1 - number2;
    }

    public double multiply(double number1, double number2) {
        return number1 * number2;
    }

    public double divide(double number1, double number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("Cannot divide by 0. The second number must be different than 0.");
        }
        return number1 / number2;
    }
}
