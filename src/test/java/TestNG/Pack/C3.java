package TestNG.Pack;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {
@Test
void pqr() {
	System.out.println("thi is pqr from c3");
}
@AfterSuite
void as() {
	System.out.println("this is after suite");
}
@BeforeSuite
void a1s() {
	System.out.println("this is before suite");
}

}
