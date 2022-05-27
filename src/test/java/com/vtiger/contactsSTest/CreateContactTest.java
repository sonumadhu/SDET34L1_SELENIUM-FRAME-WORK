package com.vtiger.contactsSTest;

import org.testng.annotations.Test;

import com.SDETL1_GenericUtility.BaseClass;
import com.SDETL1_GenericUtility.ExcelUtilities;
import com.vtiger.objectRepository.Contactpage;
import com.vtiger.objectRepository.CreateContactPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateContactTest extends BaseClass {

	Contactpage contactpage;
	CreateContactPage createcontactpage;
	@Test(groups="sanity" ,description="testng:-CreateContactTest")
	@Description("Description:-CreateContactTest")
	@Epic("Epic:-CreateContactTest")
	@Story("Story:-Createcontact")
	@Step("Step:-CreateContactTest")
	@Severity(SeverityLevel.CRITICAL)
	public void createContactExceTest()
	{ 


		String firstname = ExcelUtilities.getDataFromExcel("contact", 1, 1);
		String lastname = ExcelUtilities.getDataFromExcel("contact", 2, 1);

		contactpage=new Contactpage(driver);

		createcontactpage=new CreateContactPage(driver);

		homePage.contactClick();



		contactpage.createContactIcon();


		createcontactpage.firstName(firstname);
		createcontactpage.lastName(lastname);
		createcontactpage.saveCreateContact();



	}

}
