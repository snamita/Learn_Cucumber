package StepDefination;

import org.openqa.selenium.WebDriver;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard;
import pages.Login;
import pages.Solutions;



public class loginstep {
	Dashboard dashboard;
	Login login;
	TestBase testbase;
	WebDriver driver =null;
	@Given("Launch QuickServe")
	public void Launch_quickserve() {
		testbase= new TestBase();
		testbase.initialization();
	}
	@Then("Login to QuickServe with {string},{string},{string} and {string}")
	public void login_to_quickserve(String fname,String lname,String emailId,String emp_code) throws InterruptedException {
		login= new Login();
		login.qsLogin(fname,lname,emailId,emp_code);
	}
	@Then("verify logged in user")
	public void verify_logged_in_user() throws InterruptedException {
		dashboard= new Dashboard();
		dashboard.verifyLoggedInUser();
	}

	@Then("Select the environment")
	public void Select_the_environment() throws InterruptedException {
		
		dashboard.selectEnvironment();
	}
}
