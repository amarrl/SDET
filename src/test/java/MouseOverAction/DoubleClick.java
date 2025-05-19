package MouseOverAction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement box1	=driver.findElement(By.xpath("//h2[text()='Double Click']/following-sibling::div//input[@id='field1']"));
		WebElement box2	=driver.findElement(By.xpath("//h2[text()='Double Click']/following-sibling::div//input[@id='field2']"));
		WebElement 	doubles=driver.findElement(By.xpath("//h2[text()='Double Click']/following-sibling::div//button[//button='Copy Text']"));
		
		
		box1.clear(); 
		box1.sendKeys("Amat Rajkumar"); 
		
	
		
		Actions act=new Actions(driver);
		
		Action doub=act.doubleClick(doubles).build();
		
		act.doubleClick(doubles).build().perform();
			
			String box2text=box2.getAttribute("value");
			System.out.println("Box2 text is "+box2text);
			
			if(box2text.equals("Amat Rajkumar")) {
				System.out.println("Both same "); 
			}
			else {
				System.out.println("Both not same");
			}
			

	}

}
