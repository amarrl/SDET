package SeleniumTestCase;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTestCase2 {

	public static void main1(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.savaari.com/"); 
		driver.manage().window().maximize(); 
		 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		List<WebElement> socialMedia=driver.findElements(By.xpath("//a[@class='col-auto px-2']"));
		
		System.out.println(socialMedia.size());
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Round Trip']")));
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Round Trip']")));
		WebElement roundtrip=driver.findElement(By.xpath("//button[text()='Round Trip']"));
		wait.until(ExpectedConditions.elementToBeClickable(roundtrip));
		
		roundtrip.click(); 
		
		WebElement from=driver.findElement(By.xpath("//input[@id='fromCityList']"));
		
		from.sendKeys("Bengaluru");
		from.sendKeys(Keys.ENTER);
		//from.sendKeys(Keys.RETURN);
		//from.sendKeys("Keys.ENTER);
		/*
		WebElement TO=driver.findElement(By.xpath("//input[contains(@placeholder,'Splaceholder')]"));
		TO.sendKeys("Tirupati");
		TO.sendKeys(Keys.ENTER);
		
		*/
		
		WebElement to=driver.findElement(By.cssSelector("input[placeholder='Start typing city - e.g. Mysore']"));
		
		to.sendKeys("Tirupati");
		to.sendKeys(Keys.ENTER);
		

		

	}
	
	public static void main(String[] args) {
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--user-data-dir=C:\\Saregama\\browser");
	}

}
