package TestNG.Pack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C2 {
	@Test
	void xyz() {
		System.out.println("this is method from c2 i.e abc");
	}
	
	@AfterTest
	void at() {
		System.out.println("This is After test method");
	}

}
