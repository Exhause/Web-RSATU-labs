package rsatu.financial.calculator;

import rsatu.calculator.core.BasicCalculator;
import rsatu.math.utils.AdvancedMath;

public class FinancialCalculator {

    public static double calculateLoanPayment(double principal, double annualRate, int years) {
        double monthlyRate = annualRate / 100 / 12;
        int numberOfPayments = years * 12;

        double ratePower = BasicCalculator.power(1 + monthlyRate, numberOfPayments);
        return principal * (monthlyRate * ratePower) / (ratePower - 1);
    }

    public static double calculateFutureValue(double presentValue, double rate, int periods) {
        return AdvancedMath.compoundInterest(presentValue, rate, periods);
    }

    public static double calculateNetPresentValue(double[] cashFlows, double discountRate) {
        double npv = 0;
        for (int i = 0; i < cashFlows.length; i++) {
            npv += cashFlows[i] / BasicCalculator.power(1 + discountRate/100, i);
        }
        return npv;
    }
}