package ShadowDom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice {

	public static void main(String[] args) {
	
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.aerosimple.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement Login=driver.findElement(By.xpath("(//a[text()='Login'])[1]"))	;
		String jk=Login.getCssValue("background-color"); 
		
		System.out.println(jk);
		
		/*
		WebElement login=driver.findElement(By.xpath("//input[@class='enact_sandstone_Input_InputField_input']"));
		
		WebElement continues=driver.findElement(By.xpath("//p[text()='Continue']"));  
		
		String name=login.getAttribute("placeholder");    
		String h1=login.getDomAttribute("placeholder"); 
		
		String h2=continues.getCssValue("background-color");  
		
		
		
		System.out.println(h1);  
		System.out.println("snxnsnx"+ h2);   
		*/
	}
	

}
