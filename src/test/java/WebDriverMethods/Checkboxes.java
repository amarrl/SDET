package WebDriverMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		
		//in order to import all reuired packages conrl+shif+o
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		//1.select specific check boxes
		
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
		
		//to select all the checkboxes
		
		List<WebElement>listcheckbox=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		for(int i=4;i<listcheckbox.size();i++) {	 
			listcheckbox.get(i).click();
			System.out.println("selected all");
		}
	Thread.sleep(5000);
		
		for(int i=0;i<listcheckbox.size();i++) {
			if(listcheckbox.get(i).isSelected()) {
			listcheckbox.get(i).click();
			
		}
		}
		/*
		System.out.println("selecting last 3 check boxes");
		for(int i=4;i<listcheckbox.size();i++) {
			listcheckbox.get(i).click();
			System.out.println("selected all");
		}
		*/
		
		

	}

}
