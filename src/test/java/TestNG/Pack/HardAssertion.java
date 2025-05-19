package TestNG.Pack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	
	@Test
	void tets() {
		//Assert.assertEquals("Amar", "Amar");
		
		//Assert.assertEquals(123, 12344);
		
		//Assert.assertNotEquals(1234, 1234);
		
		Assert.assertTrue(true);
		Assert.assertFalse(true);
		 
		Assert.assertTrue(1==1);
		Assert.assertFalse(1==2); 
	}
	
	

}
