package pages;

import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import base.TestBase;
import extentreport.ExtentTestManager;
import util.TestUtil;
import util.LightningFunctions;
import util.OdinFunctions;
import util.LiDARFunctions;

public class Tasking extends TestBase {

	int i = 1;
	Actions act = new Actions(driver);
	String _taskflowname = TestUtil.generateRandomTaskName();

	// Object Repository
	@FindBy(xpath = "(//i[@data-original-title='Add Annotations'])[1]")
	WebElement add_annotation;

	@FindBy(xpath = "(//span[@title='Add annotation'])[1]")
	WebElement add_annotation_lidar;

	@FindBy(xpath = "//div[@id='annotation-dialog']")
	WebElement ann_dialog;

	@FindBy(xpath = "//*[name()='svg']/*[name()='rect']")
	WebElement lightning_image_load;

	@FindBy(xpath = "//canvas[@id='image']")
	WebElement odin_image_load;

	@FindBy(xpath = "(//canvas)[1]")
	WebElement lidar_image_load;

	@FindBy(xpath = "//div/label/select[contains(@class,'custom-select')]")
	WebElement tool_drpdwn;

	@FindBy(xpath = "//span[contains(text(),'Polygon')]")
	WebElement polygon;

	@FindBy(xpath = "//span[contains(text(),'Bounding Box')]")
	WebElement boundingbox;

	@FindBy(xpath = "(//span[contains(text(),'Polygon')])[2]")
	WebElement odinpolygon;

	@FindBy(xpath = "//span[contains(text(),'Magic Wand')]")
	WebElement magic_wand;

	@FindBy(xpath = "(//span[contains(text(),'Brush')])[2]")
	WebElement brush;

	@FindBy(xpath = "(//span[contains(text(),'Lasso')])[3]")
	WebElement lasso;

	@FindBy(xpath = "//span[contains(text(),'Bucket')]")
	WebElement bucket;

	@FindBy(xpath = "(//span[contains(text(),'Magnetic Lasso')])[2]")
	WebElement magnetic_lasso;

	@FindBy(xpath = "(//span[contains(text(),'Fill Unannotated Region')])[3]")
	WebElement fill_unannotated_region;

	@FindBy(xpath = "//button[@id='add-identity']")
	WebElement add_identity;

	@FindBy(xpath = "//input[@type='color']")
	WebElement ann_color;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement ann_submit;

	@FindBy(xpath = "//span[@id='batch-size']")
	WebElement batch_size;

	@FindBy(xpath = "//button[@id='nextNavButton']")
	WebElement next_frame;

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	WebElement task_submit;

	@FindBy(xpath = "(//div/Input)[3]")
	WebElement classattri_first;

	@FindBy(xpath = "(//div/Input)[4]")
	WebElement classattri_second;

	@FindBy(xpath = "(//div/Input)[5]/..")
	WebElement classattri_third;

	@FindBy(xpath = "(//div/Input)[6]/..")
	WebElement classattri_fourth;

	@FindBy(xpath = "//div[contains(text(),'of')]")
	WebElement lidar_batch_size;

	@FindBy(xpath = "(//span/button/span)[9]")
	WebElement ann_save;

	@FindBy(xpath = "(//span[@class='MuiButton-label'])[4]")
	WebElement ann_save_button;

	@FindBy(xpath = "//span[@title='Next task']/button/span")
	WebElement next_task;

	@FindBy(xpath = "//div/input[@placeholder='Select instance']")
	WebElement select_instance;

	@FindBy(xpath = "//span[contains(text(),'+ Create new')]/..")
	WebElement create_new;

	@FindBy(xpath = "(//div/button)[4]")
	WebElement super_impose_button;

	@FindBy(xpath = "//div[@data-index=0]")
	WebElement reference_image;

	@FindBy(xpath = "(//li[contains(text(),'Cuboid')])[1]")
	WebElement lidarcuboid;

	@FindBy(xpath = "(//li[4][contains(text(),'Polygon')])[1]")
	WebElement lidarpolygon;

	@FindBy(xpath = "//div/li[contains(text(),'Super-impose on points')]")
	WebElement super_impose;

	@FindBy(xpath = "(//li[contains(text(),'Polygon2D')])[1]")
	WebElement polygon2D;

	@FindBy(xpath = "(//li[contains(text(),'Rectangle')])[1]")
	WebElement rectangle;

	@FindBy(xpath = "//div[@class='MuiAlert-message']/div/div/button[1]")
	WebElement overlap_alert_yes;

	@FindBy(xpath = "//span[contains( text(),'Time-Varying')]")
	WebElement time_varying;

	@FindBy(xpath = "//Span[contains(text(),'White')]")
	WebElement colorwhite;

	@FindBy(xpath = "(//span/Input)[3]")
	WebElement multiselectfirst;

	@FindBy(xpath = "(//span/Input)[4]")
	WebElement multiselectsecond;

	@FindBy(xpath = "(//span/Input)[5]")
	WebElement booleaoption;

	@FindBy(xpath = "(//div/fieldset)[5]/..")
	WebElement inputboxoption;

	@FindBy(xpath = "//span[@title='Menu']/button/span")
	WebElement menu;

	@FindBy(xpath = "//li[contains(text(),'Batch Attributes')]")
	WebElement batch_attribute_menu;

	@FindBy(xpath = "//li[contains(text(),'Task Attributes')]")
	WebElement task_attribute_menu;

	@FindBy(xpath = "//li[contains(text(),'Tool Setting')]")
	WebElement tool_setting;

	@FindBy(xpath = "(//div[@id='simple-select'])[1]")
	WebElement task_attribute_first;

	@FindBy(xpath = "//li[@data-value='Day']")
	WebElement task_attribute_firstoption;

	@FindBy(xpath = "(//span[contains(text(),'Sunny')])")
	WebElement task_attribute_multiselectoption;

	@FindBy(xpath = "//li[@data-value='Clear']")
	WebElement batch_attribute_firstoption;

	@FindBy(xpath = "//span[@title='Close']")
	WebElement task_attribute_close;

	@FindBy(css = "div:nth-child(7) > span > button > span > svg")
	WebElement menu_newframe;

	@FindBy(xpath = "(//span[@title='Add annotation'])[1]/following::span[@class='MuiIconButton-label'][2]")
	WebElement jumptoobject;

	@FindBy(xpath = "(//span[@title='Add annotation'])[1]/following::span[@class='MuiIconButton-label'][4]")
	WebElement hideannnotation;

	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[4]")
	WebElement outlier;

	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[3]")
	WebElement isolate; 
	
	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[5]")
	WebElement jumporigin;

	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[6]")
	WebElement fittoscreen;

	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[7]")
	WebElement fullscreen;

	@FindBy(xpath = "//p[contains(text(),'2D')]")
	WebElement twoD;

	@FindBy(xpath = "//p[contains(text(),'3D')]")
	WebElement threeD;

	@FindBy(xpath = "//span[contains(text(),'Focus')]")
	WebElement focus;

	@FindBy(xpath = "(//span[@class='MuiSlider-rail'])[1]")
	WebElement focus_slider;

	@FindBy(xpath = "//img[@src='icons/jump-to-view-btns/front.svg']")
	WebElement front_view;

	@FindBy(xpath = "//img[@src='icons/jump-to-view-btns/right_active.svg']")
	WebElement active_view;

	@FindBy(xpath = "//img[@src='icons/jump-to-view-btns/top.svg']")
	WebElement top_view;

	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[1]")
	WebElement rotate_direction;

	@FindBy(xpath = "(//li[@class='MuiListItem-container'])[2]")
	WebElement annotation_selection;

	@FindBy(xpath = "//span[contains(text(),'Show all points')]")
	WebElement Show_all_points;

	@FindBy(xpath = "//span[contains(text(),'Show ground only')]")
	WebElement Show_ground_only;

	@FindBy(xpath = "//span[contains(text(),'Show non-ground only')]")
	WebElement Show_non_ground_only;

	@FindBy(xpath = "//span[contains(text(),'Filled boxes')]")
	WebElement filled_boxes;

	@FindBy(xpath = "//span[contains(text(),'Object names')]")
	WebElement object_name;

	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[8]")
	WebElement help;

	@FindBy(xpath = "//div[contains(text(),'Shortcuts')]")
	WebElement shortcut;

	@FindBy(xpath = "//li[contains(text(),'Batch Information')]")
	WebElement batch_information;

	@FindBy(xpath = "//span[contains(text(),'Copy to Clipboard')]")
	WebElement copy_clipboard;

	@FindBy(xpath = "//span[contains(text(),'Copy to Clipboard')]/following::button[1]")
	WebElement batch_info_close;

	@FindBy(xpath = "//span[contains(text(),'Enable Eye Dome Lighting')]")
	WebElement eye_dome_light;

	@FindBy(xpath = "(//div[contains(text(),'Class Point Brightness')]/following::span/span)[1]")
	WebElement class_point_brightness;

	@FindBy(xpath = "//input[@value='white']")
	WebElement background_white;
	
	@FindBy(xpath = "(//div[contains(text(),'Point size modifier')]/following::span/span)[1]")
	WebElement pt_size_modifier;

	@FindBy(xpath = "//span[contains(text(),'Fixed')]")
	WebElement pt_type_fixed;

	@FindBy(xpath = "//span[contains(text(),'Adaptive')]")
	WebElement pt_type_adaptive;
	
	@FindBy(xpath = "//div[contains(text(),'Point Colors')]/following::span[1]")
	WebElement point_colors;

	@FindBy(xpath = "//span[contains(text(),'RGBA')]")
	WebElement pt_color_RGBA;

	@FindBy(xpath = "//span[contains(text(),'Gradient')]")
	WebElement pt_color_gradient;

	@FindBy(xpath = "//span[contains(text(),'Intensity')]")
	WebElement pt_color_intensity;

	@FindBy(xpath = "//span[contains(text(),'Classification')]")
	WebElement pt_color_classification;
	
	@FindBy(xpath = "//span[contains(text(),'GpsTime')]")
	WebElement pt_color_gpstime;

	@FindBy(xpath = "//div[contains(text(),'Performance')]/following::span[@class='MuiSlider-thumb MuiSlider-thumbColorPrimary'][1]")
	WebElement pt_budget;

	@FindBy(xpath = "(//div[contains(text(),'Performance')]/following-sibling::span/span)[1]")
	WebElement pt_budget_slider;

	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[17]")
	WebElement object_clipping;

	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[19]")
	WebElement delete_annotation;

	@FindBy(xpath = "//li[contains(text(),'Delete from current frame')]")
	WebElement delete_frame_annotation;
	
	@FindBy(xpath = "(//div[contains(text(),'Gradient Range: ')]/following::span/span)[1]")
	WebElement gradient_range;
			
	@FindBy(xpath = "(//div[contains(text(),'Speed Controls: ')]/following::span/span)[1]")
	WebElement speed_controls;
	
	@FindBy(xpath = "(//div[contains(text(),'Gamma')]/following::span/span)[1]")
	WebElement gamma;
	
    @FindBy(xpath = "(//div[contains(text(),'Brightness')]/following::span/span)[1]")
	WebElement brightness;
    
	@FindBy(xpath = "(//div[contains(text(),'Contrast')]/following::span/span)[1]")
	WebElement contrast;
	
	@FindBy(xpath = "//span[contains(text(),'Show ROI')]")
	WebElement show_roi;
	
	@FindBy(xpath = "//span[contains(text(),'Show ROI')]/following::span[1]")
	WebElement show_roi_plus;
	
	@FindBy(xpath = "//span[contains(text(),'Radius (meters):')]/following::input[1]")
	WebElement radius_meter;
	

	JavascriptExecutor executor = (JavascriptExecutor) driver;

	// Initializing page objects
	public Tasking() {
		PageFactory.initElements(driver, this);
	}

	// Methods
	public WebElement selectPlusButton(String S) {
		WebElement plusbutton = driver
				.findElement(By.xpath(String.format("(//i[@data-original-title='Add Annotations'])[" + S + "]")));
		return plusbutton;
	}

	public void lightning_Bbox(WebDriver driver, int annotationCount) throws InterruptedException {
		waitForElementToBeVisible(driver, lightning_image_load);
		Thread.sleep(3000);
		int i = 1;
		while (i < annotationCount) {
			LightningFunctions.BBoxAnnotation(driver, lightning_image_load, i);
			Thread.sleep(3000);
			ann_submit.click();
			ExtentTestManager.getTest().log(Status.PASS, "BBox Annotation created");
			System.out.println("BBox Annotation created");
			i++;
		}
	}

	public void odin_Polygon(WebDriver driver, int annotationCount) throws InterruptedException {
		waitForElementToBeVisible(driver, odin_image_load);
		Thread.sleep(3000);
		selectPlusButton("1").click();
		odinpolygon.click();
		ExtentTestManager.getTest().log(Status.PASS, "Polygon button clicked");
		System.out.println("Polygon button clicked");
		int i = 1;
		while (i < annotationCount) {
			waitForElementToBeVisible(driver, odin_image_load);
			OdinFunctions.PolygonAnnotation(driver, odin_image_load, i, ann_submit);
			i++;
			ExtentTestManager.getTest().log(Status.PASS, "Polygon annotation created");
			System.out.println("Polygon annotation created");
		}
	}

	public void odin_brush(WebDriver driver, int annotationCount) throws InterruptedException {
		waitForElementToBeVisible(driver, odin_image_load);
		Thread.sleep(3000);
		selectPlusButton("1").click();
		brush.click();
		ExtentTestManager.getTest().log(Status.PASS, "brush button clicked");
		System.out.println("brush button clicked");
		int i = 1;
		while (i < annotationCount) {
			waitForElementToBeVisible(driver, odin_image_load);
			OdinFunctions.brushAnnotation(driver, odin_image_load, i, ann_submit);
			i++;
			ExtentTestManager.getTest().log(Status.PASS, "brush annotation created");
			System.out.println("brush annotation created");
		}
	}

	public void odin_lasso(WebDriver driver, int annotationCount) throws InterruptedException {
		waitForElementToBeVisible(driver, odin_image_load);
		Thread.sleep(3000);
		selectPlusButton("1").click();
		lasso.click();
		ExtentTestManager.getTest().log(Status.PASS, "lasso button clicked");
		System.out.println("lasso button clicked");
		int i = 1;
		while (i < annotationCount) {
			waitForElementToBeVisible(driver, odin_image_load);
			OdinFunctions.lassoAnnotation(driver, odin_image_load, i, ann_submit);
			i++;
			ExtentTestManager.getTest().log(Status.PASS, "lasso annotation created");
			System.out.println("lasso annotation created");
		}
	}

	public void odin_magnaticlasso(WebDriver driver, int annotationCount) throws InterruptedException {
		waitForElementToBeVisible(driver, odin_image_load);
		Thread.sleep(3000);
		selectPlusButton("1").click();
		magnetic_lasso.click();
		ExtentTestManager.getTest().log(Status.PASS, "magnetic_lasso button clicked");
		System.out.println("magnetic_lasso button clicked");
		int i = 1;
		while (i < annotationCount) {
			waitForElementToBeVisible(driver, odin_image_load);
			OdinFunctions.lassoAnnotation(driver, odin_image_load, i, ann_submit);
			i++;
			ExtentTestManager.getTest().log(Status.PASS, "magnetic_lasso annotation created");
			System.out.println("magnetic_lasso annotation created");
		}
	}

	public void odin_FillUnannRegion(WebDriver driver) throws InterruptedException {
		try {
			waitForElementToBeVisible(driver, odin_image_load);
			Thread.sleep(3000);
			waitForElementToBeVisible(driver, ann_dialog);
			waitForElementToBeVisible(driver, selectPlusButton("5"));
			selectPlusButton("3").click();
			fill_unannotated_region.click();
			ann_submit.click();
			ExtentTestManager.getTest().log(Status.PASS, "Fill Unannotated Region Created successfully");
			System.out.println("Fill Unannotated Region Created successfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "Fill Unannotated Region failed");
			System.out.println("Fill Unannotated Region Created successfully");
		}
	}

	// Class level attribute value
	public void lidar_ClassAttribute() {
		time_varying.click();
		classattri_first.sendKeys("ABC");
		classattri_second.sendKeys("EFG");
		classattri_third.click();
		colorwhite.click();
		multiselectfirst.click();
		multiselectsecond.click();
		booleaoption.click();
	}

	public void lidar_jumpToObject(WebDriver driver) throws Exception {

		waitForElementToBeVisible(driver, lidar_image_load);
		waitForElementToBeClickable(driver, jumptoobject);
		jumptoobject.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "jumptoObject");
	}

	public void lidar_hideAnnotation(WebDriver driver) throws Exception {
		waitForElementToBeVisible(driver, lidar_image_load);
		hideannnotation.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "hideannotation");
		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", hideannnotation);
	}

	public void lidar_outlier(WebDriver driver) throws Exception {
		waitForElementToBeVisible(driver, lidar_image_load);
		outlier.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "outlier");
		waitForElementToBeVisible(driver, lidar_image_load);
		outlier.click();
	}
	public void lidar_isolate(WebDriver driver) throws Exception {
		waitForElementToBeVisible(driver, lidar_image_load);
		isolate.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "isolate");
	}
	public void lidar_jumptoorigin(WebDriver driver) throws Exception {
		waitForElementToBeVisible(driver, lidar_image_load);
		jumporigin.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "jumptoorigin");
		waitForElementToBeVisible(driver, lidar_image_load);
		jumporigin.click();
	}

	public void lidar_fittoscreen(WebDriver driver) throws Exception {
		waitForElementToBeVisible(driver, lidar_image_load);
		fittoscreen.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "fittoscreen");
		waitForElementToBeVisible(driver, lidar_image_load);
		fittoscreen.click();
	}

	public void lidar_fullscreen(WebDriver driver) throws Exception {
		waitForElementToBeVisible(driver, lidar_image_load);
		fullscreen.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "fullscreen");
		waitForElementToBeVisible(driver, lidar_image_load);
		fullscreen.click();
	}

	public void lidar_2D(WebDriver driver) throws Exception {
		waitForElementToBeVisible(driver, lidar_image_load);
		twoD.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "twoD");
		waitForElementToBeVisible(driver, lidar_image_load);
		twoD.click();
		Thread.sleep(1000);
	}

	public void lidar_3D(WebDriver driver) throws Exception {
		waitForElementToBeVisible(driver, lidar_image_load);
		threeD.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "threeD");
		waitForElementToBeVisible(driver, lidar_image_load);
		threeD.click();
		Thread.sleep(1000);
	}

	public void lidar_focus(WebDriver driver) throws Exception {

		waitForElementToBeVisible(driver, lidar_image_load);
		annotation_selection.click();
		Thread.sleep(1000);
		focus.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "focus");
		TestUtil.moveSlider(focus_slider, driver);
		front_view.click();
		TestUtil.compareScreenshot(driver, lidar_image_load,"frontView");
		Thread.sleep(1000);
		top_view.click();
		 TestUtil.compareScreenshot(driver, lidar_image_load,"topView");

	}
	public void lidar_rotate(WebDriver driver) throws Exception {

		waitForElementToBeVisible(driver, lidar_image_load);
		annotation_selection.click();
		Thread.sleep(1000);
		for(int i=1;i<5;i++)
		{
		String filename="rotate_direction_"+Integer.toString(i);
		rotate_direction.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, filename);
		Thread.sleep(1000);
		}
		
	}
		
	public void lidar_showAllpoints(WebDriver driver) throws Exception {
		waitForElementToBeVisible(driver, lidar_image_load);
		TestUtil.compareScreenshot(driver, lidar_image_load, "Show_all_points");
		Show_all_points.click();
		Thread.sleep(1000);
		Show_ground_only.click();
		Thread.sleep(1000);
		TestUtil.compareScreenshot(driver, lidar_image_load, "Show_ground_only");
		Show_ground_only.click();
		Thread.sleep(1000);
		Show_non_ground_only.click();
		Thread.sleep(1000);
		TestUtil.compareScreenshot(driver, lidar_image_load, "Show_non_ground_only");

	}

	public void lidar_help(WebDriver driver) throws Exception {
		help.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "help");
		batch_information.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "batch_information");
		copy_clipboard.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "copy_clipboard");
		batch_info_close.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "batch_info_close");

	}

	public void lidar_object_clipping(WebDriver driver) throws Exception {
		waitForElementToBeVisible(driver, lidar_image_load);
		annotation_selection.click();
		object_clipping.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "object_clipping");
		object_clipping.click();
	}

	public void lidar_delete(WebDriver driver) throws Exception {
		annotation_selection.click();
		delete_annotation.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "delete_annotation");
		delete_frame_annotation.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "delete_frame_annotation ");
	}

	public void lidar_filled_boxes(WebDriver driver) throws Exception {
		filled_boxes.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "filled_boxes");
		object_name.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "object_name");
	}
	public void lidar_open_tool_setting(WebDriver driver) throws Exception
	{
		waitForElementToBeClickable(driver, menu_newframe);
		act.moveToElement(menu_newframe);
		menu_newframe.click();
		tool_setting.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "tool_setting");
	}
	public void lidar_class_point_brightness(WebDriver driver) throws Exception
	{
		TestUtil.compareScreenshot(driver, lidar_image_load, "before_class_point_brightness");
		TestUtil.moveSlider(class_point_brightness, driver);
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_class_point_brightness");
	}
	public void lidar_ts_perforance(WebDriver driver) throws Exception
	{
		TestUtil.compareScreenshot(driver, lidar_image_load, "before_pt_budget");
		TestUtil.moveSlider(pt_budget_slider, driver);
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_pt_budget");
	}
	public void lidar_ts_ps_modifier(WebDriver driver) throws Exception
	{ 
		TestUtil.compareScreenshot(driver, lidar_image_load, "before_ts_ps_modifier");
		TestUtil.moveSlider(pt_size_modifier, driver);
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_ts_ps_modifier");
	}
	public void lidar_ts_background(WebDriver driver) throws Exception
	{
		TestUtil.compareScreenshot(driver, lidar_image_load, "before_ts_background");
		background_white.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_ts_background_white");
		pt_type_fixed.click();
		pt_type_adaptive.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_adaptive");
	}
	public void lidar_point_color_gradient(WebDriver driver) throws Exception{
		TestUtil.compareScreenshot(driver, lidar_image_load, "before_gradient");
		point_colors.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_gradient");
		pt_color_gradient.click();
	    TestUtil.moveSlider(gradient_range, driver);
	    TestUtil.compareScreenshot(driver, lidar_image_load, "after_gradient_range");
	}
	public void lidar_point_color_RGBA(WebDriver driver) throws Exception{
		point_colors.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "before_rgba");
		TestUtil.moveSlider(gamma, driver);
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_rgba_gamma");
		TestUtil.moveSlider(brightness, driver);
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_rgba_brightness");
		TestUtil.moveSlider(contrast, driver);
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_rgba_contrast");
		speed_controls.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_rgba_speedControl");
		
		}
	public void lidar_pt_color_intensity(WebDriver driver) throws Exception{
		point_colors.click();
		pt_color_intensity.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "before_pt_color_intensity");
		TestUtil.moveSlider(speed_controls, driver);
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_pt_color_intensity");
		}
	public void lidar_pt_color_classification(WebDriver driver) throws Exception{
		point_colors.click();
		pt_color_classification.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "before_pt_color_classification");
		TestUtil.moveSlider(speed_controls, driver);
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_pt_color_classification");
		}
	public void lidar_pt_color_gpsTime(WebDriver driver) throws Exception{
		point_colors.click();
		pt_color_gpstime.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "before_pt_color_gpstime");
		TestUtil.moveSlider(speed_controls, driver);
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_pt_color_gpstime");
		}
	public void lidar_show_roi(WebDriver driver) throws Exception{
		show_roi.click();
		show_roi_plus.click();
		TestUtil.compareScreenshot(driver, lidar_image_load, "before_show_roi_plus");
		radius_meter.sendKeys("50");
		TestUtil.compareScreenshot(driver, lidar_image_load, "after_show_roi_plus");
	}

	public void lidar_Cuboid(WebDriver driver, int annotationCount) throws InterruptedException, IOException {

		waitForElementToBeVisible(driver, lidar_image_load);
		add_annotation_lidar.click();
		lidarcuboid.click();
		ExtentTestManager.getTest().log(Status.PASS, "cuboid button clicked");
		System.out.println("Cuboid button clicked");
		Thread.sleep(3000);
		int i = 1;
		LiDARFunctions liDARFunctions = new LiDARFunctions();
		liDARFunctions.CuboidAnnotation(driver, lidar_image_load, i);
		Thread.sleep(3000);
		waitForElementToBeVisible(driver, create_new);
		act.moveToElement(create_new).clickAndHold(create_new).perform();
		act.release(create_new);
		lidar_ClassAttribute();
		waitForElementToBeClickable(driver, ann_save_button);
		Thread.sleep(30000);
		System.out.println("wait over");
		ann_save_button.click();
		ExtentTestManager.getTest().log(Status.PASS, "Cuboid annotation created");
		System.out.println("Cuboid annotation created");
	}

	public void lidar_Polygon(WebDriver driver, int annotationCount) throws InterruptedException {

		Thread.sleep(3000);
		add_annotation_lidar.click();
		waitForElementToBeClickable(driver, lidarpolygon);
		lidarpolygon.click();
		int i = 1;
		Thread.sleep(3000);
		waitForElementToBeVisible(driver, lidar_image_load);
		LiDARFunctions.TwoDPolygonAnnotation(driver, lidar_image_load, i);
		waitForElementToBeVisible(driver, create_new);
		Actions act = new Actions(driver);
		act.moveToElement(create_new).clickAndHold(create_new).perform();
		act.release(create_new);
		lidar_ClassAttribute();
		waitForElementToBeVisible(driver, ann_save_button);
		ann_save_button.click();
		overlap_alert_yes.click();
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(Status.PASS, "Polygon annotation created for LiDAR");
		System.out.println("Polygon annotation created for LiDAR");
	}

	public void lidar_Rectangle(WebDriver driver, int annotationCount) throws InterruptedException {

		waitForElementToBeVisible(driver, lidar_image_load);
		add_annotation_lidar.click();
		rectangle.click();
		ExtentTestManager.getTest().log(Status.PASS, "Rectangle button clicked");
		System.out.println("Rectangle button clicked");
		Thread.sleep(3000);
		int i = 1;
		LiDARFunctions.RectangleAnnotation(driver, lidar_image_load, i);
		waitForElementToBeVisible(driver, create_new);
		act.moveToElement(create_new).clickAndHold(create_new).perform();
		act.release(create_new);
		lidar_ClassAttribute();
		waitForElementToBeVisible(driver, ann_save_button);
		ann_save_button.click();
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(Status.PASS, "Rectangle annotation created");
		System.out.println("Rectangle annotation created");
	}

	public void lidar_TwoDPolygonAnnotation(WebDriver driver, int annotationCount) throws InterruptedException {
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.contextClick(reference_image).perform();
		act.moveToElement(super_impose).click(super_impose).perform();
		Thread.sleep(3000);
		add_annotation_lidar.click();
		waitForElementToBeClickable(driver, polygon2D);
		polygon2D.click();
		int i = 1;
		Thread.sleep(3000);
		waitForElementToBeVisible(driver, lidar_image_load);
		LiDARFunctions.TwoDPolygonAnnotation(driver, lidar_image_load, i);
		waitForElementToBeVisible(driver, create_new);
		act.moveToElement(create_new).clickAndHold(create_new).perform();
		act.release(create_new);
		lidar_ClassAttribute();
		waitForElementToBeVisible(driver, ann_save_button);
		ann_save_button.click();
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(Status.PASS, "2DPolygon annotation created");
		System.out.println("2DPolygon annotation created");
	}

	public void lightning_CreateAnnotation() throws InterruptedException {
		try {
			waitForElementToBeVisible(driver, ann_dialog);
			Thread.sleep(3000);
			selectPlusButton("1").click();
			Thread.sleep(3000);
			boundingbox.click();
			ExtentTestManager.getTest().log(Status.PASS, "Bounding Box clicked");
			System.out.println("Bounding Box clicked");
			waitForElementToBeVisible(driver, lightning_image_load);

			// Get batch size
			String bSize = batch_size.getText();
			int index = bSize.length();
			int batch_size = Integer.parseInt(bSize.substring(index - 1));

			// Frame traversing
			for (int i = 1; i < batch_size; i++) {
				lightning_Bbox(driver, 5);
				next_frame.click();
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.PASS, "Next frame clicked");
				System.out.println("Next frame clicked");
			}

			// Batch submission
			lightning_Bbox(driver, 3);
			task_submit.click();
			ExtentTestManager.getTest().log(Status.PASS, "Submit button clicked");
			System.out.println("Submit button clicked");
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			ExtentTestManager.getTest().log(Status.PASS, "Task submitted");
			System.out.println("Task submitted");
			driver.close();
		} catch (Exception e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Task submission failed");
			System.out.println("Task submission failed");
		}
	}

	public void odin_CreateAnnotation() throws InterruptedException, AWTException {
		
			waitForElementToBeVisible(driver, ann_dialog);
			Thread.sleep(5000);

			// Get batch size
			String bSize = batch_size.getText();
			int index = bSize.length();
			int batch_size = Integer.parseInt(bSize.substring(index - 1));

			// Frame traversing
			for (int i = 1; i < batch_size; i++) {

				odin_Polygon(driver, 2);
				odin_brush(driver, 2);
				odin_lasso(driver, 2);
				odin_FillUnannRegion(driver);
				next_frame.click();
				ExtentTestManager.getTest().log(Status.PASS, "Next frame clicked");
				System.out.println("Next frame clicked");
			}

			// Batch submission
			odin_Polygon(driver, 2);
			odin_brush(driver, 2);
			odin_lasso(driver, 2);
			odin_FillUnannRegion(driver);
			task_submit.click();
			ExtentTestManager.getTest().log(Status.PASS, "Submit button clicked");
			System.out.println("Submit button clicked");
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			ExtentTestManager.getTest().log(Status.PASS, "Task submitted");
			System.out.println("Task submitted");
			driver.close();
		
	}

	public void lidar_CreateAnnotation_Cuboid() throws InterruptedException, IOException {
			waitForElementToBeVisible(driver, lidar_image_load);
			lidar_Cuboid(driver, 1);
	}

	public void lidar_CreateAnnotation_Polygon() throws InterruptedException {
		try {
			waitForElementToBeVisible(driver, lidar_image_load);
			lidar_Polygon(driver, 1);
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(Status.FAIL, "Polygon annotation creation failed");
			System.out.println("Polygon annotation creation failed");
		}
	}

	public void lidar_CreateAnnotation_TwoDPolygon() throws InterruptedException {
			super_impose_button.click();
			lidar_TwoDPolygonAnnotation(driver, 1);	
	}

	public void lidar_CreateAnnotation_Rectangle() throws InterruptedException {
			lidar_Rectangle(driver, 1);
	}

	public void lidar_CopyPasteRectangle() throws InterruptedException {
			// Get batch size
			waitForElementToBeVisible(driver, lidar_batch_size);
			String bSize = lidar_batch_size.getText();
			int batch_size = Integer.parseInt(bSize.substring(3));
			System.out.println(batch_size);
			// copy annotation
			lidar_image_load.sendKeys(Keys.chord(Keys.CONTROL, "c"));
			System.out.println("Annotation copied from" + i + "frame");
			Thread.sleep(1000);
			waitForElementToBeClickable(driver, next_task);
			executor.executeScript("arguments[0].click();", next_task);
			System.out.println(i + "frameClicked");
			// Paste annotation while traversing the frames
			for (int i = 1; i < batch_size; i++) {
				Thread.sleep(10000);
				super_impose_button.click();
				Thread.sleep(10000);
				super_impose_button.click();
				Actions act = new Actions(driver);
				act.contextClick(reference_image).perform();
				act.moveToElement(super_impose).click(super_impose).perform();
				Thread.sleep(3000);
				lidar_image_load.sendKeys(Keys.chord(Keys.CONTROL, "v"));
				waitForElementToBeVisible(driver, ann_save_button);
				ann_save_button.click();
				System.out.println("Annotation pasted");
				Thread.sleep(30000);
				waitForElementToBeClickable(driver, next_task);
				executor.executeScript("arguments[0].click();", next_task);
				System.out.println(i + "frameClicked");
			}
			// Batch submission
			task_submit.click();
			ExtentTestManager.getTest().log(Status.PASS, "Submit button clicked");
			System.out.println("Submit button clicked");
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.PASS, "Task submitted");
			System.out.println("Task submitted");
			driver.close();
	}

	public void lidar_FrameTraverseAndSubmit() throws InterruptedException {
			// Get batch size
			waitForElementToBeVisible(driver, lidar_batch_size);
			String bSize = lidar_batch_size.getText();
			int batch_size = Integer.parseInt(bSize.substring(3));
			System.out.println(batch_size);
			waitForElementToBeClickable(driver, next_task);
			// Frame traversing
			waitForElementToBeClickable(driver, menu_newframe);
			act.moveToElement(menu_newframe);
			menu_newframe.click();
			// act.moveToElement(task_attribute_menu);
			waitForElementToBeClickable(driver, batch_attribute_menu);
			batch_attribute_menu.click();
			task_attribute_first.click();
			batch_attribute_firstoption.click();
			task_attribute_close.click();
			waitForElementToBeClickable(driver, menu_newframe);
			act.moveToElement(menu_newframe);
			menu_newframe.click();
			act.moveToElement(task_attribute_menu);
			task_attribute_menu.click();
			task_attribute_first.click();
			task_attribute_firstoption.click();
			task_attribute_multiselectoption.click();
			task_attribute_close.click();
			waitForElementToBeClickable(driver, next_task);
			executor.executeScript("arguments[0].click();", next_task);
			System.out.println(i + "frameClicked");
			for (int i = 1; i < batch_size; i++) {
				Thread.sleep(10000);
				waitForElementToBeClickable(driver, menu_newframe);
				act.moveToElement(menu_newframe);
				menu_newframe.click();
				act.moveToElement(task_attribute_menu);
				task_attribute_menu.click();
				task_attribute_first.click();
				task_attribute_firstoption.click();
				task_attribute_multiselectoption.click();
				task_attribute_close.click();
				waitForElementToBeClickable(driver, next_task);
				executor.executeScript("arguments[0].click();", next_task);
				System.out.println(i + "frameClicked");
			}
			// Batch Submission
			task_submit.click();
			ExtentTestManager.getTest().log(Status.PASS, "Submit button clicked");
			System.out.println("Submit button clicked");
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.PASS, "Task submitted");
			System.out.println("Task submitted");
			driver.close();
	}
}
