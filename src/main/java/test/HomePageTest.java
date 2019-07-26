package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.PropertyManager;
import framework.TestBase;
import page.HomePage;
import page.LoginPage;

public class HomePageTest extends TestBase {

	@Test
	public void verifyHomepageTitle(){
		LoginPage login = new LoginPage(driver);
		HomePage hpg = new HomePage(driver);
		login.enterEmail("Reenakaur.Qa@gmail.com");
		login.enterPassword("Test123.");
		login.clickLoginButton();
		String homepageTitle =hpg.getHomePageTitle();
		Assert.assertEquals(homepageTitle, PropertyManager.getProperty("homepagetitle"));
	}
	
	@Test
	public void verifyHomepageHeader(){
		LoginPage login = new LoginPage(driver);
		HomePage hpg = new HomePage(driver);
		login.enterEmail("Reenakaur.Qa@gmail.com");
		login.enterPassword("Test123.");
		login.clickLoginButton();
		hpg.getHomePageHeader();
		Assert.assertEquals(hpg.getHomePageHeader(), PropertyManager.getProperty("homepageheader"));
	}
	
	@Test
	public void verifyAccountName(){
		LoginPage login = new LoginPage(driver);
		HomePage hpg = new HomePage(driver);
		login.enterEmail("Reenakaur.Qa@gmail.com");
		login.enterPassword("Test123.");
		login.clickLoginButton();
		hpg.getLoggedInAccountName();
		Assert.assertEquals(hpg.getLoggedInAccountName(), PropertyManager.getProperty("accountName"));
			
	}
	
	@Test
	public void contacts(){
		LoginPage login = new LoginPage(driver);
		HomePage hpg = new HomePage(driver);
		login.enterEmail("Reenakaur.Qa@gmail.com");
		login.enterPassword("Test123.");
		login.clickLoginButton();
		hpg.clickContacts();
		hpg.clickSubContacts();
		Assert.assertEquals(hpg.createContactappears(), true);
		
		

	}
	
}
