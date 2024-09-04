package pages;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import base.TestBase;
import extentreport.ExtentTestManager;

public class JobDetails extends TestBase {

	// Object Repository
	@FindBy(xpath = "//ul/li/span[contains(text(),'New Import')]")
	WebElement new_import;

	@FindBy(xpath = "//app-job-overview/h4[contains(text(),'Manage Job')]")
	WebElement manage_job;

	@FindBy(xpath = "//label/small[contains(text(),'Upload zip')]")
	WebElement upload_zip;

	@FindBy(xpath = "//label/small[contains(text(),'Amazon S3')]")
	WebElement upload_s3;

	@FindBy(xpath = "//div/button[contains(text(),'Browse Files')]/ancestor::div/input")
	WebElement browse_files;

	@FindBy(xpath = "//span/label[contains(text(),'File Uploader')]")
	WebElement file_uploader;

	@FindBy(xpath = "//div/button[contains(text(),'Upload File')]")
	WebElement upload_file;

	@FindBy(xpath = "//button/span/label[contains(text(),'File upload done')]")
	WebElement upload_done;

	@FindBy(xpath = "//button/span[contains(text(),'Importer URL')]")
	WebElement import_url_button;

	@FindBy(xpath = "//li/a[contains(text(),'quickserve_uploads')]")
	WebElement s3root_url;

	@FindBy(xpath = "//label/input[@type='text']")
	WebElement s3_url;

	@FindBy(css = "li.list-group-item.pb-3 > div > label > small")
	WebElement by_folder;

	@FindBy(css = "li.list-group-item.pt-3.mt-1.border-0 > div > label > small")
	WebElement by_folder_limit;

	@FindBy(xpath = "//div/label/input[@type='number']")
	WebElement image_limit;

	@FindBy(xpath = "//div/button[contains(text(),'Save Configuration')]")
	WebElement save_config;

	@FindBy(xpath = "//li/span[contains(text(),'All Batches')]")
	WebElement all_batches;

	@FindBy(xpath = "//div/span/span[text()='Refresh']")
	WebElement refresh_button;

	@FindBy(css = "h6:nth-child(4) > span.font-weight-bolder.d-inline-flex > app-animated-digit > span")
	WebElement op_jobs;

	@FindBy(xpath = "//div/button[contains(text(),'Launch')]")
	WebElement launch_tool;

	@FindBy(xpath = "//span[contains(text(),'Batch Export')]")
	WebElement batch_export;

	@FindBy(xpath = "//span[text()=' Batch Code ']")
	WebElement batchcode_row;
	
	@FindBy(xpath = "//li/span[contains(text(),'Aggregated Batch Time')]")
	WebElement aggregate_batch;

	// Initializing page objects
	public JobDetails() {
		PageFactory.initElements(driver, this);
	}

	// Methods
	public void uploadZipFile() throws InterruptedException {
			waitForElementToBeClickable(driver, manage_job);
			new_import.click();
			ExtentTestManager.getTest().log(Status.PASS, "New Import option has been clicked successfully");
			System.out.println("New Import option has been clicked successfully");
			upload_zip.click();
			ExtentTestManager.getTest().log(Status.PASS, "Upload Zip option clicked successfully");
			System.out.println("Upload Zip option clicked successfully");
			browse_files.sendKeys(System.getProperty("user.dir") + "/src/main/java/qs/qa/util/resolution2KImages.zip");
			waitForElementToBeVisible(driver, file_uploader);
			Thread.sleep(2000);
			upload_file.click();
			ExtentTestManager.getTest().log(Status.PASS, "Upload file has been clicked successfully");
			System.out.println("Upload file has been clicked successfully");
			waitForElementToBeVisible(driver, upload_done);
			if (prop.getProperty("uploadby").equalsIgnoreCase("folder with image limit")) {
				by_folder_limit.click();
				ExtentTestManager.getTest().log(Status.PASS, "Image limit option has been selected successfully");
				System.out.println("Image limit option has been selected successfully");
				image_limit.sendKeys(prop.getProperty("imagelimit"));
			} else if (prop.getProperty("uploadby").equalsIgnoreCase("folder")) {
				by_folder.click();
				ExtentTestManager.getTest().log(Status.PASS, "By Folder option has been selected successfully");
				System.out.println("By Folder option has been selected successfully");
			}
			save_config.click();
	}

	public void uploadFromS3Bucket() throws InterruptedException {
			waitForElementToBeClickable(driver, manage_job);
			new_import.click();
			ExtentTestManager.getTest().log(Status.PASS, "New Import option has been clicked successfully");
			System.out.println("New Import option has been clicked successfully");
			if (!upload_s3.isSelected())
			upload_s3.click();
			Thread.sleep(1000);
			ExtentTestManager.getTest().log(Status.PASS, "Upload S3 option clicked successfully");
			System.out.println("Upload S3 option clicked successfully");
			import_url_button.click();
			Thread.sleep(3000);
			s3root_url.click();
			Thread.sleep(3000);
			s3_url.sendKeys("Sample 13/");
			if (prop.getProperty("uploadby").equalsIgnoreCase("folder with image limit")) {
				by_folder_limit.click();
				ExtentTestManager.getTest().log(Status.PASS, "Image limit option has been selected successfully");
				System.out.println("Image limit option has been selected successfully");
				image_limit.sendKeys(prop.getProperty("imagelimit"));
			} else if (prop.getProperty("uploadby").equalsIgnoreCase("folder")) {
				by_folder.click();
				ExtentTestManager.getTest().log(Status.PASS, "By Folder option has been selected successfully");
				System.out.println("By Folder option has been selected successfully");
			}
			Thread.sleep(3000);
			save_config.click();
			Thread.sleep(3000);
	}

	public void launchOPtask() throws InterruptedException {
			all_batches.click();
			ExtentTestManager.getTest().log(Status.PASS, "Switch to All Batch module");
			System.out.println("Switch to All Batch module");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			boolean displayed = false;
			do {
				try {
					displayed = launch_tool.isDisplayed();
					ExtentTestManager.getTest().log(Status.PASS, "Launch tool button is visible");
					System.out.println("Launch tool button is visible");
				} catch (NoSuchElementException e) {
					refresh_button.click();
					ExtentTestManager.getTest().log(Status.PASS, "Refreshed button has been clicked");
					System.out.println("Refreshed button has been clicked");
				}
			} while (!displayed);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			launch_tool.click();
			ExtentTestManager.getTest().log(Status.PASS, "Launch tool button has been clicked");
			System.out.println("Launch tool button has been clicked");
			Thread.sleep(5000);
	}

	public BatchExport openExportBuilder() {
			batch_export.click();
			waitForElementToBeVisible(driver, batchcode_row);
			ExtentTestManager.getTest().log(Status.PASS, "Successfully switched to Export tab");
			System.out.println("Successfully switched to Export tab");
		return new BatchExport();
	}
	public Reports openReports() {
		aggregate_batch.click();
		return new Reports();
	}
}
