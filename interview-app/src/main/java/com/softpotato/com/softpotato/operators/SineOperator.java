package com.softpotato.com.softpotato.operators;

public class SineOperator extends UnaryOperator {

    public SineOperator() {}

    @Override
    public double operation(double value) {
        return Math.sin(value);
    }

    @Override
    public int operation(int value) {
        return (int) Math.sin(value);
    }

    @Override
    public AdvancedNumber operation(AdvancedNumber value) {
        return new AdvancedNumber(operation(value.getIntegerVal()), operation(value.getDoubleVal()));
    }
    
}
