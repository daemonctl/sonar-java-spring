package com.turkcell.multimodule.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Calculator Test Suite")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Toplama işlemi - pozitif sayılar")
    void testAddPositiveNumbers() {
        assertEquals(8.0, calculator.add(3.0, 5.0));
        assertEquals(10.5, calculator.add(4.5, 6.0));
    }

    @Test
    @DisplayName("Toplama işlemi - negatif sayılar")
    void testAddNegativeNumbers() {
        assertEquals(-8.0, calculator.add(-3.0, -5.0));
        assertEquals(2.0, calculator.add(-3.0, 5.0));
    }

    @Test
    @DisplayName("Toplama işlemi - sıfır ile")
    void testAddWithZero() {
        assertEquals(5.0, calculator.add(0.0, 5.0));
        assertEquals(5.0, calculator.add(5.0, 0.0));
        assertEquals(0.0, calculator.add(0.0, 0.0));
    }

    @ParameterizedTest
    @CsvSource({
        "10, 5, 5",
        "20, 8, 12",
        "0, 5, -5",
        "-10, -5, -5"
    })
    @DisplayName("Çıkarma işlemi - parameterized test")
    void testSubtract(double a, double b, double expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    @Test
    @DisplayName("Çarpma işlemi - pozitif sayılar")
    void testMultiplyPositiveNumbers() {
        assertEquals(15.0, calculator.multiply(3.0, 5.0));
        assertEquals(24.0, calculator.multiply(4.0, 6.0));
    }

    @Test
    @DisplayName("Çarpma işlemi - negatif sayılar")
    void testMultiplyNegativeNumbers() {
        assertEquals(15.0, calculator.multiply(-3.0, -5.0));
        assertEquals(-15.0, calculator.multiply(-3.0, 5.0));
    }

    @Test
    @DisplayName("Çarpma işlemi - sıfır ile")
    void testMultiplyWithZero() {
        assertEquals(0.0, calculator.multiply(0.0, 5.0));
        assertEquals(0.0, calculator.multiply(5.0, 0.0));
    }

    @Test
    @DisplayName("Bölme işlemi - normal durumlar")
    void testDivideNormalCases() {
        assertEquals(2.0, calculator.divide(10.0, 5.0));
        assertEquals(2.5, calculator.divide(5.0, 2.0));
        assertEquals(-2.0, calculator.divide(-10.0, 5.0));
    }

    @Test
    @DisplayName("Bölme işlemi - sıfıra bölme hatası")
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.divide(10.0, 0.0));
        assertEquals("Sıfıra bölme hatası!", exception.getMessage());
    }

    @Test
    @DisplayName("Kare alma işlemi")
    void testSquare() {
        assertEquals(25.0, calculator.square(5.0));
        assertEquals(16.0, calculator.square(-4.0));
        assertEquals(0.0, calculator.square(0.0));
        assertEquals(6.25, calculator.square(2.5));
    }

    @Test
    @DisplayName("Karekök alma işlemi - pozitif sayılar")
    void testSqrtPositiveNumbers() {
        assertEquals(5.0, calculator.sqrt(25.0));
        assertEquals(4.0, calculator.sqrt(16.0));
        assertEquals(0.0, calculator.sqrt(0.0));
        assertEquals(3.0, calculator.sqrt(9.0), 0.001);
    }

    @Test
    @DisplayName("Karekök alma işlemi - negatif sayı hatası")
    void testSqrtNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.sqrt(-4.0));
        assertEquals("Negatif sayının karekökü alınamaz!", exception.getMessage());
    }

    @Test
    @DisplayName("Mutlak değer işlemi")
    void testAbsoluteValue() {
        assertEquals(5.0, calculator.abs(5.0));
        assertEquals(5.0, calculator.abs(-5.0));
        assertEquals(0.0, calculator.abs(0.0));
        assertEquals(3.14, calculator.abs(-3.14));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "5, 120",
        "4, 24",
        "3, 6"
    })
    @DisplayName("Faktöriyel hesaplama - parameterized test")
    void testFactorial(int input, long expected) {
        assertEquals(expected, calculator.factorial(input));
    }

    @Test
    @DisplayName("Faktöriyel - negatif sayı hatası")
    void testFactorialNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.factorial(-1));
        assertEquals("Negatif sayının faktöriyeli hesaplanamaz!", exception.getMessage());
    }

    @Test
    @DisplayName("Üs alma işlemi")
    void testPower() {
        assertEquals(8.0, calculator.power(2.0, 3.0));
        assertEquals(25.0, calculator.power(5.0, 2.0));
        assertEquals(1.0, calculator.power(10.0, 0.0));
        assertEquals(0.5, calculator.power(2.0, -1.0));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, 0, -2, -4})
    @DisplayName("Çift sayı kontrolü - çift sayılar")
    void testIsEvenNumbers(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, -1, -3})
    @DisplayName("Tek sayı kontrolü")
    void testIsOddNumbers(int number) {
        assertFalse(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23})
    @DisplayName("Asal sayı kontrolü - asal sayılar")
    void testPrimeNumbers(int number) {
        assertTrue(calculator.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 9, 10, 12, 15, 16, 20})
    @DisplayName("Asal olmayan sayı kontrolü")
    void testNonPrimeNumbers(int number) {
        assertFalse(calculator.isPrime(number));
    }

    @Test
    @DisplayName("Negatif sayılar asal değildir")
    void testNegativeNumbersNotPrime() {
        assertFalse(calculator.isPrime(-5));
        assertFalse(calculator.isPrime(-2));
    }

    @Test
    @DisplayName("Edge case testleri")
    void testEdgeCases() {
        // Büyük sayılarla işlemler
        assertEquals(1000000.0, calculator.add(999999.0, 1.0));
        assertEquals(2.0, calculator.divide(1000000.0, 500000.0));

        // Ondalıklı sayılarla işlemler
        assertEquals(7.5, calculator.add(3.2, 4.3), 0.001);
        assertEquals(6.25, calculator.multiply(2.5, 2.5), 0.001);
    }

    @Test
    @DisplayName("Kombinasyon testleri")
    void testCombinedOperations() {
        // (5 + 3) * 2 = 16
        double result1 = calculator.multiply(calculator.add(5.0, 3.0), 2.0);
        assertEquals(16.0, result1);

        // sqrt(25) + 3^2 = 5 + 9 = 14
        double result2 = calculator.add(calculator.sqrt(25.0), calculator.power(3.0, 2.0));
        assertEquals(14.0, result2);

        // |(-10) / 2| = 5
        double result3 = calculator.abs(calculator.divide(-10.0, 2.0));
        assertEquals(5.0, result3);
    }
}
