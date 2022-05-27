package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactIcon;
	
	//Constructor
	public Contactpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//business lib
	public void createContactIcon()
	{
		createContactIcon.click();
	}
}
