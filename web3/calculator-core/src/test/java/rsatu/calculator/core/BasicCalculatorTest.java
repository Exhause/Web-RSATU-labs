package rsatu.calculator.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class BasicCalculatorTest {

    @Test
    public void testAdd() {
        assertEquals(5.0, BasicCalculator.add(2.0, 3.0), 0.001);
    }

    @Test
    public void testSubtract() {
        assertEquals(1.0, BasicCalculator.subtract(4.0, 3.0), 0.001);
    }

    @Test
    public void testMultiply() {
        assertEquals(6.0, BasicCalculator.multiply(2.0, 3.0), 0.001);
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, BasicCalculator.divide(6.0, 3.0), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        BasicCalculator.divide(5.0, 0.0);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, BasicCalculator.power(2.0, 3.0), 0.001);
    }

    @Test
    public void testSquareRoot() {
        assertEquals(4.0, BasicCalculator.squareRoot(16.0), 0.001);
    }
}