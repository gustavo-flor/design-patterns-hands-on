package com.github.gustavoflor.dpho.structural.adapter;

public class Calculator {

    public String sum(final String expression) {
        final var args = expression.split("\\+");
        final var a = Integer.parseInt(args[0].trim());
        final var b = Integer.parseInt(args[1].trim());
        final var result = a + b;
        return String.format("%s + %s = %s", a, b, result);
    }

}
