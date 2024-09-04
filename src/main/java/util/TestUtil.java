package util;

import java.util.Set;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import pages.Tasking;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import base.TestBase;
import extentreport.ExtentTestManager;
import pages.JobDetails;

public class TestUtil {

	static String parentwindow = null;
	private static String fileSeperator = System.getProperty("file.separator");

	public static String generateRandomSolName() {
		String _randomsolname = null;
		if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Lightning"))
			_randomsolname = "Test2DSolution" + RandomStringUtils.randomNumeric(3);
		else if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Segmentation"))
			_randomsolname = "TestSegSolution" + RandomStringUtils.randomNumeric(3);
		else if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Lidar"))
			_randomsolname = "TestLidarSolution" + RandomStringUtils.randomNumeric(3);
		return _randomsolname;
	}

	public static String generateRandomRecipeName() {
		String _randomrecipename = null;
		if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Lightning"))
			_randomrecipename = "2DConfig" + RandomStringUtils.randomNumeric(2);
		else if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Segmentation"))
			_randomrecipename = "SegConfig" + RandomStringUtils.randomNumeric(2);
		else if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Lidar"))
			_randomrecipename = "LidarConfig" + RandomStringUtils.randomNumeric(2);
		return _randomrecipename;
	}

	public static String generateRandomTaskName() {
		String _randomtaskflowname = null;
		if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Lightning"))
			_randomtaskflowname = "2DTask" + RandomStringUtils.randomNumeric(2);
		else if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Segmentation"))
			_randomtaskflowname = "SegTask" + RandomStringUtils.randomNumeric(2);
		else if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Lidar"))
			_randomtaskflowname = "LidarTask" + RandomStringUtils.randomNumeric(2);
		return _randomtaskflowname;
	}

	public static String generateRandomJobName() {
		String _randomjobname = null;
		if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Lightning"))
			_randomjobname = "2DJob" + RandomStringUtils.randomNumeric(2);
		else if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Segmentation"))
			_randomjobname = "SegJob" + RandomStringUtils.randomNumeric(2);
		else if (TestBase.prop.getProperty("annotationtool").equalsIgnoreCase("Lidar"))
			_randomjobname = "LidarJob" + RandomStringUtils.randomNumeric(2);
		return _randomjobname;
	}

	public static void logTestStep(String status, String S) {
		if (status == "PASS") {
			ExtentTestManager.getTest().log(Status.PASS, S);
			System.out.println(S);
		} else if (status == "FAIL") {
			ExtentTestManager.getTest().log(Status.FAIL, S);
			System.out.println(S);
		}
	}

	public static Tasking switchToTaskingWindow(WebDriver driver) {
		parentwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		for (String child : allwindows) {
			if (!parentwindow.equalsIgnoreCase(child))
				driver.switchTo().window(child);
		}
		return new Tasking();
	}

	public static JobDetails switchToQSWindow(WebDriver driver) {
		if (parentwindow != null)
			driver.switchTo().window(parentwindow);
		return new JobDetails();
	}

	public static void webelementScreenshot(WebDriver driver, WebElement element) throws IOException {
		String str = element.toString();
		String str1 = str.replaceAll("[^a-zA-Z0-9]", "");
		String strNew = str1.substring(54);
		System.out.println(strNew);
		Screenshot ss = new AShot().takeScreenshot(driver, element);
		System.out.println(System.getProperty("user.dir") + fileSeperator + "sceenshot");
		ImageIO.write(ss.getImage(), "png", new File(
				System.getProperty("user.dir") + fileSeperator + "curretScreenshot" + fileSeperator + strNew + ".png"));
	}

	public static void compareScreenshot(WebDriver driver, WebElement element, String expected) throws Exception {
		String str = element.toString();
		String str1 = str.replaceAll("[^a-zA-Z0-9]", "");
		String strNew = str1.substring(55);
		System.out.println(strNew);
		Screenshot actualimg = new AShot().takeScreenshot(driver);

		ImageIO.write(actualimg.getImage(), "png", new File(System.getProperty("user.dir") + fileSeperator
				+ "currentScreenshot" + fileSeperator + strNew + "_" + expected + ".png"));
		System.out.println(System.getProperty("user.dir") + fileSeperator + "curretScreenshot" + fileSeperator + strNew
				+ "_" + expected + ".png");
		BufferedImage actualImage = ImageIO.read(new File(System.getProperty("user.dir") + fileSeperator
				+ "currentScreenshot" + fileSeperator + strNew + "_" + expected + ".png"));
		System.out.println(System.getProperty("user.dir") + "/sceenshot/" + expected + ".png");
		BufferedImage expectedImage = ImageIO.read(new File(
				System.getProperty("user.dir") + fileSeperator + "screenshot" + fileSeperator + expected + ".png"));
		pixelwiseComparioson(actualImage, expectedImage);
		ImageDiffer imgdiff = new ImageDiffer();

		ImageDiff diff = imgdiff.makeDiff(expectedImage, actualImage).withDiffSizeTrigger(200);
		int size = diff.getDiffSize();
		if (size != 0) {
			File diffFile = new File(System.getProperty("user.dir") + fileSeperator + "ScreenshotDiff" + fileSeperator
					+ expected + ".png");
			ImageIO.write(diff.getMarkedImage(), "png", diffFile);
			if (diff.hasDiff()) {
				System.out.println("Image is different by makediff.");
			} else {
				System.out.println("Image is same by makediff");
			}
		}
	}

	public static void pixelwiseComparioson(BufferedImage img1, BufferedImage img2) throws IOException {

		int w1 = img1.getWidth();
		int w2 = img2.getWidth();
		int h1 = img1.getHeight();
		int h2 = img2.getHeight();
		if ((w1 != w2) || (h1 != h2)) {
			System.out.println("Both images should have same dimensions");
		} else {
			long diff = 0;
			for (int j = 0; j < h1; j++) {
				for (int i = 0; i < w1; i++) {
					// Getting the RGB values of a pixel
					int pixel1 = img1.getRGB(i, j);
					Color color1 = new Color(pixel1, true);
					int r1 = color1.getRed();
					int g1 = color1.getGreen();
					int b1 = color1.getBlue();
					int pixel2 = img2.getRGB(i, j);
					Color color2 = new Color(pixel2, true);
					int r2 = color2.getRed();
					int g2 = color2.getGreen();
					int b2 = color2.getBlue();
					// sum of differences of RGB values of the two images
					long data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
					diff = diff + data;

				}
			}
			System.out.println("diff:" + diff);
			double avg = diff / (w1 * h1 * 3);
			double percentage = (avg / 255) * 100;
			System.out.println("percentage:" + percentage);
			if (percentage == 0) {
				System.out.println("Image is same by method 1.");
			} else {
				System.out.println("Image is different by method 1.");
			}

		}
	}

	public static void moveSlider(WebElement mainSlider, WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		int sliderWidth = mainSlider.getSize().getWidth();
		System.out.println(sliderWidth);
		Actions moveSlider = new Actions(driver);
		moveSlider.moveToElement(mainSlider, ((sliderWidth) / 10), 0).click();
		moveSlider.build().perform();
		Thread.sleep(1000);
	}

}
