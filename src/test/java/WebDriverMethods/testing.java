package WebDriverMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testing {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com"); // Replace with your actual URL  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
  
        
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        
        

        // Store first 10 hrefs
        List<String> urls = new ArrayList<>();
        for (int i = 0; i < 10 && i < linkElements.size(); i++) {
            String href = linkElements.get(i).getAttribute("href");
            if (href != null && !href.isEmpty()) {
                urls.add(href);
            }
        }
 
        // Now open each link in a new tab and print the title
        for (String url : urls) {
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get(url);
            System.out.println("Title: " + driver.getTitle());
            driver.close();
            driver.switchTo().window(driver.getWindowHandles().iterator().next()); // back to original tab
        } 
  
        driver.quit();
        
        driver.switchTo().defaultContent();
    }
}
