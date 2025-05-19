package JavaScriptExecutor;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
	
	public static void main(String[]args) {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.crematrix.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//JavaScriptExecutor js=driver;
		
		WebElement blog=driver.findElement(By.xpath("//a[text()='Blog']")); 
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		  
		js.executeScript("arguments[0].scrollIntoView();", blog);
		
		WebElement CRELeaseMatrix=driver.findElement(By.xpath("//h4[text()='About Us']/following::div/ul/child::li/a[text()='CRE Lease Matrix']"));
		js.executeScript("arguments[0].click();", CRELeaseMatrix); 
		
		Set<String>windows=driver.getWindowHandles();
		System.out.println(windows); 
		
		String[]aa=(String[]) windows.toArray();
		
		//js1.executeScript("arguments[0].scrollIntoView();",radio);
	}

}
