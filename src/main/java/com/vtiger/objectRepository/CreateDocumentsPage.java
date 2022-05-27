package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CreateDocumentsPage {
	
	@FindBy(xpath = "//input[@name='notes_title']")
	private WebElement documentTitleTxt;
	
	@FindBy(xpath = "//input[@id='filename_I__']")
	private WebElement chooseFileBtn;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement saveDocumentBtn;
	
	@FindBy(xpath = "//a[@id='cke_5']")
	private WebElement boldIcon;
	
	@FindBy(xpath = "//a[@id='cke_6']")
	private WebElement italicIcon;
	
	@FindBy(xpath = "//html[@dir='ltr']")
	private WebElement descriptionArea;

	public CreateDocumentsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//business lib
	
	public void documentTitle(String doc_title)
	{
		documentTitleTxt.sendKeys(doc_title);
	}
	
	public void chooseFileBtn(String filepath) 
	{
		chooseFileBtn.sendKeys(filepath);
	}
	
	public void saveDocuments()
	{
		saveDocumentBtn.click();
	}
	
	public void boldAndItalic()
	{
		boldIcon.click();
		italicIcon.click();
	}
	
	public void descriptionArea(String message) 
	{
		descriptionArea.sendKeys(message);
	}

}
