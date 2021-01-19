package com.qa.testcases;
import org.apache.commons.mail.*;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.excelreader.ExcelReader;
import com.qa.pages.BEI_functions;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

public class DateRange extends TestBase {
	TestUtil testUtil;
	ExcelReader reader;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	String alert_text_message=null;

//	public void send_email() throws EmailException
//	{
//		EmailAttachment attachment = new EmailAttachment();
//		  attachment.setPath("./test-output-BEI/myReport.html");
//		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
//		 // attachment.setDescription("Test Report");
//		 // attachment.setName("Bulk Email Invoices");
//		  MultiPartEmail email = new MultiPartEmail();
//		  email.setHostName("smtp.gmail.com");
//		  email.setSmtpPort(465);
//		  email.setAuthenticator(new DefaultAuthenticator("sindhuja.b@tvarana.com", "Sindhu@123"));
//		  email.setSSLOnConnect(true);
//		  email.addTo("sindhuja.b@tvarana.com", "Sindhu");
//		  email.setFrom("sindhuja.b@tvarana.com", "Sindhuja");
//		  email.setSubject("Bulk Email Invoice Report");
//		  email.setMsg("Here is the report please find the attachment");
//		  email.attach(attachment);
//		  email.send();
//	}
//	@BeforeTest
//	public void setExtent() {
//		// specify location of the report
//		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output-BEI_1/myReport.html");
//
//		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
//		htmlReporter.config().setReportName("Netsuite Login Testing"); // Name of the report
//		htmlReporter.config().setTheme(Theme.STANDARD);
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
//		// Passing General information
//		extent.setSystemInfo("Environemnt", "QA");
//		extent.setSystemInfo("user", "Sindhuja");
//	}
//
//	@AfterTest
//	public void endReport() throws EmailException {
//		extent.flush();
//		//send_email();
//
//	}
//
//	@AfterMethod
//	public void tearDown(ITestResult result) throws IOException, EmailException {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			//test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
//			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
//																					// report
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			//test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
//		}
//		driver.quit();
//	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		testUtil = new TestUtil();
		testUtil.setUp();
	}
	@DataProvider
	public Object[][] date_range() throws IOException {
		reader = new ExcelReader();
		return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\bei_testdata.xlsx",0);
	}

	@Test(dataProvider = "date_range", priority = 1)
	public void date_range(String form_date,String to_date,String due_date,String testcase,String customer_name,String department,String class1,String location,String email_ids) throws Exception
	{	
		//test = extent.createTest("Testcase is " +testcase);
		BEI_functions bei=new BEI_functions();
		bei.date_range_invoices(form_date, to_date,due_date,testcase,customer_name,department,class1,location,email_ids,test);
	}
		

}
