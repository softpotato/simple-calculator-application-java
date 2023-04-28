package com.softpotato.com.softpotato.operators;

public abstract class UnaryOperator extends Operator {
    public UnaryOperator() {
        super(4, true, false);
    }
    public abstract double operation(double value);
    public abstract int operation(int value);
    public abstract AdvancedNumber operation(AdvancedNumber value);
}
