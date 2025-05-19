package MouseOverAction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 
		
		Actions act=new Actions(driver);	
		WebElement inputbox1=driver.findElement(By.xpath("//textarea[@name='text1']"));
		WebElement inputbox2=driver.findElement(By.xpath("//textarea[@name='text2']"));
		
		inputbox1.sendKeys("Amar Rajkumar");  
		
	//ctl+A
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();  //keydown means pressing keys  //keysdown means releasing
		
		  
		//ctl+C
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		//Tab
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//ctl+v
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform(); 
		
		//act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT)act.keyUp(Keys.CONTROL).perform();
		
		//ctrl+shift+a  below whichever pressing last rel;ese that first
		
		//act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT)act.keyUp(Keys.CONTROL).perform();
		
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER);
		
	}

}
