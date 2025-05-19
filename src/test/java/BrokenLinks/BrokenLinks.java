package BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	

	
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/"); 
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		List<WebElement>links=driver.findElements(By.tagName("a"));		  
		String hsj=links.get(0).toString();
		int bokenlink=0;
		for(WebElement bothlink:links) { 
			
			String hreflink=bothlink.getAttribute("href");
			
			
			if(hreflink==null || hreflink.isEmpty()) { 
				System.out.println("Hrf value is empty so not possible to check");
				continue;
			}
			try { 
			URL url=new URL(hreflink);  //converted href value from string to URL format
			HttpURLConnection connection=(HttpURLConnection) url.openConnection(); //open connection to the server
			connection.connect();   //connect to server and sent request to server
			
			if(connection.getResponseCode()>=400) { 
				System.out.println("The link is broken :"+hreflink);
				
				bokenlink++;
			}
			else {
				System.out.println("The link is not broken: "+hreflink);
			}
			}
			
			catch(Exception e){
			
			}
			
			
		}
		System.out.println(bokenlink); 
		

	}

}
