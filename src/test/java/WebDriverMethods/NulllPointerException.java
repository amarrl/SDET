package WebDriverMethods;

import org.openqa.selenium.WebDriver;

public class NulllPointerException {

	public static void main(String[] args) {
		
		/*
		WebDriver driver = null;
				driver.get("https://app.fireflink.com/");
				*/
		
		 String s=" Amar Kumar Raj ";
	      
	      int count=0;
	      
	    char ch[]=s.toCharArray();
	        
	       
	      for(int i=0;i<ch.length;i++){
	        if(ch[i]==' ') {
	        	count++;
	        }
	      }
	      
	      System.out.println(count);

	}

}
