package com.testScripts;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic_Library.WebDriver_Utility;

public class TC003_RemoveFromCart_Test extends TC002_AddToCart_Test{

	@Test(groups = "regressionTesting")
	public void removeFromCartTest() throws InterruptedException {
		
		driver.findElement(By.partialLinkText("Shopping cart")).click();
		driver.findElement(By.xpath("(//a[text()='Casual Golf Belt'])[2]/ancestor::tr[@class='cart-item-row']/descendant::input[@type='checkbox']")).click();
		driver.findElement(By.cssSelector("[name='updatecart']")).click();
		WebDriver_Utility.scrollTOWebElement(driver, driver.findElement(By.xpath("//h1[text()='Shopping cart']")));
		try {
			Reporter.log("Element is present...", true);
			WebDriver_Utility.takesScreenshotOfWebPage(driver, "shoppingCart2");
		} catch (Exception e) {
			Reporter.log("Element is not present...", true);
		}
	}
}
