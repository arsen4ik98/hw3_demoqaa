import com.codeborne.selenide.Configuration;
import io.qameta.allure.Attachment;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import testdata.Attach;
import testdata.TestData;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class HomeWork4SelenideTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/"; // practiceFormTest
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map .<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    void homeWork4CodeExampleExistsOnSelenideGithubWiki() {

        step("Открыть главную страницу", () -> {
        open("/selenide/selenide");
        });
        step("Переходить по wiki", () -> {
        $("#wiki-tab").click();
        });
        step("Иcкать SoftAssertions", () -> {
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        });
        step("Открывать SoftAssertions", () -> {
        $("#wiki-pages-box").$$("a").findBy(text("SoftAssertions")).click();
        });
        step("Проверка текста", () -> {
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
        });
        Attach.addVideo();
        Attach.makeScreenshot();
        Attach.pageSource();
    }

}
