package rsatu.financial.calculator;

import org.junit.Test;
import static org.junit.Assert.*;
import rsatu.calculator.core.BasicCalculator;
import rsatu.math.utils.AdvancedMath;

public class FinancialCalculatorTest {

    @Test
    public void testLoanPayment() {
        double payment = FinancialCalculator.calculateLoanPayment(100000, 5, 10);
        assertEquals(1060.66, payment, 0.1);
    }

    @Test
    public void testFutureValue() {
        double futureValue = FinancialCalculator.calculateFutureValue(1000, 5, 2);
        assertEquals(1102.5, futureValue, 0.1);
    }

    @Test
    public void testUsingDependencies() {
        double addResult = BasicCalculator.add(5, 3);
        assertEquals(8.0, addResult, 0.001);

        double factorialResult = AdvancedMath.factorial(4);
        assertEquals(24.0, factorialResult, 0.001);
    }
}