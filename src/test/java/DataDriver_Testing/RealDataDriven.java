package DataDriver_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RealDataDriven {

	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\Amar\\Downloads\\FireFlink Manual Test Case Template_2025-02-24 15-25-12.xlsx");
		FileInputStream fi=null;
		FileOutputStream fo=null;
		XSSFWorkbook wb=null;
		
		
		try {
			fi=new FileInputStream(file);
			wb=new XSSFWorkbook(fi);
			fo=new FileOutputStream(file);
	
		XSSFSheet sh=wb.getSheet("TestCases");
		sh.createRow(6).createCell(0).setCellValue("Ama"); 
		
		wb.write(fo); 
		
			XSSFSheet sheet1=wb.getSheet("TestCases");
			
			int rowno=sheet1.getLastRowNum(); 
			
			System.out.println("Total rows "+rowno); 
			
			int cellno=sheet1.getRow(0).getLastCellNum();
			
			System.out.println("Total cells "+cellno);
			//XSSFCell cellvalue=sheet1.getRow(0).getCell(0);
			XSSFCell cellvalue = null;
		for(int r=0;r<rowno;r++) {
			for(int c=0;c<cellno;c++) {
				 cellvalue=sheet1.getRow(r).getCell(c);
				 System.out.print(cellvalue+"\t"); 
			}
			System.out.println();
		} 
		
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			wb.close();
			fi.close();
			//fo.close(); 
			
		} 
		
		
		

	}

	
}
