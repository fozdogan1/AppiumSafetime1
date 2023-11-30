package step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import pages.ParentLoginPage;
import pages.StudentLoginPage;
import io.cucumber.java.en.Then;
import utilities.PostgreSQLConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ParentLogin_stepdef {

    ParentLoginPage parentLoginPage = new ParentLoginPage();
    private String password;
    private String parentEmail ;

    private final Faker faker = new Faker();

    private String randomPFirstName;
    private String randomPLastName;
    private String randomPhoneNumber;

        @Given("I connect to the PostgreSQL database")
        public void iConnectToThePostgreSQLDatabase() {
         //   Connection connection = PostgreSQLConnection.getConnection();

        }

   /*     @When("I perform a database operation")
        public void iPerformADatabaseOperation() {
            Connection connection = PostgreSQLConnection.getConnection();


        }

        @And("I close the PostgreSQL connection")
        public void iCloseThePostgreSQLConnection() {
            Connection connection = PostgreSQLConnection.getConnection();
            PostgreSQLConnection.closeConnection(connection);
        }


*/
    @When("^Parent open the app and enters (.*) and (.*)")
    public void parentOpenTheAppAndEntersAnd(String parentEmail, String password) {
       String new_parentEmail = PostgreSQLConnection.getParent();
        parentLoginPage.parentLogin(new_parentEmail, password);
    }

    @Then("^Parent enters personal info (.*), (.*), (.*)")
    public void parentEntersPersonalInfo(String pfirstname, String plastname, String pphonenumber) {
        randomPFirstName = faker.name().firstName();
        randomPLastName = faker.name().lastName();
        randomPhoneNumber = faker.phoneNumber().subscriberNumber(10);
        parentLoginPage.personalInfo(randomPFirstName, randomPLastName,randomPhoneNumber);
    }
}
