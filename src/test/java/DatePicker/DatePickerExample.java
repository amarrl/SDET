package DatePicker;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePickerExample {
	
	static void SelectfutherDate(WebDriver driver,String month,String year,String date) {
		while(true) {
			String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			String currentyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			
			
			if(currentmonth.equals(month)&& currentyear.equals(year)) {
				driver.findElement(By.xpath("//a[text()='"+date+"']")).click(); 
				break;  
				
			}
			else {

				WebElement Next=driver.findElement(By.xpath("//span[text()='Prev']/parent::a/following-sibling::a//span[text()='Next']"));
			//Thread.sleep(Duration.ofSeconds(5));
			}
			
		}
		
	}
	



	static void SelectPreviousDate(WebDriver driver,String month,String year) {
		while(true) {
			String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			String currentyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			
			
			if(currentmonth.equals(month)&& currentyear.equals(year)) {
				driver.findElement(By.xpath("//a[text()='22']")).click();
				break;
				
			}
			else {

				WebElement pre=driver.findElement(By.xpath("//span[text()='Next']/parent::a/preceding-sibling::a//span[text()='Prev']"));
			//Thread.sleep(Duration.ofSeconds(5));
			}
			
		}
		
	}
	
		
	
	public static void main(String[]args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		WebElement Datepicker=driver.findElement(By.xpath("//h3[text()='Widgets']/following::ul/child::li/child::a[text()='Datepicker']"));
		Datepicker.click();
		
		WebElement frmae=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(frmae);
		driver.findElement(By.id("datepicker")).click();
		
		//1.Method 1 using sendkeys
		
		//driver.findElement(By.id("datepicker")).sendKeys("05/06/2024");  //mm/day/yyyy
		
		//2.Method 2 :using date picker
		
		String year="2025";
		String month="May";
		String date="13";
		
		SelectfutherDate(driver,month,year);
		SelectPreviousDate(driver,month,year);
	
		
		//List<WebElement> monthYear=driver.findElements(By.xpath("//div[@class='ui-datepicker-title']/child::span[@class='ui-datepicker-month' or @class='ui-datepicker-year']"));
		
		//String currentmonth=monthYear.get(0).getText();;
		//String currentyear=monthYear.get(1).getText();;
		
		
		
		
		
		
	
		
		
		
		/*
		for(WebElement mmyy:monthYear) {
			String mm=mmyy.getText();
			System.out.println(mm);
			
		}*/
		/*
	for(int i=0;i<100;i++) {
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(pre, null)
		String gmonth=monthYear.get(0).getText();
		String gyear=monthYear.get(1).getText();
		
		
		if(gmonth.equals(month) && gyear.equals(year)) {
			
			driver.findElement(By.xpath("//a[text()='22']")).click();
			break;
		
			
		}
		else {
			
		

			wait.until(ExpectedConditions.elementToBeClickable(Next));
			Next.click();
			//driver.findElement(By.xpath("//span[text()='Tu']")).click();
			
			Thread.sleep(Duration.ofSeconds(1));
		
			
		}
			*/
		
	
	}
	

}
