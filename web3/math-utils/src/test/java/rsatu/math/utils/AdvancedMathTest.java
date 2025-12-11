package rsatu.math.utils;

import org.junit.Test;
import static org.junit.Assert.*;
import rsatu.calculator.core.BasicCalculator;

public class AdvancedMathTest {

    @Test
    public void testFactorial() {
        assertEquals(120.0, AdvancedMath.factorial(5), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegative() {
        AdvancedMath.factorial(-5);
    }

    @Test
    public void testCompoundInterest() {
        double result = AdvancedMath.compoundInterest(1000, 5, 2);
        assertEquals(1102.5, result, 0.1);
    }

    @Test
    public void testUsingBasicCalculatorFromDependency() {
        double powerResult = BasicCalculator.power(2, 3);
        assertEquals(8.0, powerResult, 0.001);
    }
}