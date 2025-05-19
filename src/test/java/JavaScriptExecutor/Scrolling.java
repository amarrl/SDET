package JavaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scrolling {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	JavascriptExecutor ja=(JavascriptExecutor) driver;  
	
	
	// 1) scroll down the page by pixel number
	//ja.executeScript("window.scrollBy(0,1500)", "");  
	  
	System.out.println(ja.executeScript("return window.pageYOffset;")); 
	
	
	//2) scrooll down the page till element is visible
	
	WebElement scroll1=driver.findElement(By.xpath("//h2[text()='HTML Static Table']"));
	
	//ja.executeScript("arguments[0].scrollIntoView();", scroll1);
	
	System.out.println(ja.executeScript("return window.pageYOffset;"));
	
	
	//3)Scroll till end of the page
	
	ja.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
	//4)Scroll till begining of the page
	
	Thread.sleep(Duration.ofSeconds(3));
	
	ja.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}

}
