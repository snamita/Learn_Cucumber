package util;
import java.util.Random;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import extentreport.ExtentTestManager;

public class OdinFunctions {

	public static void PolygonAnnotation(WebDriver driver, WebElement AnnotatedPath, int annotationCount,
			WebElement annSubmit) {
		try {
			Actions act = new Actions(driver);
			int width = AnnotatedPath.getSize().getWidth();
			int height = AnnotatedPath.getSize().getHeight();
			Random rand = new Random();
			{
				int x = rand.nextInt(width / 2) + annotationCount;
				int y = rand.nextInt(height / 2) + annotationCount;
				act.moveToElement(AnnotatedPath).moveByOffset(x - 2, y - 10).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 25, y - 125).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 30, y - 150).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 100, y - 180).click().perform();
				act.sendKeys("E").build().perform();
				act.sendKeys("R").build().perform();
				annSubmit.click();
				ExtentTestManager.getTest().log(Status.PASS, "Annotation created");
				System.out.println("Annotation created");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Annotation not created");
		}
	}

	public static void brushAnnotation(WebDriver driver, WebElement AnnotatedPath, int annotationCount,
			WebElement annSubmit) {
		try {
			Actions act = new Actions(driver);
			int width = AnnotatedPath.getSize().getWidth();
			int height = AnnotatedPath.getSize().getHeight();
			Random rand = new Random();
			{
				int x = rand.nextInt(width / 2) + annotationCount;
				int y = rand.nextInt(height / 2) + annotationCount;

				for (int k = 1; k < 100; k = k + 10) {
					act.clickAndHold(AnnotatedPath).moveByOffset(x + annotationCount, y + k + annotationCount).build().perform();

				}
				act.release().build().perform();
				act.sendKeys("E").build().perform();
				if (annSubmit.isDisplayed())
					annSubmit.click();
				ExtentTestManager.getTest().log(Status.PASS, "Annotation created");
				System.out.println("Annotation created");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Annotation not created");
		}
	}

	public static void lassoAnnotation(WebDriver driver, WebElement AnnotatedPath, int annotationCount,
			WebElement annSubmit) {
		try {
			Actions act = new Actions(driver);
			int width = AnnotatedPath.getSize().getWidth();
			int height = AnnotatedPath.getSize().getHeight();
			Random rand = new Random();
			{
				int x = rand.nextInt(width / 2) + annotationCount;
				int y = rand.nextInt(height / 2) + annotationCount;
				for (int k = 1; k < 25; k = k + 5) {
					for (int l = 50; l < 101; l = l + 50) {
						act.moveToElement(AnnotatedPath).click()
								.moveByOffset(x + annotationCount, y - k + annotationCount)
								.moveByOffset(x + annotationCount, y + annotationCount - l).build().perform();
					}
				}
				act.sendKeys("E").build().perform();
				act.sendKeys("R").build().perform();
				if (annSubmit.isDisplayed())
					annSubmit.click();
				ExtentTestManager.getTest().log(Status.PASS, "Annotation created");
				System.out.println("Annotation created");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Annotation not created");
		}
	}
}
