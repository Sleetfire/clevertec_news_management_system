package ru.clevertec.news_management_service.integration;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.clevertec.news_management_service.NewsManagementServiceApplication;

@Transactional
@ActiveProfiles(value = "test")
@SpringBootTest(classes = NewsManagementServiceApplication.class)
public abstract class BaseIntegrationTest {

    private static final String DOCKER_IMAGE_NAME = "postgres:13.2";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12378";
    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>(DOCKER_IMAGE_NAME)
            .withUsername(USERNAME)
            .withPassword(PASSWORD);

    @BeforeAll
    static void init() {
        container.start();
    }

    @DynamicPropertySource
    static void setup(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

}
