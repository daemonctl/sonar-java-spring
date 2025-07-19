package com.turkcell.multimodule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("MultiModuleJavaApplication Tests")
class MultiModuleJavaApplicationTest {

    @Test
    @DisplayName("Spring Boot context loads successfully")
    void contextLoads() {
        // Bu test Spring Boot context'inin başarıyla yüklendiğini doğrular
        // Context yüklenmesi başarılıysa test geçer
    }

    @Test
    @DisplayName("Application class test")
    void applicationClassTest() {
        // Application sınıfının constructor'ını test et
        MultiModuleJavaApplication app = new MultiModuleJavaApplication();
        assertNotNull(app);
        assertInstanceOf(MultiModuleJavaApplication.class, app);
    }

    @Test
    @DisplayName("Main method test")
    void mainMethodTest() {
        // Main metodunu test etmek için
        String[] args = {};

        // Main metodunu çağırıp test edelim - gerçek coverage için
        assertDoesNotThrow(() -> {
            MultiModuleJavaApplication.main(args);
        });
    }
}
