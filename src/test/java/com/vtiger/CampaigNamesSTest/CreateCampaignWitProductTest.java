package com.vtiger.CampaigNamesSTest;

import org.testng.annotations.Test;

import com.SDETL1_GenericUtility.BaseClass;
import com.SDETL1_GenericUtility.ExcelUtilities;
import com.SDETL1_GenericUtility.WebDriverUtility;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateCampaignPage;
import com.vtiger.objectRepository.CreateProductPage;
import com.vtiger.objectRepository.ProductPage;

public class CreateCampaignWitProductTest extends BaseClass  {
	
	ProductPage productpage;
	CreateProductPage createproductpage;
	
	
	CampaignPage campaignpage;
	CreateCampaignPage  createcampaighpage;
	
	@Test
	public void campaignWithProduct() {
		
		
		productpage=new ProductPage(driver);
		createproductpage=new CreateProductPage(driver); 
		
		homePage.productClick();
		productpage.createProductIcon();
		String productname=ExcelUtilities.getDataFromExcel("product", 1, 0);
		createproductpage.productNameandsend(productname);
		createproductpage.saveProduct();
		
		homePage.moreDropdownlink(driver);
		homePage.campaignClick();
		
		campaignpage.createCampaignIcon();
		String campaigname=ExcelUtilities.getDataFromExcel("campaign",1 , 0);
		createcampaighpage.campaignName(campaigname);
		
		createcampaighpage.campaign_ProductIcon();
		
		WebDriverUtility.switchtoFrame(driver, 0);
		
		createcampaighpage.productSearchandClick(productname);
		
		homePage.adminIcon();
		homePage.signout(driver);
		
		
		
		
	}
	
	

}
