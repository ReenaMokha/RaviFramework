package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SetUpWebDriver {
	
	protected WebDriver driver;

	
	@BeforeMethod
	public void runBeforeEachMethod(){
		driver = WebDriverManager.getWebDriver();			
			
		
	}
	
	@AfterMethod
	public void runAfterEachMethod(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
