package test_Case;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Test_Base;
import test_Package.AnraTestDemo;

public class Test1 extends Test_Base {
	
	AnraTestDemo obj;
	static ExtentTest test;
	static ExtentReports report;
	static ExtentHtmlReporter reporter;
	
	public Test1() {
		super();
	}
	
	@BeforeTest
	public void setUP(){
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		initialization();
		report = new ExtentReports();
		report.attachReporter(reporter);
		obj = new AnraTestDemo();
		
			
	}
	
	@Test (priority = 1)
	public void validateTitle() throws InterruptedException{
		
		test = report.createTest("validateTitleTest1");
		obj.testBegin();
		if(driver.getTitle().equals("Amazon Sign-In"))
		{
			Assert.assertEquals(driver.getTitle().toString(), "Amazon Sign-In","Test Case Passed");
			test.log(Status.PASS, "Title Matched");
		}
		//report.flush();
	}
	
	@Test (priority = 2)
	public void ValidateTitle2() { 
		ExtentTest test2 = report.createTest("validateTitleTest2");
		//if(driver.getTitle().toString().contentEquals("Fail")){
			test2.log(Status.FAIL, "Title MisMatched");
		//}
		Assert.assertEquals(driver.getTitle().toString(), "Fail","Test Case Failed");
		//report.flush();
	}
	
	@Test (priority = 3)
	public void ValidateTitle3() { 
		ExtentTest test3 = report.createTest("validateTitleTest3");
		//if(driver.getTitle().toString().contentEquals("Fail")){
			test3.log(Status.FAIL, "Title MisMatched");
		//}
		Assert.assertEquals(driver.getTitle().toString(), "Fail","Test Case Failed");
		//report.flush();

	}
	
	@AfterClass
	public static void endTest()
	{
		report.flush();
	}

}
