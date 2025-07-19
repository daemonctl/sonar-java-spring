package com.turkcell.multimodule.controller;

import com.turkcell.multimodule.service.Calculator;
import com.turkcell.multimodule.service.MathGeometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/math")
public class MathController {

    @Autowired
    private Calculator calculator;

    @Autowired
    private MathGeometry mathGeometry;

    @GetMapping("/add")
    public ResponseEntity<Double> add(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(calculator.add(a, b));
    }

    @GetMapping("/subtract")
    public ResponseEntity<Double> subtract(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(calculator.subtract(a, b));
    }

    @GetMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(calculator.multiply(a, b));
    }

    @GetMapping("/divide")
    public ResponseEntity<Double> divide(@RequestParam double a, @RequestParam double b) {
        try {
            return ResponseEntity.ok(calculator.divide(a, b));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/power")
    public ResponseEntity<Double> power(@RequestParam double base, @RequestParam double exponent) {
        return ResponseEntity.ok(calculator.power(base, exponent));
    }

    @GetMapping("/factorial")
    public ResponseEntity<Long> factorial(@RequestParam int n) {
        try {
            return ResponseEntity.ok(calculator.factorial(n));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/circle-area")
    public ResponseEntity<Double> circleArea(@RequestParam double radius) {
        try {
            return ResponseEntity.ok(mathGeometry.circleArea(radius));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/rectangle-area")
    public ResponseEntity<Double> rectangleArea(@RequestParam double length, @RequestParam double width) {
        try {
            return ResponseEntity.ok(mathGeometry.rectangleArea(length, width));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/distance")
    public ResponseEntity<Double> distance(@RequestParam double x1, @RequestParam double y1,
                                         @RequestParam double x2, @RequestParam double y2) {
        return ResponseEntity.ok(mathGeometry.distance(x1, y1, x2, y2));
    }

    @GetMapping("/is-prime")
    public ResponseEntity<Boolean> isPrime(@RequestParam int number) {
        return ResponseEntity.ok(calculator.isPrime(number));
    }
}
