package StepDefination;

import org.openqa.selenium.WebDriver;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;



public class dashboardstep {
	Login login;
	TestBase testbase;
	WebDriver driver =null;
	@Given("Launch QuickServe")
	public void Launch_quickserve() {
		testbase= new TestBase();
		testbase.initialization();
	}
	@Then("Login to QuickServe")
	public void login_to_quickserve() throws InterruptedException {
		login= new Login();
		login.qsLogin();
	}

}
