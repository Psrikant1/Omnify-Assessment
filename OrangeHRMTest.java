package omnify;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMTest {
       
	       WebDriver driver;
	       LoginPage loginPage;
	       PIMPage pimPage;
	       AddEmployee employee;
	       EmployeeListPage employeeListPage;
	       LogOutPage logOutPage;
	       
	           String[][] employees = {
	    	        {"Rohit", "Sharma"},
	    	        {"Virat", "Kohali"},
	    	        {"Shubham", "Gill"}
	    	    };
	       
	        @BeforeClass
	        public void setup() {
	            driver = new ChromeDriver();
	            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            
	            loginPage = new LoginPage(driver);
	            pimPage = new PIMPage(driver);
	            employee = new AddEmployee(driver);
	            employeeListPage = new EmployeeListPage(driver);
	            logOutPage = new LogOutPage(driver);
	        }
	        @Test
	        public void testOrangeHRM() throws InterruptedException {
	            loginPage.login("Admin", "admin123");
	            Thread.sleep(3000);

	            pimPage.navigateToPIM();
	            Thread.sleep(2000);
	            
	           for (String[] emp : employees) {
	                employee.addEmployee(emp[0], emp[1]);
	                Thread.sleep(2000);
	                pimPage.navigateToPIM();
	            }
	            
	            for (String[] emp : employees) {
	                String fullName = emp[0] + " " + emp[1];
	                employeeListPage.verifyEmployee(fullName);
	                Thread.sleep(2000);
	            }
	            
	            logOutPage.logout();

	        }    
	        @AfterClass
	        public void tearDown() {
	        	driver.quit();
	        }
}
