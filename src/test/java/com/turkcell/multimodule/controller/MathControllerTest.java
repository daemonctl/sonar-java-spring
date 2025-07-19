package com.turkcell.multimodule.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("MathController Integration Test Suite")
class MathControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    @DisplayName("Toplama API testi")
    void testAddAPI() {
        String url = createURLWithPort("/api/math/add?a=5.0&b=3.0");
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(8.0, response.getBody());
    }

    @Test
    @DisplayName("Çıkarma API testi")
    void testSubtractAPI() {
        String url = createURLWithPort("/api/math/subtract?a=10.0&b=4.0");
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(6.0, response.getBody());
    }

    @Test
    @DisplayName("Çarpma API testi")
    void testMultiplyAPI() {
        String url = createURLWithPort("/api/math/multiply?a=4.0&b=5.0");
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(20.0, response.getBody());
    }

    @Test
    @DisplayName("Bölme API testi - başarılı")
    void testDivideAPISuccess() {
        String url = createURLWithPort("/api/math/divide?a=15.0&b=3.0");
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(5.0, response.getBody());
    }

    @Test
    @DisplayName("Bölme API testi - sıfıra bölme hatası")
    void testDivideAPIError() {
        String url = createURLWithPort("/api/math/divide?a=10.0&b=0.0");
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);

        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Üs alma API testi")
    void testPowerAPI() {
        String url = createURLWithPort("/api/math/power?base=2.0&exponent=3.0");
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(8.0, response.getBody());
    }

    @Test
    @DisplayName("Faktöriyel API testi - başarılı")
    void testFactorialAPISuccess() {
        String url = createURLWithPort("/api/math/factorial?n=5");
        ResponseEntity<Long> response = restTemplate.getForEntity(url, Long.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(120L, response.getBody());
    }

    @Test
    @DisplayName("Faktöriyel API testi - negatif sayı hatası")
    void testFactorialAPIError() {
        String url = createURLWithPort("/api/math/factorial?n=-1");
        ResponseEntity<Long> response = restTemplate.getForEntity(url, Long.class);

        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Daire alanı API testi - başarılı")
    void testCircleAreaAPISuccess() {
        String url = createURLWithPort("/api/math/circle-area?radius=5.0");
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody() > 78.0 && response.getBody() < 79.0);
    }

    @Test
    @DisplayName("Daire alanı API testi - negatif yarıçap hatası")
    void testCircleAreaAPIError() {
        String url = createURLWithPort("/api/math/circle-area?radius=-3.0");
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);

        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Dikdörtgen alanı API testi - başarılı")
    void testRectangleAreaAPISuccess() {
        String url = createURLWithPort("/api/math/rectangle-area?length=6.0&width=4.0");
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(24.0, response.getBody());
    }

    @Test
    @DisplayName("Dikdörtgen alanı API testi - negatif değer hatası")
    void testRectangleAreaAPIError() {
        String url = createURLWithPort("/api/math/rectangle-area?length=-5.0&width=3.0");
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);

        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Mesafe API testi")
    void testDistanceAPI() {
        String url = createURLWithPort("/api/math/distance?x1=0.0&y1=0.0&x2=3.0&y2=4.0");
        ResponseEntity<Double> response = restTemplate.getForEntity(url, Double.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(5.0, response.getBody());
    }

    @Test
    @DisplayName("Asal sayı kontrolü API testi")
    void testIsPrimeAPI() {
        // Asal sayı testi
        String url1 = createURLWithPort("/api/math/is-prime?number=7");
        ResponseEntity<Boolean> response1 = restTemplate.getForEntity(url1, Boolean.class);
        assertEquals(200, response1.getStatusCodeValue());
        assertTrue(response1.getBody());

        // Asal olmayan sayı testi
        String url2 = createURLWithPort("/api/math/is-prime?number=4");
        ResponseEntity<Boolean> response2 = restTemplate.getForEntity(url2, Boolean.class);
        assertEquals(200, response2.getStatusCodeValue());
        assertFalse(response2.getBody());
    }
}
