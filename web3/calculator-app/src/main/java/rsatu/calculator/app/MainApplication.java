package rsatu.calculator.app;

import rsatu.calculator.core.BasicCalculator;
import rsatu.math.utils.AdvancedMath;
import rsatu.financial.calculator.FinancialCalculator;

public class MainApplication {

    public static void main(String[] args) {
        System.out.println("=== Калькулятор приложение ===");

        // Использование calculator-core
        double sum = BasicCalculator.add(10, 5);
        double product = BasicCalculator.multiply(4, 7);
        System.out.println("10 + 5 = " + sum);
        System.out.println("4 * 7 = " + product);

        // Использование math-utils
        double factorial = AdvancedMath.factorial(6);
        double compound = AdvancedMath.compoundInterest(1000, 10, 5);
        System.out.println("6! = " + factorial);
        System.out.println("Сложный процент (1000 под 10% на 5 лет) = " + compound);

        // Использование financial-calculator
        double loanPayment = FinancialCalculator.calculateLoanPayment(200000, 7, 15);
        double[] cashFlows = {-50000, 15000, 20000, 25000, 30000};
        double npv = FinancialCalculator.calculateNetPresentValue(cashFlows, 8);
        System.out.println("Ежемесячный платеж по кредиту: " + loanPayment);
        System.out.println("Чистая приведенная стоимость: " + npv);

        System.out.println("=== Расчеты завершены ===");
    }

    public static String performComplexCalculation(double a, double b, double c) {
        double result1 = BasicCalculator.add(a, b);
        double result2 = AdvancedMath.factorial((int)c);
        double result3 = FinancialCalculator.calculateFutureValue(result1, 5, 3);

        return String.format("Результат 1: %.2f, Результат 2: %.2f, Результат 3: %.2f",
                result1, result2, result3);
    }
}