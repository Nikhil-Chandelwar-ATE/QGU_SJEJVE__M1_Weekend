package com.learning_TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.generic_Library.WebDriver_Utility;
import com.objectRepository.LoginPage;
import com.objectRepository.WelcomePage;

public class Learning_Extent_Report {

	@Test
	public void loginTest() throws InterruptedException {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/FirstReport.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		
		ExtentTest test = report.createTest("loginTest");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		
		try {
			Assert.assertEquals(driver.getTitle(), "DWS");
			test.log(Status.INFO, "Demo Web Shop opened....");
			WelcomePage wp = new WelcomePage(driver);
			wp.getLoginLink().click();
			test.log(Status.INFO, "Login Page opened...");
			LoginPage lp = new LoginPage(driver);
			lp.getEmailTextField().sendKeys("kaur367@gmail.com");
			driver.navigate().refresh();
			lp.getEmailTextField().sendKeys("kaur367@gmail.com");
			lp.getPasswordTextField().sendKeys("Harry@27");
			lp.getLoginButton().click();
			test.log(Status.PASS, "User Logged in successfully...");
			Thread.sleep(2000);
			
			
		} catch (Throwable e) {
			
			test.log(Status.FAIL, "fail.....");
			test.addScreenCaptureFromBase64String(WebDriver_Utility.getScreenShotPath(driver));
		}
		driver.quit();
		report.flush();
	}
}
