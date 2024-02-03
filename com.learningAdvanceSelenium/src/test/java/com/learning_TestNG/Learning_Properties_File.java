package com.learning_TestNG;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Learning_Properties_File {

	@Test()
	public void loginTest() throws Throwable {
		
		//To create Java representation object of external file
		FileInputStream fis = new FileInputStream("./src/test/resources/data/commanData.properties");
		
		//This class is used to fetch data from properties file
		Properties prop = new Properties();
		
		//This method is used to load all the keys in properties class object
		prop.load(fis);
		
		//This method is used to fetch value by passing keys
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		WebDriver driver = new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(USERNAME);
		driver.findElement(By.id("Password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
