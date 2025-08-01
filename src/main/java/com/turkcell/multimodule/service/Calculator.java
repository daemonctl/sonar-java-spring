package com.turkcell.multimodule.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * @throws IllegalArgumentException zero divisation error
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Zero divisation error!");
        }
        return a / b;
    }

    public double square(double a) {
        return a * a;
    }

    /**
     * @throws IllegalArgumentException negatif sayı durumunda
     */
    public double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Negatif number cannot be square rooted!");
        }
        return Math.sqrt(a);
    }

    public double abs(double a) {
        return Math.abs(a);
    }

    /**
     * @throws IllegalArgumentException
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negatif number cannot have a factorial!");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
