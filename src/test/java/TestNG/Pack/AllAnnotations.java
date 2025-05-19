package TestNG.Pack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {
	@BeforeSuite
	void bs() {
		System.out.println("this is before suite");
	}

	@AfterSuite
	void As() {
		System.out.println("this is after suite");
	}
	
	
	@BeforeTest
	void BT() {
		System.out.println("this is Before test");
	}
	
	@AfterTest
	void At() {
		System.out.println("this is After test");
	}
	@BeforeClass
	void BC() {
		System.out.println("this is Before Class");
	}
	@AfterClass
	void AC() {
		System.out.println("this is After Class");
	}
	@BeforeMethod
	void BM() {
		System.out.println("this is Before Method");
	}
	@AfterMethod
	void AM() {
		System.out.println("this is After Method");
	}
	
	@Test
	void test1() {
		System.out.println("this is inside test1");
	}
	@Test
	void test2() {
		System.out.println("this is inside test2");
	}
}
