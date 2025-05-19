package SeleniumTestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import com.sun.tools.javac.util.List;

public class Xpathes {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		 
		
		String g=driver.findElement(By.xpath("//a[contains(text(),'L&T')]/self::a")).getText();
		System.out.println("Self :"+g);
		
		String g1=driver.findElement(By.xpath("//a[contains(text(),'L&T')]/parent::td")).getText();
		System.out.println("Parent :"+g1);
		
		 
		
	java.util.List<WebElement>fdfe=driver.findElements(By.xpath("//a[contains(text(),'L&T')]/ancestor::tr/child::td"));
		System.out.println("Parent :"+fdfe.size());
		
		//a[contains(text(),'L&T')]/ancestor::tr/child::td

	}

}
