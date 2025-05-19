package POM_Using_Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjectClass1 {
	
	WebDriver driver;
	
	
	//contructor
	
	LoginPageObjectClass1(WebDriver driver){
		this.driver=driver;
		 
		PageFactory.initElements(driver,this);
	}
	
	//locators
	
	@FindBy(xpath="//input[@name='username']") WebElement username_;
	
	@FindBy(xpath="//input[@name='password']") WebElement password_;
	
	@FindBy(xpath="//button[text()=' Login ']") WebElement login_;
	
	

	//Actions
	
	public void setUserName(String username) {
		username_.sendKeys(username);
	}
	
	public void setPassword(String password) {
		password_.sendKeys(password);
	}
	

	public void loginButton() {
		login_.click();
	}
	
}
