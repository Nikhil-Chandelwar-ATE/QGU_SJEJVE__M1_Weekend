package com.generic_Library;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_Implementation implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		String name = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) Base_Test_2.sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./src/test/resources/screenshots/" + name + time + ".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
