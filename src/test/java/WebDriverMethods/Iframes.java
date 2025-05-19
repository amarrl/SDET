package WebDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//frame 1
		//WebElement firstframe=driver.findElement(By.xpath(" //frame[@src=\"frame_1.html\"]"));

		//driver.switchTo().frame(firstframe);
		 
		driver.switchTo().frame(0); 

		WebElement firstinput=driver.findElement(By.xpath("//input[@name='mytext1']"));
		firstinput.click();
Thread.sleep(2000);
		firstinput.sendKeys("AmarKumar");
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();  //go back to the main page then only we can go to the 2nd frmae
		//frame2
		
		driver.switchTo().frame(1); 

		WebElement secondinput=driver.findElement(By.xpath("//input[@name='mytext2']"));
		secondinput.click();
Thread.sleep(2000);
secondinput.sendKeys("Amar2222");
 //swicth all the way back to main page
driver.switchTo().defaultContent();
//3rd frame
WebElement thirdframe=driver.findElement(By.xpath(" //frame[@src=\"frame_3.html\"]"));
driver.switchTo().frame(thirdframe);
WebElement thirdinput=driver.findElement(By.xpath("//input[@name='mytext3']"));
thirdinput.click();
Thread.sleep(2000); 
thirdinput.sendKeys("Amar 3333");

//inner frame part of 3
driver.switchTo().frame(0);
driver.findElement(By.xpath("//span[text()='I am a human']")).click();




	}

}
