package writeToExcel;

import org.testng.annotations.Test;

public class WritingToExcel extends XLSXFileConfig {
   
	public static XLSXFileConfig writexl;
	public static String excelLoc = System.getProperty("user.dir") + "\\testData\\Write_testData.xlsx";
	public static String sheetName = "write";
	public static String[] Data ={"First name","Last name","Ph#","Address"};

	@Test
	public void fetchTestData() {

		writexl = new XLSXFileConfig();
		writexl.writeToXLSXFile(excelLoc, sheetName, Data );
		
	
	}
}
