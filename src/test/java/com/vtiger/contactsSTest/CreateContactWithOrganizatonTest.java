package com.vtiger.contactsSTest;

import org.testng.annotations.Test;

import com.SDETL1_GenericUtility.BaseClass;
import com.SDETL1_GenericUtility.ExcelUtilities;
import com.SDETL1_GenericUtility.WebDriverUtility;
import com.vtiger.objectRepository.Contactpage;
import com.vtiger.objectRepository.CreateContactPage;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.Organizationpage;

public class CreateContactWithOrganizatonTest extends BaseClass {
	 
	Organizationpage organizationpage;
	CreateOrganizationPage createorganizationpage;
	Contactpage contactpage;
	CreateContactPage createcontactpage;
	
	@Test
	public void contactWitOranization() {
		
		String organizationname=ExcelUtilities.getDataFromExcel("organization", 2, 1);
		String firstname=ExcelUtilities.getDataFromExcel("contact", 1, 1);
		String lastname=ExcelUtilities.getDataFromExcel("contact", 2, 1);
		
		organizationpage=new Organizationpage(driver);
		createorganizationpage= new CreateOrganizationPage(driver);
		contactpage=new Contactpage(driver);
		createcontactpage=new CreateContactPage(driver);
		
		homePage.organizationClick();
		organizationpage.createOrganizationIcon();
		createorganizationpage.organizationNameandSave(organizationname+randomnumber);
		
		homePage.contactClick();
		contactpage.createContactIcon();
		
		createcontactpage.firstName(firstname);
		createcontactpage.lastName(lastname);
		
		createcontactpage.organizationClick();
		WebDriverUtility.switchToWindowBasedOnTitle(driver, "Accounts&actions");
		
		createcontactpage.saveCreateContact();
		
		
		
		
	}
	

}
