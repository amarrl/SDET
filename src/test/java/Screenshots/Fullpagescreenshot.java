package Screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fullpagescreenshot {

	public static void main(String[] args) {
WebDriver driver=new ChromeDriver();  
		
		driver.manage().window().maximize();;
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
	TakesScreenshot ts=(TakesScreenshot) driver; 
	File sorcefile=	ts.getScreenshotAs(OutputType.FILE); 
	
	File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
		
			//C:\Users\Amar\eclipse-workspace\new 2024 ide\SDET"\screenshots.fullpage.png"
			sorcefile.renameTo(targetfile);

	}
	
}
