package framework;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	
	@DataProvider(name = "Login")// name of the test
	public static Object[][] toPassLoginData() {//2d array represents rows and column
	 return new Object[][] {
		 
		ExcelReader.readExcelData("applicationData.xlsx", "Sanity", "user1"),//key=unique identifier of the testdata
		ExcelReader.readExcelData("applicationData.xlsx", "Sanity", "user2")
		 
		 
		 
	 };
	}
	
	
	
	
	
	
	
}
