package BrokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnotherBrokenLink {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		int brokenlink=0;
		driver.get("https://www.deadlinkchecker.com/"); 
		String idd=driver.getWindowHandle();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		List<String>tabUrls=new ArrayList<>();
		
		
		List<WebElement>elemet=driver.findElements(By.tagName("a"));
		
		for(WebElement el:elemet) {
			
			String href=el.getDomAttribute("href"); 
			
			if(href==null || href.isEmpty()) {
				System.out.println("The link is empty not posiible to check");
				continue;
			}  
			
			try {
				
				URL url=new URL(href);
			
				HttpURLConnection connection=(HttpURLConnection) url.openConnection();
				connection.connect();
				
				if(connection.getResponseCode()>=400) {
					System.out.println("The link is broken "+href); 
					brokenlink++; 
				}
				else {
					tabUrls.add(href);
					System.out.println("The link is not broken "+href);
				}
			}
			catch(Exception e) {
				
			}
		}
	
		System.out.println("Number of BrokenLinks are "+brokenlink);
		System.out.println("------------------------------------------");
		 
System.out.println(tabUrls); 
/*
for(String navi:tabUrls) {
	driver.switchTo().newWindow(WindowType.TAB).get(navi);
	String ti=driver.getTitle();
	
	
	
	try {
		WebElement elle=driver.findElement(By.xpath("//input[@value='USD']/parent::td/child::input"));
		WebElement usd=wait.until(ExpectedConditions.visibilityOf(elle));
		
		System.out.println("Switched to window with matching element "+usd.getDomAttribute("value"));
		
		
	}catch(Exception e) { 
		
	}
	
	driver.close();
	
	driver.switchTo().window(idd);      
	break;
	//driver.switchTo().window(driver.getWindowHandles().iterator().next());
	
	   
}

*/

for(int i=0;i<tabUrls.size();i++) {
	driver.switchTo().newWindow(WindowType.TAB);
	String urlString=tabUrls.get(i);
	
	 driver.get(urlString);
String tit=	 driver.getTitle();
System.out.println(tit);
driver.close();

driver.switchTo().window(driver.getWindowHandles().iterator().next());


}

	}

}
