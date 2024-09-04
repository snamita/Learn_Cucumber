package util;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import extentreport.ExtentTestManager;


public class LiDARFunctions {

	public void CuboidAnnotation(WebDriver driver, WebElement AnnotatedPath, int annotationCount) {
		try {
			int width = AnnotatedPath.getSize().getWidth();
			Random rand = new Random();
			{
				int x = rand.nextInt(width / 2) + annotationCount;
				Actions act = new Actions(driver);
				act.moveToElement(AnnotatedPath).moveByOffset(x , 0).click().perform();
				System.out.println("Cuboid Annotation DONE");
			}
		} catch (Exception e) {
			System.out.println("Unable to annotate Cuboid");
		}

	}
	public static void TwoDPolygonAnnotation(WebDriver driver, WebElement AnnotatedPath, int annotationCount) {
		try {
			Actions act = new Actions(driver);
			int width = AnnotatedPath.getSize().getWidth();
			int height = AnnotatedPath.getSize().getHeight();
			Random rand = new Random();
			{
				int x = rand.nextInt(width / 4) + annotationCount;
				int y = rand.nextInt(height / 4) + annotationCount;
				act.moveToElement(AnnotatedPath).moveByOffset(x - 50, y - 10).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 20, y - 50).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 100, y - 80).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 25, y - 100).click().perform();
				act.contextClick(AnnotatedPath).perform();
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "2DPolygon Annotation not created");
		}
	}
	
	public static void RectangleAnnotation(WebDriver driver, WebElement AnnotatedPath, int annotationCount) {
		try {
			Actions act = new Actions(driver);
			int width = AnnotatedPath.getSize().getWidth();
			int height = AnnotatedPath.getSize().getHeight();
			Random rand = new Random();
			{
				int x = rand.nextInt(width / 4) + annotationCount;
				int y = rand.nextInt(height / 4) + annotationCount;
				act.moveToElement(AnnotatedPath).moveByOffset(x - 2, y - 10).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 2, y - 50).click().perform();
				act.moveToElement(AnnotatedPath).moveByOffset(x - 30,y - 50).click().perform();
				act.contextClick(AnnotatedPath).perform();
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Rectangle Annotation not created");
		}
	}
	
	}