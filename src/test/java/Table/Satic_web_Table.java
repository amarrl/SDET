package Table;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Satic_web_Table {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//get total number of rows in a table
		
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("number of Rows "+rows); 
		
		// 2.Find total number of cloumns in a table
		int columns=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("number of columns "+columns);
		
		// 3. Read data from specific row and column (ex 5th row and 1st column)
		
		String name=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println(name);  //master in slenium
		System.out.println("-----------------------------");
		/*
		// 4. Read data from all the row and column
		
		for(int r=2;r<rows;r++) {
			for(int c=1;c<columns;c++) {
				String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(value+"\t");
				
			}
			System.out.println();
		}
		*/
		//5. Print the book name of authod
		
		for(int r=2;r<=rows;r++) {
			String Authorname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			
			if(Authorname.equals("Mukesh")) {
				String MukeshBookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(MukeshBookName+"\t"+Authorname);
			}
		
		}
		System.out.println("====================================");
		// 6. Capture all the rpice and print total price
		int total=0;
		for(int r=2;r<=rows;r++) {
			String prices=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			//System.out.println(prices);
			
			total=total+Integer.parseInt(prices);
			
			
		
		}
		System.out.println(total);
	}

}
