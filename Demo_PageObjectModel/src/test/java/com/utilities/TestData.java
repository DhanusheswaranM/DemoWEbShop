package com.utilities;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name = "excelTestData" ,parallel=true )
	public Object[][] excelDataProvider() throws IOException{
		Object[][] arrobj = getExcelData("D:\\EXCEL\\demowebshop.xlsx","Sheet1");
		return arrobj;
	}
 
	public String[][] getExcelData(String filename, String sheetName) throws IOException{
		String[][] data = null ;
		try {
			FileInputStream fis = new FileInputStream(filename);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int noOfRows = sheet.getPhysicalNumberOfRows();
			int noOfCols = row.getLastCellNum();
			Cell cell ;
			data = new String[noOfRows-1][noOfCols];
			for(int i = 1 ; i < noOfRows ; i++) {
				for(int j = 0 ; j < noOfCols ; j++) {
					row = sheet.getRow(i);
					cell = row.getCell(j);
					data[i-1][j] = cell.getStringCellValue();
					}
			}
		}catch(Exception e) {
			System.out.println("the exception raised as "+e.getMessage());
		}
		return data;
	}
}
