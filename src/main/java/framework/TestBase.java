package framework;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;

public class TestBase {
	
	
protected WebDriver driver;

	
	@BeforeMethod
	public void runBeforeEachMethod(){
		PropertyConfigurator.configure("log4j.properties");
		driver = WebDriverManager.getWebDriver();			
			
	}
	
	@AfterMethod()
	public void takeScreenShotWhenFailed(ITestResult result){
		if(result.isSuccess()==false){
			File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				//FileUtils.copyFile(sourceFile, new File("D:\\SeleniumAll\\RaviFramework\\screenshots\\screenshot.png"));
	FileUtils.copyFile(sourceFile,new File("D:\\SeleniumAll\\RaviFramework\\screenshots\\"+System.currentTimeMillis()+"screenshot.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@AfterMethod(dependsOnMethods="takeScreenShotWhenFailed")
	public void runAfterEachMethod(){
		driver.quit();
	}

	
//		@AfterMethod()
//		public void takeScreenshot(){
//			TakesScreenshot ts=(TakesScreenshot)driver;//interface typecaste driver
//			File Source =ts.getScreenshotAs(OutputType.FILE);	//	get the source	
//			FileUtils.copyFile(Source,new File("D:\\SeleniumAll\\RaviFramework\\screenshots\\"+System.currentTimeMillis()+"screenshot.png"));//copy the source to desination
//		}
 
	
	
	
}
