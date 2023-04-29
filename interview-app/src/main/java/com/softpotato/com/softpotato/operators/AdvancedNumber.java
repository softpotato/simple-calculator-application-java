package com.softpotato.com.softpotato.operators;

public class AdvancedNumber extends Element {
    private int integerVal;
    private double doubleVal;

    public AdvancedNumber(String input) {
        super(false);
        integerVal = Integer.parseInt(input);
        doubleVal = Double.parseDouble(input);
    }

    public AdvancedNumber(int integerVal, double doubleVal) {
        super(false);
        this.integerVal = integerVal;
        this.doubleVal = doubleVal;
    }

    public int getIntegerVal() {
        return integerVal;
    }

    public double getDoubleVal() {
        return doubleVal;
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    public boolean equals(Object obj) { // For unit testing purposes
        if (!(obj instanceof AdvancedNumber)) {
            return false;
        } 

        AdvancedNumber other = (AdvancedNumber) obj;

        if (this.integerVal == other.getIntegerVal() && this.doubleVal == other.getDoubleVal()) {
            return true;
        }
        return false;
    }
}
