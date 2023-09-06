package com.hopestar.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplimentationClass implements ITestListener{


	public void onTestStart(ITestResult result) {
		
	}

	
	public void onTestSuccess(ITestResult result) {
		
	}

	
	public void onTestFailure(ITestResult result) {
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(HopeStarBaseClass.driver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./src/test/EditClient123.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

	
	public void onTestSkipped(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	
	public void onFinish(ITestContext context) {
		
	}
	
	
	

}
