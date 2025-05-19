package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObjectClass {
	
	WebDriver driver;
	
	//Contructor
	LoginPageObjectClass(WebDriver driver){
		this.driver=driver;
		
	}
	 

	//Locators
	
		By username_=By.xpath("//input[@name='username']");
		
		By password=By.xpath("//input[@name='password']");
		
		By login=By.xpath("");
		 
	//Action Methods
		
		public void setUserName(String username) {
			driver.findElement(username_).sendKeys(username);
			
		}
		
		public void setPassword(String pass) {
			driver.findElement(password).sendKeys(pass);
		}
		
		public void clickOnLogin() {
			driver.findElement(login).click();
		}
		
		

}
