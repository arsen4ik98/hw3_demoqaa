import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import testdata.Attach;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


@Tag("simple")
 class HomeWork5DragAndDrop {

     @BeforeAll
     static void beforeAll() {
         Configuration.browser = "chrome";
         WebDriverManager.chromedriver().setup();
         Configuration.browserSize = "1920x1080";
         Configuration.baseUrl = "https://the-internet.herokuapp.com/";
         Configuration.pageLoadStrategy = "eager";
         Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
     }



    @Test
    void homeWork5DragAndDrop(){
        open("/drag_and_drop");
        SelenideElement buttonA = $("#column-a");
        SelenideElement buttonB = $("#column-b");
        Actions actions = actions();
        actions.dragAndDrop(buttonA, buttonB).perform();
        buttonA.shouldHave(text("B"));
        buttonB.shouldHave(text("A"));
        Attach.addVideo();
    }

    @Test
    void homeWork5DragAndDropProverka2(){
        open("/drag_and_drop");
        SelenideElement buttonA = $("#column-a");
        SelenideElement buttonB = $("#column-b");
        buttonA.dragAndDropTo(buttonB);
        buttonA.shouldHave(text("B"));
        buttonB.shouldHave(text("A"));
        Attach.addVideo();
    }
}
