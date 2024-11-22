import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class SimpleJUnitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com"; // practiceFormTest
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void firstTest() {

        open("/text-box");
        $("#userName").setValue("test1");
        $("#userEmail").setValue("test1@example.com");
        $("#currentAddress").setValue("test1Add");
        $("#permanentAddress").setValue("test1PAdd");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("test1"));
        $("#output").$("#email").shouldHave(text("test1@example.com"));
        $("#output").$("#currentAddress").shouldHave(text("test1Add"));
        $("#output").$("#permanentAddress").shouldHave(text("test1PAdd"));
    }

    @Test
    void practiceFormTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("test1");
        $("#lastName").setValue("test1F");
        $("#userEmail").setValue("test1@example.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").setValue("30 Sep 2024");
        $("#subjectsInput").setValue("Chemistry");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--027").click();
        $("#subjectsInput").setValue("C");
        $$(".subjects-auto-complete__menu-list div").findBy(text("Chemistry")).shouldBe(visible).click();
        $("label[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("Image.jpg");
        $("#currentAddress").setValue("test1Add");
        $("#state").shouldBe(visible).click();
        $(byText("NCR")).click();
        $("#city").shouldBe(visible).click();
        $(byText("Noida")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("test1"));
        $(".modal-content").shouldHave(text("test1@example.com"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("9999999999"));
        $(".modal-content").shouldHave(text("27 December,1992"));
        $(".modal-content").shouldHave(text("Chemistry"));
        $(".modal-content").shouldHave(text("Sports"));
        $(".modal-content").shouldHave(text("Image.jpg"));
        $(".modal-content").shouldHave(text("test1Add"));
        $(".modal-content").shouldHave(text("NCR Noida"));
    }

    @Test
    void practiceFormHW6Test() {

        open("/automation-practice-form");
        $("#firstName").setValue("test1");
        $("#lastName").setValue("test1F");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("9999999999");
        $("#submit").click();

        $(".modal-content").shouldHave(
                text("test1"),
                text("test1F"),
                text("Male"),
                text("9999999999"));
    }

    @Test
    void practiceFormHW6NegativeTest() {

        open("/automation-practice-form");
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
    }
}
