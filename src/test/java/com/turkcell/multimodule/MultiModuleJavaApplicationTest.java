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
    }

    @Test
    @DisplayName("Application class test")
    void applicationClassTest() {
        MultiModuleJavaApplication app = new MultiModuleJavaApplication();
        assertNotNull(app);
        assertInstanceOf(MultiModuleJavaApplication.class, app);
    }

    @Test
    @DisplayName("Main method test")
    void mainMethodTest() {
        String[] args = {};

        assertDoesNotThrow(() -> {
            MultiModuleJavaApplication.main(args);
        });
    }
}
