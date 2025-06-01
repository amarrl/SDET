package UploadingFile;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadonClickOnElement {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
		
		//ChromeDriver driver=new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php"); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		//1.single file upload
		WebElement file=driver.findElement(By.xpath("//strong[text()='Upload Files:']/following-sibling::input"));
		Thread.sleep(2000); 
		/*
file.sendKeys("C:\\Users\\Amar\\Downloads\\BillSummary.pdf");

String name=driver.findElement(By.xpath("//ul[@id='fileList']/child::li")).getText();
System.out.println(name);
*/
//2.multiple file upload

String file1="C:\\Users\\Amar\\Downloads\\BillSummary.pdf";

String file2="C:\\Users\\Amar\\Downloads\\BillSummary.txt";
file.sendKeys(file1+"\n"+file2);

List<WebElement> files=driver.findElements(By.xpath("//ul[@id='fileList']/child::li"));

for(WebElement filesname:files) {
	System.out.println(filesname.getText());
	
	
	
}









	}

}
