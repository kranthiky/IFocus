package writeToExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXFileConfig {

	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;

	public void writeToXLSXFile(String excelLoc, String sheetName, String[] Data) {

		try {
			File file = new File(excelLoc);
			FileInputStream ip = new FileInputStream(file);
			wb = new XSSFWorkbook(ip);
			sheet = wb.getSheet(sheetName);
				 
		    XSSFRow row = sheet.getRow(0); //Get the first row from the sheet
		    
		    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum(); 
		    int columnCount = row.getLastCellNum();
		    
		    ip.close();  //Close input stream

		    FileOutputStream op = new FileOutputStream(file); // object of FIP to write data
		    
		    XSSFRow newRow = sheet.createRow(rowCount+1); //Create a new row and append it at last of sheet
   
		    for(int j = 0; j < columnCount ; j++){  //Create a loop over the cell of newly created Row

		        XSSFCell cell = newRow.createCell(j); //Fill data in row
		        cell.setCellValue(Data[j]);
		    }		    
		    wb.write(op); //write data in the excel file
		    op.close(); //close output stream

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
