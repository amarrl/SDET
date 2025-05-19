package TestNG.Listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestNG.Listeners.MyListener.class )
public class TestLinstenmers extends BaseTest { 
	 
	//WebDriver driver; 
	@BeforeClass
	void openApplication() {
		 
		 driver=new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		
	}
	@Test(priority=2)
	void TestLogo() throws InterruptedException {
		
		driver.get("https://www.orangehrm.com/");
		Thread.sleep(3000);
	
		
	}
	@Test(priority=3)
	void Login() {
		
	
		
		WebElement logo=driver.findElement(By.xpath("//a[@class='navbar-brand nav-logo']//img[@alt='OrangeHRM lLogo']"));
		boolean status=logo.isDisplayed();
		Assert.assertEquals(status, true); 
		
		
	}
	
	@Test(dependsOnMethods= {"Login"})
	void input() {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	}
	
	@AfterClass
	void logout() {
		driver.quit();
		
	}
	

}
