package com.example.selenideparttwotask;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    public static final String BASE_URL = "https://the-internet.herokuapp.com/drag_and_drop";

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @BeforeEach
    public void openResource() {
        open(BASE_URL);
    }

    @AfterEach
    public void turnDown() {
        closeWebDriver();
    }

    @Test
    public void dragAndDropTest() {
        SelenideElement a = element("#column-a");
        SelenideElement b = element("#column-b");

        a.dragAndDropTo(b);

        a.shouldHave(Condition.text("B"));
        b.shouldHave(Condition.text("A"));
    }
}
