package com.learning_TestNG;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class Learning_Configuration_Annotation {

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Executing before suite...", true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("Executing after suite...", true);
	}
	
	@BeforeTest	
	public void beforeTest() {
		Reporter.log("Executing before test...", true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("Executing after test...", true);
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("Executing before class...", true);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("Executing after class...", true);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("Executing before method...", true);
	}
	
	@AfterMethod
	public void afterMethod() {
		Reporter.log("Executing after method...", true);
	}
	
	@Test(priority = 2)
	public void loginTest() {
		Reporter.log("Executing login test case...", true);
	}
	
	@Test(priority = 1)	//acts like a main method
	public void registerTest() {	// act like test case
		
		Reporter.log("Executing register Test Case...", true);	//steps of test case
	}
	
	@Test(priority = 3)
	public void searchTest() {
		
		Reporter.log("Executing Search Test Case...", true);	//steps of test case
	}
}
