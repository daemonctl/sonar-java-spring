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
    @DisplayName("Addition number test - positive numbers")
    void testAddPositiveNumbers() {
        assertEquals(8.0, calculator.add(3.0, 5.0));
        assertEquals(10.5, calculator.add(4.5, 6.0));
    }

    @Test
    @DisplayName("Addition testing - negatif number")
    void testAddNegativeNumbers() {
        assertEquals(-8.0, calculator.add(-3.0, -5.0));
        assertEquals(2.0, calculator.add(-3.0, 5.0));
    }

    @Test
    @DisplayName("Addition testing - with zero number")
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
    @DisplayName("Substraction testing - parameterized test")
    void testSubtract(double a, double b, double expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    @Test
    @DisplayName("Multiply testing - pozitif number")
    void testMultiplyPositiveNumbers() {
        assertEquals(15.0, calculator.multiply(3.0, 5.0));
        assertEquals(24.0, calculator.multiply(4.0, 6.0));
    }

    @Test
    @DisplayName("Multiply testing - negatif number")
    void testMultiplyNegativeNumbers() {
        assertEquals(15.0, calculator.multiply(-3.0, -5.0));
        assertEquals(-15.0, calculator.multiply(-3.0, 5.0));
    }

    @Test
    @DisplayName("Multiply testing - divide by zero")
    void testMultiplyWithZero() {
        assertEquals(0.0, calculator.multiply(0.0, 5.0));
        assertEquals(0.0, calculator.multiply(5.0, 0.0));
    }

    @Test
    @DisplayName("Divison testing - normal cases")
    void testDivideNormalCases() {
        assertEquals(2.0, calculator.divide(10.0, 5.0));
        assertEquals(2.5, calculator.divide(5.0, 2.0));
        assertEquals(-2.0, calculator.divide(-10.0, 5.0));
    }

    @Test
    @DisplayName("Divison testing - zero division error")
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.divide(10.0, 0.0));
        assertEquals("Zero divisation error!", exception.getMessage());
    }

    @Test
    @DisplayName("Square testing")
    void testSquare() {
        assertEquals(25.0, calculator.square(5.0));
        assertEquals(16.0, calculator.square(-4.0));
        assertEquals(0.0, calculator.square(0.0));
        assertEquals(6.25, calculator.square(2.5));
    }

    @Test
    @DisplayName("Sqrt positive numbers")
    void testSqrtPositiveNumbers() {
        assertEquals(5.0, calculator.sqrt(25.0));
        assertEquals(4.0, calculator.sqrt(16.0));
        assertEquals(0.0, calculator.sqrt(0.0));
        assertEquals(3.0, calculator.sqrt(9.0), 0.001);
    }

    @Test
    @DisplayName("Sqrt negative number error")
    void testSqrtNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.sqrt(-4.0));
        assertEquals("Negatif number cannot be square rooted!", exception.getMessage());
    }

    @Test
    @DisplayName("Absolute value testing")
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
    @DisplayName("Factorial testing - parameterized test")
    void testFactorial(int input, long expected) {
        assertEquals(expected, calculator.factorial(input));
    }

    @Test
    @DisplayName("Factorial - negatif number error")
    void testFactorialNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.factorial(-1));
        assertEquals("Negatif number cannot have a factorial!", exception.getMessage());
    }

    @Test
    @DisplayName("Power testing")
    void testPower() {
        assertEquals(8.0, calculator.power(2.0, 3.0));
        assertEquals(25.0, calculator.power(5.0, 2.0));
        assertEquals(1.0, calculator.power(10.0, 0.0));
        assertEquals(0.5, calculator.power(2.0, -1.0));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, 0, -2, -4})
    @DisplayName("Even number check - even number")
    void testIsEvenNumbers(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, -1, -3})
    @DisplayName("Odd number check - odd number")
    void testIsOddNumbers(int number) {
        assertFalse(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23})
    @DisplayName("Prime number check - prime number")
    void testPrimeNumbers(int number) {
        assertTrue(calculator.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 9, 10, 12, 15, 16, 20})
    @DisplayName("Non-prime number check - non-prime number")
    void testNonPrimeNumbers(int number) {
        assertFalse(calculator.isPrime(number));
    }

    @Test
    @DisplayName("Negative number check - not prime")
    void testNegativeNumbersNotPrime() {
        assertFalse(calculator.isPrime(-5));
        assertFalse(calculator.isPrime(-2));
    }

    @Test
    @DisplayName("Edge case testing")
    void testEdgeCases() {
        // Büyük sayılarla işlemler
        assertEquals(1000000.0, calculator.add(999999.0, 1.0));
        assertEquals(2.0, calculator.divide(1000000.0, 500000.0));

        // Ondalıklı sayılarla işlemler
        assertEquals(7.5, calculator.add(3.2, 4.3), 0.001);
        assertEquals(6.25, calculator.multiply(2.5, 2.5), 0.001);
    }

    @Test
    @DisplayName("Combined operations testing")
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
