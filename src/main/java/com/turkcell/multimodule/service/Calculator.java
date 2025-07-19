package com.turkcell.multimodule.service;

import org.springframework.stereotype.Service;

/**
 * Matematiksel işlemler için Calculator sınıfı
 */
@Service
public class Calculator {

    /**
     * İki sayıyı toplar
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * İki sayıyı çıkarır
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * İki sayıyı çarpar
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * İki sayıyı böler
     * @throws IllegalArgumentException sıfıra bölme durumunda
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Sıfıra bölme hatası!");
        }
        return a / b;
    }

    /**
     * Sayının karesini alır
     */
    public double square(double a) {
        return a * a;
    }

    /**
     * Sayının karekökünü alır
     * @throws IllegalArgumentException negatif sayı durumunda
     */
    public double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Negatif sayının karekökü alınamaz!");
        }
        return Math.sqrt(a);
    }

    /**
     * Sayının mutlak değerini alır
     */
    public double abs(double a) {
        return Math.abs(a);
    }

    /**
     * Faktöriyel hesaplar
     * @throws IllegalArgumentException negatif sayı durumunda
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negatif sayının faktöriyeli hesaplanamaz!");
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

    /**
     * Üs alma işlemi
     */
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * Sayının çift olup olmadığını kontrol eder
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Sayının asal olup olmadığını kontrol eder
     */
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
