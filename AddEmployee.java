package omnify;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee {
       
	WebDriver driver;
	
    //Constructor
        public AddEmployee(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
   }
        @FindBy(linkText = "Add Employee")
        WebElement addEmployeeLink;

        @FindBy(name = "firstName")
        WebElement firstNameField;

        @FindBy(name = "lastName")
        WebElement lastNameField;

        @FindBy(xpath = "//button[@type='submit']")
        WebElement saveButton;
        
        public void addEmployee(String firstName, String lastName) {
            addEmployeeLink.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            firstNameField.sendKeys(firstName);
            lastNameField.sendKeys(lastName);
            saveButton.click();
        }
        
        
        
        
        
        
        
        
}
