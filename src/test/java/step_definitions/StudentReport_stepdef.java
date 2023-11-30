package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StudentReportPage;

public class StudentReport_stepdef {

    StudentReportPage studentReportPage = new StudentReportPage();

    private String reportText= "First report for me";

    @Given("^Student sign in with (.*) and (.*)")
    public void studentSignInWithUsernameAndPassword(String username, String password) {
        studentReportPage.signIn(username,password);
    }

    @When("^Student navigates to report page and enters details (.*)")
    public void student_navigates_to_report_page_and_enters_details(String reportDetails) {

        studentReportPage.reportPage(reportText);
    }



    @And("submits the report")
    public void submits_the_report() {


    }



    @Then("The report should be successfully submitted")
    public void the_report_should_be_successfully_submitted() {
    studentReportPage.assertionForReport();
    }


}
