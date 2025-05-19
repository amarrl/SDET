package WebDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptExecuterClick {

	public static void main(String[] args) throws InterruptedException {
		
			WebDriver driver=new ChromeDriver();
			driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize(); 
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			
			WebElement orangeHRM=driver.findElement(By.xpath("//input[@name='password']"));
			//orangeHRM.click();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();",orangeHRM); 
			orangeHRM.sendKeys("shbhbsbhhbs"); 
			System.out.println("----------");
			
			
			

	}

}
