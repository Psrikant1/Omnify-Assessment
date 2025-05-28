package omnify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {
      
	WebDriver driver;
	
	//Constructor
	 public PIMPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	 //Locators
	 @FindBy(xpath = "//span[text()='PIM']")
	    WebElement pimTab;
	 
	 //Actions Methods
	 public void navigateToPIM() {
	        new Actions(driver).moveToElement(pimTab).click().perform();
	    }
}
