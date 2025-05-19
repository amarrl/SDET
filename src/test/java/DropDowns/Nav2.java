package DropDowns;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;


import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TessAPI;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.Word;
import net.sourceforge.tess4j.util.LoadLibs;

public class Nav2 {

	public static void main(String[] args) throws WebDriverException, IOException, TesseractException {
		// TODO Auto-generated method stub

		DesiredCapabilities cap=new DesiredCapabilities();  
		cap.setCapability("platformName", "Android");
		//		cap.setCapability("udid", "RZ8T60RAEPB");
		AndroidDriver driver=new  AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		ITesseract tesseract = new Tesseract();
		System.out.println(LoadLibs.extractTessResources("tessdata").getAbsolutePath());
		tesseract.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath());
		tesseract.setLanguage("eng");
//		TakesScreenshot sc=(TakesScreenshot) driver;
//		//		sc.getScreenshotAs(null);
//		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File("C:\\Users\\Amar\\Downloads\\Text.png");
//        FileHandler.copy(screenshot, destinationFile);
        InputStream ip = new FileInputStream("C:\\Users\\Amar\\Downloads\\Text.jpg");
		BufferedImage bufferedImage = ImageIO.read(ip);
		String result = tesseract.doOCR(bufferedImage);
		System.out.println("---=="+result);
		List<net.sourceforge.tess4j.Word> words = tesseract.getWords(bufferedImage, TessAPI.TessPageSegMode.PSM_AUTO);
		for (Word word : words) {
			
		System.out.println(word);
		}
		// Your program element business logic starts here ...
		for (Word word : words) {
			if (word.toString().toLowerCase().contains("Container Carrier")) {
				int x1 = word.getBoundingBox().x;
				int y1 = word.getBoundingBox().y;
				System.out.println(x1+"x "+y1+" y");
				int width = word.getBoundingBox().width; 
				int height = word.getBoundingBox().height;
				TouchAction action = null;
				int x = x1+(width/2);
				int y = y1+(height/2);
				System.out.println(x+"x "+y+" y");
				action = new TouchAction(driver);
				//				}
				//				else {
				//					action = new TouchAction(iosDriver);
				//				}
				action.tap(PointOption.point(x, y)).perform();
			}
			System.out.println("----");

		}
	}
}
