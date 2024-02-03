package com.learning_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Learning_Priority_Attribute {

	@Test(priority = 1)
	public void registerTest() {
		
		Reporter.log("Executing Register Test Case...", true);	//steps of test case
	}
	
	@Test(priority = 2)	//acts like a main method
	public void loginTest() {	// act like test case
		
		Reporter.log("Executing Login Test Case...", true);	//steps of test case
	}
	
	@Test(priority = 3)
	public void searchTest() {
		
		Reporter.log("Executing Search Test Case...", true);	//steps of test case
	}
}
