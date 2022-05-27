package com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SDETL1_GenericUtility.ExcelUtilities;
import com.SDETL1_GenericUtility.IconstantPath;

public class TestNgPractice1Test extends TestNGBasicConfigAnnotationPracticeTest {

	@Test(dataProvider = "logindata")

	public void practice1Test(String username, String password) {
		Reporter.log(username+"--->"+password,true);

	}
	@DataProvider
	public Object[][] logindata() throws EncryptedDocumentException, IOException{
		ExcelUtilities.openExcel(IconstantPath.EXCELPATH);
		return ExcelUtilities.getMultlipleDataFromExcel("loginData");
	}



}
