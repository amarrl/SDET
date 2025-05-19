package DataDriver_Testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenExcelUtils {

		
		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet sf;
		public static XSSFRow ro;
		public static XSSFCell co;
		public static CellStyle style;
		 
		
		public static int getRowCount(String xlfile,String xlSheet) throws IOException {
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			sf=wb.getSheet(xlSheet);
			int rowcount=sf.getLastRowNum();
			
			wb.close(); 
			fi.close();
			
			return rowcount;
		}
		
		public static int getCellCount(String xlfile,String xlSheet,int rownum) throws IOException {
			
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			sf=wb.getSheet(xlSheet);
			ro=sf.getRow(rownum);
			int cellcount=ro.getLastCellNum();
			
			wb.close(); 
			fi.close();
			
			return cellcount;
			
		}
	public static String getCellData(String xlfile,String xlSheet,int rownum,int colnum) throws IOException {
			
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			sf=wb.getSheet(xlSheet);
			ro=sf.getRow(rownum);
			co=ro.getCell(colnum);
			String data=co.toString();
			
			wb.close();
			fi.close();
			
			
			return data;
			
		}
	//write data into cell  //parrally reading and writing //in that same roe we will create new ceel for  updating the value
	
	public static void SetCellData(String xlfile,String xlSheet,int rownum,int colnum,String data) throws IOException {
		
		fi=new FileInputStream(xlfile); 
		wb=new XSSFWorkbook(fi);
		sf=wb.getSheet(xlSheet);
		ro=sf.getRow(rownum);
		co=ro.createCell(colnum);
			co.setCellValue(data);
			
			fo=new FileOutputStream(xlfile);
			
			wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	public static void fillGreenColour(String xlfile,String xlSheet,int rownum,int colnum,int column) throws IOException {
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sf=wb.getSheet(xlSheet); 
		ro=sf.getRow(rownum);
	
		style=wb.createCellStyle();
		 
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			co.setCellStyle(style);
			
			fo=new FileOutputStream(xlfile);
			
			wb.write(fo); 
		
		wb.close();
		fi.close();
		fo.close();
		
	}
	

}
