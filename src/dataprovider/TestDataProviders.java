package dataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProviders {
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static String sheetName = "FB Reg";
	public static DataFormatter formatter = new DataFormatter();
	
	@DataProvider(name ="Read from Excel")
	public static Object[][] ReadVariant() throws IOException
	 {
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir") + "\\testData\\FB_Users_Data.xlsx"); //Excel sheet file location get mentioned here
		workbook = new XSSFWorkbook (fis); //get my workbook 
		sheet= workbook.getSheet(sheetName);// get my sheet from workbook
	    XSSFRow Row=sheet.getRow(0);   //get my Row which start from 0   
	   
	   	int rowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows
	    int colNum= Row.getLastCellNum(); // get last ColNum 
	    	
	    Object Data[][]= new Object[rowNum-1][colNum]; // pass my  count data in array
	    	
	     for(int i=0; i<rowNum-1; i++) //Loop work for Rows
	     {  
	     XSSFRow row= sheet.getRow(i+1); 
	     
	     for (int j=0; j<colNum; j++) //Loop work for colNum
	     {
	     if(row==null)
	     Data[i][j]= "";
	     else 
	     {
	     XSSFCell cell= row.getCell(j);
	     if(cell==null)
	     Data[i][j]= ""; //if it get Null value it pass no data 
	     else
	     {
	    
	 //    String value=formatter.formatCellValue(cell);//returns value as a String regardless of a cell type
	     //Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
	     Data[i][j] = cell.getStringCellValue();
	     }
	     }
	     }
	     }
	    	return Data;
	 }
}
