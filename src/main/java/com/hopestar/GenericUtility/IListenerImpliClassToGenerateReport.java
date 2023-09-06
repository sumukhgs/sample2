package com.hopestar.GenericUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class IListenerImpliClassToGenerateReport implements ITestListener{

	ExtentReports report;
	ExtentTest Test;
	
	public void onTestStart(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		Test=report.createTest(methodname);
		Reporter.log(methodname+"--> Test Script Execution Started ");
	}


	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		Test.log(Status.PASS, methodname+"---> passed");
	
		Reporter.log(methodname+"--> Test Script Passed  ");
		
	}

	
	public void onTestFailure(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		//EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(BaseClass.sdriver);
		EventFiringWebDriver driver = new EventFiringWebDriver(HopeStarBaseClass.driver);
		File src = driver.getScreenshotAs(OutputType.FILE);
		String path=".\\src\\hopestarscreenshot\\fail.png";
		File dst = new File(path);
	try {
		FileUtils.copyFile(src, dst);
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	 try {
	        Test.addScreenCaptureFromPath(dst.getAbsolutePath(), "Failure Screenshot");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	Test.log(Status.FAIL, methodname+"---> Failed");
	Test.log(Status.FAIL, result.getThrowable());
	Reporter.log(methodname+"--> Test Script Failed  ");
	
		
	}

	
	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		Test.log(Status.PASS, methodname+"---> Skipped");
		Test.log(Status.FAIL, result.getThrowable());
		Reporter.log(methodname+"--> Test Script Skippe  ");
	
	}

	
	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report");
		htmlreport.config().setDocumentTitle("HopeStar Life-Insurance");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("hopestar report");
		
	    report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("OS", "http://localhost:8888/");
		report.setSystemInfo("reporter name", "sumukh g s");
		
	}

	
	public void onFinish(ITestContext context) {
		report.flush();

	}
	
	

}
