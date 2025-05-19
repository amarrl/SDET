package ExcelDriven.src.test.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test {  

	public static void main(String[]args) throws IOException {
		File file=new File("C:\\Users\\Amar\\Desktop\\exe\\Iview\\ApiRah\\Book1.xlsx");
		FileInputStream fi = null;
		FileOutputStream fo=null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
		
		try {
			fi=new FileInputStream(file);
			wb=new XSSFWorkbook(fi);
			fi.close(); 
			
			sheet=wb.getSheet("Sheet1");
			row=sheet.getRow(2);
			cell=row.getCell(0);  
			System.out.println(cell.toString()); 
			 
		
			Thread.sleep(5000); 
			
			sheet.createRow(6).createCell(1).setCellValue("amar Kumar");
			fo=new FileOutputStream(file);  
			wb.write(fo); 
			Thread.sleep(5000);
		}
		catch(Exception e) {
			
		}
		finally {
			try {
			if(wb!=null)wb.close();
			//fi.close();
			if(fo!=null)fo.close(); 
		}catch(Exception e) {
			
		}
		
	}
}
}