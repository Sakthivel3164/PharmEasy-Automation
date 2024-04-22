package ust.PharmEasyAutomationSuite.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandling {
	public static String[][] getExcelData(String path, String sheetname) throws Exception {

		FileInputStream fileInputStream = new FileInputStream(new File(path));

//			apache poi - handle excel file
//			xlxs-XSSFworkbook
//			xls - HSSFworkbook --->poi library

		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();// to get used row count
		Row row = sheet.getRow(0);
		int colCount = row.getPhysicalNumberOfCells();
		String[][] data = new String[rowCount][colCount];
		DataFormatter df = new DataFormatter();
		for (int i = 0; i < rowCount; i++) {

			for (int j = 0; j < colCount; j++) {
				data[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));

			}

		}
		return data;
		// to get used cell count
//			System.out.println("Total number of rows used: "+rowCount);
//			System.out.println("Total number of columns: "+colCount);

	}

}
