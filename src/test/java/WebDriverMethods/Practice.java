package WebDriverMethods;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {

	public static void main(String[]args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://demo.trackier.io/campaign/create.html");
		
		driver.manage().window().maximize();
		
		WebElement email=	driver.findElement(By.xpath("//input[@name='email']"));
		
		WebElement password=	driver.findElement(By.xpath("//input[@name='password']	"));
		
		WebElement Login=driver.findElement(By.xpath("//button[text()='Log In']"));
		
		email.sendKeys("info@trackier.com");
		password.sendKeys("test@123#");
		Login.click();
		
	 
		driver.findElement(By.xpath("//label[text()='Advertiser']/following::span/following::span")).click();
		
		List<WebElement>e1=driver.findElements(By.xpath("//label[text()='Advertiser']/following::div/../../../..//span[@class='select2-results']/child::ul/child::li"));
		 
		for(WebElement e11:e1) { 
			String TEXT=e11.getText();
			System.out.println("Text is "+TEXT); 
		}
		
		
	}
}
