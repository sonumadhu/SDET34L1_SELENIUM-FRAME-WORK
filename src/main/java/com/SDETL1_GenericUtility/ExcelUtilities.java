package com.SDETL1_GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class is used to maintain all the excel specific common methods
 * 
 * @author Bhushana
 *
 */
public class ExcelUtilities {
	static Workbook  wb;
	
	
	public static void openExcel(String filepPath) throws EncryptedDocumentException, IOException   {
		FileInputStream fisExcel = new FileInputStream(filepPath);
		wb=WorkbookFactory.create(fisExcel);
	}
/**
 *  * this method is used to fetch the data from the excel sheet
 * @param sheetname
 * @param rowNumber
 * @param cellNumber
 * @return
 */
public static String getDataFromExcel(String sheetname,int rowNumber,int cellNumber) {
	
		String data = wb.getSheet(sheetname).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	return data;
}
/**
 * this method is used to create and set cell value into Excel
 * @param sheetname
 * @param rowNumber
 * @param cellNumber
 * @param message
 */
public static void createCell_Setcell(String sheetname,int rowName,int cellNum,String value) {
	
	wb.getSheet(sheetname).getRow(rowName).createCell(cellNum).setCellValue(value);
			
		}
/**
 * this method is used to write in the Excel
 * @param filepath
 * @throws IOException 
 * @throws IOExcepion
 * 
 */
 public static void saveExcelData(String savepath) throws IOException {
	FileOutputStream fos = new FileOutputStream(savepath); 
	wb.write(fos);
	
 }
 /**
  * 
  * 
  * @throws IOException
  */
 
 
public static void closeExcel() throws IOException {
	wb.close();
	
}
/**
 *this method is used to fetch the multiple data from the excel sheet 
 * 
 * @param sheetname
 * @return
 */
public static Object[][] getMultlipleDataFromExcel(String sheetname){
	 Sheet sh = wb.getSheet(sheetname);
	 
	Object[][] arr=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0;i<sh.getLastRowNum();i++) {
		for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
		{
			arr[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue().toString();
		}	
		}
	return arr;
		
	}
}

