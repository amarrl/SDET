package BrokenLinks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class CaptchSas {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://sastasundar.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); 

		//WebElement WlcLogin=driver.findElement(By.xpath(""));
		WebElement deliveryPopUp=driver.findElement(By.xpath("//h2[text()='Where do you want the delivery?']/../../../child::a[@id='js_location_cancel']"));
		
		if(deliveryPopUp.isDisplayed()) {
			deliveryPopUp.click();
		}
		 
		
		By loginBtn = By.xpath("//span[text()='Login']");

		int attempts = 0;
		while (attempts < 3) {
		    try {
		        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		        break; // Exit loop if successful
		    } catch (StaleElementReferenceException e) {
		        System.out.println("Retrying due to stale element...");
		    }
		    attempts++;
		}
		
		WebElement LOGIN=driver.findElement(By.xpath("//a[@id='logpop']"));
		LOGIN.click();
		
		WebElement QuickLogin=driver.findElement(By.xpath("//h2[text()='Quick Login / Register']"));
		
		
		QuickLogin.isDisplayed();
		
		WebElement enterMob=driver.findElement(By.xpath("//input[@id='email_mobileno']"));
		
		enterMob.sendKeys("9826783567");
		
		WebElement captchImag=driver.findElement(By.xpath("(//div[@class='captchaHolder'])[1]"));
		
		File des=new File("C:\\Users\\Amar\\Downloads\\screenshot - 2025-05-12T151710.421.jpg");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File outputFile=captchImag.getScreenshotAs(OutputType.FILE);
	
		FileUtils.copyFile(outputFile,des);	 	  
		 
		String res=GetTextFromImage(des.toString());
		System.out.println(res);
 
		
	}


  

public static String GetTextFromImage(String filePath) {
	String responseText = "";
	try {
		byte[] bodyBytes = readFileToBytes(filePath);
		Response response = RestAssured.given().header("apikey", "6yPMEmT5SjZ04U7NMAsGOIpHOpXqMVMS")
				.contentType("application/octet-stream")
				.body(bodyBytes).post("https://api.apilayer.com/image_to_text/upload");
		responseText = response.jsonPath().get("all_text"); 
		System.out.println("Fetched text from Image");

	} catch (Exception e) {
		System.out.println("failed to Fetch text from Image");

	}
	return responseText;
}


public static byte[] readFileToBytes(String filePath) {
	try {
		return Files.readAllBytes(Paths.get(filePath));
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}
}