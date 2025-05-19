package DropDowns;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiddenDropDowns {
	
	public static void main(String[]args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123"); 
		
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		
		WebElement empstatus=driver.findElement(By.xpath("//label[text()='Employment Status']/following::div[1]//div[text()='-- Select --']"));
		empstatus.click();   
		 
		JavascriptExecutor  js=(JavascriptExecutor)driver;         
		 
		 
		List<WebElement>employemts=driver.findElements(By.xpath("//div[@role='listbox']/child::div//span"));
		
		for(WebElement name:employemts) {
			System.out.println(name.getText()); 
			
			if(name.getText().equalsIgnoreCase("Full-Time Probation")) {
				name.click();
				
				break;
			} 
		}
		
		
		
		
		
		/*
		WebElement select=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Job Title']/../..//div[text()='-- Select --']")));
		select.click();
		
		List<WebElement>options=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		/*
		System.out.println(options.size());
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
		
		for(WebElement s:options) {
			System.out.println(s.getText());
		}
		*/
		
	}

}
