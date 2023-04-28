package com.softpotato.com.softpotato.operators;

public class TangentOperator extends UnaryOperator {

    public TangentOperator() {}

    @Override
    public double operation(double value) {
        return Math.tan(value);
    }

    @Override
    public int operation(int value) {
        return (int) Math.tan(value);
    }

    @Override
    public AdvancedNumber operation(AdvancedNumber value) {
        return new AdvancedNumber(operation(value.getIntegerVal()), operation(value.getDoubleVal()));
    }
    
}
