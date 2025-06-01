package WebDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrakierCaptcha {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver(); 
		 
		driver.manage().window().maximize();
		driver.get("https://mmpdev.trackier.com/v2/register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement recpatchaFrame=driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
		
		driver.switchTo().frame(recpatchaFrame);
		
		WebElement iamNotRobot=driver.findElement(By.xpath("//span[@id='recaptcha-anchor']"));
		iamNotRobot.click();
		
		driver.switchTo().defaultContent();
		
		//div[@class='recaptcha-checkbox-border']
		
		
		

	}

}
