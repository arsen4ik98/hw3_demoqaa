import org.junit.jupiter.api.Test;
import pages.DemoqaaPages;
import pages.components.ResultsTableComponent;

public class TextBoxTests extends TestBase {

    DemoqaaPages demoqaaPages =new DemoqaaPages();

    @Test
    void hw6PageObjectsTest() {
        demoqaaPages.openPage()
                .setFirstNameLocator("test1")
                .setLastNameLocator("test1F")
                .setUserEmailLocator("test1@example.com")
                .setGenderLocator("Male")
                .setUserNumberLocator("9999999999")
                .setDateOfBirthLocator("27","December", "1992")
                .setSubjectsInputLocator("Chemistry")
                .setHobbiesLocator("Sports")
                .setUploadPictureLocator("Image.jpg")
                .setCurrentAddressLocator("test1Add")
                .setStateLocator("NCR")
                .setCityLocator("Noida")
                .setSubmitLocator();

        demoqaaPages.checkResult("Student Name", "test1 test1F")
                .checkResult("Student Email", "test1@example.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999")
                .checkResult("Date of Birth", "27 December,1992")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "Image.jpg")
                .checkResult("Address", "test1Add")
                .checkResult("State and City", "NCR Noida");

    }

    @Test
    void practiceFormHW6Test() {

        demoqaaPages.openPage()
                .setFirstNameLocator("test1")
                .setLastNameLocator("test1F")
                .setGenderLocator("Male")
                .setUserNumberLocator("9999999999")
                .setSubmitLocator();

        demoqaaPages.checkResult("Student Name", "test1 test1F")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999");

    }

    @Test
    void practiceFormHW6NegativeTest() {

        demoqaaPages.openPage()
                .setSubmitLocator();

        demoqaaPages.checkNoResults();

    }

}
