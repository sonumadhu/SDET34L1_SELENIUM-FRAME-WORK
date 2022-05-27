package com.SDETL1_GenericUtility;

import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * this class contains only java specific reusable methods
 * @author Bhushana
 * 
 */
public class JavaUtility {
	/**
	 * this method is used to Convert string value to long data type
	 * @param
	 * @return
	 */
	public long stringToLong(String timeout) {
		return Long.parseLong( timeout);

	}
	/**
	 * this method is used to get the random number
	 *@param limit 
	 * @return
	 */
	public int getRandomNumber(int limit) {
		Random ran = new Random();
		return ran.nextInt(limit);

	}
	/**
	 * this method is used to print the message
	 * @param message
	 * 
	 */
	public void printStatement(String message) {	
		System.out.println(message);
	}
	/**
	 *this method is used to validate the statement 
	 * 
	 */
	public  void ifValidation(String ele, String value )
	{
		if(ele.contains(value)) {
			System.out.println("validated");
		}
		else {
			System.out.println("Not validated");

		}
	}
	/**
	 * validation through assertion
	 * 
	 */
	public void assertionThroughIfCondition(String sessionID,String value ) {

		if(sessionID.contains("Home")) {

			ExcelUtilities.createCell_Setcell("SheetName", 0, 0, "create contact page is not dis played");
			ExcelUtilities.createCell_Setcell("Contact Name", 0, 0, "Tc is pass");

		}
	}
	/**
	 * this method is used to wait until the element is clickable
	 *@param element
	 * @param Polingtime 
	 * @param duration
	 * @throws InterruptedException 
	 * @throws InteruuptedException
	 */
	public void customWait(WebElement element,long Polingtime,int duration) throws InterruptedException {
		int count=0;
		while(count<=duration) {

			try {
				element.click();

			} catch (Exception e) {
				Thread.sleep(Polingtime*500);
				count++;

			}
			

		}



	}
	/**
	 * This method is used to compare actual result with expected result using contains
	 * 
	 * @param actualResult
	 * @param expectedResult
	 * @param testCasename
	 */
	
	public void assertionThroughConditionContains(String actualResult,String expectedResult, String testCasename) {
		if(actualResult.contains(expectedResult)) {
			System.out.println(testCasename+"created successfully");
			System.out.println("TC is pass");
		}
	}
	/**
	 * This method is used to compare actual result with expected result using equalignoreCase 
	 * 
	 * @param actualResult
	 * @param expectedResult
	 * @param testCasename
	 */
	
	public void assertionThroughEqulIgnoreCase(String actualResult,String expectedResult, String testCasename) {
		if(actualResult.equalsIgnoreCase(expectedResult)) {
			System.out.println(testCasename+"created successfully");
			System.out.println("Tc is pass");
			
		}
	}
	
	public String dateTimeFormat() {
	
		return null;
	}
}
