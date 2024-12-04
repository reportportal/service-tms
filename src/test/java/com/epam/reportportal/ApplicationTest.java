package com.epam.reportportal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
public class ApplicationTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQL = new PostgreSQLContainer<>("postgres:17.0-alpine");

    @Test
    void contextLoads() {
    }

}
