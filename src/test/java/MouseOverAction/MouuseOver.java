package MouseOverAction;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouuseOver {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String currentfirstwindowid=driver.getWindowHandle();
		System.out.println("Second window "+currentfirstwindowid);
		System.out.println("1st url is "+driver.getCurrentUrl());
		
		WebElement swicth=driver.findElement(By.xpath("//div[@id='HTML4']/child::div/child::button[text()='New Browser Window']"));
		swicth.click();
		
		Set windows=driver.getWindowHandles(); 
		List<String>listids=new ArrayList(windows); 
		
		
		
	
		driver.switchTo().window(listids.get(1));
		System.out.println("Second window "+driver.getWindowHandle());
	    System.out.println("2nd url is "+driver.getCurrentUrl());
	    WebElement destop=driver.findElement(By.xpath("//div[@id='narbar-menu']/child::ul//a[text()='Desktops']"));
	    Actions action=new Actions(driver);
	   
	    
	    WebElement mac=driver.findElement(By.xpath("//div[@class='dropdown-menu']/child::div//a[text()='Mac (1)']"));
	     action.moveToElement(destop).moveToElement(mac).build().perform();
	    
	    mac.click();
		

	}

}
