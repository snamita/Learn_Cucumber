package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;
import base.TestBase;
import extentreport.ExtentTestManager;
import util.TestUtil;

public class Taskflows extends TestBase {

	Actions act = new Actions(driver);
	String _taskflowname = TestUtil.generateRandomTaskName();
	String _newtaskflowname = "New" + TestUtil.generateRandomTaskName();

	// Object Repository
	@FindBy(xpath = "//span[contains(text(),'New Taskflow')]")
	WebElement new_taskflow;

	@FindBy(xpath = "//button/span[contains(text(),'Job Builder')]")
	WebElement job_builder;

	@FindBy(xpath = "//div/div[1]/div/label/select")
	WebElement tool_dropdown;

	@FindBy(xpath = "//label/small[text()=' 1 OP ']")
	WebElement template_op;

	@FindBy(xpath = "//label/small[text()=' 1 OP + 1 QC ']")
	WebElement template_qc;

	@FindBy(xpath = "//label/small[text()=' 1 OP + 1 QC + 1 Super QC ']")
	WebElement template_superqc;

	@FindBy(css = "section > div:nth-child(2) > input")
	WebElement taskflow_name;

	@FindBy(css = "section > div:nth-child(3) > textarea")
	WebElement taskflow_desc;

	@FindBy(xpath = "//button/span[contains(text(),'Split button')]/ancestor::button")
	WebElement save_draft_btn;

	@FindBy(xpath = "//li/a[contains(text(),'Save as Draft')]")
	WebElement saveasdraft;

	@FindBy(xpath = "//div/button[contains(text(),'Publish Taskflow')]")
	WebElement publish_taskflow;

	@FindBy(css = "#NC1 > g > text")
	WebElement Operator;

	@FindBy(css = "#NC2 > g > text")
	WebElement QC;

	@FindBy(css = "#NC3 > g > text")
	WebElement SuperQC;

	@FindBy(xpath = "//div/h4[text()=' Node Details (Operator) ']")
	WebElement op_node_detail;

	@FindBy(xpath = "//div/h4[text()=' Node Details (QC) ']")
	WebElement qc_node_detail;

	@FindBy(xpath = "//div/h4[text()=' Node Details (Super QC) ']")
	WebElement superqc_node_detail;

	@FindBy(css = "div.modal-body > div:nth-child(2) > textarea")
	WebElement node_desc;

	@FindBy(xpath = "//app-taskflow-template-node-manage/div/div/div/div/select")
	WebElement recipe_dropdown;

	@FindBy(xpath = "//div/div[@class='row']/div[1]/div/select")
	WebElement deliverable_type;

	@FindBy(xpath = "//div/div[@class='row']/div[2]/div/select")
	WebElement deliverable_option;

	@FindBy(xpath = "//label/span[contains(text(),'Visualized Images')]")
	WebElement visualized_images;

	@FindBy(xpath = "//label/span[contains(text(),'Masked Images')]")
	WebElement masked_images;

	@FindBy(xpath = "//div/span/label[@for='revert-tasks']")
	WebElement revert_tasks;

	@FindBy(xpath = "//div/button[contains(text(),'Update Changes')]")
	WebElement update_changes;

	@FindBy(xpath = "//div/a/span[contains(text(),'Back to List')]")
	WebElement back2list;

	@FindBy(xpath = "//div/button[contains(text(),'Confirm')]")
	WebElement confirm_btn;

	@FindBy(xpath = "//div/button[contains(text(),'Cancel')]")
	WebElement cancel_btn;

	@FindBy(xpath = "//label/span[contains(text(),'Taskflow Id')]")
	WebElement taskflow_id;
	
	@FindBy(xpath = "//div/input[@placeholder='Enter to search from the list']")
	WebElement search_taskflow;

	@FindBy(xpath = "//div/button[@dropdowntoggle][contains(@class, 'btn-outline-theme-primary')]")
	WebElement taskflow_dropdown_toggle;

	// Initializing page objects
	public Taskflows() {
		PageFactory.initElements(driver, this);
	}

	// Methods
	public WebElement getdropdownwebelement(String S) {
		return driver.findElement(By.xpath(String.format("//li/a[contains(text() , '%s')]", S)));
	}

	public WebElement getsuccesselement(String S) {
		return driver.findElement(By.xpath(String.format("//*[text() = '%s']", S)));
	}
	
	public WebElement gettaskflowname(String S) {
		return driver.findElement(By.xpath(String.format("//tr/td//span[contains(text(), '%s')]", S)));		
	}
	
	public void selectLatestRecipe() {
		Select op = new Select(recipe_dropdown);
		int opLen = op.getOptions().size();
		op.selectByIndex(opLen - 1);
	}

	public void createNewTaskflow(String annotationtool) {
			waitForElementToBeClickable(driver, new_taskflow);
			new_taskflow.click();
			waitForElementToBeClickable(driver, tool_dropdown);
			try{
				selectannotationtool(annotationtool);
			}
			catch (StaleElementReferenceException e) {
				selectannotationtool(annotationtool);
			}
			waitForElementToBeVisible(driver, template_qc);
			if (prop.getProperty("taskflow_template").equalsIgnoreCase("OP")) {
				template_op.click();
				System.out.println("Template QC clicked");}
			else if (prop.getProperty("taskflow_template").equalsIgnoreCase("QC")) {
				template_qc.click();
				System.out.println("Template QC clicked");}
			else if (prop.getProperty("taskflow_template").equalsIgnoreCase("SuperQC")) {
				template_superqc.click();
				System.out.println("SuperQC clicked");}
			taskflow_name.sendKeys(_taskflowname);
			taskflow_desc.sendKeys("This is a test description");
			if (prop.getProperty("taskflow_template").equalsIgnoreCase("OP")) {
				waitForElementToBeClickable(driver, Operator);
				act.doubleClick(Operator).perform();
				waitForElementToBeVisible(driver, op_node_detail);
				selectLatestRecipe();
				TestUtil.logTestStep("PASS", "Latest Recipe Selected");
				Select deliverable = new Select(deliverable_type);
				deliverable.selectByIndex(1);
				TestUtil.logTestStep("PASS", "Delivery type selected");
				waitForElementToBeVisible(driver, deliverable_option);
				Select option = new Select(deliverable_option);
				option.selectByIndex(1);
				TestUtil.logTestStep("PASS", "Delivery option Selected");
				update_changes.click();
				waitForElementToBeInvisible(driver, update_changes);
			} else if (prop.getProperty("taskflow_template").equalsIgnoreCase("QC")) {
				waitForElementToBeClickable(driver, Operator);
				act.doubleClick(Operator).perform();
				waitForElementToBeVisible(driver, op_node_detail);
				selectLatestRecipe();
				TestUtil.logTestStep("PASS", "Latest Recipe Selected");
				Select deliverable = new Select(deliverable_type);
				deliverable.selectByIndex(1);
				TestUtil.logTestStep("PASS", "Delivery type selected");
				waitForElementToBeVisible(driver, deliverable_option);
				Select option = new Select(deliverable_option);
				option.selectByIndex(1);
				TestUtil.logTestStep("PASS", "Delivery option Selected");
				update_changes.click();
				System.out.println("Update changes clicked on QC");
				waitForElementToBeInvisible(driver, update_changes);
				act.doubleClick(QC).perform();
				System.out.println("QC button double clicked");
				waitForElementToBeVisible(driver, qc_node_detail);
				selectLatestRecipe();
				deliverable.selectByIndex(1);
				waitForElementToBeVisible(driver, deliverable_option);
				option.selectByIndex(1);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", revert_tasks);
				System.out.println("Revert enabled QC");
				update_changes.click();
				waitForElementToBeInvisible(driver, update_changes);
				TestUtil.logTestStep("PASS", "Changes Updated");
			} else if (prop.getProperty("taskflow_template").equalsIgnoreCase("SuperQC")) {
				waitForElementToBeClickable(driver, Operator);
				act.doubleClick(Operator).perform();
				System.out.println("SuperQC Selected");
				ExtentTestManager.getTest().log(Status.PASS, "SuperQC Selected");
				waitForElementToBeVisible(driver, op_node_detail);
				selectLatestRecipe();
				TestUtil.logTestStep("PASS", "Latest Recipe Selected");
				Select deliverable = new Select(deliverable_type);
				deliverable.selectByIndex(1);
				TestUtil.logTestStep("PASS", "Delivery type selected");
				waitForElementToBeVisible(driver, deliverable_option);
				Select option = new Select(deliverable_option);
				option.selectByIndex(1);
				TestUtil.logTestStep("PASS", "Delivery option Selected");
				update_changes.click();
				System.out.println("Update changes button clicked on OP");
				waitForElementToBeInvisible(driver, update_changes);
				act.doubleClick(QC).perform();
				System.out.println("Double clicked QC");
				waitForElementToBeVisible(driver, qc_node_detail);
				selectLatestRecipe();
				deliverable.selectByIndex(1);
				waitForElementToBeVisible(driver, deliverable_option);
				option.selectByIndex(1);
				System.out.println("Delivery option has been seleceted QC");
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", revert_tasks);
				System.out.println("Revert enabled QC");
				update_changes.click();
				System.out.println("QC node detail selected");
				waitForElementToBeInvisible(driver, update_changes);
				act.doubleClick(SuperQC).perform();
				waitForElementToBeVisible(driver, superqc_node_detail);
				selectLatestRecipe();
				deliverable.selectByIndex(1);
				System.out.println("SuperQC node detail selected");
				waitForElementToBeVisible(driver, deliverable_option);
				option.selectByIndex(1);
				System.out.println("Delivery option has been seleceted superQC");
				executor.executeScript("arguments[0].click();", revert_tasks);
				update_changes.click();
				System.out.println("Revert enabled");
				waitForElementToBeInvisible(driver, update_changes);
				TestUtil.logTestStep("PASS", "Changes Updated");
			}
			publish_taskflow.click();
			try{
				confirm_btn.click();
			}
			catch (ElementClickInterceptedException e) {
				confirm_btn.click();
			}
			System.out.println("New Taskflow Created : " + _taskflowname);
			waitForElementToBeVisible(driver, taskflow_id);
			back2list.click();
	}

	public void searchForTaskFlow(String searchtext) {
		waitForElementToBeVisible(driver,search_taskflow);
		search_taskflow.clear();
		if(searchtext.isEmpty())
			search_taskflow.sendKeys(_taskflowname);
		else 
			search_taskflow.sendKeys(searchtext);
		System.out.println("Taskflow search is going on");
		waitForElementToBeClickable(driver,taskflow_dropdown_toggle);
		taskflow_dropdown_toggle.click();
	}
	
	public void clickOnCloneTaskFlow() {
			waitForElementToBeClickable(driver, getdropdownwebelement("Clone Taskflow"));
			getdropdownwebelement("Clone Taskflow").click();
			System.out.println("Clone Taskflow button has been clicked");
			waitForElementToBeVisible(driver, getsuccesselement("Config successfully cloned"));
			System.out.println("Config successfully cloned");
			TestUtil.logTestStep("PASS", "Taskflow successfully cloned");
	}
	
	public void editTaskFlowAndMarkPublish() throws InterruptedException {
		waitForElementToBeClickable(driver, getdropdownwebelement("Edit Details"));
		getdropdownwebelement("Edit Details").click();
		waitForElementToBeClickable(driver,taskflow_name);
		Thread.sleep(3000);
		System.out.println("Taskflow modification started while cloning");
		taskflow_name.clear();
		taskflow_name.sendKeys(_newtaskflowname);
		taskflow_desc.clear();
		taskflow_desc.sendKeys("This is a Automation test description");
		publish_taskflow.click();
		System.out.println("Published button clicked");
		confirm_btn.click();
		System.out.println("Yes option clicked while publishing flow");
		TestUtil.logTestStep("PASS", "Cloned Task flow name is changed and successfully published");
		back2list.click();
	}
	
	public void verifyUpdatedDetailsDisplayed() {
		search_taskflow.clear();
		searchForTaskFlow(_newtaskflowname);
		if(gettaskflowname(_newtaskflowname).getText()!=null) {
			TestUtil.logTestStep("PASS", "Updated taskflow displayed in the list");
		}
		else	
			TestUtil.logTestStep("FAIL", "Taskflow not present in the list");
	}
	
	public Jobs openJobBuilder() {
			job_builder.click();
		return new Jobs();
	}
	
	public void selectannotationtool(String annotationtool) {
		if (annotationtool.equalsIgnoreCase("Lightning")) {
			Select tool = new Select(tool_dropdown);
			tool.selectByVisibleText(" iMerit 2D ");
			TestUtil.logTestStep("PASS", "Selected iMerit 2D");
		} else if (annotationtool.equalsIgnoreCase("Segmentation")) {
			Select tool = new Select(tool_dropdown);
			tool.selectByVisibleText(" iMerit Segmentation ");
			TestUtil.logTestStep("PASS", "Selected iMerit Segmentation");
		} else if (annotationtool.equalsIgnoreCase("Lidar")) {
			Select tool = new Select(tool_dropdown);
			tool.selectByVisibleText(" iMerit LiDAR ");
			TestUtil.logTestStep("PASS", "Selected iMerit LiDAR");
		}
	}
}
