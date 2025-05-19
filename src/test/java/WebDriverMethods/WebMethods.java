package WebDriverMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebMethods {
	public static void main(String args[]) {
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	 
	String title=driver.getTitle();
	String url=driver.getCurrentUrl();
	String id=driver.getWindowHandle(); 
	String pageSource=driver.getPageSource(); 
	
	System.out.println("title is "+title);
	System.out.println("URL IS "+url);
	System.out.println("Window ID is "+id);   // id of single browser window 
	//System.out.println(pageSource);
	
	WebElement orangeHRM=driver.findElement(By.linkText("OrangeHRM, Inc"));
	orangeHRM.click(); 
	
Set<String> windowTwo=driver.getWindowHandles(); 




 
for(String s:windowTwo) {
	System.out.println(s);
	
	
}
/*
//windowTwo.driver.switchTo().window();


Object[] s=windowTwo.toArray(); 
System.out.println(s[0]); 

//or below thing concvert set collection into list collection
List<String> listid=new ArrayList(windowTwo);

driver.switchTo().window((String) s[1]);

	
	/*
	WebElement input=driver.findElement(By.cssSelector("input#Form_submitForm_EmailHomePage"));
	input.click();
	input.sendKeys("Amar.r@fireflink.com");


	WebElement input=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("input#Form_submitForm_EmailHomePage")));
	
	input.click();
	input.sendKeys("amar.r@fireflink.com");
	
	
	//If we have many number of vrowser windows we need to use loop statements
	
	for(String s1:windowTwo) {
	String gettittle=driver.switchTo().window(s1).getTitle();
	
	if(gettittle.equals("OrangeHRM")) {
		System.out.println(driver.getCurrentUrl());
	}
	
		
		
	}

		*/


	}
	
	
	
}
