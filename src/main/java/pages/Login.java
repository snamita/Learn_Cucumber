package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import base.TestBase;
import extentreport.ExtentTestManager;


public class Login extends TestBase{
	
	//Object Repository
	@FindBy(name="fname")
	WebElement firstname;

	@FindBy(name="lname")
	WebElement lastname;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="empCode")
	WebElement empcode;
	
	@FindBy(xpath="//label[@for='qs']/span")
	WebElement qs_scoperadio;
	
	@FindBy(xpath="//div/input[@id='impp']")
	WebElement impp_scoperadio;
	
	@FindBy(xpath="//div/span[@class='dropdown-btn']")
	WebElement roledropdwn;
	
	@FindBy(xpath="//ul/li/input[@aria-label='Power User']/following-sibling::div")
	WebElement poweruser_option;
	
	@FindBy(xpath="//ul/li/input[@aria-label='Super Admin']/following-sibling::div")
	WebElement superadmin_option;
	
	@FindBy(xpath="//ul/li/input[@aria-label='QS Collaborator']/following-sibling::div")
	WebElement collaborator_option;
	
	@FindBy(xpath="//button/span")
	WebElement loginbtn;

	//Initializing page objects
	public Login() {
		PageFactory.initElements(driver, this);
	}

	//Methods
	public Dashboard qsLogin(String fname, String lname,String emailId,String emp_code) throws InterruptedException{
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(emailId);
		empcode.sendKeys(emp_code);
		qs_scoperadio.click();
		roledropdwn.click();
		if(prop.getProperty("role").equalsIgnoreCase("Super Admin"))
		{
			superadmin_option.click();
		//	ExtentTestManager.getTest().log(Status.PASS, "Super Admin option has been selected");
			System.out.println("Super Admin option has been selected");
		}
		else if(prop.getProperty("role").equalsIgnoreCase("Power User"))
		{
			poweruser_option.click();
		//	ExtentTestManager.getTest().log(Status.PASS, "Power User option has been selected");
			System.out.println("Power User option has been selected");
		}
		else if(prop.getProperty("role").equalsIgnoreCase("QS Collaborator"))
		{
			collaborator_option.click();
		//	ExtentTestManager.getTest().log(Status.PASS, "QS Collaborator option has been selected");
			System.out.println("QS Collaborator option has been selected");
		}
	    roledropdwn.click();
	    Thread.sleep(10000);
		loginbtn.click();
		
	//	ExtentTestManager.getTest().log(Status.PASS, "Login button has been clicked");
		System.out.println("Login button has been clicked");
		return new Dashboard();
	}
}
