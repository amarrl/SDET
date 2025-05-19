package WebDriverMethods;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class Tessaract {
	
	
	TakesScreenshot tc=(TakesScreenshot)driver;
	File sourceFile=l.imagPath.getScreenshotAs(OutputType.FILE);   
	File targetfile=new File("C:\\Users\\Amar\\Desktop\\Selenium\\ScreenShots\\"+random+".png");
	sourceFile.renameTo(targetfile);
	
	  //ImageIO.write(ImageIO.read(Sourcefile), "png", targetfile);
	
	ITesseract tesseract=new Tesseract();
	 tesseract.setDatapath("C:\\Users\\Amar\\Desktop\\exe\\tessdata");
	String text=tesseract.doOCR(targetfile); 
	System.out.println(text); 
	 
	l.enterCaptchaText(text);
	Thread.sleep(5000); 
	

}
