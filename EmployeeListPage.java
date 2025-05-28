package omnify;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage {
     
WebDriver driver;
	
        //Constructor
        public EmployeeListPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
   }
        //Locators
        @FindBy(linkText = "Employee List")
        WebElement employeeListLink;
        
        public boolean verifyEmployee(String fullName) {
            employeeListLink.click();

            List<WebElement> employeeNames = driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span'][text()=' (204) Records Found']"));
            for (WebElement name : employeeNames) {
                if (name.getText().contains(fullName)) {
                    System.out.println(fullName + ": Name Verified");
                    return true;
                }
            }
            System.out.println(fullName + ": Not Found");
            return false;
        }
}
