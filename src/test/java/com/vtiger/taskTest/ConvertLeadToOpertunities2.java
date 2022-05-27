package com.vtiger.taskTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDETL1_GenericUtility.FileUtilities;
import com.SDETL1_GenericUtility.IconstantPath;
import com.SDETL1_GenericUtility.JavaUtility;
import com.SDETL1_GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConvertLeadToOpertunities2 {

	public static void main(String[] args) throws IOException {
	
		//convert the physical file in to java readable format
		
		
		FileUtilities.openPropertyFile( IconstantPath.PROPERTYFILEPATH);
		
		// fetching data from property file using keys
		String url = FileUtilities.StringfetchDataFromPropertyFile("url");
		String password = FileUtilities.StringfetchDataFromPropertyFile("password");
		String username = FileUtilities.StringfetchDataFromPropertyFile("username");
		String timeout = FileUtilities.StringfetchDataFromPropertyFile("timeout");

		//converting timeout into long
		JavaUtility jutil = new JavaUtility();
		jutil.stringToLong(timeout);

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();

		WebDriverUtility.navigateToApp(url, driver);
		WebDriverUtility.waitTillPageLoad(10, driver);

		// home page
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		//System.out.println("home  page is dis played");


		// validation



		String ele = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();

		jutil.ifValidation(ele, "home");

		
		//3) click on lead and click on create lead
		driver.findElement(By.xpath("//a[@href='index.php?module=Leads&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kkkk");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("tyss");
		

		//4) click on save button
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

		
		//go to actions click on convert lead
		driver.findElement(By.xpath("(//a[@class='webMnu'])[8]")).click();

		// select all check box
		
		
		driver.findElement(By.xpath("//input[@id='select_potential']")).click();
		driver.findElement(By.xpath("//input[@id='jscal_field_closedate']")).sendKeys("2022-03-07");
		
	
		//click on save
		
		driver.findElement(By.xpath("//input[@name='Save']")).click();
		
		
	
		//logout
		
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		webDriverUtility.mouseHoveractions(administrator, driver);
		WebDriverUtility.quitBrowser(driver);
		
				
}

	}


