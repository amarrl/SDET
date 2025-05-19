
package TestNG.ParallelExecution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parraleexecution {
	WebDriver driver; 
@BeforeClass
@Parameters({"browser"})
	
	void setUp(String br) {  
	
	switch(br) { 
	case "chrome": driver=new ChromeDriver(); break; 
	case "edge": driver=new EdgeDriver();break;
	case "firefox": driver=new FirefoxDriver();break;
	
	default:System.out.println("the browser is invalid");return;
	
	} 

		driver.get("https://app.fireflink.com/");  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Test(priority=1)
	void testLoginemail() {
		boolean status1=driver.findElement(By.xpath("//input[@name='emailId']")).isDisplayed();
	Assert.assertEquals(status1, true);
		
		} 
		
		
	@Test(priority=2)
	void testLoginpassword() {
		
		boolean status2=driver.findElement(By.xpath("//input[@name='password']")).isDisplayed();
		
		Assert.assertEquals(status2, true);
		
	}
	
	@AfterClass
	void close() {
		driver.quit();
		
	}

}
