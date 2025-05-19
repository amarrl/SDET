package ChromeOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class staleElement {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.fireflink.com/");
 
        // Find the element
        WebElement element = driver.findElement(By.xpath("//a[@title='Products']"));

        // Refresh the page (making the element stale)
        driver.navigate().refresh(); 
  
        // Try interacting with the stale element
        element.getText();  // This will throw StaleElementReferenceException
        driver.quit(); 

	}

}
