package Screenshots;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Specific_Area_GetScreenshot {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();;
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		/* 
		WebElement newbrowser=driver.findElement(By.xpath("//button[text()='New Browser Window']"));
		newbrowser.click();
		
		Set g=driver.getWindowHandles();
	
		//Object[]f=g.toArray();
		
		List arr=new ArrayList(g);
		
		driver.switchTo().window((String) arr.getLast());
		*/
		WebElement featured=driver.findElement(By.xpath("//h2[text()='Footer Links']"));
		 
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", featured); 

		//ja.executeScript("arguments[0].scrollIntoView();", scroll1); 
		
		WebElement featuredfullpage=driver.findElement(By.xpath("//h2[text()='Footer Links']"));
		Thread.sleep(2000);
	
		//TakesScreenshot ts=(TakesScreenshot)driver;
		File screen1=featuredfullpage.getScreenshotAs(OutputType.FILE);
		
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\specificelementsx2.png");
		screen1.renameTo(targetfile); 
		 
		
		 
		

	}

}
