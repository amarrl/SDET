package TestNG.Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListener implements ITestListener { 
	
	
    ExtentReports extent = ExtentReportManger.getReportObject();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>(); 
	
	 public void onStart(ITestResult result) {
		   System.out.println( "Test execution is started");//execute only once on test methods starts 
		  }
	
	public void onTestStart(ITestResult result) { 
	   System.out.println("test started--");  //execute only each time when the test methods starts
	   test = extent.createTest(result.getMethod().getMethodName());
	 
       extentTest.set(test);
	  }

	   
	  
	public void onTestSuccess(ITestResult result) { 
	    // not implemented
		
		System.out.println("test is passed");
	    extentTest.get().log(Status.PASS, "Test Passed");
	  }

	
	public void onTestFailure(ITestResult result) {
		
        // This method will be triggered automatically if any test fails

	    // not implemented
		System.out.println("test is fail");
		extentTest.get().fail(result.getThrowable()); // log the error
		
		Object testClass=result.getInstance();  // Get the test class where failure occurred
		
		WebDriver driver=((BaseTest)testClass).getDriver();
		 
		try {
			CaptureScreenShotUtils.captureScreenShot(driver, result.getName());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	  }


	public void onTestSkipped(ITestResult result) {
	    // not implemented
		
		System.out.println("test is skipped");
	     extentTest.get().log(Status.SKIP, "Test Skipped");
	}
	
	
	
	
	  @Override
	    public void onFinish(ITestContext context) {
		  System.out.println("Test execution is completed");
	        extent.flush(); // write everything to report
	    }
		

}
