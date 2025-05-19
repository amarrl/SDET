package TestNG.Listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShotUtils {
	
	public static void captureScreenShot(WebDriver driver,String name) throws IOException {
		File fi=new File("C:\\New folder\\"+name+".png");
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		//target.renameTo(fi);
		
		
		
		try {
			FileUtils.copyFile(source, fi); 
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
