package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import framework.BasePage;

public class LoginPage extends BasePage {
	
	//constructor created of this page and driver passed
	public LoginPage(WebDriver driver) {
		super(driver);
	}


	//elements/objects located using PageFactory annotation
	
	@FindBy(id="username")
	public WebElement Email;
	
	@FindBy(id="password")
	public WebElement Pwd;
	
	@FindBy(id="loginBtn")
	public WebElement LoginButton;
	
	@FindBy(linkText="Sign up")
	WebElement signupLink;
	
	@FindBy(xpath = "//h1[@class='private-page__title']")
	public WebElement HomePageHeader;
	
	
	
	
	// actions to be performed on the objects of the page
	
	public String getLoginTitle(){
		return getPageTitle();
	}
	
	public void enterEmail(String email){
		
		type(Email, email);
	}
	
	public void enterPassword(String password){
		type(Pwd,password);
	}
	
	public void clickLoginButton(){
		click(LoginButton);
	}

	
	public void waitSignUpLink(){
		waitForElementToBeVisible(signupLink);
	}
	
	public boolean isSuccessLogin(){
		waitForElementToBeVisible(HomePageHeader);
		return isElementDisplayed(HomePageHeader);
	}
}

