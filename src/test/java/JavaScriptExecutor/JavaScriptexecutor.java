package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptexecutor {

	public static void main(String[] args) { 
		WebDriver driver=new ChromeDriver();
		
		//ChromeDriver driver=new ChromeDriver(); 
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// js=driver;  //child we are putting into prent object
		
		JavascriptExecutor js1=(JavascriptExecutor) driver;  //we need to do upcasting hear
		
		
		 
		WebElement input1=driver.findElement(By.xpath("//input[@id='name']"));
		
		//passing text into input -alerate of sendkeyss when we get elementinterspected exception we need to use this
		js1.executeScript("arguments[0].setAttribute('value','Jon');",input1);
		
		
	
 
		WebElement radio=driver.findElement(By.xpath("//input[@id='female']"));
		js1.executeScript("arguments[0].scrollIntoView();",radio);
		
		
		
		js1.executeScript("arguments[0].click();",radio );
		
		
	}

}
