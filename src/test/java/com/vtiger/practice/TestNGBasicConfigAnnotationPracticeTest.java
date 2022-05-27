package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNGBasicConfigAnnotationPracticeTest {
	
	@BeforeSuite
	public void beforesuit1() {
		Reporter.log("beforesuit1",true);
	}
	@AfterSuite
	public void aftersuit1Test() {
		Reporter.log("Aftersuit1",true);
		
	}
	@BeforeClass
	public void beforeClass1Test() {
		Reporter.log("beforeClass1",true);
	}
	@AfterClass
	public void afterclass1Test() {
		Reporter.log("afterClass1",true);
		
		}
	@BeforeTest
	public void beforeTest1Test() {
		Reporter.log("beforeTest1",true);
		
	}
	
	@AfterTest
	public void afterTest1Test() {
		Reporter.log("aftertest1",true);
		
	}
	
	@BeforeMethod
	public void beforeMethod1Test() {
		Reporter.log("beforeMethod1",true);	
	}
	@BeforeMethod
	public void beforeMethod2Test() {
		Reporter.log("beforeMethod2",true);	
	}
	@AfterMethod
	public void afterMethod2Test() {
		Reporter.log("afterMethod2",true);	
	}	
		
	@AfterMethod
	public void afterMethod1Test() {
		Reporter.log("afterMethod1",true);	
	}		
		
	

}
