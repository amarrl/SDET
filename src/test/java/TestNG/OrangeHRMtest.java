package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRMtest {
	WebDriver driver; 
	@Test(priority=1) 
	void openApplication() {
		
		 driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		
	}
	@Test(priority=2)
	void TestLogo() throws InterruptedException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
		Thread.sleep(3000);
		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		System.out.println(logo.isDisplayed());
		
	}
	@Test(priority=3)
	void Login() {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
	}
	
	@Test(priority=4)
	void logout() {
		driver.quit();
		
	}
	
	
}
