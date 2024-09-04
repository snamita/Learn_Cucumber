package pages;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.TestBase;
import util.TestUtil;

public class Recipes extends TestBase {

	String _recipename = TestUtil.generateRandomRecipeName();
	String _newrecipename = "New" + TestUtil.generateRandomRecipeName();
	String[] classnames = { "Aeroplane", "Car", "Bus", "Truck" };
	String[] displaynames = { "A", "C", "B", "T" };
	String _category = "Vehicle";
	String[] attributenames = { "Wheels", "Blades" };
	String[] selectattributenames= {"Color"};
	String[] attributedisplaynames = { "W", "B" };
	String[] selectattributevalues = {"White","Blue"};
	String[] multiselectattributenames= {"Type"};
	String[] multiselectattributevalues = {"Taxi","Personal"};
	String[] taskselectattributenames= {"Time"};
	String[] taskselectattributevalues = {"Day","Night"};
	String[] taskmultiselectattributenames= {"Weather"};
	String[] taskmultiselectattributevalues = {"Sunny","Rainy"};
	String[] boleanattributevalues = {"Transport"};
	String[] inputbox_componentvalues= {"NoOfLights"};
	String[] batchselectattributenames= {"Visibility"};
	String[] batchselectattributevalues = {"Clear","Blury"};

	// Object Repository for Recipes
	@FindBy(xpath = "//button/span[contains(text(),'New Recipe')]")
	WebElement new_recipe;

	@FindBy(xpath = "//button/span[contains(text(),'Taskflow Builder')]")
	WebElement taskflow_builder;

	@FindBy(xpath = "//div/h4[contains(text(),'Taskflow Builder')]")
	WebElement taskflow_builder_page;

	@FindBy(xpath = "//div/input[@placeholder='Search for a recipe']")
	WebElement search_recipe;

	@FindBy(xpath = "//div/button[@dropdowntoggle][contains(@class, 'btn-outline-theme-primary')]")
	WebElement recipe_dropdown_toggle;

	@FindBy(xpath = "//div/h6[contains(text(), 'Attributes')]")
	WebElement attributes;

	@FindBy(xpath = "//div/h6[contains(text(), 'Associations')]")
	WebElement associations;
	
	@FindBy(xpath="//small/a[text()='Recipes']")
	WebElement recipes;

	// Object Repository for Basic Recipe Details
	@FindBy(xpath = "//div/button[contains(text(),'Select an option')]")
	WebElement annotation_tool;

	@FindBy(xpath = "//ul/li/a[contains(text(),'iMerit 2D')]")
	WebElement lightning_tool;

	@FindBy(xpath = "//ul/li/a[contains(text(),'iMerit Segmentation')]")
	WebElement odin_tool;

	@FindBy(xpath = "//ul/li/a[contains(text(),'iMerit LiDAR')]")
	WebElement pct_tool;

	@FindBy(xpath = "//div/input[@placeholder='Name']")
	WebElement config_name;

	@FindBy(xpath = "//div/textarea[@placeholder='Description']")
	WebElement config_desc;

	@FindBy(xpath = "//span/label[@for='customSwitch0']")
	WebElement identity;

	@FindBy(xpath = "//span/label[@for='customSwitch1']")
	WebElement colorSelector;

	@FindBy(xpath = "//span/label[@for='customSwitch0']")
	WebElement colorSelector_Seg;

	@FindBy(xpath = "//span/label[@for='customSwitch1']")
	WebElement allPixelsAnnotation;

	@FindBy(xpath = "//span/label[@for='customSwitch2']")
	WebElement sequentialTask;

	@FindBy(xpath = "//span/label[@for='customSwitch3']")
	WebElement referenceImages;

	@FindBy(xpath="//div/button[contains(text(),'Category')]")
	WebElement category;
	
	@FindBy(xpath="//div/input[@placeholder='Category name']")
	WebElement category_name;
	
	@FindBy(xpath = "//div/button[contains(text(),'Save & Next')]")
	WebElement save_next;

	// Object Repository for Classes
	@FindBy(xpath = "//div/h4[contains(text(),'New Class')]")
	WebElement new_class;

	@FindBy(xpath = "//div/input[@placeholder='Enter class name']")
	WebElement class_name;

	@FindBy(xpath = "//div/input[@placeholder='Enter class display name']")
	WebElement display_name;

	@FindBy(xpath = "//div/input[@placeholder='Abbreviation name']")
	WebElement abbreviation_name;

	@FindBy(xpath = "//div/span[@class='dropdown-btn']")
	WebElement drawingtool_drpdwn;

	@FindBy(xpath = "//ul/li/div[text()='line']")
	WebElement line;

	@FindBy(xpath = "//ul/li/div[text()='bbox']")
	WebElement bbox;

	@FindBy(xpath = "//ul/li/div[text()='polygon']")
	WebElement polygon;

	@FindBy(xpath = "//ul/li/div[text()='polyline']")
	WebElement polyline;

	@FindBy(xpath = "//ul/li/div[text()='keypoint']")
	WebElement keypoint;

	@FindBy(xpath = "//ul/li/div[text()='landmarking']")
	WebElement landmarking;

	@FindBy(xpath = "//ul/li/div[text()='cuboid']")
	WebElement cuboid;
	
	@FindBy(xpath = "//ul/li/div[text()='polygon2d']")
	WebElement polygon2d;
	
	@FindBy(xpath = "//ul/li/div[text()='rectangle']")
	WebElement rectangle;
	
	@FindBy(xpath="//div/button[contains(text(),'Select An Option')]")
	WebElement category_option;
	
	@FindBy(xpath = "//span/label[@for='customSwitch']")
	WebElement has_instance;
	
	@FindBy(xpath = "//div/button/span[contains(text(),'Save Changes')]")
	WebElement savechanges_btn;

	@FindBy(xpath = "//div/button[contains(text(),'Next')]")
	WebElement next_btn;

	// Object Repository for Attributes
	@FindBy(xpath = "//div/h4[contains(text(),'New Attribute')]")
	WebElement new_attribute;

	@FindBy(xpath = "//label/small[contains(text(),'Class Level')]")
	WebElement class_level;

	@FindBy(xpath = "//label/small[contains(text(),'Task Level')]")
	WebElement task_level;

	@FindBy(xpath = "//label/small[contains(text(),'Batch Level')]")
	WebElement batch_level;

	@FindBy(xpath = "//div/button[contains(text(),'Select An Option')]")
	WebElement ui_component;

	@FindBy(xpath = "//li/a/span[contains(text(),'boolean')]")
	WebElement boolean_component;

	@FindBy(xpath = "//li/a/span[contains(text(),'multiselect')]")
	WebElement multiselect_component;

	@FindBy(xpath = "(//li/a/span[contains(text(),'select')])[2]")
	WebElement select_component;

	@FindBy(xpath = "//li/a/span[contains(text(),'text')]")
	WebElement text_component;
	
	@FindBy(xpath = "//li/a/span[contains(text(),'inputbox')]")
	WebElement inputbox_component;

	@FindBy(xpath = "//div/input[@placeholder='Attribute Name']")
	WebElement attribute_name;

	@FindBy(xpath = "//div/input[@placeholder='Display Name']")
	WebElement attribute_display_name;
	
	@FindBy(xpath = "//div/input[@placeholder='Default Text']")
	WebElement default_text;
	
	@FindBy(xpath = "//div/input[@placeholder='Abbreviated Name']")
	WebElement abbreviated_name;

	@FindBy(xpath = "(//div/input[@placeholder='Value'])[1]")
	WebElement firstoptions_value;

	@FindBy(xpath = "(//div/input[@placeholder='Text'])[1]")
	WebElement firstoptions_text;

	@FindBy(xpath = "(//div/input[@placeholder='Abbreviation'])[1]")
	WebElement firstoptions_abbreviation;
	
	@FindBy(xpath = "(//div/input[@placeholder='Value'])[2]")
	WebElement secondoptions_value;

	@FindBy(xpath = "(//div/input[@placeholder='Text'])[2]")
	WebElement secondoptions_text;

	@FindBy(xpath = "(//div/input[@placeholder='Abbreviation'])[2]")
	WebElement secondoptions_abbreviation;

	@FindBy(xpath = "//li/button[contains(text(),'Add Option')]")
	WebElement add_option;
	
	@FindBy(xpath = "//span/label[@for='isGlobal']")
	WebElement is_global;
	
	@FindBy(xpath = "//span/label[@for='isOptional']")
	WebElement is_optional;

	// Object Repository for Associations
	@FindBy(xpath = "//div/h5[contains(text(),'New Association')]")
	WebElement new_association;

	@FindBy(xpath = "//div/span/span[contains(text(),'Select Class')]")
	WebElement select_class;
	
	@FindBy(xpath="//span[@class='selected-item-container']/..")
	WebElement class_drpdwn;
		
	@FindBy(xpath = "//div/span/span[contains(text(),'Select Attributes')]/ancestor::span")
	WebElement select_attributes;

	@FindBy(xpath = "//div[2]/ng-multiselect-dropdown/div[1]/div[1]/span")
	WebElement attribute_drpdwn;

	@FindBy(xpath = "//button[contains(text(),'Mark Published')]")
	WebElement mark_published;
	
	@FindBy(xpath="//button[contains(text(),'Confirm')]")
	WebElement confirm_btn;

	@FindBy(xpath="//button[contains(text(),'Clone Configuration')]")
	WebElement clone_config_btn;
	
	@FindBy(xpath = "//div[contains(@class,'toastify')]/button")
	WebElement close_msgbox;

	//Object Repository for Clone Recipe
	@FindBy(xpath="//div/button[contains(text(),'Save')]")
	WebElement recipe_name_save;
	
	@FindBy(xpath = "//select/option[contains(text(),'Select Type')]")
	WebElement attribute_select_type;
	
	@FindBy(xpath = "//select/option[contains(text(),'Integer')]")
	WebElement select_typeinteger;
	
	// Initializing page objects
	public Recipes() {
		PageFactory.initElements(driver, this);
	}

	// Methods
	public WebElement selecttextforassociation(String S) {
		return driver.findElement(By.xpath(String.format("//li/input[@aria-label='%s']", S)));
	}

	public WebElement getclassrowname(String S) {
		return driver.findElement(By.xpath(String.format("//table/tbody/tr/td/div/span[contains(text(),'%s')]", S)));
	}
	
	public WebElement getattributerowname(String S) {
		return driver.findElement(By.xpath(String.format("//table/tbody/tr/td/span[contains(text(),'%s')]", S)));
	}

	public WebElement getassociationrowname(int i) {
		return driver.findElement(By.xpath(String.format("//table/tbody/tr/th/following-sibling::td[%s]", i)));
	}

	public WebElement getconfigrowname(String S) {
		return driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", S)));
	}

	public WebElement getdropdownwebelement(String S) {
		return driver.findElement(By.xpath(String.format("//li/a[contains(text() , '%s')]", S)));
	}

	public WebElement selectcategory(String S) {
		return driver.findElement(By.xpath(String.format("//li/a[contains(text(),'%s')]", S)));
	}

	// This method creates a new recipe with the above mentioned array of class names
	public void createNewRecipe(String annotationtool) throws InterruptedException {
			Assert.assertTrue(waitForElementToBeClickable(driver, new_recipe), "New Recipe button is not visible");
			waitForElementToBeClickable(driver,new_recipe);
			new_recipe.click();
			TestUtil.logTestStep("PASS", "New recipe window opened");
			annotation_tool.click();
			if (annotationtool.equalsIgnoreCase("Lightning")) {
				lightning_tool.click();
				TestUtil.logTestStep("PASS", "Lightning Annotation tool selected");
			} else if (annotationtool.equalsIgnoreCase("Segmentation")) {
				odin_tool.click();
				TestUtil.logTestStep("PASS", "Odin Annotation tool selected");
			} else if (annotationtool.equalsIgnoreCase("Lidar")) {
				pct_tool.click();
				TestUtil.logTestStep("PASS", "Lidar Annotation tool selected");
			}
			config_name.sendKeys(_recipename);
			config_desc.sendKeys("This is a test config");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			if (annotationtool.equalsIgnoreCase("Lightning"))
				executor.executeScript("arguments[0].click();", colorSelector);
			else if (annotationtool.equalsIgnoreCase("Segmentation")) {
				category.click();
				category_name.sendKeys(_category);
			}
			save_next.click();
			close_msgbox.click();
			System.out.println("Recipe save button clicked");
			try {
				Assert.assertTrue(waitForElementToBeVisible(driver, new_class), "Cannot navigate to class creation tab");
			}
			catch (NoSuchElementException e){
				changeRecipeNameOnError();
			}
			Assert.assertTrue(waitForElementToBeVisible(driver, new_class), "Cannot navigate to class creation tab");
			TestUtil.logTestStep("PASS", "Class creation window opened");
			for (int i = 0; i < classnames.length; i++) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				try {
					close_msgbox.click();
				}
				catch (NoSuchElementException e) {
				}
				class_name.sendKeys(classnames[i]);
				display_name.sendKeys(displaynames[i]);
				if (annotationtool.equalsIgnoreCase("LiDAR")) {
					executor.executeScript("arguments[0].click();", has_instance);
					drawingtool_drpdwn.click();
				    	polygon2d.click();
				    	rectangle.click();
				   	polygon.click();
				    	drawingtool_drpdwn.click();
				    	System.out.println("Drawing tools Cuboid,Polygon,2Dpolygon & Rectangle has been selected for: " + classnames[i]);
				}
				else if (annotationtool.equalsIgnoreCase("Lightning")) {
					drawingtool_drpdwn.click();
					bbox.click();
					polygon.click();
					drawingtool_drpdwn.click();
					System.out.println("Drawing tools bounding box & polygon has been selected for: " + classnames[i]);
				}
				else if (annotationtool.equalsIgnoreCase("Segmentation")) {
					category_option.click();
					selectcategory(_category).click();
				}
				savechanges_btn.click();
				try {
					close_msgbox.click();
				}
				catch (NoSuchElementException e) {
				}
				Assert.assertTrue(waitForElementToBeVisible(driver, getclassrowname(classnames[i])), "Class didnot get saved");
				System.out.println("Class successfully created: " + classnames[i]);
				Assert.assertEquals(getclassrowname(classnames[i]).getText(), classnames[i], "Class didnot get created");
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			attributes.click();
			Assert.assertTrue(waitForElementToBeVisible(driver, new_attribute), "Cannot navigate to attribute tab");
			TestUtil.logTestStep("PASS", "Attribute selection window opened");
			for (int i = 0; i < attributenames.length; i++) {
				class_level.click();
				ui_component.click();
				text_component.click();
				attribute_name.sendKeys(attributenames[i]);
				attribute_display_name.sendKeys(attributedisplaynames[i]);
				default_text.sendKeys(attributedisplaynames[i]);
				if(attributenames[i] == "Wheels")
					executor.executeScript("arguments[0].click();", is_global);
				savechanges_btn.click();
				System.out.println("Attribute created: " + attributenames[i]);
				Assert.assertTrue(waitForElementToBeVisible(driver, getattributerowname(attributenames[i])), "Attribute cannot be created");
				try {
					close_msgbox.click();
				}
				catch (NoSuchElementException e) {
				}
			}
			for (int i = 0; i < selectattributenames.length; i++) {
				class_level.click();
				ui_component.click();
				select_component.click();
				attribute_name.sendKeys(selectattributenames[i]);
				attribute_display_name.sendKeys("Colors");
				firstoptions_value.sendKeys(selectattributevalues[0]);
				firstoptions_text.sendKeys(selectattributevalues[0]);
				firstoptions_abbreviation.sendKeys(selectattributevalues[0]);
				secondoptions_value.sendKeys(selectattributevalues[1]);
				secondoptions_text.sendKeys(selectattributevalues[1]);
				secondoptions_abbreviation.sendKeys(selectattributevalues[1]);
				savechanges_btn.click();
				System.out.println("Attribute created: " + selectattributenames[i]);
				Assert.assertTrue(waitForElementToBeVisible(driver, getattributerowname(selectattributenames[i])), "Attribute cannot be created");
				try {
					close_msgbox.click();
				}
				catch (NoSuchElementException e) {
				}
			}
			for (int i = 0; i < multiselectattributenames.length; i++) {
				class_level.click();
				ui_component.click();
				multiselect_component.click();
				attribute_name.sendKeys(multiselectattributenames[i]);
				attribute_display_name.sendKeys("Type");
				firstoptions_value.sendKeys(multiselectattributevalues[0]);
				firstoptions_text.sendKeys(multiselectattributevalues[0]);
				firstoptions_abbreviation.sendKeys(multiselectattributevalues[0]);
				secondoptions_value.sendKeys(multiselectattributevalues[1]);
				secondoptions_text.sendKeys(multiselectattributevalues[1]);
				secondoptions_abbreviation.sendKeys(multiselectattributevalues[1]);
				savechanges_btn.click();
				System.out.println("Attribute created: " + multiselectattributenames[i]);
				Assert.assertTrue(waitForElementToBeVisible(driver, getattributerowname(multiselectattributenames[i])), "Attribute cannot be created");
				try {
					close_msgbox.click();
				}
				catch (NoSuchElementException e) {
				}
			}
			
			for(int i=0; i < boleanattributevalues.length; i++)
			{
				class_level.click();
				ui_component.click();
				boolean_component.click();
				attribute_name.sendKeys(boleanattributevalues[i]);
				attribute_display_name.sendKeys(boleanattributevalues[i]);
				abbreviated_name.sendKeys(boleanattributevalues[i]);
				savechanges_btn.click();
				System.out.println("Attribute created: " + boleanattributevalues[i]);
				Assert.assertTrue(waitForElementToBeVisible(driver, getattributerowname(boleanattributevalues[i])), "Attribute cannot be created");
			try {
					close_msgbox.click();
				}
				catch (NoSuchElementException e) {
				}
			}
			for (int i = 0; i < taskselectattributenames.length; i++) {
			    
			    task_level.click();
				ui_component.click();
				select_component.click();
				attribute_name.sendKeys(taskselectattributenames[i]);
				attribute_display_name.sendKeys("Time");
				firstoptions_value.sendKeys(taskselectattributevalues[0]);
				firstoptions_text.sendKeys(taskselectattributevalues[0]);
				firstoptions_abbreviation.sendKeys(taskselectattributevalues[0]);
				secondoptions_value.sendKeys(taskselectattributevalues[1]);
				secondoptions_text.sendKeys(taskselectattributevalues[1]);
				secondoptions_abbreviation.sendKeys(taskselectattributevalues[1]);
				savechanges_btn.click();
				System.out.println("Attribute created: " + taskselectattributenames[i]);
				try {
					close_msgbox.click();
				}
				catch (NoSuchElementException e) {
				}
			}
			Thread.sleep(2000);
			for (int i = 0; i < taskmultiselectattributenames.length; i++) {
				task_level.click();
				ui_component.click();
				multiselect_component.click();
				attribute_name.sendKeys(taskmultiselectattributenames[i]);
				attribute_display_name.sendKeys(taskmultiselectattributenames[i]);
				firstoptions_value.sendKeys(taskmultiselectattributevalues[0]);
				firstoptions_text.sendKeys(taskmultiselectattributevalues[0]);
				secondoptions_value.sendKeys(taskmultiselectattributevalues[1]);
				secondoptions_text.sendKeys(taskmultiselectattributevalues[1]);
				savechanges_btn.click();
				System.out.println("Attribute created: " + taskmultiselectattributenames[i]);
				try {
					close_msgbox.click();
				}
				catch (NoSuchElementException e) {
				}	
			}
			Thread.sleep(2000);
		    for (int i = 0; i < batchselectattributenames.length; i++) {
				batch_level.click();
				waitForElementToBeClickable(driver,ui_component);
				ui_component.click();
				select_component.click();
				attribute_name.sendKeys(batchselectattributenames[i]);
				attribute_display_name.sendKeys(batchselectattributenames[i]);
				firstoptions_value.sendKeys(batchselectattributevalues[0]);
				firstoptions_text.sendKeys(batchselectattributevalues[0]);
				firstoptions_abbreviation.sendKeys(batchselectattributevalues[0]);
				secondoptions_value.sendKeys(batchselectattributevalues[1]);
				secondoptions_text.sendKeys(batchselectattributevalues[1]);
				secondoptions_abbreviation.sendKeys(batchselectattributevalues[1]);
				waitForElementToBeClickable(driver,savechanges_btn);
				savechanges_btn.click();
				System.out.println("Attribute created: " + batchselectattributenames[i]);	
				Thread.sleep(10000);
			}
			associations.click();
			System.out.println("Next button clicked to create association");
			Assert.assertTrue(waitForElementToBeVisible(driver, new_association), "Cannot navigate to association tab");
			TestUtil.logTestStep("PASS", "Association creation window opened");
			waitForElementToBeClickable(driver,select_class);
			for (int i = 0; i < classnames.length; i++) {
				select_class.click();
				waitForElementToBeClickable(driver,selecttextforassociation(classnames[i]));
				executor.executeScript("arguments[0].click();", selecttextforassociation(classnames[i]));
				driver.findElement(By.xpath("//html")).click();
				waitForElementToBeClickable(driver,select_attributes);
				select_attributes.click();
				waitForElementToBeClickable(driver,selecttextforassociation("Blades"));
				executor.executeScript("arguments[0].click();", selecttextforassociation("Blades"));
				waitForElementToBeClickable(driver,selecttextforassociation("Color"));
				executor.executeScript("arguments[0].click();", selecttextforassociation("Color"));
				waitForElementToBeClickable(driver,selecttextforassociation("Type"));
				executor.executeScript("arguments[0].click();", selecttextforassociation("Type"));
				waitForElementToBeClickable(driver,selecttextforassociation("Transport"));
				executor.executeScript("arguments[0].click();", selecttextforassociation("Transport"));
				attribute_drpdwn.click();
				waitForElementToBeClickable(driver,savechanges_btn);
				savechanges_btn.click();
				try {
					close_msgbox.click();
				}
				catch (NoSuchElementException e) {
				}
			}
			TestUtil.logTestStep("PASS", "Class Attribute mapping has been done");
			mark_published.click();
			waitForElementToBeClickable(driver,confirm_btn);
			Thread.sleep(1000);
			confirm_btn.click();
			try {
				close_msgbox.click();
			}
			catch (NoSuchElementException e) {
			}
			Assert.assertTrue(waitForElementToBeClickable(driver, clone_config_btn), "Config was not created");
			System.out.println("New Recipe/Config Created : " + _recipename);
			TestUtil.logTestStep("PASS", "Recipe has been Published");
			recipes.click();
		
	}

   	public void searchForRecipe(String searchtext) {
		waitForElementToBeVisible(driver, search_recipe);
		search_recipe.clear();
		if (searchtext.isEmpty()) {
			search_recipe.sendKeys(_recipename);
			waitForElementToBeClickable(driver, recipe_dropdown_toggle);
			recipe_dropdown_toggle.click();
		} else {
			search_recipe.sendKeys(searchtext);
			List<WebElement> allrecipe = driver.findElements(By.xpath("//div/button[@dropdowntoggle][contains(@class, 'btn-outline-theme-primary')]"));
			WebElement lastrecipe = allrecipe.get(allrecipe.size() - 1);
			lastrecipe.click();
		}
	}

	public void clickOnCloneConfiguration() {
			waitForElementToBeClickable(driver, getdropdownwebelement("Clone Configuration"));
			getdropdownwebelement("Clone Configuration").click();
			WebElement modalcontainer = driver.findElement(By.xpath("//div/app-recipe-generator-layout/div/app-recipe-generator/app-recipe-clone"));
			WebElement modalcontent = modalcontainer.findElement(By.xpath(".//div/div/div[2]/div/div/input"));
			waitForElementToBeVisible(driver, modalcontent);
			modalcontent.sendKeys(_newrecipename);
			recipe_name_save.click();
			Assert.assertTrue(waitForElementToBeVisible(driver, getconfigrowname(_newrecipename)), "Recipe was not cloned");
			TestUtil.logTestStep("PASS", "Recipe successfully cloned");
	}

	public void editRecipeAndMarkPublish() throws InterruptedException {
		try {
			close_msgbox.click();
		}
		catch (NoSuchElementException e) {
		}
		waitForElementToBeClickable(driver, getdropdownwebelement("Edit Details"));
		try{
			getdropdownwebelement("Edit Details").click();
		}
		catch (StaleElementReferenceException e) {
			getdropdownwebelement("Edit Details").click();
		}
		waitForElementToBeVisible(driver,mark_published);
		mark_published.click();
		confirm_btn.click();
		TestUtil.logTestStep("PASS", "Cloned recipe, changed name and published successfully");
	}

	public void verifyUpdatedDetailsDisplayed() {
		recipes.click();
		waitForElementToBeClickable(driver, search_recipe);
		search_recipe.clear();
		System.out.println("Recipe search box cleared");
		searchForRecipe(_newrecipename);
		if (getconfigrowname(_newrecipename).getText() != null)
			TestUtil.logTestStep("PASS", "Updated recipe displayed in the list");
		else
			TestUtil.logTestStep("FAIL", "Recipe not present in the list");
	}

	public Taskflows openTaskflowBuilder() {
			waitForElementToBeClickable(driver, taskflow_builder);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", taskflow_builder);	
			waitForElementToBeVisible(driver, taskflow_builder_page);
			TestUtil.logTestStep("PASS", "Switched to Taskflow builder");
		return new Taskflows();
	}

	public void changeRecipeNameOnError() {
		_recipename = TestUtil.generateRandomRecipeName();
		config_name.sendKeys(_recipename);
		save_next.click();
	}
}
