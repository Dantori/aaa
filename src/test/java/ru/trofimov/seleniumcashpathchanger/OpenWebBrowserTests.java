package ru.trofimov.seleniumcashpathchanger;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class OpenWebBrowserTests {

    @Test
    void testOpenWebBrowser() {
        open();
    }
}
