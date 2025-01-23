import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import testdata.Attach;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

class HomeWork5SelenideTwoTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Test
    void homeWork5HoverSolutions() {
        step("Открыть главную страницу", () -> {
        open("https://github.com/");
        });
        step("Открыть меню", () -> {
        $("header").$(byText("Solutions")).hover();
        });
        step("Перейти в Enterprises", () -> {
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprises")).click();
        });
        step("Проверить, что загрузилась нужная страница", () -> {
        $("h1#hero-section-brand-heading").shouldHave(exactText("The AI-powered developer platform"));
        });
        Attach.addVideo();
        Attach.makeScreenshot();
        Attach.pageSource();
    }

}