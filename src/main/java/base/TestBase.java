package base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
		
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/config/config.properties");
			prop.load(ip);
			} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome") && prop.getProperty("mode").equalsIgnoreCase("headless")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless","--window-size=1920,1080", "--no-sandbox", "-disable-dev-shm-usage", "--remote-allow-origins=*");
			driver = WebDriverManager.chromedriver().capabilities(options).create();	
		}
		else if(browserName.equalsIgnoreCase("Chrome") && prop.getProperty("mode").equalsIgnoreCase("ui")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = WebDriverManager.chromedriver().capabilities(options).create();
		}
		driver.switchTo().defaultContent();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		if((prop.getProperty("environment")).equalsIgnoreCase("Dev"))
		{
			driver.get(prop.getProperty("dev_url"));
		}
		else if((prop.getProperty("environment")).equalsIgnoreCase("Playground"))
		{
			driver.get(prop.getProperty("playground_url"));
		}
		else if((prop.getProperty("environment")).equalsIgnoreCase("stage"))
		{
			driver.get(prop.getProperty("stage_url"));
		}
		else if((prop.getProperty("environment")).equalsIgnoreCase("preview"))
		{
			driver.get(prop.getProperty("preview_url"));
		}
	}
	
	public static boolean waitForElementToBeClickable(WebDriver driver, WebElement webelement) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(webelement));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public static void waitForElementToBeInvisible(WebDriver driver, WebElement webelement) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(webelement));
	}
	
	public static boolean waitForElementToBeVisible(WebDriver driver, WebElement webelement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(webelement));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
