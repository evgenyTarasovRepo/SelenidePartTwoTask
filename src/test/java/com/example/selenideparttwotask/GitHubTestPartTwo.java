package com.example.selenideparttwotask;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTestPartTwo {
    public static final String BASE_URL_GIT = "https://github.com/";

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @BeforeEach
    public void openResource() {
        open(BASE_URL_GIT);
    }

    @AfterEach
    public void turnDown() {
        closeWebDriver();
    }

    @Test
    public void openAndCheckEnterprise() {
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $(withText("like the best")).shouldHave(text("Build like the best"));
    }
}
