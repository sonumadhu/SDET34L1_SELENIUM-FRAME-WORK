package com.vtiger.excelTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SampleExcelTest {

	public static void main(String[] args) throws IOException {
		// covert the physical file into java
		FileInputStream fis1=new FileInputStream("./src/test/resorces/Excel.xlsx");
		
		//open the excel
		Workbook wb = WorkbookFactory.create(fis1);
		
		//get the control on sheet
		Sheet sh = wb.getSheet("organization");
		
		//get the control on row
		Row row = sh.getRow(2);
		
		//get the data from cell
		Cell cell = row.getCell(1);
		
		//close the work book
		wb.close();
	}

}
