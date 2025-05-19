package DataDriver_Testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practive {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Amar\\Desktop\\Selenium\\testing data.xlsx");
		 
		XSSFWorkbook iw=new XSSFWorkbook(file);
		XSSFSheet Sheet1=iw.getSheet("Sheet1"); 
		int totalnumberofrows=Sheet1.getLastRowNum(); 
		int totalcell=Sheet1.getRow(0).getLastCellNum(); 
		
		for(int r=0;r<=totalnumberofrows;r++) {
			
			for(int c=0;c<totalcell;c++) {
				
				XSSFCell cell=Sheet1.getRow(r).getCell(c); 
				System.out.print(cell.toString()+"\t");
				 
			}
			System.out.println();
		}
	 
		 
		
	
		XSSFRow Row0=Sheet1.getRow(0);
		
		if(Row0==null) {
			Row0=Sheet1.createRow(0);
		}
		
		XSSFCell cell4=Row0.getCell(4);
		if(cell4==null) {
		 cell4=Row0.createCell(4);
		}
	
		cell4.setCellValue("Ajay devgan write");
		
		FileOutputStream output=new FileOutputStream("C:\\Users\\Amar\\Desktop\\Selenium\\testing data.xlsx");
		iw.write(output);
		output.close();
		file.close();
		iw.close();
		
		System.out.println("====");
		
		/*
		FileInputStream file=new FileInputStream("C:\\Users\\Amar\\eclipse-workspace\\new 2024 ide\\SDET\\Test Data\\testing data.xlsx");
		
	
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int totalnumberofrows=sheet.getLastRowNum();
		System.out.println(totalnumberofrows); //3
		
		int totalcell=sheet.getRow(0).getLastCellNum();
		System.out.println(totalcell);   //4    column will alway start from 1
		
		XSSFCell data=sheet.getRow(1).getCell(3);
		System.out.println(data.toString());
		
		for(int r=0;r<=totalnumberofrows;r++) {
			
			//XSSFRow currentrow=sheet.getRow(r);
					
			for(int c=0;c<totalcell;c++) {
				
				XSSFCell cell=sheet.getRow(r).getCell(c);
				
				System.out.print(cell.toString()+"\t");
				
			}
			System.out.println();
		}
		*/

	}

}

