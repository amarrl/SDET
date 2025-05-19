package TestNG.dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice {
	
	
	@Test(priority=2,dependsOnMethods="appOpen")
	public void login() {
		Assert.assertTrue(false);  
	}
	 
	@Test(priority=1)
	public void appOpen() { 
		Assert.assertTrue(true);
		  
	}
	 
	@Test
	void logout() {
		Assert.assertFalse(false);
	}

}
