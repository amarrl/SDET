package DataDriver_Testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class Propertiyfile {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Test data\\Amar.properties");
		
		FileOutputStream file1=new FileOutputStream(System.getProperty("user.dir")+"\\Test data\\Amar.properties");
		
	//	C:\Users\Amar\eclipse-workspace\new 2024 ide\SDET\Test Data\Amar.properties
		 
	Properties p=new Properties();
	p.load(file);
	
	PrintWriter pw=new PrintWriter(file1);
	
	
	String wsusername=p.getProperty("Username");
	p.getProperty("Password");
	
	System.out.println(wsusername);

	
	//Set<String> keys= p.stringPropertyNames();
	
	Set<Object>list=p.keySet();
	
	
	
	
	System.out.println(list);
	
	//reading all values
	
	Collection<Object>values =p.values();
	
	System.out.println(values);
	
	file.close();
	
		
		

	}

}
