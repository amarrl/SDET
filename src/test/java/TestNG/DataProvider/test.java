package TestNG.DataProvider;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
	

	static WebDriver driver;
	static WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://app.fireflink.com/");   
		
		
	
		
		WebElement reject=driver.findElement(By.xpath("//button[text()='Reject All']"));
		//reject.click();
		
		WebElement emails=driver.findElement(By.xpath("//input[@name='emailId']"));
		
		emails.sendKeys("amar.r@testyantra.com"); 
		 
		
		
		WebElement passwords=driver.findElement(By.xpath("//input[@name='password']"));
		passwords.sendKeys("Password@123"); 
		
		WebElement sigin=driver.findElement(By.xpath("//button[text()='Sign in']"));
		
		sigin.click();	 
		
		
		
		WebElement firstProduct=driver.findElement(By.xpath("//div[@class='product_1']//img[@alt='fireFlinkPlatform']"));
		
		wait.until(ExpectedConditions.visibilityOf(firstProduct));
		
		wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
		
		
		firstProduct.click(); 
		
		String iirefid=driver.getWindowHandle();
		System.out.println("1st id is "+iirefid);
		 
		Thread.sleep(Duration.ofSeconds(3));
		Set<String>windows=driver.getWindowHandles();
		
		System.out.println(windows);
		System.out.println(windows.size());
		 
		System.out.println("1st current url is "+ (driver.getCurrentUrl()));
		driver.switchTo().window(iirefid); 
		
		System.out.println("1st one title is "+driver.getTitle()); 
		
		for(String til:windows) {
			driver.switchTo().window(til);
			if(til.equalsIgnoreCase("FireFlink")) { 
				//driver.switchTo().window((String)nos[i]); 
				System.out.println(driver.getTitle()); 
				System.out.println(driver.getCurrentUrl());
				break;
			}
			else {
				continue;
			}
			
		}
		
		//Object[]nos=windows.toArray(); 
		
		/*
		for(int i=0;i<windows.size();i++) {
			driver.switchTo().window((String) nos[i]);
			 
			String tittle=driver.getTitle();
			
			if(tittle.equalsIgnoreCase("FireFlink")) {  
				driver.switchTo().window((String)nos[i]); 
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				break;
			}
			else {
				continue;
			}
			
		}
		*/
		
		
		
		/*
		
		*/
		
		
		
		
		
		

	}

}
