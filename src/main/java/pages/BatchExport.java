package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import extentreport.ExtentTestManager;
import com.aventstack.extentreports.Status;
import util.TestUtil;

public class BatchExport extends TestBase {

	int i = 1;
	Actions act = new Actions(driver);
	String _taskflowname = TestUtil.generateRandomTaskName();
	String batchCode = prop.getProperty("batchcode");

	// Object Repository
	@FindBy(xpath="(//label[@class='custom-control-label cursor-pointer ml-3 d-inline-flex'])[1]")
	WebElement first_batch;

	@FindBy(xpath="//button[contains(text(),'Request Export')]")
	WebElement export_btn;

	@FindBy(xpath="//button[contains(text(),'Page 1')]")
	WebElement pagination;

	@FindBy(xpath="//span[contains(text(),'Page 2')]")
	WebElement page2;
	
	@FindBy(xpath="//span[contains(text(),'Page 3')]")
	WebElement page3;

	@FindBy(xpath="//div/input[@placeholder='Search']")
	WebElement search_batch;

	@FindBy(xpath="//div/input[@placeholder='Search']/following::i")
	WebElement clear_search;

	@FindBy(xpath="//button[contains(text(),'Operator')]")
	WebElement node_filter;

	@FindBy(xpath="//li/a[contains(text(),'QC')]")
	WebElement QC;

	@FindBy(xpath="//button[contains(text(),'Ready to Export')]")
	WebElement ready_to_export;

	@FindBy(xpath="//a[contains(text(),'In Progress')]")
	WebElement inprogress;
	
	@FindBy(xpath="//div/span/label[text()='Refresh']")
	WebElement refresh_button;
	
	@FindBy(xpath="//div[contains(@class,'toastify')]")
	WebElement msgbox;

	// Initializing page objects
	public BatchExport() {
		PageFactory.initElements(driver, this);
	}
	
	//export new batch
	public void newSolutionOpExport() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		boolean displayed = false;
		do {
			try {
			displayed = first_batch.isDisplayed();
			ExtentTestManager.getTest().log(Status.PASS, "Batch Displayed");
			System.out.println("Batch Displayed");
			}catch (NoSuchElementException e) {
			refresh_button.click();
			System.out.println("Refresh button clicked");
			}
		}
		while(!displayed);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		first_batch.click();
		waitForElementToBeClickable(driver, export_btn);
		export_btn.click();
		ExtentTestManager.getTest().log(Status.PASS, "New Solution export requested");
		System.out.println("New Solution export requested");
		waitForElementToBeVisible(driver, msgbox);
	}
	//To check export feature for existing batch in OP tab
	public void existingOpExport(String batchcode) {
		waitForElementToBeClickable(driver, first_batch);
		first_batch.click(); //selects the first batch on the first page
		search_batch.sendKeys(batchcode); //search for a particular batch
		waitForElementToBeClickable(driver, selectbatchcode(batchcode));
		ExtentTestManager.getTest().log(Status.PASS, "BatchCode searched successfully");
		System.out.println("BatchCode searched successfully");
		selectbatchcode(batchcode).click(); //selects the searched batch
		clear_search.click(); //clears search
		ExtentTestManager.getTest().log(Status.PASS, "OP Batchcode Search has been cleared successfully");
		System.out.println("OP Batchcode Search has been cleared successfully");
		pagination.click();
		if(page3.isDisplayed()) {
			page3.click(); //navigates to page 3
			ExtentTestManager.getTest().log(Status.PASS, "Page3 is Present");
			System.out.println("Page3 is Present");
			waitForElementToBeClickable(driver, first_batch);
			first_batch.click(); //selects the 1st batch from page 3
		}	
		waitForElementToBeClickable(driver, export_btn);
		export_btn.click();
		waitForElementToBeVisible(driver, msgbox);
	}

	//To check export feature for existing batch in QC tab
	public void existingQcExport(String batchcode) {
		try {
		node_filter.click();
		QC.click();
		waitForElementToBeClickable(driver, first_batch);
		first_batch.click(); //selects the first batch on the first page
		search_batch.sendKeys(batchcode); //search for a particular batch
		waitForElementToBeClickable(driver, selectbatchcode(batchcode));
		ExtentTestManager.getTest().log(Status.PASS, "BatchCode searched successfully");
		System.out.println("BatchCode searched successfully");
		selectbatchcode(batchcode).click(); //selects the searched batch
		clear_search.click(); //clears search
		ExtentTestManager.getTest().log(Status.PASS, "QC Batchcode Search has been cleared successfully");
		System.out.println("QC Batchcode Search has been cleared successfully");
		pagination.click();
		ExtentTestManager.getTest().log(Status.PASS, "Pagination clicked");
		System.out.println("Pagination clicked");
		if(page2.isDisplayed()) {
			page2.click(); //navigates to page 2
			ExtentTestManager.getTest().log(Status.PASS, "Page2 has been clicked");
			System.out.println("Page2 has been clicked");
			waitForElementToBeClickable(driver, first_batch);
			first_batch.click(); //selects the 1st batch from page 2
			ExtentTestManager.getTest().log(Status.PASS, "Page2 Batch has been selected");
		}
		waitForElementToBeClickable(driver, export_btn);
		export_btn.click();
		waitForElementToBeVisible(driver, msgbox);
		ExtentTestManager.getTest().log(Status.PASS, "QC Export has been requested");
		System.out.println("QC Export has been requested");
		}catch(NoSuchElementException e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Unable to Request QC Export");
			System.out.println("Unable to Request QC Export");}
	}
	
	public WebElement selectbatchcode(String S) {
		WebElement batchcode = driver.findElement(By.xpath(String.format("//span[contains(text(),'"+S+"')]")));
		return batchcode;
	}

	public void checkFilter() {
		try {
		ready_to_export.click();
		inprogress.click();
		ExtentTestManager.getTest().log(Status.PASS, "In-Progress filter is working");
		System.out.println("In-Progress filter is working");
		}catch(NoSuchElementException e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Export page filter is not working");
			System.out.println("Export page filter is not working");}
	}
}
