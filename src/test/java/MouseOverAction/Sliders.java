package MouseOverAction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sliders {

	public static void main(String[] args) {
		
			
			WebDriver driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		WebElement startpoint=driver.findElement(By.xpath("//div[@id='slider-range']/child::span[1]")); 
		//Point startpointloc=startpoint.getLocation().getX();
		Point startpointloc=startpoint.getLocation();  
		System.out.println("LOcation of min slider before moving "+startpointloc);  //(59, 252) x,y
		Actions action=new Actions(driver);
		
		
		//action.dragAndDropBy(startpoint, 100, 252).perform();
		
		//System.out.println("LOcation of min slider After moving "+startpoint.getLocation()); 
		
		WebElement endpoint=driver.findElement(By.xpath("//div[@id='slider-range']/child::span[2]"));
		
		System.out.println("Max location of end point slidr "+endpoint.getLocation());
		action.dragAndDropBy(endpoint, -100, 289).perform();
		
		

		
		
		System.out.println("Max location of end point slidr "+endpoint.getLocation());
		
	
		
		

	}

}
