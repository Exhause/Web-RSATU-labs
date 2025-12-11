package rsatu.calculator.core;

public class BasicCalculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Square root of negative number is not allowed");
        }
        return Math.sqrt(number);
    }

    public static void main(String[] args) {
        System.out.println("=== Базовый калькулятор (calculator-core) ===");
        System.out.println("2 + 3 = " + add(2, 3));
        System.out.println("5 - 2 = " + subtract(5, 2));
        System.out.println("4 * 6 = " + multiply(4, 6));
        System.out.println("8 / 2 = " + divide(8, 2));
        System.out.println("2^3 = " + power(2, 3));
        System.out.println("√16 = " + squareRoot(16));
        System.out.println("=== Демонстрация завершена ===");
    }
}