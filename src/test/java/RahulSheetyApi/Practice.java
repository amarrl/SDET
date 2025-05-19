package RahulSheetyApi;

import org.apache.commons.lang3.RandomStringUtils;

public class Practice {

	public static void main(String[] args) {
		String randomString = RandomStringUtils.randomAlphanumeric(10);
		
		String email=randomString+"com"; 
		
		System.out.println(email); 

	}

}
