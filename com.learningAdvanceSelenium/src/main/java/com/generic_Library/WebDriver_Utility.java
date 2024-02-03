package com.generic_Library;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class WebDriver_Utility {

	public static void scrollTOWebElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void takesScreenshotOfWebPage(WebDriver driver, String ssNAme) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/test/resources/screenshots/" + ssNAme + ".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getScreenShotPath(WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}
}