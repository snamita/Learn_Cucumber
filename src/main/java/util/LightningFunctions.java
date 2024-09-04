package util;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import extentreport.ExtentTestManager;

public class LightningFunctions {

	public void KeypointAnnotation(WebDriver driver, WebElement AnnotatedPath, int annotationCount) {
		try {
			int width = AnnotatedPath.getSize().getWidth();
			Random rand = new Random();
			{
				int x = rand.nextInt(width / 2) + annotationCount;
				Actions act = new Actions(driver);
				act.moveToElement(AnnotatedPath).moveByOffset(x - 2, 0).click().perform();
				System.out.println("Keypoint Annotation DONE");
				AnnotatedPath.click();
			}
		} catch (Exception e) {
			System.out.println("Unable to annotate Keypoint");
		}
	}

	public void LandMarkingAnnotation(WebDriver driver, WebElement AnnotatedPath, int annotationCount) {
		try {
			Actions act = new Actions(driver);
			int width = AnnotatedPath.getSize().getWidth();
			int height = AnnotatedPath.getSize().getHeight();
			Random rand = new Random();
			{
				int x = rand.nextInt(width) + annotationCount;
				int y = rand.nextInt(height) + annotationCount;
				act.moveToElement(AnnotatedPath).moveByOffset(x - 2, y - 10).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 25, y - 125).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 30, y - 150).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 100, y - 180).click().perform();
				System.out.println("DONE");
				AnnotatedPath.click();
				ExtentTestManager.getTest().log(Status.PASS, "Annotation created");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Unable to create annotation");
		}
	}

	public static void PolygonAnnotation(WebDriver driver, WebElement AnnotatedPath, int annotationCount) {
		try {
			Actions act = new Actions(driver);
			Thread.sleep(2000);
			int width = AnnotatedPath.getSize().getWidth();
			int height = AnnotatedPath.getSize().getHeight();
			Random rand = new Random();
			{
				int x = rand.nextInt(width / 2) + annotationCount;
				int y = rand.nextInt(height / 2) + annotationCount;
				System.out.println("x" + x + "y" + y);
				act.moveToElement(AnnotatedPath).moveByOffset(x - 2, y - 10).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 25, y - 125).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 30, y - 150).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 100, y - 180).click().perform();
				act.sendKeys("E").build().perform();
				System.out.println("DONE");
				AnnotatedPath.click();
			}
		} catch (Exception e) {
			System.out.println("Unable to annotate Polygon");
		}
	}

	public static void BBoxAnnotation(WebDriver driver, WebElement AnnotatedPath, int annotationCount) {
		try {
			Actions act = new Actions(driver);
			Thread.sleep(2000);
			int width = AnnotatedPath.getSize().getWidth();
			int height = AnnotatedPath.getSize().getHeight();
			Random rand = new Random();
			{
				int x = rand.nextInt(width / 2) + annotationCount;
				int y = rand.nextInt(height / 2) + annotationCount;
				System.out.println("x" + x + "y" + y);
				act.moveToElement(AnnotatedPath).moveByOffset(x - 20, y - 10).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 125, y - 100).click().perform();
				ExtentTestManager.getTest().log(Status.PASS, "Annotation created");
				AnnotatedPath.click();
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Unable to create annotation");
		}
	}
}
