package readExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileConfig {

	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;

	public void initializeExcelFile(String excelLoc, String sheetName) {

		try {
			File file = new File(excelLoc);
			FileInputStream ip = new FileInputStream(file);
			wb = new XSSFWorkbook(ip);
		//	sheet = wb.getSheet(sheetName);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public String fetchData(String sheetName, int row, int cell) {
		sheet = wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(cell).getStringCellValue();
		return data;

	}
	public String fetchData(int index, int row, int cell) {
		sheet = wb.getSheetAt(index);
		String data = sheet.getRow(row).getCell(cell).getStringCellValue();
		return data;

	}
}
