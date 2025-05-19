package MouseOverAction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionvsActions {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement contextclickE=driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action=new Actions(driver); 
		Action right=action.contextClick(contextclickE).build();  //build() explicitly added by perform
	
		
		right.perform();
	}

}
