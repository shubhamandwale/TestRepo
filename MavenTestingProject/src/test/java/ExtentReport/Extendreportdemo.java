package ExtentReport;


import org.junit.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extendreportdemo {

	ExtentReports report;
	ExtentTest test;


	@BeforeTest
	public void Startreport() {
		report = new ExtentReports("./ExtentReports/ExtentReport.html",true);
		report.addSystemInfo("Host name", "shubham");
     	report.addSystemInfo("Environment", "Dev");
     	report.addSystemInfo("UserName", "Shubham Mandwale");


		      
		    
	}

	@Test
	public void test1() {
		test = report.startTest("failTest");
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL, "test1 is failed");
	}

	@Test
	public void test2() {
		test = report.startTest("passTest");
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "test2 is passed");
	}

	@Test
	public void test3skiptest() {
		test = report.startTest("Skiptest");
		throw new SkipException("Skipping - this is not ready for testing");
	}

	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		report.endTest(test);
	}
	@AfterTest
	public void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
		report.flush();
		//Call close() at the very end of your session to clear all resources. 
		//If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
		//You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
		//Once this method is called, calling any Extent method will throw an error.
		//close() - To close all the operation
		report.close();
	}

}