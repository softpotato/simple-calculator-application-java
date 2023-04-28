package com.softpotato.com.softpotato.operators;

public class MultiplicationOperator extends BinaryOperator {

    public MultiplicationOperator() {
        super(2);
    }

    @Override
    public double operation(double leftNum, double rightNum) {
        return leftNum * rightNum;
    }

    @Override
    public int operation(int leftNum, int rightNum) {
        return leftNum * rightNum;
    }

    @Override
    public AdvancedNumber operation(AdvancedNumber leftNum, AdvancedNumber rightNum) {
        return new AdvancedNumber(
                operation(leftNum.getIntegerVal(), rightNum.getIntegerVal()),
                operation(leftNum.getDoubleVal(), rightNum.getDoubleVal()));
    }

}
