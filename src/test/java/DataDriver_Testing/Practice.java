package DataDriver_Testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice {

	public static void main(String[] args) throws IOException {
		
	FileInputStream fi=new FileInputStream("C:\\Users\\Amar\\Downloads\\Book1.xlsx");  
	
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	 
	XSSFSheet ws=wb.getSheet("Sheet1"); 
	 
	int totalrow=ws.getLastRowNum();  
	int totalcell=ws.getRow(0).getLastCellNum(); 
	
	System.out.println(totalrow); //4  
	
	System.out.println(totalcell); //5  
	 
	for(int r=0;r<totalrow;r++) { 
		for(int c=0;c<totalcell;c++) 
		{ 
			XSSFCell data=ws.getRow(r).getCell(c);  
			System.out.print(data);
		}
		System.out.println();
	}
	
	FileOutputStream fo=new FileOutputStream("C:\\Users\\Amar\\Desktop\\Selenium\\testing data.xlsx");
	
	
 	
	wb.getSheet("Sheet1");
	
	XSSFRow ddd=ws.getRow(0);
	
	ddd.getCell(4).setCellValue("smsjjmjk");
	
	wb.write(fo);;
	wb.close();
	
	
	
	
	
	
	
	
	
		
		
		

	}

}
