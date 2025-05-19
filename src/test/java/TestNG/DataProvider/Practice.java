package TestNG.DataProvider;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Practice {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	
	@Test(priority=1)
	public void launch() {
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://app.fireflink.com/");   
	}
	
	@Test(priority=2,dataProvider="Dp")  
	public void login(String email,String password) throws InterruptedException {
		
		try {
		WebElement reject=driver.findElement(By.xpath("//button[text()='Reject All']"));
		if(reject.isDisplayed()) {
		reject.click();
		}
		
		WebElement emails=driver.findElement(By.xpath("//input[@name='emailId']")); 
		
		emails.sendKeys(email); 
		  
		
		
		WebElement passwords=driver.findElement(By.xpath("//input[@name='password']")); 
		passwords.sendKeys(password);  
		
		WebElement sigin=driver.findElement(By.xpath("//button[text()='Sign in']"));
		 
		sigin.click();	  
		
		
		
		WebElement firstProduct=driver.findElement(By.xpath("//div[@class='product_1']//img[@alt='fireFlinkPlatform']"));
		
		Thread.sleep(Duration.ofSeconds(5));
		
		if(firstProduct.isDisplayed()) {
		
		wait.until(ExpectedConditions.visibilityOf(firstProduct));
		
		wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
		
		
		firstProduct.click();
		}
		
		String parentWindow=driver.getWindowHandle();
		System.out.println("1st id is "+parentWindow);
		 
		Thread.sleep(Duration.ofSeconds(3));
		Set<String>windows=driver.getWindowHandles();
		
	
		for(String wind:windows) {
			driver.switchTo().window(wind); 
			
			String til=driver.getTitle();
			
			if(til.equalsIgnoreCase("FireFlink")) {
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				break;
			}
		}
		
		
	
		driver.findElement(By.xpath("(//*[local-name()='path' and @fill='currentColor'])[2]")).click();
		driver.findElement(By.xpath("//li[text()='Sign out']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(sigin));
		
		driver.switchTo().window(parentWindow);
		
		

		 
		
	
	}
	catch (Exception e) {
        System.out.println("Test failed due to: " + e.getMessage());
    }

	
	}
	
	
	@DataProvider(name="Dp",indices= {0,1})
	Object[][]loginData(){
		
		Object[][]data= {
				{"amar.r@testyantra.com","Password@123"},
				{"amar.r@fireflink.com","Amar@1400"}
				};
		
		return data; 
		
	} 
	
	@DataProvider(name="DPq")
	 Object[][] data(){

	Object data[][]={
	{1,2,3,4},
	{5,6,7,8},
	{3,4,5}

	};
	return data;
	}
	
	
		
	
	
}
