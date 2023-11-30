package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.StudentNavigatePage;

public class StudentNavigate_stepdef {
    StudentNavigatePage studentNavigatePage = new StudentNavigatePage();

    @Given("^The student opens the mobile app (.*) and (.*)")
    public void the_student_opens_the_mobile_app(String username, String password) {
    studentNavigatePage.loginApp(username,password);
    }



    @When("The student uses the navigation bar to navigate between different sections")
    public void the_student_uses_thee_navigation_bar_to_navigate_between_different_sections() {

    }



    @Then("The student logs out of the app")
    public void the_student_logs_out_of_the_app() {
        studentNavigatePage.closeSuccessfully();

    }


}
