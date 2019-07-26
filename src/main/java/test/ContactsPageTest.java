package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.ExcelReader;
import framework.PropertyManager;
import framework.TestBase;
import framework.TimeUtils;
import page.ContactsPage;
import page.HomePage;
import page.LoginPage;

public class ContactsPageTest extends TestBase {
	


	//@DataProvider(name = "Login")// name of the test
	//public Object[][] toPassLoginData() {//2d array represents rows and column
	 //return new Object[][] {
		//ExcelReader.readExcelData("applicationData.xlsx", "Login", "usera"),//key=unique identifier of the testdata
	// };
	//}
	
	@DataProvider(name = "addContact")// name of the test
	public Object[][] toAddNewContact() {//2d array represents rows and column
	 return new Object[][] {
		ExcelReader.readExcelData("applicationData.xlsx", "Sanity", "contact1"),//key=unique identifier of the testdata
	 };
	}

	@Test
	public void createcontact() {

		LoginPage login = new LoginPage(driver);
		HomePage hpg = new HomePage(driver);
		ContactsPage cpg = new ContactsPage(driver);
		//login.enterEmail(user);
		login.enterEmail(PropertyManager.getProperty("username"));
		//login.enterPassword(password);
		login.enterPassword(PropertyManager.getProperty("password"));
		login.clickLoginButton();
		hpg.clickContacts();
		hpg.clickSubContacts();
		cpg.getContactPageHeader();
		Assert.assertEquals(cpg.getContactPageHeader(), PropertyManager.getProperty("contactHeader"));
	}

	
	@Test(dataProvider="addContact")
	public void createNewContact(String key,String Email,String Firstname,String Lastname,String Jobtitle){
		LoginPage login = new LoginPage(driver);
		HomePage hpg = new HomePage(driver);
		ContactsPage cpg = new ContactsPage(driver);
		login.enterEmail(PropertyManager.getProperty("username"));
		login.enterPassword(PropertyManager.getProperty("password"));
		login.clickLoginButton();
		hpg.clickContacts();
		hpg.clickSubContacts();
		cpg.clickCreateContact();
		cpg.enterEmailForContact(Email);	
		cpg.enterFirstName(Firstname);
		cpg.enterLastname(Lastname);
		TimeUtils.mediumWait();
		cpg.enterJobTitle(Jobtitle);		
		cpg.clickCreateContactFinal();
		//String firstName =cpg.getFirstNameOfContact();
		
		//Assert.assertEquals(firstName, "Ravi");		
		cpg.clickGoToContact();
		
	}
	
	
	
	
}
