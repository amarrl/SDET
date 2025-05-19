package ShadowDom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shadowdom {
	
	//if shdow dom is

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();;
		driver.get("https://dev.automationtesting.in/shadow-dom"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		 
		SearchContext shadow0=driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		String sh1=shadow0.findElement(By.cssSelector("#shadow-element")).getText();

		SearchContext shadow1=shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		 
		Thread.sleep(1000);
		SearchContext shadow2=shadow1.findElement(By.cssSelector("#nested-shadow-root")).getShadowRoot();
			String sh2=shadow2.findElement(By.cssSelector("Nested Shadow Element")).getText();
			System.out.println(sh2);

	}

}
