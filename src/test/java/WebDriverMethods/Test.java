package WebDriverMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Test {

	public static void main(String[] args) throws IOException, TesseractException {
		
WebDriver driver=new ChromeDriver();
		
	File target=new File("C:\\Users\\Amar\\Downloads\\screenshot - 2025-05-15T162053.312.jpg");
		
		driver.manage().window().maximize();
		driver.get("https://apply.dsuonline.com/"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		WebElement captch=driver.findElement(By.xpath("//span[@class='beforeCImage_new']/following-sibling::img"));
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=captch.getScreenshotAs(OutputType.FILE); 
		
	FileUtils.copyFile(source, target);
	

	ITesseract tesseract=new Tesseract();
	 tesseract.setDatapath("C:\\Users\\Amar\\Desktop\\exe\\tessdata");
	String text=tesseract.doOCR(target); 
	System.out.println(text); 
	 
		
		
	}

}
