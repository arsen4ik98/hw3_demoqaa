import org.junit.jupiter.api.Test;
import pages.DemoqaaPages;

import static testdata.TestData.*;
import pages.components.ResultsTableComponent;

public class TextBoxTests extends TestBase {

    DemoqaaPages demoqaaPages =new DemoqaaPages();


    @Test
    void hw6PageObjectsTest() {
        demoqaaPages.openPage()
                .setFirstNameLocator(FIRST_NAME)
                .setLastNameLocator(LAST_NAME)
                .setUserEmailLocator(EMAIL)
                .setGenderLocator(GENDER)
                .setUserNumberLocator(PHONE_NUMBER)
                .setDateOfBirthLocator(DAY_OF_BIRTH, MONTH_OF_BIRTH, YEAR_OF_BIRTH)
                .setSubjectsInputLocator(SUBJECT)
                .setHobbiesLocator(HOBBY)
                .setUploadPictureLocator(PICTURE)
                .setCurrentAddressLocator(ADDRESS)
                .setStateLocator(STATE)
                .setCityLocator(CITY)
                .setSubmitLocator();

        demoqaaPages.checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkResult("Student Email", EMAIL)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", PHONE_NUMBER)
                .checkResult("Date of Birth", DAY_OF_BIRTH + " " + MONTH_OF_BIRTH + "," + YEAR_OF_BIRTH)
                .checkResult("Subjects", SUBJECT)
                .checkResult("Hobbies", HOBBY)
                .checkResult("Picture", PICTURE)
                .checkResult("Address", ADDRESS)
                .checkResult("State and City", STATE + " " + CITY);

    }

    @Test
    void practiceFormHW6Test() {

        demoqaaPages.openPage()
                .setFirstNameLocator(FIRST_NAME)
                .setLastNameLocator(LAST_NAME)
                .setGenderLocator(GENDER)
                .setUserNumberLocator(PHONE_NUMBER)
                .setSubmitLocator();

        demoqaaPages.checkResult("Student Name", FIRST_NAME+ " " +LAST_NAME)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", PHONE_NUMBER);

    }

    @Test
    void practiceFormHW6NegativeTest() {

        demoqaaPages.openPage()
                .setSubmitLocator();

        demoqaaPages.checkNoResults();

    }

}
