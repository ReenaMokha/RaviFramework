package test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.ExcelReader;
import framework.TestBase;
import framework.TestDataProvider;
import page.LoginPage;

public class LoginPageTest extends TestBase {
	
	Logger logger = Logger.getLogger(LoginPageTest.class);
	//This method will provide data to any test method that declares that its Data Provider
	//is named "test1"
	@DataProvider(name = "Login")// name of the test
	public Object[][] toPassLoginData() {//2d array represents rows and column
	 return new Object[][] {
		ExcelReader.readExcelData("applicationData.xlsx", "Sanity", "usera"),//key=unique identifier of the testdata
	 };
	}
	 
	
	@Test(dataProvider="Login")
	public void verifyLoginIntoApp(String key, String user, String password, String extra){
		LoginPage login = new LoginPage(driver);//initialize the driver of the respective page by creating an object and passing the driver
		logger.info("Enter email");
		login.enterEmail(user);
		logger.info("Enter Password");
		login.enterPassword(password);
		login.clickLoginButton();
		Assert.assertEquals(login.isSuccessLogin(), true);
		logger.info("verifyLoginTest Passed");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
