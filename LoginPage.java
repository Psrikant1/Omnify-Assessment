package omnify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
        
	WebDriver driver;
	
	    //Constructor
	    public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	    //Locators
	    @FindBy(xpath = "//input[@placeholder='Username']")
	    WebElement usernameField;

	    @FindBy(xpath = "//input[@placeholder='Password']")
	    WebElement passwordField;
        
	    @FindBy(xpath = "//button[@type='submit']")
	    WebElement loginButton;

	    //Actions Method
	    public void login(String username, String password) {
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        loginButton.click();
	    }
	
}
