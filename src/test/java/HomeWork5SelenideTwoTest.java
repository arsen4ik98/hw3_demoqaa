import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import testdata.Attach;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

class HomeWork5SelenideTwoTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Test
    void homeWork5HoverSolutions() {

        open("https://github.com/");
        $("header").$(byText("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprises")).click();
        $("h1#hero-section-brand-heading").shouldHave(exactText("The AI-powered developer platform"));
        Attach.addVideo();
    }

}