package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameTxt;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTxt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement organiationIcon;
	
	@FindBy(xpath ="(//input[@class='crmButton small save'])[1] ")
	private WebElement saveBtn;
	
	//Constructor
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//business lib
	public void firstName(String firstName)
	{
		firstNameTxt.sendKeys(firstName);
	}
	
	public void lastName(String lastName)
	{
		lastNameTxt.sendKeys(lastName);
	}
	
	public void saveCreateContact()
	{
		saveBtn.click();
	}
	
	public void organizationClick() 
	{
		organiationIcon.click();
	}
	

}
