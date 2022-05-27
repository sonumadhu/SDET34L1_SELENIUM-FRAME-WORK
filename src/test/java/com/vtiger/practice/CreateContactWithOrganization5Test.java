package com.vtiger.practice;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDETL1_GenericUtility.ExcelUtilities;
import com.SDETL1_GenericUtility.FileUtilities;
import com.SDETL1_GenericUtility.IconstantPath;
import com.SDETL1_GenericUtility.JavaUtility;
import com.SDETL1_GenericUtility.WebDriverUtility;
import com.vtiger.objectRepository.Contactpage;
import com.vtiger.objectRepository.CreateContactPage;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.Organizationpage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateContactWithOrganization5Test
{

	public static void main(String[] args) throws IOException, Throwable 

	{		
		/*FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties property = new Properties();
		property.load(fis);
		String url = property.getProperty("url");
		String userName = property.getProperty("userName");
		String password = property.getProperty("password");
		String timeout = property.getProperty("timeout");

		long longtimeout = Long.parseLong(timeout);*/



		JavaUtility jutil = new JavaUtility();

		jutil.stringToLong("10");

		FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		String url = FileUtilities.StringfetchDataFromPropertyFile("url");
		String username = FileUtilities.StringfetchDataFromPropertyFile("username");
		String password = FileUtilities.StringfetchDataFromPropertyFile("password");

		ExcelUtilities.openExcel(IconstantPath.EXCELPATH);
		String orgname = ExcelUtilities.getDataFromExcel("contact", 2, 0);
		String firstname = ExcelUtilities.getDataFromExcel("Contact", 1, 1);
		String lastname = ExcelUtilities.getDataFromExcel("Contact", 2, 1);		

		//TESTDATA - EXCEL
		/*	FileInputStream fis1 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook work = WorkbookFactory.create(fis1);
		Sheet sheet = work.getSheet("Organization");
		Row r = sheet.getRow(1);
		Cell c = r.getCell(1);
		String data = c.getStringCellValue();

		Sheet s1 = work.getSheet("Contact Name");
		Row r1 = s1.getRow(0);
		Cell c1 = r1.getCell(1);
		String firstname = c1.getStringCellValue();

		Sheet s2 = work.getSheet("Contact Name");
		Row r2 = s2.getRow(1);
		Cell c2 = r2.getCell(1);
		String lastname = c2.getStringCellValue();*/


		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		/*driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

		LoginPage loginpg= new LoginPage(driver);
		HomePage homepg= new HomePage(driver);
		Organizationpage orgpg= new Organizationpage(driver);
		CreateOrganizationPage createOrgpg= new CreateOrganizationPage(driver);
		Contactpage contactpg= new Contactpage(driver);
		CreateContactPage ccpg = new  CreateContactPage(driver);


		/*driver.get(url);
		//Generic Maximize, Implicitly wait*/

		WebDriverUtility.navigateToApp(url, driver);
		WebDriverUtility.browserSettings(10, driver);



		/*	
		// login page
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();  */

		jutil.getRandomNumber(1000);

		/*	Random random = new Random(); 
	    int ran = random.nextInt(1000);*/
		loginpg.loginToApp(username, password);
		homepg.organizationClick();
		orgpg.createOrganizationIcon();
		createOrgpg.organizationName(orgname+jutil.getRandomNumber(1000));
		createOrgpg.saveOrganization();

		Thread.sleep(3000);
		homepg.contactClick();
		contactpg.createContactIcon();
		ccpg.firstName(firstname);
		ccpg.lastName(lastname);
		ccpg.organizationClick();
		WebDriverUtility.switchToWindowBasedOnTitle(driver,"Accounts&action");
		createOrgpg.organizationNameandSave(orgname);

		/*driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(data+jutil.getRandomNumber(1000));
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();*/

		Thread.sleep(3000);

		/*

		/* WebElement ss = driver.findElement(By.xpath("//a [@href='index.php?module=Contacts&action=index']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(ss).click().perform();*/

		/*WebElement ss = driver.findElement(By.xpath("//a [@href='index.php?module=Contacts&action=index']"));
		WebDriverUtility.mouseHoveractions(ss, driver);

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);				
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();

		String parent_browser = driver.getWindowHandle();
		System.out.println(parent_browser);

		Set<String> child_and_parent = driver.getWindowHandles();
		System.out.println(child_and_parent);
		child_and_parent.remove(parent_browser);
		for(String only_child:child_and_parent)
		{
			driver.switchTo().window(only_child);
			driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("TYSS935");
	        driver.findElement(By.xpath("//input[@name='search']")).click();
	        driver.findElement(By.id("1")).click();
		}
       driver.switchTo().window(parent_browser);

       driver.findElement(By.xpath("//input[@accesskey='S']")).click();*/


		/*  WebElement mouse = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
       Actions act1 = new Actions(driver);
       act1.moveToElement(mouse).click().perform();*/

		/*   WebElement move = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
       WebDriverUtility.mouseHoveractions(move, driver);

       driver.findElement(By.xpath("//a[.='Sign Out']")).click(); */

	}

}
