package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.BasePage;

public class ContactsPage extends BasePage {
	
	public ContactsPage(WebDriver driver) {
		super(driver);
	}
		
	@FindBy(xpath="//h1[@class='private-header__heading']")
	public WebElement contactHeader;
	
	@FindBy(xpath="//span[text()='Create contact']")
	public WebElement createContact;
	
	@FindBy(xpath="//h3[@class='m-all-0']")
	public WebElement createContactLabel;
	
	@FindBy(xpath="//div[@class='p-x-0 col-xs-12']//input[@class='form-control private-form__control']")
	public WebElement enterContactEmail;
	
	@FindBy(xpath="//input[@data-field='firstname']")
	public WebElement enterContactFirstName;
	
	@FindBy(xpath="//input[@data-field='lastname']")
	public WebElement enterContactLastName;
	
	
	@FindBy(xpath="//input[@data-field='jobtitle']")
	public WebElement enterContactJobTitle;
	
	@FindBy(xpath="//footer//span[text()='Create contact']")
	public WebElement clickfinalContact;

	@FindBy(xpath="//span[text()='Create and add another']")
	public WebElement clickandAddAnother;
	
	@FindBy(xpath="//span[text()='Cancel']")
	public WebElement clickCancel;
	
	@FindBy(xpath="//i18n-string[text()='About this contact']")
	public WebElement clickAbouttheContact;
	
	
	@FindBy(xpath="//input[@data-field='firstname']")
	public WebElement firstName;
	
	@FindBy(xpath="//a[@class='private-link uiLinkWithoutUnderline uiLinkDark private-breadcrumbs__item']")
	public WebElement goToContactPage;
	
	//************************************************************//
	
	
	public String getContactPageTitle(){
		waitForElementToBeVisible(contactHeader);
		return getPageTitle();
		
	}

	public String getContactPageHeader(){
		waitForElementToBeVisible(contactHeader);
		return getText(contactHeader);
	}
	
	public void clickCreateContact(){
		waitForElementToBeVisible(createContact);
		click(createContact);
		
	}
	
	public void enterEmailForContact(String ContactEmail){
		waitForElementToBeVisible(enterContactEmail);
		waitForElementToBeVisible(createContactLabel);
		type(enterContactEmail, ContactEmail);
	}
	
	public void enterFirstName(String FirstName){
		waitForElementToBeVisible(enterContactFirstName);
		type(enterContactFirstName, FirstName);
	}
	
	public void enterLastname(String LastName){
		waitForElementToBeVisible(enterContactLastName);
		type(enterContactLastName, LastName);
		
	}
		
	public void enterJobTitle(String JobTitle){
		waitForElementToBeVisible(enterContactJobTitle);
		waitForJobTitleField();
		//waitForElementToBeClickable(enterContactJobTitle);
		type(enterContactJobTitle, JobTitle);	
		
	}	
	
	public void waitForJobTitleField(){
		By elementlocator = By.xpath("//input[@data-field='jobtitle']");
		waitForElementPresent(elementlocator);
	}
		
	public void clickCreateContactFinal(){
		waitForElementToBeVisible(clickfinalContact);
		click(clickfinalContact);	
	}	
	
	public void clickCreateandAddAnother(){
		click(clickandAddAnother);
	}
		
	public void clickCancel(){
		click(clickCancel);
	}
	
	public String getFirstNameOfContact(){
		waitForElementToBeVisible(firstName);
		return getText(firstName);
	}
	
	public void clickGoToContact(){
		waitForElementToBeVisible(goToContactPage);
		click(goToContactPage);
	}
	
	
	}
	
	
	
	
	


