package com.learning_TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Learning_Depends_On_Methods_Attribute {

	@Test
	public void registerTest() {
		
		Reporter.log("Executing Register Test Case...", true);	//steps of test case
	}
	
	@Test(dependsOnMethods = "registerTest")	//acts like a main method
	public void loginTest() {	// act like test case
		
		Reporter.log("Executing Login Test Case...", true);	//steps of test case
	}
	
	@Test(dependsOnMethods = {"registerTest", "loginTest"})
	public void searchTest() {
		
		Reporter.log("Executing Search Test Case...", true);	//steps of test case
	}
}
