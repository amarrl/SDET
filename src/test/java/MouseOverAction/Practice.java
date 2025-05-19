package MouseOverAction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice {

	public static void main(String[] args) {
		
	
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/"); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
		
		WebElement name=driver.findElement(By.xpath("//input[@id='name']"));
		
		name.sendKeys("Amar R");
		
		
		
		
		Actions act=new Actions(driver);
		
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
			
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform(); 
		 
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();   
		
		driver.switchTo().window(driver.getWindowHandle());
		
		act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("i").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
	
	
		
	}

}
