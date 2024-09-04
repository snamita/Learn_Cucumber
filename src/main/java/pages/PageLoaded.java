package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class PageLoaded implements ExpectedCondition { 
    //String expectedTitle;
    String expectedUrl;
    
    public PageLoaded(/*String expectedTitle, */ String expectedUrl) {
    //this.expectedTitle = expectedTitle; 
    this.expectedUrl = expectedUrl;
    }

    @Override
    public Boolean apply(Object driver) { 
    //Boolean isTitleCorrect = driver.getTitle().contains(expectedTitle);
    Boolean isUrlCorrect = ((WebDriver)driver).getCurrentUrl().contains(expectedUrl);
    return isUrlCorrect;
    } 
}