import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import testdata.Attach;
import java.util.Map;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class HomeWork4SelenideTest {


    static CredentialsConfig config;
    @BeforeAll
    static void beforeAll() {
        config = ConfigFactory.create(CredentialsConfig.class);
        String browserVersion = System.getProperty("version", "126.0.6478.126");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("windowSize", "1920x1080");
        String remoteUrl = System.getProperty("remoteBrowserUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.baseUrl = "https://github.com/"; // practiceFormTest
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = remoteUrl;
        //Configuration.browserVersion = browserVersion;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map .<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;

        System.out.println("Remote URL: " + remoteUrl);
        System.out.println("Browser: " + Configuration.browser);
        System.out.println("Browser version: " + System.getProperty("version"));
        System.out.println("Window size: " + Configuration.browserSize);

    }

    @Test
    @Tag("hw12_test")
    void homeWork4CodeExampleExistsOnSelenideGithubWiki() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
        Attach.browserConsoleLogs();
        System.out.println("Remote URL: " + config.remote());
    }

}
