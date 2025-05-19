package DataDriver_Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Anonymus {
    public static void main(String[] args) throws IOException {
        // Define the file
        File file = new File("C:\\Users\\Amar\\Downloads\\2nd Round Interview (1).xlsx");

        // Input and output streams  
        FileInputStream fi = null; 
        FileOutputStream fo = null;  
        XSSFWorkbook xb = null;

        try {
            // Open the file input stream 
            fi = new FileInputStream(file);

            // Load the workbook 
            xb = new XSSFWorkbook(fi); 

            // Create a new sheet
            XSSFSheet newSheet = xb.createSheet("Dataa");

            // Add some sample data
            newSheet.createRow(0).createCell(0).setCellValue("Sample Data");

            // Open the file output stream
            fo = new FileOutputStream(file); 

            // Write the changes to the file
            xb.write(fo);	

            System.out.println("Workbook updated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close all resources properly
            if (xb != null) {
                xb.close();
            }
            if (fi != null) { 
                fi.close();
            }
            if (fo != null) {
                fo.close();
            }
        }
    }
}
