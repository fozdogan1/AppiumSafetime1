package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import pages.LoginPage;
import com.github.javafaker.Faker;
import pages.StudentLoginPage;

public class TeacherLogin_stepdef {

    LoginPage loginPage = new LoginPage();
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

       // @Given("Teacher open the app and enters <username> and <password>,<firstname>,<lastname>")
        /*public void teacherOpensAppAndEnters(String username, String password, String firstname, String lastname) {
            if ("<dynamic_username>".equals(username)) {
                // Rastgele bir kullanıcı adı oluştur
                username = faker.name().username();
            }

            if ("<dynamic_firstname>".equals(firstname)) {
                // Rastgele bir isim oluştur
                firstname = faker.name().firstName();
            }

            if ("<dynamic_lastname>".equals(lastname)) {
                // Rastgele bir soyisim oluştur
                lastname = faker.name().lastName();
            }


        }


*/

    @Given("^Teacher open the app and enters (.*) and (.*),(.*),(.*)")
       public void teacher_open_the_app_and_enters_and (String username, String password, String firstName, String
       lastName){
        randomFirstName = faker.name().firstName();
        randomLastName = faker.name().lastName();

           loginPage.login(dynamicUsername, password, randomFirstName, randomLastName);

       }

       @Then("Teacher login successfully")
       public void teacher_login_successfully () {
           String actualText = loginPage.reportText.getText();
           String expectedText = "report to law enforcement";
           Assert.assertEquals(expectedText, actualText);

       }

/*    @Given("^Student open the app and enters (.*) and (.*)")
    public void studentOpenTheAppAndEntersUsernameAndPasswordFirstnameLastname(String username, String password)
             {
       studentLoginPage.studentLogin(dynamicUsername, password, randomFirstName, randomLastName);
    }


   // @Then("Student enters personel info {string}")
   // public void studentEntersPersonelInfo(String ali) {
   //     studentLoginPage.studentPersonelInfo(ali);
   // }

    @Then("Student login successfully")
    public void studentLoginSuccessfully() {
    }

    @Then("^Student enters personel info (.*), (.*), (.*), (.*), (.*)")
    public void studentEntersPersonelInfoSfirstnameSlastnameSDOBParentemailPphonenumber(String sfirstname, String slastname, String sDOB, String parentemail, String pphonenumber ) {
        studentLoginPage.studentPersonelInfo(randomFirstName, randomLastName, sDOB, parentemail, pphonenumber);
    }


    // @Then("Student enters personel info {string}")
   // public void studentEntersPersonelInfo(String arg0) {
    //}

 */
}

