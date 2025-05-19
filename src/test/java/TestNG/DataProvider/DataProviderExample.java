package TestNG.DataProvider;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	WebDriver driver;
	 WebDriverWait wait;
	@BeforeClass 
	
	void openApp() throws InterruptedException { 
		driver=new ChromeDriver();	
		 
		
		driver.get("https://app.fireflink.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		
		 wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		
	} 
	 
	@Test(priority=1,dataProvider="dp")  
	void testLogin(String email,String Password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='emailId']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		 
		driver.findElement(By.xpath("//button[text()='Sign in']")).click(); 
		
		
		Thread.sleep(Duration.ofSeconds(10)); 
		
		driver.findElement(By.xpath("//img[@alt='fireFlinkPlatform']")).click();
		Set<String>windows =driver.getWindowHandles();
		   
		for(String wind:windows) { 
			
			driver.switchTo().window(wind);
	
			String til=driver.getTitle();
			
			if(til.equalsIgnoreCase("FireFlink")) {
				System.out.println(driver.getTitle());
				break; 
			}
			else { 
				continue;
			}
			
		} 
		/*
WebElement allproje=driver.findElement(By.xpath("//div[text()='All Projects']"));
		
		wait.until(ExpectedConditions.visibilityOf(allproje));
	
		boolean status=driver.findElement(By.xpath("//div[text()='All Projects']")).isDisplayed();
		 
		if(status==true) {
			System.out.println("test case is passed"); 
			
			Assert.assertTrue(true);
		}
		else{
			Assert.fail();
			
		}
		
		*/

		
		driver.findElement(By.xpath("(//*[local-name()='svg']//*[local-name()='path' and @fill='currentColor'])[2]")).click();
		driver.findElement(By.xpath("//li[text()='Sign out']")).click(); 
		
		
		 
	}
	
	@Test(priority=2)
	
	void sigout() {
		
		System.out.println("Done");
	}
	
	
	//@AfterClass
	void close() {
		driver.quit();
		 
	}
	
	@ DataProvider(name="dp",indices= {0,1})
	public Object[][] loginData() {
		Object[][]data= { 
				
				{"amar.r@testyantra.com","Password@123"},
				{"amar.r@fireflink.com","Amar@1400"}
				 
		}; 
		 
		return data;  
		
		
		
	}

}
