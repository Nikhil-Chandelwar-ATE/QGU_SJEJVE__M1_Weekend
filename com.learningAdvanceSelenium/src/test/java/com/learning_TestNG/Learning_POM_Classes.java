package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic_Library.File_Utility;
import com.objectRepository.LoginPage;
import com.objectRepository.WelcomePage;

public class Learning_POM_Classes {

	@Test
	public void loginTest() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys("kaur367@gmail.com");
		driver.navigate().refresh();
		lp.getEmailTextField().sendKeys("kaur367@gmail.com");
		lp.getPasswordTextField().sendKeys("Harry@27");
		lp.getLoginButton().click();
		Thread.sleep(2000);
		driver.quit();
	}
}
