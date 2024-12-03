import org.junit.jupiter.api.Test;
import pages.DemoqaaPages;
import testdata.TestData;

public class TextBoxTests extends TestBase {

    DemoqaaPages demoqaaPages =new DemoqaaPages();
    TestData testData = new TestData();


    @Test
    void hw6PageObjectsTest() {
        demoqaaPages.openPage()
                .setFirstNameLocator(testData.FIRST_NAME)
                .setLastNameLocator(testData.LAST_NAME)
                .setUserEmailLocator(testData.EMAIL)
                .setGenderLocator(testData.GENDER)
                .setUserNumberLocator(testData.PHONE_NUMBER)
                .setDateOfBirthLocator(testData.DAY_OF_BIRTH, testData.MONTH_OF_BIRTH, testData.YEAR_OF_BIRTH)
                .setSubjectsInputLocator(testData.SUBJECT)
                .setHobbiesLocator(testData.HOBBY)
                .setUploadPictureLocator(testData.PICTURE)
                .setCurrentAddressLocator(testData.ADDRESS)
                .setStateLocator(testData.STATE)
                .setCityLocator(testData.CITY)
                .setSubmitLocator();

        demoqaaPages.checkResult("Student Name", testData.FIRST_NAME + " " + testData.LAST_NAME)
                .checkResult("Student Email", testData.EMAIL)
                .checkResult("Gender", testData.GENDER)
                .checkResult("Mobile", testData.PHONE_NUMBER)
                .checkResult("Date of Birth", testData.DAY_OF_BIRTH + " " + testData.MONTH_OF_BIRTH + "," + testData.YEAR_OF_BIRTH)
                .checkResult("Subjects", testData.SUBJECT)
                .checkResult("Hobbies", testData.HOBBY)
                .checkResult("Picture", testData.PICTURE)
                .checkResult("Address", testData.ADDRESS)
                .checkResult("State and City", testData.STATE + " " + testData.CITY);

    }

    @Test
    void practiceFormHW6Test() {

        demoqaaPages.openPage()
                .setFirstNameLocator(testData.FIRST_NAME)
                .setLastNameLocator(testData.LAST_NAME)
                .setGenderLocator(testData.GENDER)
                .setUserNumberLocator(testData.PHONE_NUMBER)
                .setSubmitLocator();

        demoqaaPages.checkResult("Student Name", testData.FIRST_NAME+ " " +testData.LAST_NAME)
                .checkResult("Gender", testData.GENDER)
                .checkResult("Mobile", testData.PHONE_NUMBER);

    }

    @Test
    void practiceFormHW6NegativeTest() {

        demoqaaPages.openPage()
                .setSubmitLocator();

        demoqaaPages.checkNoResults();

    }

}
