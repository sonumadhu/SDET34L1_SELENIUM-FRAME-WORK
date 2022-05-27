package com.vtiger.CampaigNamesSTest;

import org.testng.annotations.Test;

import com.SDETL1_GenericUtility.BaseClass;
import com.SDETL1_GenericUtility.ExcelUtilities;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateCampaignPage;

public class CreateCompaignTest extends BaseClass {
	
	CampaignPage campaignpage;
	CreateCampaignPage  createcpg;
	
	@Test(groups="sanity")
	public void creCampaignTest() {
		
		campaignpage=new CampaignPage(driver);
		createcpg=new CreateCampaignPage(driver);
		homePage.moreDropdownlink(driver);
		homePage.campaignClick();
		campaignpage.createCampaignIcon();
		String campaignname=ExcelUtilities.getDataFromExcel("campaign",1 ,0 );
		createcpg.campaignName(campaignname);
		
		
				
		
	}
	
	

}
