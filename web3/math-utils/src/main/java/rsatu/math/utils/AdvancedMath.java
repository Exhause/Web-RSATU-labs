package rsatu.math.utils;

import rsatu.calculator.core.BasicCalculator;

public class AdvancedMath {

    public static double factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double compoundInterest(double principal, double rate, int years) {
        return principal * BasicCalculator.power(1 + rate/100, years);
    }

    public static double quadraticEquation(double a, double b, double c) {
        double discriminant = BasicCalculator.power(b, 2) - 4 * a * c;
        if (discriminant < 0) {
            throw new IllegalArgumentException("No real roots");
        }
        return (-b + BasicCalculator.squareRoot(discriminant)) / (2 * a);
    }
}