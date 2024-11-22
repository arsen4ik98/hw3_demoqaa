import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;



 class HomeWork5DragAndDrop {

     @BeforeAll
     static void beforeAll() {
         Configuration.browserSize = "1920x1080";
         Configuration.baseUrl = "https://the-internet.herokuapp.com/";
         Configuration.pageLoadStrategy = "eager";
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
    }

    @Test
    void homeWork5DragAndDropProverka2(){
        open("/drag_and_drop");
        SelenideElement buttonA = $("#column-a");
        SelenideElement buttonB = $("#column-b");
        buttonA.dragAndDropTo(buttonB);
        buttonA.shouldHave(text("B"));
        buttonB.shouldHave(text("A"));
    }
}
