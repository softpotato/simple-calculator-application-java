package com.softpotato.com.softpotato.operators;

public abstract class Operator extends Element {

    public Operator( int precedence, boolean isUnary, boolean isParenthesis) {
        super(true);
        this.precedence = precedence;
        this.isUnary = isUnary;
        this.isParenthesis = isParenthesis;
    }

    private boolean isParenthesis;
    private int precedence;
    private boolean isUnary;

    /**
     * Returns true if the given precedence is greater or equal, otherwise
     * returns false.
     * @param other
     * @return
     */
    public boolean comparePrecedence(Operator other) {
        if (other.precedence >= this.precedence) {
            return true;
        }
        return false;
    }

    public boolean isUnary() {
        return this.isUnary;
    }

    public boolean isParenthesis() {
        return this.isParenthesis;
    }
}
