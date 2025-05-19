package MouseOverAction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']/p[text()='Drag me to my target']"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']/p[text()='Drop here']"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(drag, drop).perform(); 
		
		System.out.println("draged");  
		

	} 

}
