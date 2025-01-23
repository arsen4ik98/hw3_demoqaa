import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import testdata.Attach;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SimpleJUnitTest extends TestBase {


    @Test
    void firstTest() {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
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
        Attach.addVideo();

    }

    @Test
    void practiceFormTest() {
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        step("Открыть главную страницу", () -> {
        open("/automation-practice-form");
        });
        step("Заполнить поле firstName", () -> {
        $("#firstName").setValue("test1");
        });
        step("Заполнить поле lastName", () -> {
        $("#lastName").setValue("test1F");
        });
        step("Заполнить поле userEmail", () -> {
        $("#userEmail").setValue("test1@example.com");
        });
        step("Выбрал пол", () -> {
        $("label[for='gender-radio-1']").click();
        });
        step("Заполнить номер телефона", () -> {
        $("#userNumber").setValue("9999999999");
        });
        step("Заполнить поле даты рождения", () -> {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--027").click();
        });
        step("Заполнить поле Субьект", () -> {
        $("#subjectsInput").setValue("C");
        $$(".subjects-auto-complete__menu-list div").findBy(text("Chemistry")).shouldBe(visible).click();
        });
        step("Заполнить поле Хобби", () -> {
        $("label[for='hobbies-checkbox-1']").click();
        });
        step("Загрузить фото", () -> {
        $("#uploadPicture").uploadFromClasspath("Image.jpg");
        });
        step("Заполнить поле Адреса", () -> {
        $("#currentAddress").setValue("test1Add");
        });
        step("Заполнить поле State", () -> {
        $("#state").shouldBe(visible).click();
        $(byText("NCR")).click();
        });
        step("Заполнить поле Город", () -> {
        $("#city").shouldBe(visible).click();
        $(byText("Noida")).click();
        });
        step("Нажать на кнопку Submit", () -> {
        $("#submit").click();
        });
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
        Attach.addVideo();
        Attach.makeScreenshot();
        Attach.pageSource();
    }


}
