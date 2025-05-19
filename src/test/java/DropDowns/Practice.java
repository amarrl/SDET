package DropDowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Practice {
	
	public static void main(String[]args) {
		
		ChromeOptions options=new ChromeOptions(); 
		options.addArguments("--disable-blink-features=AutomationControlled");
		WebDriver driver=new ChromeDriver(options);
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement countrydrodownOptions=driver.findElement(By.xpath("//select[@id='country']"));
		
		
		String s=countrydrodownOptions.getText();  
		 
		System.out.println(s); 
		
		//Select sc=new Select(countrydrodownOptions);
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		


WebElement options=driver.findElement(By.xpath("//select[@id='country']"));

Select a=new Select(options);
a.selectByIndex(3); 

List<WebElement>dd=a.getOptions();

for(WebElement h:dd) {
	System.out.println(h.getText());
}

	}
	*/

}
}
