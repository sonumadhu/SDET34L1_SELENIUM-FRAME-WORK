package com.vtiger.organizationSTest;

import org.testng.annotations.Test;

import com.SDETL1_GenericUtility.BaseClass;
import com.SDETL1_GenericUtility.ExcelUtilities;
import com.SDETL1_GenericUtility.WebDriverUtility;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.Organizationpage;

public class CreateOrgWithDropDown extends BaseClass {
	
	Organizationpage organizationpage;
	CreateOrganizationPage createorganizationpage;
	
	
	
	@Test
	public void organizationWithDropDown() {
	 
		String orgname= ExcelUtilities.getDataFromExcel("organization", 2, 1);
		
		organizationpage=new Organizationpage(driver);
		createorganizationpage=new CreateOrganizationPage(driver);
		
		homePage.organizationClick();
		organizationpage.createOrganizationIcon();
		createorganizationpage.organizationName(orgname+randomnumber);
		WebDriverUtility.dropDownHandlebyVisibleText(createorganizationpage.industryDropdown(),orgname );
		WebDriverUtility.dropDownHandlebyVisibleText(createorganizationpage.typeDropdown(), "press");
		createorganizationpage.saveOrganization();
	}

}
