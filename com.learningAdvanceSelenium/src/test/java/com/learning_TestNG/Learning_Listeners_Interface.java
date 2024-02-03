package com.learning_TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.generic_Library.Base_Test_2;

@Listeners(com.generic_Library.Listener_Implementation.class)
public class Learning_Listeners_Interface extends Base_Test_2{

	@Test
	public void searchTest() throws InterruptedException {
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop");
		driver.findElement(By.name("q")).sendKeys("mobile");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
	}
}
