package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGAseerTest extends TestNGBasicConfigAnnotationPracticeTest {
	@Test
	public void practice1Test() {
		Reporter.log("a-practice1",true);
		Reporter.log("b-practice1",true);
		Reporter.log("c-practice1",true);
		Assert.fail();
		Reporter.log("d-practice1",true);
		Reporter.log("e-practice11",true);
		Reporter.log("f-practice",true);
		
	}
	
	@Test
	public void practice2Test() {
		Reporter.log("a-practice2",true);
		Reporter.log("b-practice2",true);
		Reporter.log("c-practice2",true);
		Reporter.log("d-practice2",true);
		Assert.fail();
		Reporter.log("e-practice2",true);
		Reporter.log("f-practice2",true);
		
	}
	@Test
	public void practice3Test() {
		Reporter.log("a-practice3",true);
		Reporter.log("b-practice3",true);
		Reporter.log("c-practice3",true);
		Reporter.log("d-practice3",true);
		Assert.fail();
		Reporter.log("e-practice3",true);
		Reporter.log("f-practice3",true);
		
	}
	@Test
	public void practice4Test() {
		Reporter.log("a-practice4",true);
		Reporter.log("b-practice4",true);
		Reporter.log("c-practice4",true);
		Reporter.log("d-practice4",true);
		Assert.fail();
		Reporter.log("e-practice4",true);
		Reporter.log("f-practice4",true);
		
	}
	
	
	
}
