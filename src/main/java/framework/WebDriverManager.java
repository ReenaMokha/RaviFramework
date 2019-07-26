package framework;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class WebDriverManager {
	public static Logger logger = Logger.getLogger(WebDriverManager.class);
	public static WebDriver driver;
	
	
	public static WebDriver getWebDriver(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumAll\\RaviFramework\\resources\\chromedriver.exe");
		logger.info("Launching Browser");
		driver=new ChromeDriver();
		driver.get(PropertyManager.getProperty("url"));
		TimeUtils.mediumWait();
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		return driver;
		
		
		
	}
	
	
	
	
	
	

}
