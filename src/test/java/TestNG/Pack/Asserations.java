package TestNG.Pack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Asserations {
	@Test
	
	void testTittle() {
		String exp_tittle="Opencart";
		String act_tittle="Opencajnnjrt";
	/*
	
	if(exp_tittle.equals(act_tittle)) {
		System.out.println("test is passed");
	}
	else {
		System.out.println("test is filed");
	}
	*/
		
		Assert.assertEquals(exp_tittle, act_tittle);
		
	
	}

}
