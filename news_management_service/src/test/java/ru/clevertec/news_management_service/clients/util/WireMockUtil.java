package ru.clevertec.news_management_service.clients.util;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.experimental.UtilityClass;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

@UtilityClass
public class WireMockUtil {

    public static final String DEFAULT_HOST = "localhost";
    public static final int DEFAULT_PORT = 9000;
    private static WireMockServer wireMockServer;

    public static void startServer() {
        if (wireMockServer == null) {
            wireMockServer = new WireMockServer(DEFAULT_PORT);
        }
        wireMockServer.start();
        configureFor(DEFAULT_HOST, DEFAULT_PORT);
    }

    public static void stopServer() {
        wireMockServer.stop();
    }

    public static void resetStubs() {
        wireMockServer.resetAll();
    }
}
