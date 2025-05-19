package TestNG.Grouping;

import org.testng.annotations.Test;

public class LoginTest {
	
	@Test(priority=1,groups= {"sanity"}) 
	void loginEmail() { 
		System.out.println("This is login by email");
	}
	
	@Test(priority=2,groups= {"sanity"})  
	void loginFb() {
		System.out.println("This is login by fb");
	}
	
	@Test(priority=3,groups= {"sanity"})
	void loginTwitter() {
		System.out.println("This is login by twitter");
	}

}
