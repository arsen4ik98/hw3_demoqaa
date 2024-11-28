package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaaPages {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();


    private final SelenideElement firstNameLocator = $("#firstName");
    private final SelenideElement lastNameLocator = $("#lastName");
    private final SelenideElement userEmailLocator = $("#userEmail");
    private final SelenideElement genderLocator = $("#genterWrapper");
    private final SelenideElement userNumberLocator = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInputLocator = $("#subjectsInput");
    private final SelenideElement hobbiesLocator = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureLocator = $("#uploadPicture");
    private final SelenideElement currentAddressLocator = $("#currentAddress");
    private final SelenideElement stateLocator = $("#state");
    private final SelenideElement cityLocator = $("#city");
    private final SelenideElement submitLocator = $("#submit");


    public DemoqaaPages openPage() {
        open("/automation-practice-form");
        return this;
    }

    public DemoqaaPages setFirstNameLocator(String value) {
        firstNameLocator.setValue(value);
        return this;
    }

    public DemoqaaPages setLastNameLocator(String value) {
        lastNameLocator.setValue(value);
        return this;
    }

    public DemoqaaPages setUserEmailLocator(String value) {
        userEmailLocator.setValue(value);
        return this;
    }

    public DemoqaaPages setGenderLocator(String value) {
        genderLocator.$(byText(value)).click();
        return this;
    }

    public DemoqaaPages setUserNumberLocator(String value) {
        userNumberLocator.setValue(value);
        return this;
    }

    public DemoqaaPages setDateOfBirthLocator(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public DemoqaaPages setSubjectsInputLocator(String value) {
        subjectsInputLocator.val(value).pressEnter();
        return this;
    }

    public DemoqaaPages setHobbiesLocator(String value) {
        hobbiesLocator.$(byText(value)).click();
        return this;
    }

    public DemoqaaPages setUploadPictureLocator(String value) {
        uploadPictureLocator.uploadFromClasspath(value);
        return this;
    }

    public DemoqaaPages setCurrentAddressLocator(String value) {
        currentAddressLocator.setValue(value);
        return this;
    }

    public DemoqaaPages setStateLocator(String value) {
        stateLocator.shouldBe(visible).click();
        $(byText(value)).click();
        return this;
    }

    public DemoqaaPages setCityLocator(String value) {
        cityLocator.shouldBe(visible).click();
        $(byText(value)).click();
        return this;
    }

    public void setSubmitLocator() {
        submitLocator.click();
    }
    public DemoqaaPages checkResult(String key, String value) {

        resultsTableComponent.checkResult(key,value);
        return this;
    }

    public void checkNoResults() {
        resultsTableComponent.checkNoResults();
    }


}



