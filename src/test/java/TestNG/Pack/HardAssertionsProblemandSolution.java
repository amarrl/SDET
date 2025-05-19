package TestNG.Pack;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertionsProblemandSolution {
	//if we if use hard assertions means if assertions got failed means the excution will stop there only
	@Test
	void test_HardAsertions() {
		System.out.println("Testinh");
		System.out.println("Testinh");  
		
		Assert.assertEquals(1, 2);  
		System.out.println("Testinh");
		System.out.println("Testinh");
	}
	
	
	@Test
	void asseret_SoftAssert() {
		System.out.println("Soft Asser1 ");
		System.out.println("Soft Asser2 ");
		
		SoftAssert asser=new SoftAssert();
		
		asser.assertNotEquals(1, 1);
		
		System.out.println("Soft Asser3 ");
		System.out.println("Soft Asser4 ");
		
		asser.assertAll();
	}

}
