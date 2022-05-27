package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	

	//Declaring the elements and specifying access specifier as private
	@FindBy(xpath = "//input[@type='text']")
	private WebElement userNameText;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordText;
	
	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement submitBtn;
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		//Pagefactory is concerte class and initelement will use to
	}
	
	//Business Library 
	
	public void loginToApp(String username, String password) 
	{
		userNameText.sendKeys(username);
		passwordText.sendKeys(password);
		submitBtn.click();

}
}
