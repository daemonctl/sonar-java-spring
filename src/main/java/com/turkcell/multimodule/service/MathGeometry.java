package com.turkcell.multimodule.service;

import org.springframework.stereotype.Service;

@Service
public class MathGeometry {

    public double circleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Yarıçap negatif olamaz!");
        }
        return Math.PI * radius * radius;
    }

    public double circlePerimeter(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Yarıçap negatif olamaz!");
        }
        return 2 * Math.PI * radius;
    }

    public double rectangleArea(double length, double width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Uzunluk ve genişlik negatif olamaz!");
        }
        return length * width;
    }

    public double rectanglePerimeter(double length, double width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Uzunluk ve genişlik negatif olamaz!");
        }
        return 2 * (length + width);
    }

    public double triangleArea(double base, double height) {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Taban ve yükseklik negatif olamaz!");
        }
        return 0.5 * base * height;
    }

    public double sphereVolume(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Yarıçap negatif olamaz!");
        }
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public double sphereSurfaceArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Yarıçap negatif olamaz!");
        }
        return 4 * Math.PI * radius * radius;
    }
    public double cylinderVolume(double radius, double height) {
        if (radius < 0 || height < 0) {
            throw new IllegalArgumentException("Yarıçap ve yükseklik negatif olamaz!");
        }
        return Math.PI * radius * radius * height;
    }

    public double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public double hypotenuse(double a, double b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Kenar uzunlukları negatif olamaz!");
        }
        return Math.sqrt(a * a + b * b);
    }
}
