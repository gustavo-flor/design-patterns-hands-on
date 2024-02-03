package com.github.gustavoflor.dpho.structural.adapter;

public class CalculatorAdapter {

    private final Calculator calculator;

    public CalculatorAdapter() {
        this.calculator = new Calculator();
    }

    public int sum(final int a, final int b) {
        final var result = calculator.sum(String.format("%s + %s", a, b));
        return Integer.parseInt(result.split("=")[1].trim());
    }

}
