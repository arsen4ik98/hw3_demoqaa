package testdata;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class TestData {

    public Faker faker = new Faker(new Locale("ru"));
    public Faker fakerE = new Faker(new Locale("en"));

    public String FIRST_NAME = faker.name().firstName();
    public String LAST_NAME = faker.name().lastName();
    public String EMAIL = fakerE.internet().emailAddress();
    public String GENDER = faker.options().option("Male", "Female", "Other");
    public String PHONE_NUMBER = faker.phoneNumber().subscriberNumber(10);
    public Date dateOfBirth = faker.date().birthday(18, 100);
    public SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    public String MONTH_OF_BIRTH = faker.options().option("January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November","December");
    public SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    public String DAY_OF_BIRTH = dayFormat.format(dateOfBirth);
    public String YEAR_OF_BIRTH = yearFormat.format(dateOfBirth);
    public String HOBBY = faker.options().option("Sports", "Reading", "Music");
    public String[] SUBJECTS = {
            "English", "Chemistry", "Computer Science", "Commerce", "Economics",
            "Social Studies", "Arts", "History", "Maths", "Accounting",
            "Physics", "Biology", "Hindi", "Civics"
    };
    public String SUBJECT = faker.options().option(SUBJECTS);
    public String PICTURE = "Image.jpg";
    public String ADDRESS = faker.address().fullAddress();
    public Map<String, String[]> CITIES_BY_STATE = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
    public String STATE = faker.options().option(CITIES_BY_STATE.keySet().toArray(new String[0]));
    public String CITY = faker.options().option(CITIES_BY_STATE.get(STATE));


}
