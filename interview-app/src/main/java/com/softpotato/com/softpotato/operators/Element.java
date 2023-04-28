package com.softpotato.com.softpotato.operators;

public abstract class Element {
    protected boolean isOperator;

    public boolean isOperator() {
        return isOperator;
    }

    public Element(boolean isOperator) {
        this.isOperator = isOperator;
    }
}
