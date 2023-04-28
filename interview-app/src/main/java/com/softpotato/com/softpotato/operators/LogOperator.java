package com.softpotato.com.softpotato.operators;

public class LogOperator extends UnaryOperator {

    @Override
    public int operation(int value) {
        return (int) Math.log(value); // probably not the greatest way to do so.
    }

    @Override
    public double operation(double value) {
        return Math.log(value);
    }

    @Override
    public AdvancedNumber operation(AdvancedNumber value) {
        return new AdvancedNumber(operation(value.getIntegerVal()), operation(value.getDoubleVal()));
    }
    
}
