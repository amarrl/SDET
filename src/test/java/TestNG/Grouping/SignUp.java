package TestNG.Grouping;

import org.testng.annotations.Test;

public class SignUp {
	 
	@Test(priority=1,groups= {"Regression"})
	void signUpEmail() {
		System.out.println("This is login by email regressiom");
	}
	
	@Test(priority=2,groups= {"Regression"}) 
	void signupFb() {
		System.out.println("This is login by fb regressiom");
	}

	@Test(priority=3,groups= {"Regression"})
	void signUpTwitter() {
		System.out.println("This is login by twitter regressiom");
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
