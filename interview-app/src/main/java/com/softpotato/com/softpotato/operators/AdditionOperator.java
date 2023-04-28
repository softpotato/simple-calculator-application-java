package com.softpotato.com.softpotato.operators;

public class AdditionOperator extends BinaryOperator {

    public AdditionOperator() {
        super(1);
    }

    @Override
    public double operation(double leftNum, double rightNum) {
        return leftNum + rightNum;
    }

    @Override
    public int operation(int leftNum, int rightNum) {
        return leftNum + rightNum;
    }

    @Override
    public AdvancedNumber operation(AdvancedNumber leftNum, AdvancedNumber rightNum) {
        return new AdvancedNumber(
            operation(leftNum.getIntegerVal(), rightNum.getIntegerVal()),
            operation(leftNum.getDoubleVal(), rightNum.getDoubleVal()));
    }
    
}
