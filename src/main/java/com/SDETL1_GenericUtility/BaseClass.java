package com.SDETL1_GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public int randomnumber;
	public String password;
	public String username;
	public long longTimeout;
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public JavaUtility jutil;
	public String url;
	//public String browser;
	public String timeOut;
	public WebDriverUtility webutility;

	/**
	 * this method is used to open excel file, property file and get connection of database
	 * 
	 * @throws IOException
	 */

	@BeforeSuite(groups="baseclass")
	public void beforeSuitTest() throws IOException {
		FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		ExcelUtilities.openExcel(IconstantPath.EXCELPATH);
	}
	/**
	 * normal execution(launch browser,navigate to application,read common data,browser settings,implicit wait explicit wait)
	 * instance for common class
	 * @throws IOException
	 */
	//@Parameters("browser")
	@BeforeClass(groups="baseclass")
	public void beforeClassTest(/*String browser*/) throws IOException {
		jutil=new JavaUtility();
		WebDriverUtility webutility=new WebDriverUtility();
		url=FileUtilities.StringfetchDataFromPropertyFile("url");
		username=System.getProperty("USENAME");
		password=System.getProperty("PASSWORD");
		/*username =FileUtilities.StringfetchDataFromPropertyFile("username");
		password =FileUtilities.StringfetchDataFromPropertyFile("password");*/
		String browser=FileUtilities.StringfetchDataFromPropertyFile("browser");
		timeOut =FileUtilities.StringfetchDataFromPropertyFile("timeout");


		longTimeout= jutil.stringToLong(timeOut);
		randomnumber=jutil.getRandomNumber(1000);

		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			jutil.printStatement("please specify proper browser key");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;

		}
		WebDriverUtility.navigateToApp(url, driver);
		WebDriverUtility.browserSettings(longTimeout, driver);
		webutility.initializeActions(driver);
		WebDriverUtility.explicitlyWait(driver, longTimeout);

		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);


	}
	/**
	 * this method is used to perform common action(login action) 
	 * 
	 */

	@BeforeMethod(groups="baseclass")
	public void beforeMethod1Test() {
		loginPage.loginToApp(username, password);
	}
	/**
	 *this method is used to perform logout action 
	 * 
	 */

	@AfterMethod(groups="baseclass")
	public void afterMethod1Test() {
		homePage.signout(driver);

	}
	/**
	 *this method is used to perform close browser 
	 * 
	 * 
	 */

	@AfterClass(groups="baseclass")
	public void afterClass1Test() {
		WebDriverUtility.quitBrowser(driver);
	}
	/**
	 * this method is used to close  Database connection, close Excel connection
	 * 
	 * @throws IOException
	 */

	@AfterSuite(groups="baseclass")
	public void afterSuit1Test() throws IOException  {
		ExcelUtilities.closeExcel();
	}
}


