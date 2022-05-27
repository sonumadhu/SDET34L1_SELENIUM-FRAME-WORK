package com.vtiger.ProductSTest;

import org.testng.annotations.Test;

import com.SDETL1_GenericUtility.BaseClass;
import com.SDETL1_GenericUtility.ExcelUtilities;
import com.vtiger.objectRepository.CreateProductPage;
import com.vtiger.objectRepository.ProductPage;

public class ProductTest  extends BaseClass {
	
	ProductPage productpage;
	CreateProductPage createproductpg;
	
	
	@Test(groups="regression")
	public void createProduct() {
		
		productpage=new ProductPage(driver);
		createproductpg=new CreateProductPage(driver); 
		
		homePage.productClick();
		productpage.createProductIcon();
		String productname=ExcelUtilities.getDataFromExcel("product", 1, 0);
		createproductpg.productNameandsend(productname);
		createproductpg.saveProduct();
		
	}

}

