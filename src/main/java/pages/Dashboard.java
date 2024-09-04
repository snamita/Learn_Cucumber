package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import base.TestBase;
import extentreport.ExtentTestManager;

public class Dashboard extends TestBase {

	// Object Repository
	@FindBy(xpath = "//button/span/b")
	WebElement logged_user;

	@FindBy(css = "div > button > svg")
	WebElement user_details;

	@FindBy(xpath = "//li/a[contains(text(),'Account Details')]")
	WebElement account_details;

	@FindBy(xpath = "//span/small/following-sibling::span")
	WebElement user_role;

	@FindBy(xpath = "//div/button[contains(@class,'close')]")
	WebElement close_btn;

	@FindBy(xpath = "//div/h6[text()='Tv2 imerit-dev.']")
	WebElement dev_env;

	@FindBy(xpath = "//div/h6[contains(text(),'Tv2 Terraform Env.')]")
	WebElement terraform_env;

	@FindBy(xpath = "//div/h6[text()='Tv2 Stitchless Env.']")
	WebElement stitchless_env;

	@FindBy(xpath = "//div/h6[contains(text(),'Tv2 imerit-stage')]")
	WebElement stage_env;

	@FindBy(xpath = "//div/h6[contains(text(),'Tv2 imerit-prod')]")
	WebElement prod_env;

	@FindBy(xpath = "//div/h6[contains(text(),'Preview Env.')]")
	WebElement preview_env;

	// Initializing page objects
	public Dashboard() {
		PageFactory.initElements(driver, this);
	}

	// Methods
	// This method is to verify that the logged in user is the same user who logged in
	public void verifyLoggedInUser() throws InterruptedException {
		Thread.sleep(20000);
		Assert.assertEquals(logged_user.getText(), prop.getProperty("firstname"));
		System.out.println("Logged in Username Matched in the Dashborad");
	//	ExtentTestManager.getTest().log(Status.PASS, "Logged in Username Matched in the Dashborad");
	}

	// This method can only be called if user logs in as Super Admin as he only has rights to see account details
	public void verifyUserRole() {
		waitForElementToBeClickable(driver, user_details);
		user_details.click();
		waitForElementToBeClickable(driver, account_details);
		account_details.click();
		Assert.assertEquals(user_role.getText(), prop.getProperty("role"));
		System.out.println("Super Admin role verifed successfully");
		//ExtentTestManager.getTest().log(Status.PASS, "Super Admin role verifed successfully");
		close_btn.click();
	}

	// This method selects the correct environment tile from dashboard based on the testing environment
	public Solutions selectEnvironment() {

		if (prop.getProperty("environment").equalsIgnoreCase("playground")) {
			waitForElementToBeClickable(driver, terraform_env);
			terraform_env.click();
			System.out.println("Playground environment selected");
			//ExtentTestManager.getTest().log(Status.PASS, "Playground environment selected");
		} else if (prop.getProperty("environment").equalsIgnoreCase("dev")) {
			waitForElementToBeClickable(driver, dev_env);
			dev_env.click();
			//ExtentTestManager.getTest().log(Status.PASS, "Dev environment selected");
			System.out.println("Dev environment selected");
		} else if (prop.getProperty("environment").equalsIgnoreCase("stage")) {
			waitForElementToBeClickable(driver, stage_env);
			stage_env.click();
			//ExtentTestManager.getTest().log(Status.PASS, "Stage environment selected");
			System.out.println("Stage environment selected");
		} else if (prop.getProperty("environment").equalsIgnoreCase("prod")) {
			waitForElementToBeClickable(driver, prod_env);
			prod_env.click();
			//ExtentTestManager.getTest().log(Status.PASS, "Production environment selected");
			System.out.println("Production environment selected");
		} else if (prop.getProperty("environment").equalsIgnoreCase("preview")) {
			waitForElementToBeClickable(driver, preview_env);
			preview_env.click();
			//ExtentTestManager.getTest().log(Status.PASS, "Preview environment selected");
      System.out.println("Preview environment selected");
		}
		return new Solutions();
	}
}
