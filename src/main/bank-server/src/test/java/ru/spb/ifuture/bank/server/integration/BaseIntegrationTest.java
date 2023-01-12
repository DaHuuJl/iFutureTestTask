/*
package ru.spb.ifuture.bank.server.integration;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public abstract class BaseIntegrationTest {

    public static PostgreSQLContainer<?> POSTGRESQL_CONTAINER = new PostgreSQLContainer<>("postgres:14.5-alpine")
        .withDatabaseName("test-db")
        .withUsername("postgres")
        .withPassword("postgres");

    static {
        if (!Boolean.parseBoolean(System.getProperty("testcontainers.disabled"))) {
            POSTGRESQL_CONTAINER.start();
            try {
                POSTGRESQL_CONTAINER.execInContainer(
                    "CREATE DATABASE ifuture_db;",
                    "CREATE USER owner_ifuture_db WITH PASSWORD 'owner_ifuture_db';",
                    "GRANT ALL PRIVILEGES ON DATABASE \"ifuture_db\" to owner_ifuture_db;"
                );
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.setProperty("spring.datasource.url", POSTGRESQL_CONTAINER.getJdbcUrl());
            System.setProperty("spring.datasource.username", POSTGRESQL_CONTAINER.getUsername());
            System.setProperty("spring.datasource.password", POSTGRESQL_CONTAINER.getPassword());
        }
    }
}
*/
