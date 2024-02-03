package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Learning_Soft_Assert {

	@Test
	public void loginTest() throws InterruptedException {
		
		SoftAssert ast = new SoftAssert();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		ast.assertEquals(driver.getTitle(), "Demo Web");
		driver.findElement(By.linkText("Log in")).click();
		ast.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
		driver.findElement(By.id("Email")).sendKeys("nikhil26@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("nikhil123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		ast.assertEquals(driver.getTitle(), "Demo Web Shop");
		Thread.sleep(2000);
		driver.quit();
		ast.assertAll();
	}
}
