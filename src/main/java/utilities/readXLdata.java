package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readXLdata {

	    public static void main(String[] args) {
	        File fi = new File(System.getProperty("user.dir")+"/test-output\\login_results.xlsx");
	        try (FileInputStream fis = new FileInputStream(fi);
	             Workbook w = WorkbookFactory.create(fis)) {

	            // Modify the cell value
	            w.getSheetAt(0).getRow(0).getCell(0).setCellValue("PASSPASS");

	            // Write the changes back to the file
	            try (FileOutputStream fos = new FileOutputStream(fi)) {
	                w.write(fos);
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	


}

