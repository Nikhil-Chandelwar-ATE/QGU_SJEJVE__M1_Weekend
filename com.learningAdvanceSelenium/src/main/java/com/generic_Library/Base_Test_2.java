package com.generic_Library;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test_2 {

	public ExtentReports report;
	public ExtentTest test;
	public WebDriver driver;
	public static WebDriver sDriver;

	@BeforeSuite
	public void configureReport() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/"+Java_Utility.getName()+".html");
		report = new ExtentReports();
		report.attachReporter(spark);
	}
	
	@BeforeClass(alwaysRun = true)
	public void openBrowser() throws Throwable {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(File_Utility.getPropertyValue("url"));
		
		sDriver = driver;
	}

	@BeforeMethod(alwaysRun = true)
	public void loginToDWS(Method method) throws Throwable {

		test = report.createTest(method.getName());
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(File_Utility.getPropertyValue("username"));
		driver.findElement(By.id("Password")).sendKeys(File_Utility.getPropertyValue("password"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void logoutFromDWS() throws InterruptedException {

		driver.findElement(By.linkText("Log out")).click();
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {

		driver.quit();
	}
	
	@AfterSuite
	public void saveReport() {
		
		report.flush();
	}
}
