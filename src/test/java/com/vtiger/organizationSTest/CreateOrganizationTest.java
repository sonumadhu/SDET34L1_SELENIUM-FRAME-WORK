package com.vtiger.organizationSTest;

import org.testng.annotations.Test;

import com.SDETL1_GenericUtility.BaseClass;
import com.SDETL1_GenericUtility.ExcelUtilities;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.Organizationpage;

public class CreateOrganizationTest extends BaseClass {
	Organizationpage oranizationpage;
	CreateOrganizationPage createorganizationpage;
	
	@Test(groups="regression")
	public void createOrgExcel() {
		
		
		
		String organizatinName = ExcelUtilities.getDataFromExcel("organization", 2, 1);
		
		oranizationpage=new Organizationpage(driver);
		createorganizationpage= new CreateOrganizationPage(driver);
		
		homePage.organizationClick();
		oranizationpage.createOrganizationIcon();
		
		createorganizationpage.organizationName(organizatinName);
		
		
		
	}
	

}
