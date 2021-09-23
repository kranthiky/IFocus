package readExcel;

import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

public class ReadExcelFile extends ExcelFileConfig {

	public static ExcelFileConfig readxl;
	public static String excelLoc = System.getProperty("user.dir") + "\\testData\\Excel_testData.xlsx";
	public static String sheetName = "FB Reg";

	@Test
	public void fetchTestData() {

		readxl = new ExcelFileConfig();
		readxl.initializeExcelFile(excelLoc, sheetName);
		
		int rowCount = sheet.getLastRowNum();
		System.out.println("No.Of rows:"+rowCount);
		System.out.println("fetched data: ");

		for (int i = 1; i < rowCount+1; i++) {
			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {

				String cellData = readxl.fetchData(sheetName, row.getRowNum(), j);
				System.out.println(cellData);
			}
		}
	}
}
