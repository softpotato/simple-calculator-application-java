package com.softpotato;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.softpotato.com.softpotato.operators.AdditionOperator;
import com.softpotato.com.softpotato.operators.AdvancedNumber;
import com.softpotato.com.softpotato.operators.BinaryOperator;
import com.softpotato.com.softpotato.operators.CosineOperator;
import com.softpotato.com.softpotato.operators.DivisionOperator;
import com.softpotato.com.softpotato.operators.Element;
import com.softpotato.com.softpotato.operators.ExponentOperator;
import com.softpotato.com.softpotato.operators.MultiplicationOperator;
import com.softpotato.com.softpotato.operators.NegationOperator;
import com.softpotato.com.softpotato.operators.Operator;
import com.softpotato.com.softpotato.operators.Parenthesis;
import com.softpotato.com.softpotato.operators.SineOperator;
import com.softpotato.com.softpotato.operators.SubtractionOperator;
import com.softpotato.com.softpotato.operators.TangentOperator;
import com.softpotato.com.softpotato.operators.UnaryOperator;

public class Calculator {
    // Tests and prints output
    public static AdvancedNumber simpleCompute(String input) {
        String fInput = parenthesisSpacer(input);

        System.out.println("Computing: " + fInput);
        try {
            Queue<Element> postFixEquation = infixToPrefix(fInput);
            AdvancedNumber output = computePostFixEquation(postFixEquation);
            System.out.println("Integer: " + output.getIntegerVal());
            System.out.println("Double: " + output.getDoubleVal());
            return output;
        } catch (Exception e) {
            System.out.println("Invalid formula format!");
            return null;
        }
    }

    // Makes it so parenthesis can be improperly placed, cause I keep breaking it
    // cause bad
    private static String parenthesisSpacer(String input) {

        return input
                .replaceAll("[(](?!\s)", "( ")
                .replaceAll("[)](?!\s)", ") ")
                .replaceAll("(?!\s)[)]", " )");
    }

    // Shunting Yard Algorithm
    private static Queue<Element> infixToPrefix(String input) throws Exception {
        Queue<Element> outputQueue = new LinkedList<Element>();
        Stack<Operator> operatorStack = new Stack<Operator>();

        boolean tempUnary = false; // used to keep track if a unary is waiting to be inserted

        String[] tokens = input.split("\\s+");
        for (String token : tokens) {
            if (isNumber(token)) {
                outputQueue.add(new AdvancedNumber(token));

                if (tempUnary) {
                    outputQueue.add(operatorStack.pop());
                    tempUnary = false;
                }

            } else if (isBinaryOperator(token)) {
                tempUnary = false;
                Operator nextOperator;
                switch (token) {
                    case "+":
                        nextOperator = new AdditionOperator();
                        break;
                    case "-":
                        nextOperator = new SubtractionOperator();
                        break;
                    case "*":
                        nextOperator = new MultiplicationOperator();
                        break;
                    case "/":
                        nextOperator = new DivisionOperator();
                        break;
                    case "^":
                        nextOperator = new ExponentOperator();
                        break;
                    default:
                        nextOperator = null;
                        throw new Exception("Invalid Input");
                }

                while (!operatorStack.empty() && nextOperator.comparePrecedence(operatorStack.peek())) {
                    outputQueue.add(operatorStack.pop());
                }

                operatorStack.push(nextOperator);

            } else if (isUnaryOperator(token)) {
                Operator nextOperator;

                switch (token) {
                    case "sin":
                        nextOperator = new SineOperator();
                        break;
                    case "cos":
                        nextOperator = new CosineOperator();
                        break;
                    case "tan":
                        nextOperator = new TangentOperator();
                        break;
                    default:
                        nextOperator = null;
                        throw new Exception("Invalid Input");
                }

                // For unary, we need to store the operation always since it is applied
                // directly to the next number. Also, since unary has the highest precedence,
                // I assume that it will be inserted immediately after the next number.
                operatorStack.push(nextOperator);
                tempUnary = true;

            } else if (token.equals("(")) {
                operatorStack.add(new Parenthesis());

            } else if (token.equals(")")) {
                while ((!operatorStack.empty()) && (!operatorStack.peek().isParenthesis())) {
                    outputQueue.add(operatorStack.pop());
                }

                operatorStack.pop();

            } else if (token.equals("-(")) {
                operatorStack.push(new NegationOperator());
                operatorStack.push(new Parenthesis());
            } else {
                System.err.println("Unregistered Input");
                throw new Exception("Invalid Input");
            }
        }

        while (!operatorStack.empty()) {
            assert !operatorStack.peek().isParenthesis();
            outputQueue.add(operatorStack.pop());
        }

        return outputQueue;

    }

    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isBinaryOperator(String s) {
        switch (s) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
                return true;
        }
        return false;
    }

    private static boolean isUnaryOperator(String s) {
        switch (s) {
            case "sin":
            case "cos":
            case "tan":
                return true;
        }

        return false;
    }

    private static AdvancedNumber computePostFixEquation(Queue<Element> postFixQueue) {
        Stack<Element> currentNumberStack = new Stack<Element>();

        while (!postFixQueue.isEmpty()) {
            Element entry = postFixQueue.poll();

            if (entry.isOperator()) {
                Operator entryOperator = (Operator) entry;

                if (entryOperator.isUnary()) {
                    UnaryOperator unaryEntryOperator = (UnaryOperator) entry;
                    Element newNum = unaryEntryOperator.operation((AdvancedNumber) currentNumberStack.pop());
                    currentNumberStack.push(newNum);

                } else {
                    BinaryOperator binaryEntryOperator = (BinaryOperator) entry;
                    AdvancedNumber right = (AdvancedNumber) currentNumberStack.pop();
                    AdvancedNumber left = (AdvancedNumber) currentNumberStack.pop();

                    currentNumberStack.add(binaryEntryOperator.operation(left, right));
                }

            } else {
                currentNumberStack.push(entry);
            }
        }

        return (AdvancedNumber) currentNumberStack.pop();
    }
}
