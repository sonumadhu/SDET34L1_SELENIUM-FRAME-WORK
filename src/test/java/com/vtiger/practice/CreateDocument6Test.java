package com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDETL1_GenericUtility.ExcelUtilities;
import com.SDETL1_GenericUtility.FileUtilities;
import com.SDETL1_GenericUtility.IconstantPath;
import com.SDETL1_GenericUtility.JavaUtility;
import com.SDETL1_GenericUtility.WebDriverUtility;
import com.vtiger.objectRepository.CreateDocumentsPage;
import com.vtiger.objectRepository.DocumentsPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocument6Test {

	public static void main(String[] args) throws IOException {
		
		

		FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		String url = FileUtilities.StringfetchDataFromPropertyFile("url");
		String password = FileUtilities.StringfetchDataFromPropertyFile("password");
		String username = FileUtilities.StringfetchDataFromPropertyFile("username");
		
		
		//long
		JavaUtility jutil = new JavaUtility();
		jutil.stringToLong("10");
		
		
		/*FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
		Properties property=new Properties();
		property.load(fis);
		String url = property.getProperty("url");
		String timeout = property.getProperty("timeout");
		String username = property.getProperty("username");
		String password = property.getProperty("password");


		long longTimeOut=Long.parseLong(timeout);*/
		WebDriver driver=null;

	

		/*Random ran = new Random();
		int randomnumber = ran.nextInt(1000);*/
		 ExcelUtilities.openExcel(IconstantPath.EXCELPATH);
		 
		 String title= ExcelUtilities.getDataFromExcel("document", 2, 0);
	
		 String dpath = ExcelUtilities.getDataFromExcel("document", 2, 1); 
		 
		 String dDescription= ExcelUtilities.getDataFromExcel("document", 2, 2);
		 
		/*FileInputStream  fis2=new FileInputStream("./src/test/resources/Excelnew.xlsx");
		 Workbook wb = WorkbookFactory.create(fis2);
		 String documenttitle = wb.getSheet("document").getRow(2).getCell(0).getStringCellValue();
		 String documentpath = wb.getSheet("document").getRow(2).getCell(1).getStringCellValue();
		 String documentdescription = wb.getSheet("document").getRow(2).getCell(2).getStringCellValue();*/
				
		  
		  
		  
		  /*Row row = sheet.getRow(2);
		Cell cell = row.getCell(0);
		String firstname = cell.getStringCellValue()+randomnumber;*/
		
		
		 
		/*Row row1 = sheet.getRow(2);
		Cell cell1 = row.getCell(1);
		String laststname = cell.getStringCellValue();*/
		

		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
		LoginPage loginpage=new LoginPage(driver);
		HomePage homepage= new HomePage(driver);
		DocumentsPage documentpage= new DocumentsPage(driver);
		CreateDocumentsPage createdocumentpage= new CreateDocumentsPage(driver);
		
		WebDriverUtility.navigateToApp(url, driver);
		WebDriverUtility.browserSettings(10, driver);
		
		
		
		/*driver.get(url);*/
		/*driver.manage().window().maximize();
		 * 
		driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);*/

		//step1 login page or login to app

		loginpage.loginToApp(username, password);
		
		/*driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();*/
		
		String login = driver.getTitle();
		{
			System.out.println(login);
		}
		/*//validation
		if(driver.getTitle().contains("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM")) {
			wb.getSheet("contact").getRow(5).createCell(4).setCellValue("home page is displayed");
			wb.getSheet("contact").getRow(5).createCell(5).setCellValue("tc is pass");  */
		homepage.documentsClick();
		documentpage.createDocumentIcon();
		createdocumentpage.documentTitle(title);
		WebDriverUtility.switchtoFrame(driver, 0);
		createdocumentpage.descriptionArea(dDescription);
		WebDriverUtility.switchBackToHome(driver);
		createdocumentpage.boldAndItalic();
		createdocumentpage.chooseFileBtn(dpath);
		createdocumentpage.saveDocuments();
		
		
	/*	driver.findElement(By.xpath("//a[.='Documents']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[1]")).sendKeys(title+jutil.getRandomNumber(1000));
		
		WebDriverUtility.switchtoFrame(driver, 0);
		
		
		
	   /* driver.switchTo().frame(0);
	    
	
		WebElement frameid= driver.findElement(By.xpath("//body[@class='cke_show_borders']"));
		
		frameid.sendKeys(dDescription);
		frameid.sendKeys(Keys.CONTROL+"abi");
		
		driver.switchTo().defaultContent();
		//driver.findElement(By.xpath("//span[@id='cke_5_label']")).click();
		//driver.findElement(By.xpath("//span[@id='cke_6_label']")).click();
		
		//file uploading
		
		driver.findElement(By.xpath("//input[@id='filename_I__']")).sendKeys(dpath);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();*/
		
		
		//singout
		
		/*WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
		WebDriverUtility.mouseHoveractions(administrator, driver);*/
		homepage.signout(driver);
		
		/*Actions act=new Actions(driver);
		act.moveToElement(admin).perform();*/
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		//driver.quit();
		WebDriverUtility.quitBrowser(driver);
		
		
		
		}

	}


