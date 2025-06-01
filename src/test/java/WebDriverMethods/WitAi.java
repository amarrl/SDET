package WebDriverMethods;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WitAi {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String targetUrl = "https://mmpdev.trackier.com/v2/register";
		driver.get(targetUrl);
		String access = "O4WOFP67U4XHEYOR5AYDPITGTX3M6UKR";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		 
        String filePath = System.getProperty("user.home") + File.separator + "track.mp3";
        
		try {
		
			 
			if(driver.findElements(By.xpath("//iframe[@title='reCAPTCHA']")).size()>=1) {
				WebElement reCaptCha =driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
				
				driver.switchTo().frame(reCaptCha);
				

				WebElement reCAPTCHABox = driver.findElement(By.xpath("//span[@id='recaptcha-anchor']"));
				reCAPTCHABox.click();
				
				int size = driver.findElements(By.xpath("//div[text()='You are verified']")).size();
				if(size==0) {
					driver.switchTo().parentFrame();
					
					WebElement reAudioBox =driver.findElement(By.xpath("//iframe[@title='recaptcha challenge expires in two minutes']"));
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(reAudioBox));
				
					WebElement audioChallegeButton =driver.findElement(By.xpath("//button[@title='Get an audio challenge']"));
					audioChallegeButton.click();
					
					String auidoPath=driver.findElement(By.xpath("//div[@class='rc-audiochallenge-control']/audio")).getDomAttribute("src");
					
				}
			}

			
			
		}

		

		driver.switchTo().parentFrame();

		WebElement imagereCAPTCHA = driver
				.findElement(By.xpath("//iframe[@title='recaptcha challenge expires in two minutes']"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(imagereCAPTCHA));
		// driver.switchTo().frame(imagereCAPTCHA);

		WebElement audioChallenge = driver.findElement(By.xpath("//button[@id='recaptcha-audio-button']"));

		audioChallenge.click(); 
		

	}

}
