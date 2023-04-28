package com.softpotato.com.softpotato.operators;

public class CosineOperator extends UnaryOperator {

    public CosineOperator() {}

    @Override
    public double operation(double value) {
        return Math.cos(value);
    }

    @Override
    public int operation(int value) {
        return (int) Math.cos(value);
    }

    @Override
    public AdvancedNumber operation(AdvancedNumber value) {
        return new AdvancedNumber(operation(value.getIntegerVal()), operation(value.getDoubleVal()));
    }
    
}
