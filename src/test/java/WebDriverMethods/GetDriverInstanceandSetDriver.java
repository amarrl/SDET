package WebDriverMethods;



import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v129.runtime.model.DeepSerializedValue.Type;

public class GetDriverInstanceandSetDriver {
	
	public static WebDriver driver;
	public static WebDriver driver2;
	
	
	
	public static void main(String[]args)  {
		
		driver=new ChromeDriver();
		
		driver.get("https://www.myntra.com/login");
		
		System.out.println(driver); 
		
		ChromeOptions options=new ChromeOptions(); 
		options.addArguments("--start-maximized");
		driver2=new ChromeDriver(options);
		
		driver2.get("https://www.myntra.com/login");
		
		driver.findElement(By.xpath("//input[@class='form-control mobileNumberInput']")).sendKeys("12345ty");
		
		
	
		
		driver2.findElement(By.xpath("//input[@class='form-control mobileNumberInput']")).sendKeys("12345ty");
		 
		
		
		
		
		
		
		
	}

}
