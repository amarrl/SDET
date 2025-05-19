package DataDriver_Testing;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writedata {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\Test Data\\Data.xlsx");
		 
		XSSFWorkbook workbook=new XSSFWorkbook();  
		 
		XSSFSheet sheet= workbook.createSheet("Data"); 
		
		 
		XSSFRow row1=sheet.createRow(0);
		
		row1.createCell(0).setCellValue("Amar");
		row1.createCell(1).setCellValue(2213);
		row1.createCell(2).setCellValue("jav");
		row1.createCell(3).setCellValue("python ");
		
		
		XSSFRow row2=sheet.createRow(1);
		
		row2.createCell(0).setCellValue("KumarAmar");
		row2.createCell(1).setCellValue(1881);
		row2.createCell(2).setCellValue(18.3);
		row2.createCell(3).setCellValue("python ");
		
		
		
	XSSFRow row3=sheet.createRow(2); 
		
		row3.createCell(0).setCellValue("KumarAmar");
		row3.createCell(1).setCellValue(1000);
		row3.createCell(2).setCellValue(1999);
		row3.createCell(3).setCellValue("pAmar ");
		
		workbook.write(file);
		
		workbook.close();
		file.close();
		
		System.out.println("file is created");
	}
}
