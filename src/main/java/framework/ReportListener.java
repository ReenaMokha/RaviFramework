package framework;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportListener extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	
	
	public void onStart(ITestContext testContext){
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/reports/myreport.html");//specify location of the report
		  htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		  
		  extent=new ExtentReports();
		  
		  extent.attachReporter(htmlReporter);
		  extent.setSystemInfo("Host name","localhost");
		  extent.setSystemInfo("Environemnt","QA");
		  extent.setSystemInfo("user","pavan");
		  
		  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		  htmlReporter.config().setReportName("Functional Testing"); // name of the report
		  //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		  htmlReporter.config().setTheme(Theme.STANDARD);

	
		
	}
	
	public void onTestSuccess(ITestResult tr){
		
		 logger=extent.createTest(tr.getName()); // create new entry in th report
		  logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); 
	
		
	}
	
	public void onFinish(ITestContext testContext)
	 {
	  extent.flush();
	 }

	public void onTestFailure(ITestResult tr)
	 {
	  logger=extent.createTest(tr.getName()); // create new entry in th report
	  logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));}

	
	
	
	
	

}
