package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import pages.StudentLoginPage;

public class StudentLogin_stepdef {
    StudentLoginPage studentLoginPage = new StudentLoginPage();

    private String password;
    String dynamicUsername = generateRandomUsername();
    private String generateRandomUsername() {
        String randomString = RandomStringUtils.randomAlphanumeric(8);
        return randomString + "@yopmail.com";
    }

    private final Faker faker = new Faker();

    private String randomFirstName;
    private String randomLastName;
    private String randomParentEmail;
    private String randomPhoneNumber;
    @Given("^Student open the app and enters (.*) and (.*)")
    public void student_open_the_app_and_enters(String username, String password ) {
    studentLoginPage.studentLogin(dynamicUsername,password);

    }




    @Then("^Student enters personel info (.*), (.*)")
    public void studentEntersPersonelInfoSfirstname(String sfirstname, String slastname) {

        randomFirstName = faker.name().firstName();
        randomLastName = faker.name().lastName();

        studentLoginPage.studentPersonelInfo(randomFirstName, randomLastName );


    }

    @And("^Student enters (.*) and (.*)")
    public void studentEntersPEmail(String pEmail, String pPhone) {
        randomParentEmail = faker.name().firstName() + "01@yopmail.com";
        randomPhoneNumber = faker.phoneNumber().subscriberNumber(10);
        studentLoginPage.studentPemail(randomParentEmail, randomPhoneNumber);
    }
    @And("Student login successfully")
    public void student_login_successfully() {
        studentLoginPage.succesfully();
    }



}
