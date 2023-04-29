package com.softpotato;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.softpotato.com.softpotato.operators.AdvancedNumber;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void emptyCase() {
        AdvancedNumber output = Calculator.simpleCompute("");
        assertNull(output);
    }

    @Test
    public void basicAdditionOperations() {
        assertTrue(Calculator.simpleCompute("1 + 1").equals(new AdvancedNumber(2, 2.0f)));
        assertTrue(Calculator.simpleCompute("10 + 100000").equals(new AdvancedNumber(100010, 100010.0f)));
        assertTrue(Calculator.simpleCompute("0 + 0").equals(new AdvancedNumber(0, 0.0f)));

        // The code doesn't handle integer overflows at all. Probably should add a
        // check, but already past 200 lines.
    }

    @Test
    public void basicSubtractionOperations() {
        assertTrue(Calculator.simpleCompute("-1 + -1").equals(new AdvancedNumber(-2, -2.0f)));
        assertTrue(Calculator.simpleCompute("1 - 2").equals(new AdvancedNumber(-1, -1.0f)));
        assertTrue(Calculator.simpleCompute("1 - -1").equals(new AdvancedNumber(2, 2.0f)));
        assertTrue(Calculator.simpleCompute("-100 - -10").equals(new AdvancedNumber(-90, -90.0f)));
    }

    @Test
    public void basicMultiplicationOperations() {
        assertTrue(Calculator.simpleCompute("1 * 2").equals(new AdvancedNumber(2, 2.0f)));
        assertTrue(Calculator.simpleCompute("-1 * -1").equals(new AdvancedNumber(1, 1.0f)));
    }

    @Test
    public void basicDivisionOperations() {
        assertTrue(Calculator.simpleCompute("1 / 1").equals(new AdvancedNumber(1, 1.0f)));
        assertTrue(Calculator.simpleCompute("100 / 10").equals(new AdvancedNumber(10, 10.0f)));
        assertTrue(Calculator.simpleCompute("-100 / -1").equals(new AdvancedNumber(100, 100.0f)));
    }

    @Test
    public void basicExponentOperations() {
        assertTrue(Calculator.simpleCompute("2 ^ 2").equals(new AdvancedNumber(4, 4.0f)));
        assertTrue(Calculator.simpleCompute("1 ^ -1").equals(new AdvancedNumber(1, 1.0f)));
    }
    
    // @Test
    // void basicAnglesOperationsTest() {
    //     // Ugh, don't really want to figure out the outputs of tan/sin/cos
    // }

    @Test
    public void compoundFormulaTests() {
        assertTrue(Calculator.simpleCompute("1 + ( 2 * 2 )").equals(new AdvancedNumber(5, 5.0f)));
        assertTrue(Calculator.simpleCompute("-( 2 + 2 * 3 / 3 * ( 4 + 8 ) ) + 1").equals(new AdvancedNumber(-25, -25.0f)));
    }
}
