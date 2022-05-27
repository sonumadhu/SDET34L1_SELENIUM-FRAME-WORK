package com.SDETL1_GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *this class is used to maintain all webdriver common actions 
 * 
 * 
 * @author Bhushana
 *
 */
public class WebDriverUtility {

	//Global variable
	static WebDriverWait wait;
	static  Select select=null;
	static Actions act=null;
	static JavascriptExecutor js;
	static JavaUtility jutil=new JavaUtility();




	//static WebDriver driver;
	/**
	 *this method is used to navigate to application 
	 * @param url
	 * 
	 * 
	 */

	public static  void navigateToApp(String url,WebDriver  driver) {

		driver.get(url);
	}
	/**
	 * this method is used to maximize the browser and implicitly wait
	 * @param longTimeOut
	 * 
	 */
	public static void browserSettings(long longTimeOut,WebDriver driver) {
		maximizeBrowser(driver);
		waitTillPageLoad(longTimeOut, driver);

	}
	/**
	 * this method is used to maximize the browser
	 * 
	 *
	 */
	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to initlize the actions
	 * 
	 * 
	 * @param driver
	 */
	public void initializeActions(WebDriver driver) {
		act= new Actions(driver);


	}
	/**
	 *this method is used to implicitly wait till page load 
	 *@param longTimeout 
	 * 
	 */

	public static void waitTillPageLoad(long longTimeOut, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}
	/**
	 * this method is used to MouseHover on the element
	 *@param driver 
	 * 
	 * 
	 */
	public void mouseHoveractions(WebElement element,WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	/**
	 * this method is used to double click on the element
	 * 
	 * @param ele
	 */

	public static void doubleClick(WebElement ele) {

		act.moveToElement(ele).click().perform();


	}
	/**
	 * 
	 * 
	 * @param driver
	 */

	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	/**
	 * 
	 * this method is used to wait control till the particular element  is clickable
	 * @param driver
	 * @param timeOut
	 * @param element
	 * 
	 */
	public static void waiituntillElementClickable(WebElement element) {	
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 *this method is used to wait the control till the particular element is visible
	 *@param driver 
	 *@param timeOut
	 * 
	 */
	public static void waitUntillElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to initialize wait instance
	 * @param driver
	 * @param timeOut
	 * 
	 */
	public static void explicitlyWait(WebDriver driver,long timeOut) {

		wait=new WebDriverWait(driver, timeOut);

	}
	
	public static void switchToWindowBasedOnTitle(WebDriver driver,String partialText) {
		Set<String> sessionIDs = driver.getWindowHandles();
		for(String id:sessionIDs) {
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText)) {
				break;
			}
		}
	}
	/**
	 * this method is used to initialize the select class
	 * 
	 * 
	 * @param element
	 */
	public static void initiazeSelect(WebElement element ) {

		select=new Select(element);

	}
	/**
	 * this method is used to handle dropdown by visible text
	 * 
	 * @param element
	 * @param visibletext
	 */

	public static void dropDownHandlebyVisibleText(WebElement element,String visibletext ) {

		select.selectByVisibleText(visibletext);
	} 

	/**
	 *this method is used to  handle dropdown by index value 
	 * 
	 * @param element
	 * @param index
	 */

	public static void dropDownHandlebyVisibleIndex(WebElement element,int index ) {

		select.selectByIndex(index);


	}
	/**
	 * this method is used to handle dropdown by value
	 * 
	 * @param value
	 * @param element
	 */
	public static void dropDownHandlebyVisibleValue(String value,WebElement element ) {

		select.selectByValue(value);


	}
	/**
	 *this method is used to switch to frame 
	 * 
	 * @param driver
	 * @param nameorID
	 */
	public static void switchtoFrame(WebDriver driver,int nameorID) {

		driver.switchTo().frame(nameorID);


	}
	/**
	 * this method is used to switch back to main page
	 * 
	 * 
	 * @param driver
	 */
	public static void switchBackToHome(WebDriver driver) {


		driver.switchTo().defaultContent();

	}
	/**
	 * this method is used to initialize javaScript executer
	 * 	
	 * @param driver
	 */

	public static void intializeJs(WebDriver driver) {
		js = (JavascriptExecutor)driver;


	}
	/**
	 *this method is used to scroll to bottom 
	 * 
	 * 
	 */
	public static void scrollTobottom() {

		js.executeScript("window.scrollBy(0,document.bodyscrollheight)");

	}
	/**
	 * this method is used to scroll
	 * 
	 * 	
	 * @param element
	 */
	public static void scrollTillElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()",element);


	}
	/**
	 * this method is used to take screen shot by using javaSriptExecuter 
	 * 
	 * @param fileName
	 * @param driver
	 * @return 
	 * @throws IOException 
	 */
	public static String takeScreenShot(String fileName, WebDriver driver ) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot )driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./screenshot/"+fileName+"_"+jutil.dateTimeFormat()+".png");
		System.out.println(dst.getAbsolutePath());
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();

	}
	/**
	 * this method is used to alert accept
	 * 
	 * @param driver
	 */
	public static void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method is used to alert dissmiss
	 * 
	 * @param driver
	 */
	public static void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method is used to alert send data
	 * 
	 * @param driver
	 * @param data
	 */
	public static void alertsendData(WebDriver driver, String data)

	{
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * this method is used to get alretText
	 * @return
	 */
	public static String getalertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();

	}
	/**
	 *this method is used to perform right click 
	 * 
	 * 
	 */
	public static void rightClick()
	{
		act.contextClick().perform();

	}
	/**
	 * this method is used to right click on element
	 * 
	 * @param element
	 */
	public static void rightClick( WebElement element) 
	{
		act.contextClick(element);

	}



}		

















