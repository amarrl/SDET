package DataDriver_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testing {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		File file=new File("C:\\Users\\Amar\\Desktop\\exe\\Iview\\ApiRah\\Book1.xlsx");
		
		FileInputStream fi=null;
		FileOutputStream fo=null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
		
		try {
			fi=new FileInputStream(file);
			wb=new XSSFWorkbook(fi);
			sheet=wb.getSheet("Sheet1");
			cell=sheet.getRow(0).getCell(2);
			System.out.println(cell.toString());
			
		
			sheet.createRow(4).createCell(0).setCellValue("newOne");
			fo=new FileOutputStream(file);
			wb.write(fo);
			System.out.println("done"); 
			
		}catch(Exception e) {
			fi.close();
			fo.close();
			wb.close();
		}
		
		
		
		
	}
}
		
	
		


