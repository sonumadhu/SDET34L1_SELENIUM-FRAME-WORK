package com.vtiger.DocumentsSTest;

import org.testng.annotations.Test;

import com.SDETL1_GenericUtility.BaseClass;
import com.SDETL1_GenericUtility.ExcelUtilities;
import com.SDETL1_GenericUtility.WebDriverUtility;
import com.vtiger.objectRepository.CreateDocumentsPage;
import com.vtiger.objectRepository.DocumentsPage;

public class CreateDocumentTest  extends BaseClass{
	
	DocumentsPage documentpage;
	CreateDocumentsPage createdocumentpage;
	
	@Test
	public void createDocTest() {
		
		documentpage=new 	DocumentsPage(driver);
		createdocumentpage=new CreateDocumentsPage(driver);
		
		homePage.documentsClick();
		documentpage.createDocumentIcon();
		String docname=ExcelUtilities.getDataFromExcel("document", 2, 0);
		createdocumentpage.documentTitle(docname);
		WebDriverUtility.switchtoFrame(driver, 0);
		String description=ExcelUtilities.getDataFromExcel("document", 2, 2);
		createdocumentpage.descriptionArea(description);
		
		WebDriverUtility.switchBackToHome(driver);
		String browsefile=ExcelUtilities.getDataFromExcel("document", 2, 1);
		createdocumentpage.chooseFileBtn(browsefile);
		
	}

}
