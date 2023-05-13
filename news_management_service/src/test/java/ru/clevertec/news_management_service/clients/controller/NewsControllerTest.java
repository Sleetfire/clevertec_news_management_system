package ru.clevertec.news_management_service.clients.controller;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.clevertec.news_management_service.clients.util.WireMockExtension;
import ru.clevertec.news_management_service.controller.NewsController;
import wiremock.org.apache.hc.client5.http.classic.methods.HttpGet;
import wiremock.org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import wiremock.org.apache.hc.client5.http.impl.classic.HttpClients;
import wiremock.org.apache.hc.core5.http.HttpResponse;
import wiremock.org.apache.hc.core5.http.ProtocolException;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest
@ExtendWith(WireMockExtension.class)
class NewsControllerTest {

    @Autowired
    private NewsController newsController;

    @Test
    void create() {
    }

    @Test
    void checkFindByIdShouldReturnNewsDto() throws IOException, ProtocolException {
        stubFor(get(urlPathMatching("/news/1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("123")
                )
        );

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:9000/news/1");
        HttpResponse response = httpClient.execute(request);
        System.out.println(response.getCode());
        System.out.println(response.getHeader("Content-Type"));
    }

    @Test
    void findAll() {
    }

    @Test
    void findPage() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findWrapper() {
    }
}