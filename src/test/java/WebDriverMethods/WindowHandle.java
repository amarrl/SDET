package WebDriverMethods;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

public class WindowHandle {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
driver=new ChromeDriver();

driver.manage().window().maximize();
		
		driver.get("https://www.myntra.com/login");
		  
		String MyntraTittle=driver.getTitle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://automate.browserstack.com/"); 
		
		String browsrStack=driver.getTitle(); 
		
		
		System.out.println(driver.getCurrentUrl());
		
		Set<String>windIDs=driver.getWindowHandles();
		
		Iterator<String>itrIDS=windIDs.iterator();
		
		while(itrIDS.hasNext()) {
			
			
		String switchedTabTitle=driver.switchTo().window(itrIDS.next()).getTitle();
		Thread.sleep(5000);      
		if(switchedTabTitle.equalsIgnoreCase("Myntra")) { 
			
			System.out.println(driver.getCurrentUrl());
			break;
		}
		}  

		driver.findElement(By.xpath("//input[@class='form-control mobileNumberInput']")).sendKeys("12345ty");
		
		 
		
		
		
		

	}

}
