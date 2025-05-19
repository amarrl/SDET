package DataDriver_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTesting {

	public static void main(String[] args) throws IOException {
		
		
		File file=new File("C:\\Users\\Amar\\Downloads\\Book1.xlsx");
		
		FileInputStream fi=null;
		FileOutputStream so=null; 
		XSSFWorkbook wb=null; 
		
		try {  
			
			fi=new FileInputStream(file);
			
			wb=new XSSFWorkbook(fi);
			XSSFSheet sheet=wb.createSheet("Amsnnsarqa");
			sheet.createRow(0).createCell(0).setCellValue("Parvatha");
			so=new FileOutputStream(file);
			wb.write(so); 
			 
			Thread.sleep(3000);
			
			XSSFSheet writebackSheet=wb.getSheet("Amsnnsarqa");
			XSSFCell value=writebackSheet.getRow(0).getCell(0);
			System.out.println(value.toString());
			 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			wb.close();
			fi.close();
			so.close();
		}
		/*
		
		File file=new File("C:\\Users\\Amar\\Downloads\\Book1.xlsx");
		
		FileInputStream fi=null;
		FileOutputStream fo=null;
		XSSFWorkbook wb=null;
		
		try {
			fi=new FileInputStream(file);
			wb=new XSSFWorkbook(fi); 
			
			XSSFSheet sheet=wb.getSheet("Sheet1");
			System.out.println(sheet.getRow(0).getCell(0));
			
		XSSFSheet sheetA=wb.createSheet("Amardara");
		
		sheetA.createRow(0).createCell(0).setCellValue("AMr");
			
			
			fo=new FileOutputStream(file);
			
			wb.write(fo); 
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			wb.close();
			fi.close();
			fo.close();
		}
		
		
		
		
		/*
		
		
		File file=new File("C:\\Users\\Amar\\Downloads\\Book1.xlsx"); 
		
		FileInputStream fi=new FileInputStream(file); 
		XSSFWorkbook	wb=new XSSFWorkbook(fi); 
		
		XSSFSheet sheet=wb.getSheet("Sheet1"); 
		int lastRow=sheet.getLastRowNum(); 
	
		
		
		int lastCell=sheet.getRow(0).getLastCellNum();
		System.out.println(lastRow);
		//System.out.println(lastCell);
		
		for(int r=0;r<=lastRow;r++) {
			for(int c=0;c<lastCell;c++) {
				System.out.print(sheet.getRow(r).getCell(c));
				
			}
			System.out.println();
		}
		*/

	}

}
