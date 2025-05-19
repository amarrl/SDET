package ChromeOptions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless {

	public static void main(String[] args) {
		
		ChromeOptions options=new ChromeOptions();  
		options.addArguments("--headless=new");   
		options.addArguments("--disable-blink-features=AutomationControlled");
		
		  
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		  
		System.out.println("=====headless done");

	}

}
