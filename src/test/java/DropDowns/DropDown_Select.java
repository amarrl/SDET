package DropDowns;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_Select {
	
	public static void main(String[]args) { 
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
	
		WebElement countryOptions=driver.findElement(By.xpath("//select[@id='country']"));
		Select options=new Select(countryOptions);
		
		    
		options.selectByVisibleText("Germany"); 
		options.selectByContainsVisibleText("Geram");
		
		//options.selectByValue("canada");
		
	//	options.selectByIndex(3);
		
	//capture the options from the drop down
		
		List<WebElement>hhs=options.getOptions();  
		
 
		
 
		System.out.println(hhs.size());
		System.out.println(hhs.get(3).getText());
	/*	
	for(int i=0;i<hhs.size();i++) {
		System.out.println(hhs.get(i).getText());
	}
		*/
		
		Select op=new Select(countryOptions); 
		
		
		
		op.selectByVisibleText("Australia");
	
		
		for(WebElement s:hhs) {
			System.out.println(s.getText());
		}
	}

}
