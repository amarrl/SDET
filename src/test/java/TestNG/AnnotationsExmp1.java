package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/*
 1.Login
 2.Search
 3.Logout
 3.lOGIN
 4.Adv Search]
 5.Logout
 */
public class AnnotationsExmp1 {
	
	@BeforeMethod 
	void Login() {
		
		System.out.println("this is Login");
		
	} 
	@Test(priority=1)
	void search() {
		System.out.println("this is Search");
	}
	@Test(priority=2)
	void advancedSearch() {
		System.out.println("this is advanced Search");
	}
@AfterMethod
	void Logout() {
		System.out.println("This is Logout ");
		
	}
}

//this is login
//this is Search
//this is logout
//this is login
//this is advanced Search
//this is logout
