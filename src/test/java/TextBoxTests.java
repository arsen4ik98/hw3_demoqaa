import org.junit.jupiter.api.Test;
import pages.DemoqaaPages;
import testdata.TestData;

public class TextBoxTests extends TestBase {

    DemoqaaPages demoqaaPages =new DemoqaaPages();
    TestData testData = new TestData();


    @Test
    void hw6PageObjectsTest() {
        demoqaaPages.openPage()
                .setFirstNameLocator(testData.firstName)
                .setLastNameLocator(testData.lastName)
                .setUserEmailLocator(testData.email)
                .setGenderLocator(testData.gender)
                .setUserNumberLocator(testData.phoneNumber)
                .setDateOfBirthLocator(testData.daybirth, testData.monthbirth, testData.yearbirth)
                .setSubjectsInputLocator(testData.subject)
                .setHobbiesLocator(testData.hobby)
                .setUploadPictureLocator(testData.picture)
                .setCurrentAddressLocator(testData.address)
                .setStateLocator(testData.state)
                .setCityLocator(testData.city)
                .setSubmitLocator();

        demoqaaPages.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", testData.daybirth + " " + testData.monthbirth + "," + testData.yearbirth)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);

    }

    @Test
    void practiceFormHW6Test() {

        demoqaaPages.openPage()
                .setFirstNameLocator(testData.firstName)
                .setLastNameLocator(testData.lastName)
                .setGenderLocator(testData.gender)
                .setUserNumberLocator(testData.phoneNumber)
                .setSubmitLocator();

        demoqaaPages.checkResult("Student Name", testData.firstName+ " " +testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber);

    }

    @Test
    void practiceFormHW6NegativeTest() {

        demoqaaPages.openPage()
                .setSubmitLocator();

        demoqaaPages.checkNoResults();

    }

}
