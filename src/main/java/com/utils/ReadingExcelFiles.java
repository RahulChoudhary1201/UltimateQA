package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.seleniumAutomation.ReadingExcelFiles;

public class ReadingExcelFiles {

	public Object[][] readExcelFile(String filePath, String FileName, String sheetName) throws IOException {
		DataFormatter formatter = new DataFormatter();

		File file = new File(filePath + "\\" + FileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;

		String fileExtensionName = FileName.substring(FileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
		}

		Sheet workbookSheet = workbook.getSheet(sheetName);
//		int rowCount = workbookSheet.getLastRowNum() - workbookSheet.getFirstRowNum();

		int rowCount1 = workbookSheet.getPhysicalNumberOfRows();
		// System.out.println(rowCount1);

		int columnCount = workbookSheet.getRow(0).getLastCellNum();
//		System.out.println(workbookSheet.getLastRowNum());
//		System.out.println(workbookSheet.getFirstRowNum());
//		System.out.println(rowCount1);
//		System.out.println(columnCount);
		Object[][] data = new Object[rowCount1][columnCount];

		for (int i = 0; i < rowCount1; i++) {

			Row row = workbookSheet.getRow(i);
		
			for (int j = 0; j < columnCount; j++) {
				// printing excel data to console
				Cell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
				// System.out.print(row.getCell(j).getStringCellValue() + "|| ");
			}
			System.out.println();
		}
		
		return data;
	}

//	public static void main(String[] args) throws IOException {
//		ReadingExcelFiles readExcel = new ReadingExcelFiles();
//		Object[][] data = readExcel.readExcelFile(
//				"C:\\Users\\2122119\\eclipse-workspace\\UltimateQA\\src\\main\\java\\com\\testdata", "TestData.xlsx",
//				"Sheet1");
//		for (int i = 1; i < data.length; i++) {
//			for (int j = 0; j < data[0].length; j++) {
//				System.out.print(data[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
}
