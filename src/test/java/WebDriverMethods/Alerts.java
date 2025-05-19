package WebDriverMethods;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		//Alerats windows are not web elements as well as inside alert any elemnst is not webelemnsts they are not inspectable
		
		WebDriver driver=new ChromeDriver(); 
		 
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//normal 1st one alrt with  ok
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(5000);
		//whichever alert window is open on the current web page this will capture that alert window and this we can store it in a variable as well
		/*
		
	  Alert	myalert=driver.switchTo().alert();  //
	  System.out.println(myalert.getText());
	  Thread.sleep(3000); //hard wait
	  myalert.accept();
	  Thread.sleep(3000); 
	  
	  //2. cofirmation alert whick has ok and cancel
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	 ; 
	Alert ok=driver.switchTo().alert();
System.out.println(ok.getText());
	Thread.sleep(3000);
	//ok.accept();
	ok.dismiss();
	
	
	// 3.Promt alrt input box
	  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	  
	  Alert promt=driver.switchTo().alert();
	  System.out.println(promt.getText());
		Thread.sleep(3000);
	  promt.sendKeys("I am King");
		Thread.sleep(3000);
	  promt.accept();
	  
	  */
	  //Using explict wait to handle alert
	  
	Alert explictAlert=wait.until(ExpectedConditions.alertIsPresent()); 
	
	explictAlert.accept(); 
	//explictAlert.dismiss();
	
	//Authoticated popup
	//https://the-internet.herokuapp.com/basic_auth
	//https://admin:admin@the-internet.herokuapp.com/basic_auth
	
	driver.get("https://the-internet.herokuapp.com/basic_auth");
	//https://userName:password@the-internet.herokuapp.com/basic_auth
	driver.get("admin:admin@https://the-internet.herokuapp.com/basic_auth");

	}

}
