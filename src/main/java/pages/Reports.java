package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import base.TestBase;
import extentreport.ExtentTestManager;

public class Reports extends TestBase {
	
	  JavascriptExecutor executor = (JavascriptExecutor) driver;

	  //Object Repository
	  @FindBy(xpath = "(//button[@class='btn btn-outline-theme-primary my-auto mr-2'])[1]" ) 
	  WebElement aggregated_download_button; //Aggregated report download
	 	
	  @FindBy(xpath = "(//*[contains(text(),'Node Wise Progress')])[1]" )
	  WebElement nw_report; // node wise report section
	  
	  @FindBy(xpath = "(//button[@class='btn btn-outline-theme-primary my-auto mr-2'])[1]" )
	  WebElement nw_progress_report_download; // node wise progress  report download
	  
	  @FindBy(xpath = "(//table)[2]//tr[1]/td[2]")
	  WebElement nw_operator; // node wise operator 
	   
	  @FindBy(xpath = "(//button[@class='btn btn-outline-theme-primary my-auto mr-2'])[3]" )
	  WebElement nw_batchwise_report_download;  // batch wise operator report download
	  
	  @FindBy(xpath = "//a[@class='nav-link font-weight-normal rounded-0 text-dark border-0 bg-grey-light']" )
	  WebElement nw_operator_wise_section;
	  
	  @FindBy(xpath = "//a[contains(text(),'Operator Node')]" )
	  WebElement nw_operator_node_back; // back to node wise section
	  
	  @FindBy(xpath = "(//table)[3]//tbody/tr/td[2]")
	  WebElement nw_taskwise;  // node wise >> Task wise report section 
	  
	  @FindBy(xpath = "(//button[@class='btn btn-outline-theme-primary my-auto mr-2'])[5]")
	  WebElement nw_taskwise_download; //node Task wise report download
	  
	  @FindBy(xpath = "(//button[@class='close pull-right my-auto py-0'])[3]")
	  WebElement nw_return; //node wise back to batch wise
	 
	  @FindBy(xpath = "(//button[@class='close pull-right my-auto py-0'])[2]")
	  WebElement nw_return_home; //node wise back to Op QC 
	  
	  //Node wise QC 
	  @FindBy(xpath = "(//table)[2]//tr[2]/td[2]" )
	  WebElement nw_qc_report;

	  @FindBy(xpath = "//a[contains(text(),'QC Node')]" )
	  WebElement nw_QC_node_back; // back to node wise section
	   
	  //Initializing page objects
	  public Reports() { 
		  PageFactory.initElements(driver, this); 
	  }
	 
	  // Methods
          public void aggregatedReport()   {
		waitForElementToBeClickable(driver, aggregated_download_button);
		executor.executeScript("arguments[0].click();", aggregated_download_button);
		ExtentTestManager.getTest().log(Status.PASS, "Downloaded Aggregated Report Succesfully");
		System.out.println("Downloaded Aggregated Report Succesfully");	
	  }		
		
	  public void nodeWiseOP() throws InterruptedException {
		waitForElementToBeClickable(driver, nw_report);
		executor.executeScript("arguments[0].click();", nw_report);
		waitForElementToBeClickable(driver, nw_progress_report_download);
		nw_progress_report_download.click();
		ExtentTestManager.getTest().log(Status.PASS, "Downloadeded Progress Report Succesfully");
		System.out.println("Downloadeded Progress Report Succesfully");
		waitForElementToBeClickable(driver, nw_operator);
		nw_operator.click();
		waitForElementToBeClickable(driver, nw_batchwise_report_download);
		nw_batchwise_report_download.click();
		ExtentTestManager.getTest().log(Status.PASS, "Downloaded Batch Wise  Report Succesfully");
		System.out.println("Downloaded Batch Wise  Report Succesfully");
		waitForElementToBeClickable(driver, nw_operator_wise_section);
		nw_operator_wise_section.click();
		Thread.sleep(1000);
		waitForElementToBeClickable(driver, nw_operator_node_back);
		nw_operator_node_back.click();
		waitForElementToBeClickable(driver,nw_taskwise);
		nw_taskwise.click();
		waitForElementToBeClickable(driver, nw_taskwise_download);
		executor.executeScript("arguments[0].click();", nw_taskwise_download);
		ExtentTestManager.getTest().log(Status.PASS, "Downloaded Task wise Report Succesfully");
		System.out.println("Downloaded Task wise Report Succesfully");
		Thread.sleep(1000);
		waitForElementToBeClickable(driver, nw_return);
		nw_return.click();
		waitForElementToBeClickable(driver, nw_return_home);
		nw_return_home.click();
		ExtentTestManager.getTest().log(Status.PASS, "Downloaded Node Wise OP Report Succesfully");
		System.out.println("Downloaded Node Wise OP Report Succesfully");
	  }
	
	  public void nodeWiseQC() throws InterruptedException{
		waitForElementToBeClickable(driver, nw_qc_report);
		nw_qc_report.click();
		System.out.println("Node-wise QC option clicked");
		waitForElementToBeClickable(driver, nw_batchwise_report_download);
		nw_batchwise_report_download.click();
		ExtentTestManager.getTest().log(Status.PASS, "Downloaded Batchwise Report Succesfully");
		System.out.println("Downloaded Batchwise Report Succesfully");
		waitForElementToBeClickable(driver, nw_operator_wise_section);
		nw_operator_wise_section.click();
		Thread.sleep(1000);
		waitForElementToBeClickable(driver, nw_QC_node_back);
		System.out.println("Node-wise oprator option clicked");
		nw_QC_node_back.click();
		waitForElementToBeClickable(driver,nw_taskwise);
		nw_taskwise.click();
		System.out.println("Node-wise Task option clicked");
		waitForElementToBeClickable(driver, nw_taskwise_download);
		executor.executeScript("arguments[0].click();", nw_taskwise_download);
		ExtentTestManager.getTest().log(Status.PASS, "Downloaded Task wise  Report Succesfully");
		System.out.println("Downloaded Task wise  Report Succesfully");
		Thread.sleep(1000);
		waitForElementToBeClickable(driver, nw_return);
		nw_return.click();
		waitForElementToBeClickable(driver, nw_return_home);
		nw_return_home.click();
		ExtentTestManager.getTest().log(Status.PASS, "Downloaded Node Wise QC report  Succesfully");
		System.out.println("Downloaded Node Wise QC report  Succesfully");
		
	}
}
