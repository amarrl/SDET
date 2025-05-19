package DataDriver_Testing;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataUsingUtilities {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String filepath=System.getProperty("user.dir")+"\\Test Data\\dataDrivern.xlsx";
		
		int rows=DataDrivenExcelUtils.getRowCount(filepath, "Sheet1");
		System.out.println(rows);
		
		 
	 
		 
	 
			//read data  from excel
			
			
			//pass data into application
			//validation
		String bookmname=DataDrivenExcelUtils.getCellData(filepath, "Sheet1", 1, 0);
		
		System.out.println(bookmname);
		driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys(bookmname);
		
		DataDrivenExcelUtils.SetCellData(filepath, "Sheet1", 1, 4, "wright back done");
		System.out.println("done");
	}

}
