package DataDriver_Testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDatafromexcel {
	
	//Excel--->Workbook --->Sheets--->Rows-->Cells

	public static void main(String[] args) throws IOException {
		//WebDriver driver=new ChromeDriver();
		 
		//Open the file in reading mode 
	
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Test Data\\DataDrivern.xlsx");
			
						//FileInputStream file=new FileInputStream("C:\\Users\\Amar\\Desktop\\Selenium\\Data DriverTesting\\DataDrivern.xlsx");
			
			//extracted  the workbook from the fiel  
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		
		 
		//Get the sheet and store it in variable
		XSSFSheet sheet=workbook.getSheet("Sheet1"); 
		
		//get the rows in rows
	int totalrows=	sheet.getLastRowNum();
		
		//If we want to find number of cells than we need to find any row in that particular row we can count number of cells
		
		int totalnumberofCells=sheet.getRow(0).getLastCellNum();
		
		System.out.println("Number of rows: "+totalrows);
		
		System.out.println("Number of cells: "+totalnumberofCells);
		
	
		for(int i=0;i<=totalrows;i++) {
			
		XSSFRow currentrow=	sheet.getRow(i);
		
			for(int c=0;c<totalnumberofCells;c++) {
			XSSFCell cell=currentrow.getCell(c);
			System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		 
		}
		
		workbook.close();
		file.close();
		System.out.println("added data");
	}

}
