package com.turkcell.multimodule.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("MathGeometry Test Suite")
class MathGeometryTest {

    private MathGeometry mathGeometry;
    private static final double DELTA = 0.001;

    @BeforeEach
    void setUp() {
        mathGeometry = new MathGeometry();
    }

    @ParameterizedTest
    @CsvSource({
        "1, 3.14159",
        "2, 12.56636",
        "5, 78.53975",
        "10, 314.15926"
    })
    @DisplayName("Daire alanı hesaplama")
    void testCircleArea(double radius, double expectedArea) {
        assertEquals(expectedArea, mathGeometry.circleArea(radius), DELTA);
    }

    @Test
    @DisplayName("Daire alanı - sıfır yarıçap")
    void testCircleAreaZeroRadius() {
        assertEquals(0.0, mathGeometry.circleArea(0), DELTA);
    }

    @Test
    @DisplayName("Daire alanı - negatif yarıçap hatası")
    void testCircleAreaNegativeRadius() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.circleArea(-5));
        assertEquals("Yarıçap negatif olamaz!", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 6.28318",
        "2, 12.56636",
        "5, 31.41592",
        "10, 62.83184"
    })
    @DisplayName("Daire çevresi hesaplama")
    void testCirclePerimeter(double radius, double expectedPerimeter) {
        assertEquals(expectedPerimeter, mathGeometry.circlePerimeter(radius), DELTA);
    }

    @Test
    @DisplayName("Daire çevresi - negatif yarıçap hatası")
    void testCirclePerimeterNegativeRadius() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.circlePerimeter(-3));
        assertEquals("Yarıçap negatif olamaz!", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "5, 3, 15",
        "10, 4, 40",
        "2.5, 4, 10",
        "0, 5, 0",
        "7, 0, 0"
    })
    @DisplayName("Dikdörtgen alanı hesaplama")
    void testRectangleArea(double length, double width, double expectedArea) {
        assertEquals(expectedArea, mathGeometry.rectangleArea(length, width), DELTA);
    }

    @Test
    @DisplayName("Dikdörtgen alanı - negatif değer hatası")
    void testRectangleAreaNegativeValues() {
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.rectangleArea(-5, 3));
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.rectangleArea(5, -3));
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.rectangleArea(-5, -3));
    }

    @ParameterizedTest
    @CsvSource({
        "5, 3, 16",
        "10, 4, 28",
        "2.5, 4, 13",
        "0, 5, 10",
        "7, 0, 14"
    })
    @DisplayName("Dikdörtgen çevresi hesaplama")
    void testRectanglePerimeter(double length, double width, double expectedPerimeter) {
        assertEquals(expectedPerimeter, mathGeometry.rectanglePerimeter(length, width), DELTA);
    }

    @Test
    @DisplayName("Dikdörtgen çevresi - negatif değer hatası")
    void testRectanglePerimeterNegativeValues() {
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.rectanglePerimeter(-5, 3));
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.rectanglePerimeter(5, -3));
    }

    @ParameterizedTest
    @CsvSource({
        "6, 4, 12",
        "10, 5, 25",
        "8, 3, 12",
        "0, 10, 0",
        "15, 0, 0"
    })
    @DisplayName("Üçgen alanı hesaplama")
    void testTriangleArea(double base, double height, double expectedArea) {
        assertEquals(expectedArea, mathGeometry.triangleArea(base, height), DELTA);
    }

    @Test
    @DisplayName("Üçgen alanı - negatif değer hatası")
    void testTriangleAreaNegativeValues() {
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.triangleArea(-6, 4));
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.triangleArea(6, -4));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 4.18879",
        "2, 33.51032",
        "3, 113.09733",
        "5, 523.59877"
    })
    @DisplayName("Küre hacmi hesaplama")
    void testSphereVolume(double radius, double expectedVolume) {
        assertEquals(expectedVolume, mathGeometry.sphereVolume(radius), DELTA);
    }

    @Test
    @DisplayName("Küre hacmi - sıfır yarıçap")
    void testSphereVolumeZeroRadius() {
        assertEquals(0.0, mathGeometry.sphereVolume(0), DELTA);
    }

    @Test
    @DisplayName("Küre hacmi - negatif yarıçap hatası")
    void testSphereVolumeNegativeRadius() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.sphereVolume(-2));
        assertEquals("Yarıçap negatif olamaz!", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 12.56636",
        "2, 50.26544",
        "3, 113.09733",
        "5, 314.15926"
    })
    @DisplayName("Küre yüzey alanı hesaplama")
    void testSphereSurfaceArea(double radius, double expectedArea) {
        assertEquals(expectedArea, mathGeometry.sphereSurfaceArea(radius), DELTA);
    }

    @Test
    @DisplayName("Küre yüzey alanı - negatif yarıçap hatası")
    void testSphereSurfaceAreaNegativeRadius() {
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.sphereSurfaceArea(-3));
    }

    @ParameterizedTest
    @CsvSource({
        "2, 5, 62.83184",
        "3, 4, 113.09733",
        "1, 10, 31.41592",
        "5, 2, 157.07963"
    })
    @DisplayName("Silindir hacmi hesaplama")
    void testCylinderVolume(double radius, double height, double expectedVolume) {
        assertEquals(expectedVolume, mathGeometry.cylinderVolume(radius, height), DELTA);
    }

    @Test
    @DisplayName("Silindir hacmi - sıfır değerler")
    void testCylinderVolumeZeroValues() {
        assertEquals(0.0, mathGeometry.cylinderVolume(0, 5), DELTA);
        assertEquals(0.0, mathGeometry.cylinderVolume(3, 0), DELTA);
        assertEquals(0.0, mathGeometry.cylinderVolume(0, 0), DELTA);
    }

    @Test
    @DisplayName("Silindir hacmi - negatif değer hatası")
    void testCylinderVolumeNegativeValues() {
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.cylinderVolume(-2, 5));
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.cylinderVolume(2, -5));
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, 3, 4, 5",
        "1, 1, 4, 5, 5",
        "0, 0, 0, 0, 0",
        "-2, -3, 1, 1, 5"
    })
    @DisplayName("İki nokta arası mesafe hesaplama")
    void testDistance(double x1, double y1, double x2, double y2, double expectedDistance) {
        assertEquals(expectedDistance, mathGeometry.distance(x1, y1, x2, y2), DELTA);
    }

    @Test
    @DisplayName("Aynı nokta arası mesafe")
    void testDistanceSamePoint() {
        assertEquals(0.0, mathGeometry.distance(5, 5, 5, 5), DELTA);
    }

    @ParameterizedTest
    @CsvSource({
        "3, 4, 5",
        "5, 12, 13",
        "8, 15, 17",
        "1, 1, 1.414"
    })
    @DisplayName("Hipotenüs hesaplama")
    void testHypotenuse(double a, double b, double expectedHypotenuse) {
        assertEquals(expectedHypotenuse, mathGeometry.hypotenuse(a, b), DELTA);
    }

    @Test
    @DisplayName("Hipotenüs - sıfır kenar")
    void testHypotenuseZeroSide() {
        assertEquals(5.0, mathGeometry.hypotenuse(0, 5), DELTA);
        assertEquals(3.0, mathGeometry.hypotenuse(3, 0), DELTA);
        assertEquals(0.0, mathGeometry.hypotenuse(0, 0), DELTA);
    }

    @Test
    @DisplayName("Hipotenüs - negatif kenar hatası")
    void testHypotenuseNegativeSides() {
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.hypotenuse(-3, 4));
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.hypotenuse(3, -4));
        assertThrows(IllegalArgumentException.class,
            () -> mathGeometry.hypotenuse(-3, -4));
    }

    @Test
    @DisplayName("Kombinasyon testleri")
    void testCombinedOperations() {
        // Kare alanı = dikdörtgen alanı (eşit kenarlar)
        double squareArea = mathGeometry.rectangleArea(5, 5);
        assertEquals(25.0, squareArea, DELTA);

        // Küre yüzey alanı vs daire alanı karşılaştırması
        double sphereSurface = mathGeometry.sphereSurfaceArea(2);
        double circleArea = mathGeometry.circleArea(2);
        assertTrue(sphereSurface > circleArea);

        // Pisagor teoremi ile mesafe kontrolü
        double hypotenuse = mathGeometry.hypotenuse(3, 4);
        double distance = mathGeometry.distance(0, 0, 3, 4);
        assertEquals(hypotenuse, distance, DELTA);
    }

    @Test
    @DisplayName("Büyük sayılarla testler")
    void testLargeNumbers() {
        double largeCircleArea = mathGeometry.circleArea(1000);
        assertTrue(largeCircleArea > 3000000);

        double largeSphereVolume = mathGeometry.sphereVolume(100);
        assertTrue(largeSphereVolume > 4000000);
    }
}
