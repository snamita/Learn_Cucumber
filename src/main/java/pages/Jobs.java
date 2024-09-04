package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import base.TestBase;
import extentreport.ExtentTestManager;
import util.TestUtil;

public class Jobs extends TestBase {

	String _jobname = TestUtil.generateRandomJobName();
	

	// Object Repository
	@FindBy(xpath = "//div/ button[contains(text(),'New Job')]")
	WebElement new_job;

	@FindBy(xpath = "//button[contains(.,'Select from List ')]")
	WebElement select_taskflow;

	@FindBy(xpath = "//div/input[contains(@placeholder,'Annotation')]")
	WebElement job_name;

	@FindBy(xpath = "//div/textarea[contains(@placeholder,'computer vision')]")
	WebElement job_desc;

	@FindBy(xpath = "//div/button[contains(text(),'Save Job Details')]")
	WebElement save_job;

	@FindBy(xpath = "//ul/li/a[contains(text(),'View Details')]")
	WebElement view_details;

	@FindBy(xpath = "//span[text()=' JOB NAME ']")
	WebElement jobname_row;

	@FindBy(xpath = "//div/input[@placeholder='Search']")
	WebElement search_job;

	@FindBy(xpath = "//button[contains(text(),'Page 1')]")
	WebElement pagination;

	// Initializing page objects
	public Jobs() {
		PageFactory.initElements(driver, this);
	}

	// Methods
	public WebElement selecttaskflow(String S) {
		WebElement taskflow = driver.findElement(By.xpath(String.format("//ul[contains(@class,'dropdown')]/li/a["+S+"]")));
		return taskflow;
	}

	public WebElement jobdetailbutton(String S) {
		WebElement jobdetail = driver.findElement(By.xpath(String.format("//tbody/tr/td[2]/h6[text()=' "+S+" ']//parent::td/following-sibling::td/div/button/i[@class='my-auto fas fa-cog']")));
		return jobdetail;
	}

	public WebElement pickuplatesttaskflow() {
		List<WebElement> taskflows;
		taskflows = driver.findElements(By.xpath(String.format("//ul[contains(@class,'dropdown')]/li/a")));
		int optionCount = taskflows.size();
		System.out.println(optionCount);
		WebElement taskflow = driver.findElement(By.xpath(String.format("(//ul[contains(@class,'dropdown')]/li/a)["+optionCount+"]")));
		return taskflow;
	}

	public JobDetails createNewJob() {
		
			waitForElementToBeClickable(driver, new_job);
			new_job.click();
			System.out.println("New job button has been clicked");
			select_taskflow.click();
			WebElement _taskflow = pickuplatesttaskflow();
			_taskflow.click();
			job_name.sendKeys(_jobname);
			job_desc.sendKeys("This is a test job description");
			save_job.click();
			System.out.println("New Job Created : " + _jobname);
			ExtentTestManager.getTest().log(Status.PASS, "Job has been created");
			System.out.println("Job has been created");
		return new JobDetails();
	}

	public JobDetails selectExisitingJob(String jobname) {
			waitForElementToBeClickable(driver, pagination);
			search_job.sendKeys(jobname);
			jobdetailbutton(jobname).click();
			view_details.click();
			ExtentTestManager.getTest().log(Status.PASS, "Existing Job has been fetched");
			System.out.println("Existing Job has been fetched");
		return new JobDetails();

	}
}
