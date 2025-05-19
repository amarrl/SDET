package MouseOverAction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickorContextClick {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement contextclickE=driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action=new Actions(driver);
		action.contextClick(contextclickE).perform();  //build() explicitly added by perform
		
		driver.findElement(By.xpath("//span[text()='Paste']")).click();
		String alertname=driver.switchTo().alert().getText();
		System.out.println(alertname);
		driver.switchTo().alert().accept();
		 
		
		
		

	}

}
