package ru.clevertec.news_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.clevertec.news_management_service.repository")
public class NewsManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsManagementServiceApplication.class, args);
	}

}
