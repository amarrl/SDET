package UploadingFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class practice {

	
		
		WebDriver driver;
		
		@BeforeClass 
		@Parameters({"browser"})
	 void browserSest(String br) {
			 
		switch(br) { 
		 
		case "chrome":{
						driver=new ChromeDriver();

						driver.get("https://app.fireflink.com");
						driver.close();
						break;
 
						}
		case "edge":{
			driver=new EdgeDriver();
			driver.get("https://app.fireflink.com");
			break;
		}
		 
		case "firefox":{
			driver=new FirefoxDriver();
			driver.get("https://app.fireflink.com");
			driver.close();
			break;
		}
		
		}

		}
		
		
		@Test
		void display() {
			System.out.println("done");
		}
		



	}


