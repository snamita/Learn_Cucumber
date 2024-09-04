package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import base.TestBase;
import extentreport.ExtentTestManager;
import util.TestUtil;

public class Solutions extends TestBase {

	String _solutionname = TestUtil.generateRandomSolName();

	// Object Repository
	@FindBy(xpath = "//span[text()=' NAME ']")
	WebElement solname_row;

	@FindBy(xpath = "//button/i[contains(@class,'fa-plus')]")
	WebElement new_solution;

	@FindBy(xpath = "//div/input[@placeholder='Search']")
	WebElement search_solution;

	@FindBy(xpath = "//div/div[2]/input[@type='text']")
	WebElement solution_name;

	@FindBy(xpath = "//div[2]/textarea[@rows='4'][contains(@class,'form-control')]")
	WebElement solution_desc;

	@FindBy(xpath = "//button/span[contains(text(),'Save Changes')]")
	WebElement savechanges_btn;

	@FindBy(xpath = "//li/a/span[@class='my-auto']")
	WebElement recipe_generator;

	@FindBy(xpath = "//span[contains(text(),'Recipe Generator')]")
	WebElement recipeGen_link;

	@FindBy(xpath = "//span[contains(text(),'Manage Taskflows')]")
	WebElement taskflow_link;

	@FindBy(xpath = "//span[contains(text(),'Job Builder')]")
	WebElement jobBuilder_link;

	// Initializing page objects
	public Solutions() {
		PageFactory.initElements(driver, this);
	}

	// Methods
	public WebElement getSolutionDetail(String S) {
        WebElement solution = driver.findElement(
                By.xpath(String.format("//span[contains(text(),'%s')]/ancestor::tr/td[5]/div/div/button", S)));
        return solution;
    }
    
    public WebElement getSolutionName(String S) {
        WebElement solution = driver.findElement(
                By.xpath(String.format("//table/tbody/tr/td/span[contains(text(),'%s')]", S)));
        return solution;
    }
    
	// This method creates a new solution
	public void createNewSolution() {
			waitForElementToBeClickable(driver, new_solution);
			new_solution.click();
			System.out.println("New solution button has been clicked");
			waitForElementToBeClickable(driver, savechanges_btn);
			solution_name.sendKeys(_solutionname);
			solution_desc.sendKeys("This is description for test solution");
			waitForElementToBeClickable(driver, savechanges_btn);
			savechanges_btn.click();
			waitForElementToBeVisible(driver,getSolutionName(_solutionname));
			System.out.println("Solution form filled and submit button has been clicked ");
			ExtentTestManager.getTest().log(Status.PASS, "Solution created Successfully");
			System.out.println("New Solution Created : " + _solutionname);
	}

	// This method selects the newly created solution and navigate to the recipe generator of that solution
	public Recipes selectSolution() {
			waitForElementToBeClickable(driver, solname_row);
			search_solution.sendKeys(_solutionname);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully Searched existing Solution: "+_solutionname);
			System.out.println("Successfully Searched existing Solution: "+_solutionname);
			WebElement _solutiondetail = getSolutionDetail(_solutionname);
			waitForElementToBeClickable(driver, _solutiondetail);
			_solutiondetail.click();
			recipe_generator.click();
			System.out.println("Updated taskflow displayed in the list");
			ExtentTestManager.getTest().log(Status.PASS, "Updated taskflow displayed in the list");
		return new Recipes();
	}

	// This method selects an existing solution from the list and navigate to its recipe generator
	public Recipes selectExistingSolution(String solutionname) {
			waitForElementToBeClickable(driver, solname_row);
			search_solution.sendKeys(solutionname);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully Searched existing Solution");
			System.out.println("Successfully Searched existing Solution");
			WebElement _solutiondetail = getSolutionDetail(solutionname);
			waitForElementToBeClickable(driver, _solutiondetail);
			_solutiondetail.click();
			recipe_generator.click();
			ExtentTestManager.getTest().log(Status.PASS, "Recipe Generator of Existing solution selected suceessfully");
			System.out.println("Recipe Generator of Existing solution selected suceessfully");
		return new Recipes();
	}

	// This method selects an existing solution from the list and navigates to its job builder
	public Jobs selectJobBuilderForASolution(String solutionname) {
			waitForElementToBeClickable(driver, solname_row);
			search_solution.sendKeys(solutionname);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully Searched existing Solution");
			System.out.println("Successfully Searched existing Solution");
			WebElement _solutiondetail = getSolutionDetail(solutionname);
			waitForElementToBeClickable(driver, _solutiondetail);
			_solutiondetail.click();
			jobBuilder_link.click();
			ExtentTestManager.getTest().log(Status.PASS, "Jobbuilder selected suceessfully");
			System.out.println("Jobbuilder selected suceessfully");
		return new Jobs();
	}
	
}
