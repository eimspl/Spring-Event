package com.kodilla.calculator.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CalculationType {
    ADDITION('+'),
    SUBTRUCTION('-'),
    MULTIPLICATION('*'),
    DIVISION(':');

    private final Character sign;

    private CalculationType(char sign) {
        this.sign = sign;
    }

    public Character getSign() {
        return sign;
    }

    public static CalculationType valueOf(Character sign) {
        for (CalculationType type : values()) {
            if (type.sign.equals(sign)) {
                return type;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid operation sign '%s'." +
                "Possible values are: %s.", sign, getValuesAsString()));
    }

    private static String getValuesAsString() {
        return Arrays.stream(values())
                .map(v -> String.valueOf(v.getSign()))
                .collect(Collectors.joining(", "));
    }
}
