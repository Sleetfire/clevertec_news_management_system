package ru.clevertec.news_management_service.clients.util;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WireMockExtension implements BeforeAllCallback, AfterEachCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        WireMockUtil.startServer();
    }

    @Override
    public void afterEach(ExtensionContext context) {
        WireMockUtil.resetStubs();
    }

    @Override
    public void afterAll(ExtensionContext context) {
        WireMockUtil.stopServer();
    }
}
