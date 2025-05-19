package TestNG.Grouping;

import org.testng.annotations.Test;

public class payments {
	@Test(priority=1,groups= {"sanity","Regression",})
	void paymenstInRuppes() { 
		System.out.println("Payments in ruppes"); 
	} 
	  
	
		@Test(priority=2,groups= {"sanity","Regression"})
		void paymenstInDollers() {
			System.out.println("Payments in dollers");
		}

}
