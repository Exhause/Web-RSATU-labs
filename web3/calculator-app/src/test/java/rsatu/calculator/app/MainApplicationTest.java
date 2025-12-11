package rsatu.calculator.app;

import org.junit.Test;
import static org.junit.Assert.*;
import rsatu.calculator.core.BasicCalculator;
import rsatu.math.utils.AdvancedMath;
import rsatu.financial.calculator.FinancialCalculator;

public class MainApplicationTest {

    @Test
    public void testComplexCalculation() {
        String result = MainApplication.performComplexCalculation(5, 3, 4);
        assertTrue(result.contains("Результат 1: 8,00"));
        assertTrue(result.contains("Результат 2: 24,00"));
    }

    @Test
    public void testAllDependenciesIntegration() {
        double basicResult = BasicCalculator.multiply(6, 7);
        assertEquals(42.0, basicResult, 0.001);

        double mathResult = AdvancedMath.factorial(5);
        assertEquals(120.0, mathResult, 0.001);

        double financeResult = FinancialCalculator.calculateLoanPayment(100000, 6, 10);
        assertTrue(financeResult > 0);
    }
}