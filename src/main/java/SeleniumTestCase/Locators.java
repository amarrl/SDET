package SeleniumTestCase;

import java.util.ArrayList;
import java.util.List;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		int ar1[]= {1,2,3,4,5,6,7};
		
		
	
	int ar2[]=new int[ar1.length];
	
	for(int i=0;i<ar1.length;i++) {
		ar2[i]=ar1[i];
	}
	
	for(int l:ar2) {
		System.out.println(l);
	}
}
}
