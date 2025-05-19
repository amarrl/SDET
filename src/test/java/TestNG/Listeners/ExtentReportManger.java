package TestNG.Listeners;

import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportManger  {
	
	
	static ExtentReports extent; 
	
	public static ExtentReports getReportObject() {  
		
		String path="C:\\New folder"+"\\reports\\index.html";
		ExtentSparkReporter  reporter=new ExtentSparkReporter (path);
		  reporter.config().setReportName("Automation Test Report");
	        reporter.config().setDocumentTitle("Test Results");
	        
	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	        extent.setSystemInfo("Tester", "YourName");
		 
		
		return extent;
		
	}
	
}
