package MouseOverAction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Newwindows {

	public static void main(String[] args) {
		
			
			WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement register=driver.findElement(By.xpath("//a[text()='Register']"));
		
		Actions act=new Actions(driver); 
		act.keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).perform();
		
			
		

	}

}
