package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 1.Login
 2.Search
 3.Advance searchea
 4.Logout
 */ 

public class BeforeclassAfterClass {
	
	@BeforeClass   //Before Class execution starts this will get execute first
	void login() {
		System.out.println("this is login"); 
	}
	@Test(priority=1)
	void search() {
		System.out.println("this is search");
	}
	@Test(priority=2)
	void advanceSearch() {
		System.out.println("this is advanced search");
	}
@AfterClass  //After Class execution completes this will get execute last
	void logOut() {
		System.out.println("this is logout");
	}
}
