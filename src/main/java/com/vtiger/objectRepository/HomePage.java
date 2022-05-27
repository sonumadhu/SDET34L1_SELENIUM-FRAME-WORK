package com.vtiger.objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDETL1_GenericUtility.WebDriverUtility;

public class HomePage {
	WebDriverUtility webutility=new WebDriverUtility();
	//declaration
	@FindBy(xpath ="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactLink;
	
	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationLink;
	
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement productLink;
	
	@FindBy(xpath = "//a[@href='index.php?module=Documents&action=index']")
	private WebElement documentsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreDropdown;
	
	@FindBy(xpath = "//a[@href='index.php?module=Campaigns&action=index']")
	private WebElement campaignsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signoutLink;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	//business lib
	
	public void contactClick()
	{
		contactLink.click();
	}
	
	public void organizationClick()
	{
		organizationLink.click();
	}
	
	public void productClick()
	{
		productLink.click();
	}
	
	public void documentsClick()
	{
		documentsLink.click();	
	}
	public void moreDropdownlink(WebDriver driver) {
		webutility.mouseHoveractions(moreDropdown,driver);
		
	}
		
	public void campaignClick()
	{
		
		campaignsLink.click();
	}
	
	public WebElement adminIcon() {
		return adminIcon;
		
	}
	public void signout(WebDriver driver)
	{
		
		webutility.mouseHoveractions(adminIcon, driver);
		signoutLink.click();
	}

}
