package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class BasePage {
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
			
	}
	/*
	 * this is for entering data to any field
	 */
	public void type(WebElement element, String data){
		element.sendKeys(data);	
	}

	public void click(WebElement element){
		element.click();
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
		
	public boolean isElementDisplayed(WebElement element){
		return element.isDisplayed();
		}
	
	//explicit wait
	public void waitForElementToBeVisible(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeDisapear(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementPresent(By Elementlocator){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(Elementlocator));
	}
	
	
	public String getText(WebElement element){
		return element.getText();
	}
	
	
	
}
