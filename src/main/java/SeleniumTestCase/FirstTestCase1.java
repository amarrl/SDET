package SeleniumTestCase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;

public class FirstTestCase1 {
	
	public static void main(String[]args) {
		//ChromeDriver driver=new ChromeDriver();
		
		//Luanch Browser
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		//driver.get("https://mvnrepository.com/");
		
		//Navigate to URL
	driver.navigate().to("https://mvnrepository.com/");
	
		
	
	//Validate Tittle should be "" before that you get after navigating and verify with the exoected one
	
	String act_titlle=driver.getTitle();
	
	System.out.println(act_titlle);
	
	String exp_title="Maven Repository: Search/Browse/Explore";
	
	if(exp_title.equals(act_titlle)) {
		System.out.println("title matched");
	}
	else {
		System.out.println("Tittle didn't match");
	}
	
		//driver.close();
	}

}
