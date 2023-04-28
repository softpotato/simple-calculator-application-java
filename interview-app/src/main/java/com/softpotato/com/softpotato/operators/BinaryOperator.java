package com.softpotato.com.softpotato.operators;

public abstract class BinaryOperator extends Operator {
    public BinaryOperator(int precedence) {
        super(precedence, false, false);
    }
    public abstract double operation(double leftNum, double rightNum);
    public abstract int operation(int leftNum, int rightNum);
    public abstract AdvancedNumber operation(AdvancedNumber leftNum, AdvancedNumber rightNum);
}
