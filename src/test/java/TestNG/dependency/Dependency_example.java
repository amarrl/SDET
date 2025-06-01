package TestNG.dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependency_example { 
	@Test(priority=2,dependsOnMethods= {"openApp"})
	void login() {
		Assert.assertTrue(true);
	} 
	
	@Test(priority=1)
	void openApp(){ 
		Assert.assertFalse(false);
	}
	 
	
	@Test(priority=3,dependsOnMethods= {"login","openApp"})
	void search(){
		Assert.assertFalse(false);
	}
	
	@Test(priority=3,dependsOnMethods= {"login","search"})
	void advancesearch(){ 
		Assert.assertFalse(false);
		
		
		
	} 
	 
	@Test
	void logout() {
		Assert.assertTrue(true);
		
	}

	
	@Test(groups = {"smoke"})
    public void smokeTest() {
        System.out.println("Executing Smoke Test");
    }

    @Test(dependsOnGroups = {"smoke"})
    public void dependentTest() {
        System.out.println("Executing Dependent Test after Smoke");
    }
}
