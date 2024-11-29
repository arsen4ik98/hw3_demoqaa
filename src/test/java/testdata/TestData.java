package testdata;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class TestData {

    private static final Faker faker = new Faker(new Locale("ru"));
    private static final Faker fakerE = new Faker(new Locale("en"));

    public static final String FIRST_NAME = faker.name().firstName();
    public static final String LAST_NAME = faker.name().lastName();
    public static final String EMAIL = fakerE.internet().emailAddress();
    public static final String GENDER = faker.options().option("Male", "Female", "Other");
    public static final String PHONE_NUMBER = faker.phoneNumber().subscriberNumber(10);
    private static final Date dateOfBirth = faker.date().birthday(18, 100);
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    public static final String MONTH_OF_BIRTH = faker.options().option("January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November","December");
    private static final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    public static final String DAY_OF_BIRTH = dayFormat.format(dateOfBirth);
    public static final String YEAR_OF_BIRTH = yearFormat.format(dateOfBirth);
    public static final String HOBBY = faker.options().option("Sports", "Reading", "Music");
    private static final String[] SUBJECTS = {
            "English", "Chemistry", "Computer Science", "Commerce", "Economics",
            "Social Studies", "Arts", "History", "Maths", "Accounting",
            "Physics", "Biology", "Hindi", "Civics"
    };
    public static final String SUBJECT = faker.options().option(SUBJECTS);
    public static  final String PICTURE = "Image.jpg";
    public static final String ADDRESS = faker.address().fullAddress();
    private static final Map<String, String[]> CITIES_BY_STATE = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
    public static final String STATE = faker.options().option(CITIES_BY_STATE.keySet().toArray(new String[0]));
    public static final String CITY = faker.options().option(CITIES_BY_STATE.get(STATE));


}
