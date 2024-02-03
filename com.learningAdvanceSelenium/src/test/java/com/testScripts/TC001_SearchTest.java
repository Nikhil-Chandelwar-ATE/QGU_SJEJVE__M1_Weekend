package com.testScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.generic_Library.Base_Test_2;
import com.generic_Library.WebDriver_Utility;

public class TC001_SearchTest extends Base_Test_2 {

	@Test(groups = "smokeTesting")
	public void searchTest() throws InterruptedException {
		
		
		driver.findElement(By.name("q")).sendKeys("mobile");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
		WebDriver_Utility.scrollTOWebElement(driver, driver.findElement(By.xpath("//h1[text()='Search']")));
		test.log(Status.PASS, "Product searched");
		WebDriver_Utility.takesScreenshotOfWebPage(driver, "mobileSearch");
	}
}
