package dataprovider;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataProviderFromAnotherClass {
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static String sheetName = "FB Reg";
	public static DataFormatter formatter = new DataFormatter();
	
	
	@Test(dataProvider = "testdata", dataProviderClass = DemoDP.class)
	public void verifyData1(String n1, Integer n2) {
		System.out.println(n1 + " " + n2);
	}

}
