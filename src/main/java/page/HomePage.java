package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import framework.BasePage;
import framework.TimeUtils;

public class HomePage extends BasePage {
	




	// constructor created of this page and driver passed
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// elements/objects located using PageFactory annotation
	

	@FindBy(id = "nav-primary-contacts-branch")
	public WebElement Contacts;

	@FindBy(id = "nav-secondary-contacts")
	public WebElement SubContacts;

	@FindBy(xpath = "//h1[@class='private-page__title']")
	public WebElement HomePageHeader;
	
	@FindBy(xpath="//span[@class='account-name ']")
	public WebElement accountName;
	
	@FindBy(xpath="//h1[@class='private-header__heading']")
	public WebElement contactHeader;
	
	

	// actions to be performed on the objects of the page
	
	public String getHomePageTitle() {
		waitForElementToBeVisible(HomePageHeader);
		return getPageTitle();

	}
	
	public String getHomePageHeader(){
		waitForElementToBeVisible(HomePageHeader);
		return getText(HomePageHeader);
	}
	
	public String getLoggedInAccountName(){
		waitForElementToBeVisible(accountName);
		return getText(accountName);
	}
	
	public void clickContacts(){
		waitForElementToBeVisible(Contacts);
		click(Contacts);	
	}
	
	public void clickSubContacts(){
		waitForElementToBeVisible(SubContacts);
		click(SubContacts);
	}
	
	public boolean createContactappears(){
		waitForElementToBeVisible(contactHeader);
		return isElementDisplayed(contactHeader);
		
	}
		
	}

	
	
	
