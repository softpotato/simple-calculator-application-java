package com.softpotato.com.softpotato.operators;

public class ExponentOperator extends BinaryOperator {

    public ExponentOperator() {
        super(3);
    }

    @Override
    public double operation(double leftNum, double rightNum) {
        return Math.pow(leftNum, rightNum);
    }

    @Override
    public int operation(int leftNum, int rightNum) {
        return (int) Math.pow(leftNum, rightNum);
    }

    @Override
    public AdvancedNumber operation(AdvancedNumber leftNum, AdvancedNumber rightNum) {
        return new AdvancedNumber(
                operation(leftNum.getIntegerVal(), rightNum.getIntegerVal()),
                operation(leftNum.getDoubleVal(), rightNum.getDoubleVal()));
    }

}
