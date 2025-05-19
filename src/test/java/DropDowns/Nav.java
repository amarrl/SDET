package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nav {

	public static void main(String[] args) throws InterruptedException{
		
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://app.staging.aerosimple.com/auth/login"); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("manoj.kamble@testyantra.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Aero@2023");
		driver.findElement(By.xpath("//span[text()='Login with Password']")).click();
		
		WebElement app=driver.findElement(By.xpath("//span[text()='apps']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='apps']")));
		wait.until(ExpectedConditions.elementToBeClickable(app));
		Thread.sleep(5000);
		app.click();
		 
		
		
		driver.findElement(By.xpath("//span[text()='Work Orders']")).click();
		
		driver.findElement(By.xpath("//span[text()='Airfield Work Orders']")).click();
		WebElement newfr=driver.findElement(By.xpath("//span[text()='New Work Order']"));
		Thread.sleep(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='New Work Order']")));
		wait.until(ExpectedConditions.elementToBeClickable(newfr));
		newfr.click();
		
		
		WebElement catagories=driver.findElement(By.xpath("//span[text()='Create Work Order']//following::div//select[@name='select-field-category']"));
		
		Select op=new Select(catagories);
		op.selectByVisibleText("Fueling Operations");
		
		
		
		
		
		 
		List<WebElement>s=op.getOptions();
		
		
		System.out.println("==========");
		
		for(WebElement sq:s) {
			System.out.println(sq.getText());
		}
		
		}
	}

