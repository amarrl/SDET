package TestNG.Pack;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {
	@Test
	void abc() {
		System.out.println("this is method from c1 i.e abc");
	}
	
	@BeforeTest
	void bt() {
		System.out.println("This is before test method");
	}

}
