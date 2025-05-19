package WebDriverMethods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwoUrlinoneWindow {

	public static void main(String[] args) {
		/*
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
driver.switchTo().newWindow(WindowType.TAB); 
		
		//driver.switchTo().newWindow(WindowType.WINDOW);
driver.get("https://text-compare.com/");
 
*/
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().newWindow(WindowType.WINDOW); 
		
		
	
	
		driver.get("https://www.selenium.dev/");  
		
	Set<String>windows=driver.getWindowHandles();
	
	 
	
	System.out.println(windows); 
	
Object[]ed=	windows.toArray();


driver.switchTo().window((String) ed[0]); 

	System.out.println(driver.getCurrentUrl());
		
	}

}
