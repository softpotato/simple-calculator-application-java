package com.softpotato.com.softpotato.operators;

public class NegationOperator extends UnaryOperator {

    public NegationOperator() {}

    @Override
    public int operation(int value) {
        return -value;
    }

    @Override
    public double operation(double value) {
        return -value;
    }

    @Override
    public AdvancedNumber operation(AdvancedNumber value) {
        return new AdvancedNumber(operation(value.getIntegerVal()), operation(value.getDoubleVal()));
    }
    
}
