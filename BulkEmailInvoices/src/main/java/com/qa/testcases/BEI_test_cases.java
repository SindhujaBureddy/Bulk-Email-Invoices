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

public class BEI_test_cases extends TestBase {
	TestUtil testUtil;
	ExcelReader reader;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	String alert_text_message=null;

	public void send_email() throws EmailException
	{
		EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("./test-output-BEI/myReport.html");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		 // attachment.setDescription("Test Report");
		 // attachment.setName("Bulk Email Invoices");
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.gmail.com");
		  email.setSmtpPort(465);
		  email.setAuthenticator(new DefaultAuthenticator("sindhuja.b@tvarana.com", "Sindhu@123"));
		  email.setSSLOnConnect(true);
		  email.addTo("sindhuja.b@tvarana.com", "Sindhu");
		  email.setFrom("sindhuja.b@tvarana.com", "Sindhuja");
		  email.setSubject("Bulk Email Invoice Report");
		  email.setMsg("Here is the report please find the attachment");
		  email.attach(attachment);
		  email.send();
	}
	@BeforeTest
	public void setExtent() {
		// specify location of the report
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output-BEI/myReport.html");

		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Netsuite Login Testing"); // Name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// Passing General information
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Sindhuja");
	}

	@AfterTest
	public void endReport() throws EmailException {
		extent.flush();
		send_email();

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, EmailException {
		if (result.getStatus() == ITestResult.FAILURE) {
			//test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
																					// report
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			//test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
		driver.quit();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		testUtil = new TestUtil();
		testUtil.setUp();
	}
//	@DataProvider
//	public Object[][] date_range() throws IOException {
//		reader = new ExcelReader();
//		return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\bei_testdata.xlsx",0);
//	}
//
//	@Test(dataProvider = "date_range", priority = 7)
//	public void date_range(String form_date,String to_date,String due_date,String testcase,String customer_name,String department,String class1,String location,String email_ids) throws Exception
//	{	
//		test = extent.createTest("Testcase is " +testcase);
//		BEI_functions bei=new BEI_functions();
//		bei.date_range_invoices(form_date, to_date,due_date,testcase,customer_name,department,class1,location,email_ids,test);
//	}
		
	@DataProvider
	public Object[][] date_validations() throws IOException {
		reader = new ExcelReader();
		return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\bei_testdata.xlsx", 1);
	}

	@Test(dataProvider = "date_validations", priority = 1)
	public void date_validations(String alphabets,String numbers,String special_chars,String alpha_numerics,String alpha_special_chars,String numbers_special_chars,String testcase,String to_date_less_than_three_digits,String to_date_greater_than_two_digits) throws Exception
	{	
		test = extent.createTest("Testcase is " +testcase);
		BEI_functions bei=new BEI_functions();
		bei.date_validations(alphabets, numbers, special_chars, alpha_numerics, alpha_special_chars, numbers_special_chars, testcase, to_date_less_than_three_digits, to_date_greater_than_two_digits,test);
	}
	@DataProvider
	public Object[][] two_filter() throws IOException {
		reader = new ExcelReader();
		return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\bei_testdata.xlsx", 4);
	}
	@Test(dataProvider = "two_filter", priority = 2)
	public void two_filter(String customer_name1,String subsidiary1,String department1,String class1,String location1,String from_date1,String to_date1,String testcase,String due_date) throws Exception
	{	
		test = extent.createTest("Testcase is " +testcase);
		BEI_functions bei=new BEI_functions();
		bei.two_filters(customer_name1, subsidiary1, department1, class1, location1, from_date1, to_date1,testcase,due_date,test);
	}
	@DataProvider
	public Object[][] higher_dates() throws IOException {
		reader = new ExcelReader();
		return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\bei_testdata.xlsx", 5);
	}
	@Test(dataProvider = "higher_dates", priority = 3)
	public void higher_dates(String from_date,String to_date,String testcase) throws InterruptedException
	{
		test = extent.createTest("The test case is" +" " +testcase);
		BEI_functions bei=new BEI_functions();
		bei.highest_dates(from_date, to_date, testcase,test);
	}
	@DataProvider
	public Object[][] email_sourcing() throws IOException {
		reader = new ExcelReader();
		return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\bei_testdata.xlsx", 3);
	}
	@Test(dataProvider = "email_sourcing", priority = 4)
	public void email_sourcing(String from_date1,String to_date1,String testcase,String customername) throws Exception
	{
		test = extent.createTest("Testcase is " +testcase);
		BEI_functions bei=new BEI_functions();
		bei.email_sourcing(from_date1, to_date1, testcase,customername,test);
	}
	@DataProvider
	public Object[][] dashboard() throws IOException {
		reader = new ExcelReader();
		return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\bei_testdata.xlsx", 2);
	}
	@Test(dataProvider = "dashboard", priority = 5)
	public void dashboard(String from_date1,String to_date1,String testcase) throws Exception
	{			
		test = extent.createTest("Testcase is " +testcase);
		BEI_functions bei=new BEI_functions();
		bei.dashboard(from_date1, to_date1, testcase,test);
	}
	@DataProvider
	public Object[][] config() throws IOException {
		reader = new ExcelReader();
		return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\bei_testdata.xlsx", 6 );
	}
	@Test(dataProvider = "config", priority = 6)
	public void configuration(String before,String after,String testcase) throws Exception
	{			
		test = extent.createTest("Testcase is " +testcase);
		BEI_functions bei=new BEI_functions();
		bei.navigate_to_config(before, after, testcase,test);
	}

	@Test(priority = 7)
	public void configuration() throws Exception
	{	
		test = extent.createTest("The test case is consolidated invoices");
		BEI_functions bei=new BEI_functions();
		bei.consolidate_invoices(test);
	}

}
