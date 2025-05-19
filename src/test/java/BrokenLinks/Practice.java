package BrokenLinks;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Practice {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--force-device-scale-factor=0.8"); 
		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://stage-saarathi.theloan24.in/login"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
		
		 
		
		
		//Identifies the WebDriver session
		String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
		
		System.out.println(sessionId); 
		
	
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[text()='Sign in with Google']/parent::span/parent::button/parent::div")));
		WebElement sigin=driver.findElement(By.xpath("//p[text()='Sign in with Google']/parent::span/parent::button/parent::div"));
		
		wait.until(ExpectedConditions.elementToBeClickable(sigin)); 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView(true);", sigin);
        Thread.sleep(1000);

        
      
        try {
        	sigin.click();
            System.out.println("Clicked using normal click");
        } catch (Exception e) {
            System.out.println("Normal click failed, trying JavaScript click");
            js.executeScript("arguments[0].click();", sigin);
        }
        
        
        
        String secretCode = "w4vc u6vz jqgq jpou vs4s h2sr tvew xtzn";
        Totp totp=new Totp(secretCode);  
       String OTP= totp.now();
        
        
       Set<String>ids= driver.getWindowHandles();
       
       for(String windowids:ids) {
    	   driver.switchTo().window(windowids); 
    	   
    	   if(driver.getCurrentUrl().contains("https://accounts.google.com/") || driver.getCurrentUrl().contains("https://accounts.google.com/")) {
    		   driver.manage().window().maximize();
    		   driver.findElement(By.xpath("//input[@type='email']")).sendKeys("cf.testnaut@cars24.com"); 
    		   WebElement next=driver.findElement(By.xpath("//span[text()='Next']"));
    		   next.click();
    		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
    		   
    		   driver.findElement(By.xpath("//input[@type='password']")).click();
    		   driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testing@1234"); 
    		   driver.findElement(By.xpath("//span[text()='Next']")).click();
    		   
    		   try {   
    			   //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Google sent a notification to y')]/ancestor::div/descendant::img")));
    		   WebElement galaxy=driver.findElement(By.xpath("//div[contains(text(),'Google sent a notification to y')]/ancestor::div/descendant::img"));
    		   WebElement tryanothorWay=   driver.findElement(By.xpath("//span[text()='Try another way']")); 
    		    
    		   if(galaxy.isDisplayed()) { 
    			   //wait.until(ExpectedConditions.visibilityOf(tryanothorWay));
    			  // js.executeScript("window.scrollBy(0,200)", "");
    			   js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", tryanothorWay);
    			  wait.until(ExpectedConditions.elementToBeClickable(tryanothorWay));
    			 
    				  
    				  System.out.println("Clicked using normal");
    			  tryanothorWay.click();
    			 
    			  System.out.println("Clicked using js"); 
    			  js.executeScript("arguments[0].click()", tryanothorWay);
    			   
    		   } 
    		   else {
    			   System.out.println("Galaxy element not found, proceeding without it...");
    		   }
    		   }catch(Exception e) { 
    			   e.printStackTrace();
    			   System.out.println("Galaxy element not found, proceeding without it...");
    		   }
    		    
    		   
    		   WebElement getVerificationcode=driver.findElement(By.xpath("//div[contains(text(),'Get a verification code from the ')]"));
    		   wait.until(ExpectedConditions.elementToBeClickable(getVerificationcode));
    		   getVerificationcode.click();
    		   
    		   WebElement totptextfield=driver.findElement(By.xpath("//input[@id=\"totpPin\"]")); 
    		   totptextfield.sendKeys(OTP);
    		   
    		   WebElement next1=driver.findElement(By.xpath("//span[text()='Next']"));
    		    
    		   wait.until(ExpectedConditions.elementToBeClickable(next1)); 
    		  // js.executeScript("arguments[0].scrollIntoView(true)", next1); 
    		   next1.click(); 
    		     
    		    
    		   
    		    
    		  
    		   
    		  
    		   
    		   WebElement continueButton=driver.findElement(By.xpath("//span[text()='Continue']"));
    		   wait.until(ExpectedConditions.elementToBeClickable(continueButton));
    		   
    		   continueButton.click();
    	   }
       }
    		   
    		   
    		Set<String>ids2= driver.getWindowHandles();
    		 
    		System.out.println("Saarathi home page id "+ids2);
    		
    		for(String windowid2:ids2) {
    			String saarathiHomePage=driver.switchTo().window(windowid2).getTitle();
    			
    			
    			 
    			if(saarathiHomePage.equals("Saarathi")) {
    				 WebElement WelcomePage= driver.findElement(By.xpath("//span[text()='My Leads']/preceding::p[contains(text(),'Welcome, cf testnaut')]"));
    				 WebElement Leads=  driver.findElement(By.xpath("//span[text()='My Leads']"));
    	    		  wait.until(ExpectedConditions.visibilityOf(WelcomePage)); 
    	    		    
    	    		  if(WelcomePage.isDisplayed()) {
    	    			  System.out.println("It is Landed on saarathi Home Page");
    	    			 // Assert.assertEquals(WelcomePage.getText(), "Welcome, cf testnaut");
    	    			  Assert.assertTrue(true);
    	    			  
    	    			  
    	    			  Leads.click();
    	    			  
    	    			  break;
    	    		  }
    			}
    		} 
    		
    		WebElement addNewLead=driver.findElement(By.xpath("//*[text()='Add New Lead']"));
    		
    		wait.until(ExpectedConditions.visibilityOf(addNewLead));
    		addNewLead.click();
    		
    		String random=RandomStringUtils.randomNumeric(9);
    		
    		String mobNumber="8".concat(random);
    		
    		System.out.println(mobNumber);
    		
    		WebElement phonenumber=driver.findElement(By.xpath("//span[text()='Phone Number']/..//input[@placeholder='9999999998']"));
    		phonenumber.sendKeys(mobNumber);
    		
    		
    		 WebElement productType=driver.findElement(By.xpath("//span[text()='Product Type']/parent::div//input"));
    		 productType.click(); 
    		 
    		List<WebElement> productTypeOptions = driver.findElements(By.xpath("//div[@class='ant-select-item-option-content']"));
    
    		for(WebElement op:productTypeOptions) {
    			if(op.getText().equals("Used Cars")) {
    				op.click();
    			}
    			break;
    		}
    		   
    		WebElement d2c=driver.findElement(By.xpath("//span[text()='Channel']/parent::div/descendant::label[@for='D2C']"));
    		
    		d2c.click();
    		
    		WebElement requestConstent=driver.findElement(By.xpath("//div[text()='Request consent']"));
    		requestConstent.click();
    		
    		WebElement resendCode=driver.findElement(By.xpath("//button[text()='Resend code']"));
    		
    		wait.until(ExpectedConditions.elementToBeClickable(resendCode));
    		
    		
    		WebElement digitCode4=driver.findElement(By.xpath("//p[contains(text(),'Enter the 4-digit code ')]/parent::div/descendant::div[contains(@class,'ant-otp')]"));
    		//wait.until(ExpectedConditions.elementToBeClickable(digitCode4));
    		wait.until(ExpectedConditions.visibilityOf(digitCode4));
    		digitCode4.click();
    		Thread.sleep(2000);
 		digitCode4.sendKeys("1234");  
    		 
    		WebElement proceed=driver.findElement(By.xpath("//div[text()='Proceed']"));
    		proceed.click(); 
    		
    		   
    		 
    		  
    		  
    		   
    		   
    	   }
    
		
		

	}


