package omnify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
        
	  WebDriver driver;
	  
	  //Constructors
	  public LogOutPage(WebDriver driver) {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
	  }
	  
	  //Locators
	  @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	  WebElement userMenu;
	  
	  @FindBy(xpath = "//a[text()='Logout']")
	  WebElement logoutlink;
	  
	  //Actions methods
	  public void logout() {
		  userMenu.click();
		  logoutlink.click();
	  }
}
