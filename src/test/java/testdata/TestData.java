package testdata;

import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestData {

    public Faker faker = new Faker(new Locale("ru"));
    public Faker fakerE = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = fakerE.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public Date dateOfBirth = faker.date().birthday(18, 100);
    public SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    public String monthbirth = faker.options().option("January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November","December");
    public SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    public String daybirth = dayFormat.format(dateOfBirth);
    public String yearbirth = yearFormat.format(dateOfBirth);
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String[] subjects = {
            "English", "Chemistry", "Computer Science", "Commerce", "Economics",
            "Social Studies", "Arts", "History", "Maths", "Accounting",
            "Physics", "Biology", "Hindi", "Civics"
    };
    public String subject = faker.options().option(subjects);
    public String picture = "Image.jpg";
    public String address = faker.address().fullAddress();
    public Map<String, String[]> citiesByState = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
    public String state = faker.options().option(citiesByState.keySet().toArray(new String[0]));
    public String city = faker.options().option(citiesByState.get(state));


}
