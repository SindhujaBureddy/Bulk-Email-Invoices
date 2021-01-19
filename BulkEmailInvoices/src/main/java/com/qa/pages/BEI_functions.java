package com.qa.pages;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.naming.CommunicationException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;
public class BEI_functions extends TestBase {
	@FindBy(xpath = "//input[@name='custpage_includesubtrans_send']//following-sibling::img")
	WebElement show_parent_emails;
	@FindBy(xpath = "//h2[@title='Total Amount Followed Up']")
	WebElement hover_on_follow;
	@FindBy(xpath = "//span[@id='ns-component-5058551695101061--1127946376']")
	WebElement over_total_refresh;
	@FindBy(xpath = "//table[@id='neg60__tab']//tbody//tr[@id='totalRow']//a")
	WebElement over_total;
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//td[@data-label='Internal ID']//preceding-sibling::td)]//a[@class='dottedlink viewitem']")
	List<WebElement> partially_paid_invoices;
	@FindBy(xpath = "//input[@id='custpage_fromdate']")
	WebElement form_date;
	@FindBy(xpath = "//input[@id='custpage_todate']")
	WebElement to_date;
	@FindBy(xpath = "//td[@id='tdbody_custpage_filter']")
	WebElement search_button;
	@FindBy(xpath = "//td[@id='tdbody_custpage_submit']")
	WebElement process_button; 
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='NAME']//preceding-sibling::td)+1]")
	List<WebElement> invoices_date_range_dates;
	@FindBy(xpath = "//input[@id='inpt_custpage_client1']")
	WebElement customer_name;
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='DOCUMENT NUMBER']//preceding-sibling::td)+2]")
	List<WebElement> invoices_with_customer_name;
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='MEMO']//preceding-sibling::td)+3]//a")
	List<WebElement> doc_nr;
	@FindBy(xpath = "//input[@id='inpt_custpage_department3']")
	WebElement department;
	@FindBy(xpath = "//input[@id='inpt_custpage_class4']")
	WebElement classs;
	@FindBy(xpath = "//input[@id='inpt_custpage_location5']")
	WebElement location;
	@FindBy(xpath = "//span[@id='department_fs_lbl_uir_label']//following-sibling::span")
	WebElement dept_in_invoice;
	@FindBy(xpath = "//span[@id='class_fs_lbl_uir_label']//following-sibling::span")
	WebElement class_in_invoice;
	@FindBy(xpath = "//span[@id='location_fs_lbl_uir_label']//following-sibling::span")
	WebElement loc_in_invoice;
	@FindBy(xpath = "//input[@id='custpage_duedate']")
	WebElement due_datee;
	@FindBy(xpath = "//span[@id='duedate_fs_lbl_uir_label']//following-sibling::span")
	WebElement due_date_in_invoice;
	@FindBy(xpath = "//input[@name='custpage_paidinfull_send']//following-sibling::img")
	WebElement show_only_open_invoices;
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='TYPE']//preceding-sibling::td)+3]")
	List<WebElement> open_status;
	@FindBy(xpath = "//span[@id='custpage_showcreditmemos_fs']")
	WebElement credit_memos;
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='Subsidiary']//preceding-sibling::td)+3]")
	List<WebElement> tran_type;
	@FindBy(xpath = "//input[@name='custpage_resendemail_send']//following-sibling::img")
	WebElement show_emailed_invoices;
	@FindBy(xpath = "//td[@id='custom502lnk']")
	WebElement bulk_email_invoices_tab;
	@FindBy(xpath = "//table[@id='recmachcustrecord_tss_attach_to_tran__tab']//tbody//tr//td[count(//td[@data-label='BULK EMAIL SEND DATE']//preceding-sibling::td)]")
	WebElement email_status_in_invoice;
	@FindBy(xpath = "//td[@id='tdbody_custpage_listunmarkall']")
	WebElement unmark_all;
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='DATE']//preceding-sibling::td)]//img")
	List<WebElement> select_invoices;
	@FindBy(xpath = "//input[@name='custpage_exclude_send']//following-sibling::img")
	WebElement exclue_selected_invoices_checkbox;
	@FindBy(xpath = "//a[@class='ns-scroll-button ns-scroll-button-bottom']")
	WebElement arrow;
	@FindBy(xpath = "//input[@name='custpage_excludeemail_send']//following-sibling::img")
	WebElement show_excluded_invoices;
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='EMAIL TO']//preceding-sibling::td)+4]//textarea")
	List<WebElement> email_to;
	@FindBy(xpath = "//input[@id='inpt_custpage_emailtemplate6']")
	WebElement email_template_input;
	@FindBy(xpath = "//div[@id='holdon-message']")
	WebElement hold_on_message;
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='DOCUMENT NUMBER']//preceding-sibling::td)+2]//a")
	List<WebElement> customer_link;
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='DOCUMENT NUMBER']//preceding-sibling::td)+2]")
	List<WebElement> customer_names;
	@FindBy(xpath = "//input[@name='custpage_multiattach_send']//following-sibling::img")  
	WebElement multi_attach;
	@FindBy(xpath = "//table[@id='recmachcustrecord_tss_attach_to_tran__tab']//tbody//tr//td[count(//td[@data-label='EMAIL STATUS']//preceding-sibling::td)]")
	WebElement no_of_invoices_in_invoice;
	@FindBy(xpath = "//table[@id='recmachcustrecord_tss_attach_to_tran__tab']//tbody//tr//td[count(//td[@data-label='Include Customer Statement']//preceding-sibling::td)+1]")
	List<WebElement> customer_statement;
	@FindBy(xpath = "//input[@name='custpage_customerstatement_send']//following-sibling::img")
	WebElement include_customer_statement_checkbox;
	@FindBy(xpath = "//table[@id='messages__tab']//tbody//tr//td[count(//td[@data-label='Primary Recipient']//preceding-sibling::td)+1]")
	WebElement email_ids_in_customer_record;
	@FindBy(xpath = "//td[@id='s_commlnk']")
	WebElement communication_tab;
	@FindBy(xpath = "//span[@id='entity_fs_lbl_uir_label']//following-sibling::Span")
	WebElement customer_name_in_invoice;
	@FindBy(xpath = "//table[@id='custpage_list_splits']//tr[@id='custpage_listheader']//following-sibling::tr//td[count(//td[@data-label='DATE']//preceding-sibling::td)]//span")
	List<WebElement> select_checkbox_checking;
	@FindBy(xpath = "//td[@id='tdbody_custpage_listmarkall']")
	WebElement mark_all;
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//td[@data-label='Customer']//preceding-sibling::td)+1]")
	List<WebElement> bei_comparison_customers;
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//td[@data-label='Number of email sent']//preceding-sibling::td)+1]")
	List<WebElement> no_of_emails_sent_through_bei;
	@FindBy(xpath = "//h2[@title='BEI Comparison After BEI']//following::td[@id='uir_totalcount']//a")
	WebElement total_count_bei;
	@FindBy(xpath = "//a[@aria-label='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//h2[@title='Total Amount Followed Up']")
	WebElement amount_followed_up_through;
	@FindBy(xpath = "//span[@id='email_fs_lbl_uir_label']//following-sibling::span")
	WebElement email_fiels_in_customer;
	@FindBy(xpath = "//span[@id='custentity_tss_bulk_email_addresses_fs_lbl_uir_label']//following-sibling::span")
	WebElement bulk_email_addresses;
	@FindBy(xpath = "//div[@data-field-type='emails']")
	WebElement to_be_emailed;
	@FindBy(xpath = "//td[@id='cmmnctntablnk']")
	WebElement communication_tab_in_invoice;
	@FindBy(xpath = "//td[@id='cmmnctntablnk']")
	WebElement communication_tab_in_credit_memo;
	@FindBy(xpath = "//input[@id='searchid']//preceding-sibling::td//a[@id='totallinkneg60']")
	WebElement total_invoices_followed_up;
	@FindBy(xpath = "//h2[@title='BEI Comparison Before BEI']//following::td[@id='uir_totalcount']//a")
	WebElement open_days_in_dashboard;
	@FindBy(xpath = "//table[@id='recmachcustrecord_tss_attach_to_tran__tab']//tbody//tr")
	List<WebElement> total_email_rows_in_bei_tab;
	static AuthPageNavigation authPage;
	static String parentWindow;
	TestUtil util; 
	@FindBy(xpath = "//table[@id='neg14050__tab']//tbody//td[count(//h2[@title='BEI Comparison Before BEI']//following::table[@id='neg14050__tab']//td[@data-label='Sum of Amount Remaining']//preceding-sibling::td)]//a")
	List<WebElement> Customer_open_days_in_bei;
	@FindBy(xpath = "//table[@id='neg14050__tab']//tbody//td[count(//h2[@title='BEI Comparison Before BEI']//following::table[@id='neg14050__tab']//td[@data-label='Maximum of Days Open']//preceding-sibling::td)+1]")
	List<WebElement> customer_open_days;
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//td[@data-label='Days Open']//preceding-sibling::td)+1]")
	List<WebElement> max_days_open_dashboard;
	@FindBy(xpath = "//h2[@title='BEI Comparison Before BEI']")
	WebElement bei_comparsion;
	@FindBy(xpath = "//li[@class='ns-menuitem ns-role-menuitem']//a//span[@class='ns-role-menuitem-text']")
	List<WebElement> beilink;
	@FindBy(xpath = "//li[@data-title='Setup']")
	WebElement setup;
	@FindBy(xpath = "//li[@data-title='Bulk Email Invoice']")
	WebElement bulk_email_invoice;
	@FindBy(xpath = "//li[@data-title='Configuration Page']")
	WebElement configuration_page;
	@FindBy(xpath = "//a//preceding::div[@id='spn_cRR_d1']")
	WebElement view_roles;
	@FindBy(xpath = "//table[@id='div__bodytab']//tr//td[count(//td[@data-label='Role']//preceding-sibling::td)+1]//a")
	List<WebElement> roles_;
	@FindBy(xpath = "//table[@id='div__bodytab']//tr//td[count(//td[@data-label='Account Type']//preceding-sibling::td)]")
	List<WebElement> company_name;
	@FindBy(xpath = "//table[@id='div__bodytab']//tr//td[count(//td[@data-label='Last Login']//preceding-sibling::td)]")
	List<WebElement> account_type;
	@FindBy(xpath = "//input[@id='inpt_custpage_emailtemplate1']")
	WebElement email_template_before;
	@FindBy(xpath = "//input[@id='inpt_custpage_emailtemplateaft2']")
	WebElement email_template_after;
	@FindBy(xpath = "//input[@id='custpage_daysbefore_formattedValue']")
	WebElement no_of_days_before_due_date;
	@FindBy(xpath = "//input[@id='custpage_daysafter_formattedValue']")
	WebElement no_of_days_after_due_date;
	@FindBy(xpath = "//input[@name='custpage_include_cs_send']//following-sibling::img")
	WebElement include_cus_stat_config;
	@FindBy(xpath = "//input[@name='custpage_opentransactions_send']//following-sibling::img")
	WebElement include_cus_stat_config_only_open;
	@FindBy(xpath = "//td[@id='tdbody_submitter']")
	WebElement submit_config;
	@FindBy(xpath = "//img[@id='inpt_custpage_emailtemplate1_arrow']")
	WebElement before_email_arrow;
	@FindBy(xpath = "//img[@id='inpt_custpage_emailtemplateaft2_arrow']")
	WebElement after_email_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> dropdown_email_after_before;
	@FindBy(xpath = "//li[@data-title='Customization']")
	WebElement customization;
	@FindBy(xpath = "//li[@data-title='Scripting']")
	WebElement scripting;
	@FindBy(xpath = "//li[@data-title='Scripts']")
	WebElement scripts;
	@FindBy(xpath = "//span[contains(text(),'Transactions')]")
	WebElement Transactions;
	@FindBy(xpath = "//li[@data-title='Sales']")
	WebElement sales;
	@FindBy(xpath = "//li[@data-title='Create Invoices']")
	WebElement create_invoices;
	@FindBy(xpath="//li[@data-title='Create Invoices']//following::li[@data-title='List']")
	WebElement invoice_list;
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//td[@data-label='Status']//preceding-sibling::td)+1]")
	List<WebElement> status_in_invoice_list;
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//td[count(//td[@data-label='Internal ID']//preceding-sibling::td)]//a[@class='dottedlink viewitem']")
	List<WebElement> view_in_invoice_list;
	@FindBy(xpath = "//td[@id='tdbody_edit']")
	WebElement edit_invoice;
	@FindBy(xpath = "//input[@id='duedate']")
	WebElement due_date_in_invoice_record;
	@FindBy(xpath = "//td[@id='spn_multibutton_submitter']")
	WebElement save_invoice;
	@FindBy(xpath = "//td[@id='tdbody_edit']")
	WebElement script_edit;
	@FindBy(xpath = "//div[@class='bntBgT']")
	WebElement edit_expand;
	@FindBy(xpath = "//span[contains(text(),'Save and Execute')]")
	WebElement save_and_execute;
	@FindBy(xpath = "//table[@id='recmachcustrecord_tss_attach_to_tran__tab']//tbody//td[count(//td[@data-label='BULK EMAIL SEND DATE']//preceding-sibling::td)+1]")
	List<WebElement> bulk_email_send_date;
	@FindBy(xpath = "//img[@id='inpt_quicksort6_arrow']")
	WebElement recently_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> recenty_drop;
	@FindBy(xpath = "//span[@id='parent_fs_lbl_uir_label']")
	WebElement parent_company;
	@FindBy(xpath = "//span[@id='parent_fs_lbl_uir_label']//following-sibling::span")
	WebElement parent_company_value;
	@FindBy(xpath = "//td[@id='tdbody_acceptpayment']")
	WebElement accept_payment;
	@FindBy(xpath = "//span[@id='amountremainingtotalbox_fs_lbl_uir_label']//following-sibling::span")
	WebElement amount_due;
	@FindBy(xpath = "//span[@id='tranid_fs_lbl_uir_label']//following-sibling::span")
	WebElement reference_no_in_invoice;
	@FindBy(xpath = "//table[@id='apply_splits']//tr//following-sibling::tr//td[count(//td[@data-label='Orig. Amt.']//preceding-sibling::td)-7]")
	List<WebElement> ref_no_in_payment;
	@FindBy(xpath = "//table[@id='apply_splits']//tr//following-sibling::tr//td[count(//td[@data-label='Payment']//preceding-sibling::td)-3]")
	List<WebElement> payment_amount_click;
	@FindBy(xpath = "//td[@id='spn_secondarymultibutton_submitter']")
	WebElement payment_save;
	@FindBy(xpath = "//table[@id='apply_splits']//tr//following-sibling::tr//td[count(//td[@data-label='Payment']//preceding-sibling::td)-3]//input[@class='inputrt']")
	List<WebElement> payment_amount;
	@FindBy(xpath = "//li[@data-title='Lists']")
	WebElement Lists;
	@FindBy(xpath = "//li[@data-title='Custom']")
	WebElement custom;
	@FindBy(xpath = "//li[@data-title='Consolidate Customer Invoices']")
	WebElement consolidate_customer_invoice;
	@FindBy(xpath = "//table[@id='custpage_ci_invoices_splits']//tbody//tr//following-sibling::tr//td[count(//td[@data-label='Currency']//preceding-sibling::td)+1]")
	List<WebElement> consolidate_customer;
	@FindBy(xpath = "//table[@id='custpage_ci_invoices_splits']//tbody//tr//following-sibling::tr//td[count(//td[@data-label='AMount Due']//preceding-sibling::td)+1]")
	List<WebElement> consolidate_no_invoices;
	@FindBy(xpath = "//table[@id='custpage_ci_invoices_splits']//tbody//tr//following-sibling::tr//td[count(//td[@data-label='Number of Invoices']//preceding-sibling::td)]//img")
	List<WebElement> consolidate_invoice_checkbox;
	@FindBy(xpath = "//td[@id='tdbody_submitter']")
	WebElement submit_consolidate;
	@FindBy(xpath = "//div[@class='descr']//a")
	WebElement consolidate_link;
	@FindBy(xpath = "//img[@id='inpt_quicksort3_arrow']")
	WebElement consolidate_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> consolidate_dropdown;
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr//following-sibling::tr//td[count(//td[@data-label='Invoices']//preceding-sibling::td)]")
	List<WebElement> consolidate_customer_after;
	@FindBy(xpath = "//table[@id='div__bodytab']//tbody//tr//following-sibling::tr//td[count(//td[@data-label='Invoices']//preceding-sibling::td)+1]")
	List<WebElement> consolidate_invoice_after;
	@FindBy(xpath = "//input[@name='custpage_opentransactions_send']//following-sibling::img")
	WebElement include_customer_open;
	@FindBy(xpath = "//input[@name='custpage_customerstatement_send']//following-sibling::img")
	WebElement include_customer;
	@FindBy(xpath = "//input[@id='inpt_custpage_pagination7']")
	WebElement total_invoices_in_bei;
	@FindBy(xpath = "//img[@id='inpt_custpage_pagination7_arrow']")
	WebElement page_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> page_dropdown;
	String confirm_message=null;
	String confirm_not=null;
	String date_validations_message=null;
	public BEI_functions() {
		PageFactory.initElements(driver, this);
	}
	public void navigate_to_consolidate_customer_invoice() throws InterruptedException
	{
		Actions action=new Actions(driver);
		action.moveToElement(Lists).build().perform();
		Thread.sleep(2000);
		if(arrow.isDisplayed())
		{
			arrow.click();
		}
		if(arrow.isDisplayed())
		{
			arrow.click();
		}
		Thread.sleep(3000);
		action.moveToElement(custom).build().perform();
		Thread.sleep(2000);
		consolidate_customer_invoice.click();	
	}
	public void required_account(String role,String company,String account) throws InterruptedException
	{
	Actions action=new Actions(driver);
	view_roles.click();
	Thread.sleep(5000);
	for(int i=0;i<roles_.size();i++)
	{
		WebElement role_index=roles_.get(i);
		String role_text=role_index.getText();
		WebElement account_index=account_type.get(i+1);
		String account_text=account_index.getText();
		WebElement company_index=company_name.get(i+1);
		String company_text=company_index.getText();
		if(role_index.getText().trim().equals(role)&&company_index.getText().trim().equals(company)&&account_index.getText().trim().equals(account))
		{
			System.out.println("role is "+role_index.getText());
			System.out.println("account is "+account_index.getText());
			System.out.println("company is "+company_index.getText());
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",role_index);
			role_index.click();
			break;
			
		}
	}
	}
	public boolean isEmpty(String emailid)
	{
		if(emailid == null){
			return true;
		}
		else
		{
		return false;
		}
			   
	}

	public static void windowHandle() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String currentwindow = driver.getWindowHandle();
		parentWindow = currentwindow;
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> i = allWindows.iterator();
		while (i.hasNext()) {
			String childwindow = i.next();
			if (!childwindow.equalsIgnoreCase(currentwindow)) {
				driver.switchTo().window(childwindow);
			}
		}
	}

	@SuppressWarnings("unused")
	public void date_range_invoices(String from_date1, String to_date1, String due_date, String testcase,
			String customer_name1, String department1, String class1, String location1,String email_ids,ExtentTest test) throws Exception {
		if(testcase.trim().equals("include customer statement with and without open transactions"))
		{
			String[] count=new String[2];
			String[]count1=new String[2];
			String total=null;
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(2000);
			include_customer_open.click();
			search_button.click();
			Thread.sleep(5000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",multi_attach);
			@SuppressWarnings("deprecation")
			WebDriverWait wait=new WebDriverWait(driver,50);
			total= driver.findElement(By.xpath("//input[@id='inpt_custpage_pagination7']")).getAttribute("value").trim();
			for(int i=0;i<count.length;i++)
			{
			count=total.split("of ");
			}
			System.out.println("The total number of invoices for customer statement without open invoices is "+count[1]);
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(3000);
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("//span[@id='custpage_paidinfull_fs']")).getAttribute("class")
					.contains("checkbox_ck"))
			{
				show_only_open_invoices.click();
			}
			include_customer.click();
			search_button.click();
			Thread.sleep(5000);
			js.executeScript("arguments[0].scrollIntoView(true);",multi_attach);
			wait.until(ExpectedConditions.visibilityOf(page_arrow));
			String total1=null;
			total1= driver.findElement(By.xpath("//input[@id='inpt_custpage_pagination7']")).getAttribute("value").trim();
			Thread.sleep(2000);		
			for(int i=0;i<count1.length;i++)
			{
			count1=total1.split("of ");
			}
			System.out.println("The total number of invoices for customer statement without open invoices is "+count1[1]);
			int open_count=Integer.parseInt(count[1]);
			int open_full_count=Integer.parseInt(count1[1]);
			if(open_full_count>open_count)
			{
				System.out.println("Transactions displayed in Customer Statement on checking Customer Statement are more than transactions displayed in Customer Statement on checking Customer Statement(Open Transactions)");
				test.pass("Transactions displayed in Customer Statement on checking Customer Statement are more than transactions displayed in Customer Statement on checking Customer Statement(Open Transactions)");
				}
			else
			{
				System.out.println("Transactions displayed in Customer Statement on checking Customer Statement are not more than transactions displayed in Customer Statement on checking Customer Statement(Open Transactions)");
				test.fail("Transactions displayed in Customer Statement on checking Customer Statement are not more than transactions displayed in Customer Statement on checking Customer Statement(Open Transactions)");
			}
					
			
		}
			
			
			
	

		if (testcase.equals("invoices within date range")) {
			Date uiMin = null, uiMax = null, baseMin, baseMax;
			form_date.clear();
			form_date.sendKeys(from_date1.trim());
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1.trim());
			Thread.sleep(2000);
			search_button.click();
			baseMin = new SimpleDateFormat("MM/dd/yyyy").parse(from_date1);
			baseMax = new SimpleDateFormat("MM/dd/yyyy").parse(to_date1);
			int n = invoices_date_range_dates.size();
			SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
			for (int i = 0; i < n; i++) {
				WebElement dateIndex = invoices_date_range_dates.get(i);
				if (i == 0) {
					String min1 = dateIndex.getText();
					uiMin = formatter1.parse(min1);
				}
				if (i == (n - 1)) {
					String max1 = dateIndex.getText();
					uiMax = formatter1.parse(max1);
				}
			}
			if (uiMin.after(baseMin) && uiMax.before(baseMax)) {
				System.out.println("Invoices are correctly displayed within the given date range");
				test.pass("Invoices are correctly displayed within the given date range");
			}
			else
			{
				System.out.println("Invoices are not displayed correctly within the given date range ");		
				test.fail("Invoices are not displayed correctly within the given date range ");
			}

		}
		if (testcase.equals("invoices of a particular customer")) {
			int count = 0;
			form_date.clear();
			form_date.sendKeys(from_date1);
			to_date.clear();
			to_date.sendKeys(to_date1);
			customer_name.sendKeys(customer_name1.trim());
			search_button.click();
			int size = invoices_with_customer_name.size();
			System.out.println("Number of customer invoices are" + " " + size);
			for (int i = 0; i < invoices_with_customer_name.size(); i++) {
				WebElement customer_index = invoices_with_customer_name.get(i);
				String customer_names = customer_name1.replace("  ", " ");
				if (customer_index.getText().contains(customer_names.trim())) {
					count = count + 1;
				}
			}
			if (count == invoices_with_customer_name.size()) {
				System.out.println("Invoices are displayed correctly for a given customer");
				test.pass("Invoices are displayed correctly for a given customer");
			}
			else
			{
				System.out.println("Invoices are not displayed correctly for a given customer");
				test.fail("Invoices are not displayed correctly for a given customer");
			}

		}
		if (testcase.equals("invoices related to particular department")) {
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(3000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(3000);
			department.sendKeys(department1.trim());
			search_button.click();
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			doc_nr.get(0).sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			if (department1.trim().equals(dept_in_invoice.getText())) {
				System.out.println("Invoices are displayed correctly for a given department");
				test.pass("Invoices are displayed correctly for a given department");
			}
			else
			{
				System.out.println("Invoices are not displayed correctly within the given department");
				test.fail("Invoices are not displayed correctly within the given department");
			}

		}
		if (testcase.equals("Invoices related to particular class")) {
			form_date.clear();
			classs.sendKeys(class1.trim());
			search_button.click();
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			doc_nr.get(0).sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			if (class1.trim().equals(class_in_invoice.getText())) {
				System.out.println("Invoices are displayed correctly for a given class");		
				test.pass("Invoices are displayed correctly for a given class");
				}
			else
			{
				System.out.println("Invoices are not displayed correctly for a given class");
				test.fail("Invoices are not displayed correctly for a given class");
			}

		}
		if (testcase.equals("Invoices related to particular location")) {
			
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(3000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(3000);
			location.sendKeys(location1.trim());
			search_button.click();
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			doc_nr.get(0).sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			if (location1.trim().equals(loc_in_invoice.getText())) {
				System.out.println("Invoices are displayed correctly for a given location");	
				test.pass("Invoices are displayed correctly for a given location");
				}
			else
			{
				System.out.println("Invoices are not displayed correctly for a given location");
				test.fail("Invoices are not displayed correctly for a given location");
			}

		}
		if (testcase.trim().equals("invoices within due date")) {
//			form_date.clear();
//			to_date.clear();
//			to_date.sendKeys(to_date1);
//			due_datee.sendKeys(due_date);
//			show_only_open_invoices.click();
//			search_button.click();
//			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
//			doc_nr.get(0).sendKeys(selectLinkOpeninNewTab);
//			windowHandle();
//			if (due_date.trim().equals(due_date_in_invoice.getText())) {
//				System.out.println("Invoices are displayed correctly within given duedate");	
//				test.pass("Invoices are displayed correctly within given duedate");
//				}
//			else
//			{
//				System.out.println("There is no invoice within that due date... please try with other due date (or) invoices are not displayed correctly within the given due date");
//				test.fail("There is no invoice within that due date... please try with other due date (or) invoices are not displayed correctly within the given due date");
//			}
			Date uiMin = null, uiMax = null, baseMin, baseMax,baseFrom;
			form_date.clear();
			form_date.sendKeys(from_date1);
			to_date.clear();
			to_date.sendKeys(to_date1);
			due_datee.sendKeys(due_date);
			show_only_open_invoices.click();
			search_button.click();
			int count=0;
			String due_date_to_test=due_datee.getText().trim();
			System.out.println("Due date from bei screen is: "+due_date_to_test);
			baseMin = new SimpleDateFormat("MM/dd/yyyy").parse(due_date);
			baseMax = new SimpleDateFormat("MM/dd/yyyy").parse(due_date);
			baseFrom=new SimpleDateFormat("MM/dd/yyyy").parse(from_date1);
			int n = invoices_date_range_dates.size();
			SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
			for (int i = 0; i < n; i++) {
				WebElement dateIndex = invoices_date_range_dates.get(i);
				if(dateIndex.getText().trim().equals(due_date.trim()))
				{
					count=count+1;
					System.out.println("The due dates that matches with given due date is: "+dateIndex.getText()+" "+count);
				}
				if (i == 0) {
					String min1 = dateIndex.getText();
					uiMin = formatter1.parse(min1);
				}
				if (i == (n - 1)) {
					String max1 = dateIndex.getText();
					uiMax = formatter1.parse(max1);
				}
			}
			
			if ((count>0&&uiMax.before(baseMax)&& uiMin.after(baseFrom)) || (uiMax.before(baseMax)&& uiMin.after(baseFrom))) {
				System.out.println("Invoices are displayed correctly within given duedate");	
				test.pass("Invoices are displayed correctly within given duedate");
			}
			else
			{
				System.out.println("There is no invoice within that due date... please try with other due date (or) invoices are not displayed correctly within the given due date");
				test.fail("There is no invoice within that due date... please try with other due date (or) invoices are not displayed correctly within the given due date");
			}
		}
		if (testcase.trim().equals("show only open invoices checkbox")) {
			if (driver.findElement(By.xpath("//span[@id='custpage_paidinfull_fs']")).getAttribute("class")
					.contains("checkbox_ck")) {
				System.out.println("open invoices is checked");
			} else {
				show_only_open_invoices.click();
				System.out.println("checked");
			}
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(2000);
			search_button.click();
			int count = 0;
			for (int i = 0; i < open_status.size(); i++) {
				WebElement open_index = open_status.get(i);
				if (open_index.getText().equals("Open")) {
					count = count + 1;
				}
				if (count == open_status.size()) {
					System.out.println("Invoices are displayed with Status Open only");
					test.pass("Invoices are displayed with Status Open only");
				}
			}
		}
		if (testcase.trim().equals("show only open invoices with credit memos")) {
			int open_invoice_count = 0;
			int credit_memos_count = 0;
			if (driver.findElement(By.xpath("//span[@id='custpage_showcreditmemos_fs']")).getAttribute("class")
					.contains("checkbox_unck")) {
				credit_memos.click();
			}
			form_date.clear();
			form_date.sendKeys(from_date1);
			to_date.clear();
			to_date.sendKeys(to_date1);
			search_button.click();
			for (int i = 0; i < tran_type.size(); i++) {
				WebElement tran_index = tran_type.get(i);
				if (tran_index.getText().equals("Invoice")) {
					open_invoice_count = open_invoice_count + 1;
				}
				if (tran_index.getText().equals("Credit Memo")) {
					credit_memos_count = credit_memos_count + 1;
				}
			}
			if (open_invoice_count > 0 && credit_memos_count > 0) {
				if(open_invoice_count+credit_memos_count==tran_type.size())
				{
				System.out.println("Invoices and credit memos are dislayed correctly by selecting show only open invoices with credit memos checkbox");
				test.pass("Invoices and credit memos are dislayed correctly by selecting show only open invoices with credit memos checkbox");
			}
			}
			else
			{
				System.out.println("Invoices and credit memos are not displayed correctly by selecting show only open invoices with credit memos checkbox");
				test.fail("Invoices and credit memos are not displayed correctly by selecting show only open invoices with credit memos checkbox");
			}

		}
		
		if (testcase.trim().equals("show emailed invoices")) {
			form_date.clear();
			if (driver.findElement(By.xpath("//span[@id='custpage_paidinfull_fs']")).getAttribute("class")
					.contains("checkbox_ck")) {
				show_only_open_invoices.click();
			}
			if (driver.findElement(By.xpath("//span[@id='custpage_resendemail_fs']")).getAttribute("class")
					.contains("checkbox_unck")) {
				show_emailed_invoices.click();
			}
			search_button.click();
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			doc_nr.get(0).sendKeys(selectLinkOpeninNewTab);
			windowHandle();
			bulk_email_invoices_tab.click();
			if (email_status_in_invoice.getText().equals("COMPLETED")) {
				System.out.println("Emailed invoices are displayed correctly by selecting show emailed invoices checkbox");
				test.pass("Emailed invoices are displayed correctly by selecting show emailed invoices checkbox");
			}
			else
			{
				System.out.println("Emailed invoices are not displayed correctly by selecting show emailed invoices checkbox");
				test.fail("Emailed invoices are not displayed correctly by selecting show emailed invoices checkbox");
			}
		}
		if(testcase.trim().equals("sending email without invoices"))
		{
			
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(1000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(1000);
			search_button.click();
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-800)", "");
			process_button.click();
			Thread.sleep(2000);
			if(isAlertPresent_()==true)
			{
			Alert alert=driver.switchTo().alert();
			confirm_message="Error message is "+alert.getText();
			System.out.println(confirm_message);
			test.pass(confirm_message);
			alert.accept();
			}
			else
			{
				System.out.println("Alert message is not displaying when we send email without invoices");
				test.fail("Alert message is not displaying when we send email without invoices");
			}
			
			
		}
		if(testcase.trim().equals("sending email without template"))
		{
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(2000);
			process_button.click();
			if(isAlertPresent_()==true)
			{
			Alert alert=driver.switchTo().alert();
			System.out.println("The error message is "+alert.getText());
			test.pass("The error message is "+alert.getText());
			alert.accept();
			}
			else
			{
				System.out.println("Alert message is not displaying when we send email without selecting template");
				test.fail("Alert message is not displaying when we send email without selecting template");
			}
			
		}
		if(testcase.trim().equals("sending multi attach email"))
		{
			String customer_url=null;
			String invoice_url=null;
			String doc_texttt=null;
			int count=0,count_empty=0;
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(2000);
			customer_name.sendKeys(customer_name1);
			Thread.sleep(2000);
			search_button.click();
			Thread.sleep(2000);
			email_template_input.sendKeys("Invoice Email Template");
			multi_attach.click();
			Thread.sleep(1000);
			unmark_all.click();
			for(int i=0;i<email_to.size();i++)
			{
				if(count==2)
				break;
				System.out.println(email_to.size());
				WebElement email_index=email_to.get(i);
				char c= email_index.getText().charAt(0);
				boolean empty_or_not= false;
				if(c ==' ')
				{
					empty_or_not = true;
				}
				if(empty_or_not)
				{
					count_empty=count_empty+1;
				}
				else
				{
					
					count=count+1;
					WebElement doc_text=doc_nr.get(i);
					doc_texttt=doc_text.getText();
					select_invoices.get(i).click();
				}

		}
			System.out.println("count is "+count);
			System.out.println("count_empty is "+count_empty);
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)");
			Thread.sleep(2000);
			process_button.click();
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='holdon-message']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@name='custpage_resendemail_send']//following-sibling::img")));
			show_emailed_invoices.click();
			search_button.click();
			for(int i=0;i<doc_nr.size();i++)
			{
				WebElement doc_index=doc_nr.get(i);
				if(doc_index.getText().equals(doc_texttt))
				{
					System.out.println("show only emailed invoices checkbox is verified");
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
					doc_index.sendKeys(selectLinkOpeninNewTab);		
					windowHandle();
					bulk_email_invoices_tab.click(); 
				String no_of_invoices=	no_of_invoices_in_invoice.getText();
				int invoices=Integer.parseInt(no_of_invoices);
				if(invoices>1)
				{
					System.out.println("Multi attach email funcitonality is working");
					test.pass("Multi attach email funcitonality is working");
				}
				else
				{
					System.out.println("Multi attach email functionality is not working");
					test.fail("Multi attach email functionality is not working");
				}
					
					
				}
			}
		}
		if(testcase.trim().equals("sending email to customer without email ids"))
		{
			String customer_url=null;
			String invoice_url=null;
			String doc_texttt=null;
			int count=0,count_empty=0;
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(2000);
			search_button.click();
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			for(int i=0;i<email_to.size();i++)
			{
				if(count_empty==1)
				break;
				System.out.println(email_to.size());
				WebElement email_index=email_to.get(i);
				char c= email_index.getText().charAt(0);
				boolean empty_or_not= false;
				if(c ==' ')
				{
					empty_or_not = true;
				}
				if(empty_or_not)
				{
					count_empty=count_empty+1;
					WebElement doc_text=doc_nr.get(i);
					doc_texttt=doc_text.getText();
					select_invoices.get(i).click();
				}
				else
				{
					count=count+1;
					
				}

		}
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 300);
			System.out.println("count is "+count);
			System.out.println("count_empty is "+count_empty);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)");
			wait.until(ExpectedConditions.visibilityOf(process_button));
			process_button.click();
			Thread.sleep(1000);
			if(isAlertPresent_()==true)
			{
			Alert alert=driver.switchTo().alert();
			System.out.println("Error message is "+alert.getText());
			test.pass("Error message is "+alert.getText());
			}
			else
			{
				System.out.println("Alert Message is not displaying when we are sending email without email id's");
				test.fail("Alert Message is not displaying when we are sending email without email id's");
			}
		}
		if(testcase.trim().equals("sending email to customer with invalid email ids"))
		{
			String customer_url=null;
			String invoice_url=null;
			String doc_texttt=null;
			int count=0,count_empty=0;
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(2000);
			search_button.click();
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			for(int i=0;i<email_to.size();i++)
			{
				if(count_empty==1)
				break;
				System.out.println(email_to.size());
				WebElement email_index=email_to.get(i);
				char c= email_index.getText().charAt(0);
				boolean empty_or_not= false;
				if(c ==' ')
				{
					empty_or_not = true;
				}
				if(empty_or_not)
				{
					count_empty=count_empty+1;
					WebElement doc_text=doc_nr.get(i);
					doc_texttt=doc_text.getText();
					select_invoices.get(i).click();
					email_to.get(i).sendKeys("sindhu@123");
					Thread.sleep(1000);
					if(isAlertPresent()==true)
					{
					Alert alert=driver.switchTo().alert();
					test.pass("The error message is: "+alert.getText());
					alert.accept();
					}				
				}
				else
				{
					count=count+1;
					
				}

		}
					
		}
//		if(testcase.trim().equals("sending invoice with customer statement"))
//		{
//			String customer_url=null;
//			String invoice_url=null;
//			String doc_texttt=null;
//			int count=0,count_empty=0;
//			form_date.clear();
//			form_date.sendKeys(from_date1);
//			Thread.sleep(2000);
//			to_date.clear();
//			to_date.sendKeys(to_date1);
//			Thread.sleep(2000);
//			search_button.click();
//			email_template_input.sendKeys("Invoice Email Template");
//			include_customer_statement_checkbox.click();
//			unmark_all.click();
//			for(int i=0;i<email_to.size();i++)
//			{
//				if(count==1)
//				break;
//				System.out.println(email_to.size());
//				WebElement email_index=email_to.get(i);
//				char c= email_index.getText().charAt(0);
//				boolean empty_or_not= false;
//				if(c ==' ')
//				{
//					empty_or_not = true;
//				}
//				if(empty_or_not)
//				{
//					count_empty=count_empty+1;
//				}
//				else
//				{
//					count=count+1;
//					WebElement doc_text=doc_nr.get(i);
//					doc_texttt=doc_text.getText();
//					select_invoices.get(i).click();
//				}
//
//		}
//			@SuppressWarnings("deprecation")
//			WebDriverWait wait = new WebDriverWait(driver, 300);
//			System.out.println("count is "+count);
//			System.out.println("count_empty is "+count_empty);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollTo(0,0)");
//			wait.until(ExpectedConditions.visibilityOf(process_button));
//			process_button.click();
//			isAlertPresent_();
//			if(isAlertPresent_()==true)
//			{
//				Alert alert=driver.switchTo().alert();
//				alert.accept();
//			}
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='holdon-message']")));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath("//input[@name='custpage_resendemail_send']//following-sibling::img")));
//			show_emailed_invoices.click();
//			search_button.click();
//			System.out.println("emailed invoices are: "+doc_nr.size());
//			String bulk_email_date[]=new String[2];
//			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//			String formatted = df.format(new Date());
//			System.out.println("Today's date is "+formatted);
//			for(int i=0;i<doc_nr.size();i++)
//			{
//				WebElement doc_index=doc_nr.get(i);
//				if(doc_index.getText().equals(doc_texttt))
//				{
//					doc_index.click();
//					windowHandle();
//					bulk_email_invoices_tab.click();
//					Thread.sleep(3000);
//					for(int j=0;j<bulk_email_send_date.size();j++)
//					{
//						WebElement bulk_index=bulk_email_send_date.get(j);
//						String bulk_text=bulk_index.getText();
//						bulk_email_date=bulk_text.split(" ");
//						System.out.println("The date array is "+bulk_email_date[j]);
//						if(bulk_email_date[0].equals(formatted.replace("/0", "/")))
//						{
//							WebElement customer_index=customer_statement.get(j);
//							if(customer_index.getText().equals("Yes"))
//							{
//								System.out.println("Customer statement is included");
//								test.pass("Customer statement is included");
//								break;
//							}
//							else
//							{
//								System.out.println("Customer statement is not included");
//								test.fail("Customer statement is not included");
//							}
//						}
//					}
//				}
//			}
//		}
		if(testcase.trim().equals("sending email with template"))
		{
			String customer_url=null;
			String invoice_url=null;
			String doc_texttt=null;
			int count=0,count_empty=0;
			int count_before=0;
			int count_after=0;
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(2000);
			search_button.click();
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			for(int i=0;i<email_to.size();i++)
			{
				if(count==1)
				break;
				System.out.println(email_to.size());
				WebElement email_index=email_to.get(i);
				char c= email_index.getText().charAt(0);
				boolean empty_or_not= false;
				if(c ==' ')
				{
					empty_or_not = true;
				}
				if(empty_or_not)
				{
					count_empty=count_empty+1;
				}
				else
				{
					count=count+1;
					String selectLinkOpeninNewTab1 = Keys.chord(Keys.CONTROL, Keys.ENTER);
					customer_link.get(i).sendKeys(selectLinkOpeninNewTab1);
					windowHandle();
					customer_url=driver.getCurrentUrl();
					driver.close();
					driver.switchTo().window(parentWindow);
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
					doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
					windowHandle();
					invoice_url=driver.getCurrentUrl();
					driver.close();
					driver.switchTo().window(parentWindow);
					WebElement doc_text=doc_nr.get(i);
					doc_texttt=doc_text.getText();
					select_invoices.get(i).click();
				}

		}
			System.out.println("count is "+count);
			System.out.println("count_empty is "+count_empty);
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)", "");
			Thread.sleep(2000);
			process_button.click();
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='holdon-message']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@name='custpage_resendemail_send']//following-sibling::img")));
			show_emailed_invoices.click();
			search_button.click();
			int count1=0;
			for(int i=0;i<doc_nr.size();i++)
			{
				WebElement doc_index=doc_nr.get(i);
				if(doc_index.getText().equals(doc_texttt))
				{
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
					doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
					windowHandle();
					bulk_email_invoices_tab.click();
					if (email_status_in_invoice.getText().equals("COMPLETED")) {
						System.out.println("Emailed invoices are displayed correctly by selecting show emailed invoices checkbox");
						ExtentTest test1=test.createNode("Show only Emailed invoice checkbox functionality testing");
						test1.pass("Emailed invoices are displayed correctly by selecting show emailed invoices checkbox");
					}
					System.out.println("Sending email with selecting template is working");
					ExtentTest test2=test.createNode("Sending email with selecting template testing");
					test2.pass("Sending email with selecting template is working");
					break;
				}
				else
				{
					count1=count1+1;
				if(count1==doc_nr.size())
					{
					System.out.println(confirm_not);
					test.fail("Emailed invoice is not displayed");
					}
				}
			}

		}
		if(testcase.trim().equals("resending email"))
		{
			String customer_url=null;
			String invoice_url=null;
			String doc_texttt=null;
			int count=0,count_empty=0;
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(2000);
			show_emailed_invoices.click();
			search_button.click();
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			int count_before=0;
			int count_after=0;
			for(int i=0;i<email_to.size();i++)
			{
				if(count==1)
				break;
				System.out.println(email_to.size());
				WebElement email_index=email_to.get(i);
				char c= email_index.getText().charAt(0);
				boolean empty_or_not= false;
				if(c ==' ')
				{
					empty_or_not = true;
				}
				if(empty_or_not)
				{
					count_empty=count_empty+1;
				}
				else
				{
					count=count+1;
					WebElement doc_text=doc_nr.get(i);
					doc_texttt=doc_text.getText();
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
					doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);	
					windowHandle();
					invoice_url=driver.getCurrentUrl();
					bulk_email_invoices_tab.click();
					System.out.println("The count of emails before resending is "+total_email_rows_in_bei_tab.size());
					test.pass("The count of emails before resending is "+total_email_rows_in_bei_tab.size());
					for(int j=0;j<total_email_rows_in_bei_tab.size();j++)
					{
						 count_before = total_email_rows_in_bei_tab.size();
					}
					driver.switchTo().window(parentWindow);
					select_invoices.get(i).click();
				}

		}
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 300);
			System.out.println("count is "+count);
			System.out.println("count_empty is "+count_empty);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)");
			wait.until(ExpectedConditions.visibilityOf(process_button));
			process_button.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='holdon-message']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@name='custpage_resendemail_send']//following-sibling::img")));
			driver.navigate().to(invoice_url);
			bulk_email_invoices_tab.click();
			count_after=total_email_rows_in_bei_tab.size();
			System.out.println("The count of email's after resending email is "+count_after);
			test.pass("The count of email's after resending email is "+count_after);
			if(count_after>count_before)
			{
				System.out.println("Resend email is working");
				test.pass("Resend email is working");
			}
			else
			{
				System.out.println("Resend Email is not working");
				test.fail("Resend Email is not working");
			}
		}
		if(testcase.trim().equals("one invoice to multiple email ids"))
		{
			String customer_url=null;
			String invoice_url=null;
			String doc_texttt=null;
			int count=0,count_empty=0;
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(2000);
			search_button.click();
			Thread.sleep(3000);
			email_template_input.sendKeys("Invoice Email Template");
			unmark_all.click();
			for(int i=0;i<email_to.size();i++)
			{
				if(count_empty==1)
				break;
				System.out.println(email_to.size());
				WebElement email_index=email_to.get(i);
				char c= email_index.getText().charAt(0);
				boolean empty_or_not= false;
				if(c ==' ')
				{
					empty_or_not = true;
				}
				if(empty_or_not)
				{
					count_empty=count_empty+1;
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
					customer_link.get(i).sendKeys(selectLinkOpeninNewTab);		
					windowHandle();
					customer_url=driver.getCurrentUrl();
					driver.close();
					driver.switchTo().window(parentWindow);
					select_invoices.get(i).click();
					email_to.get(i).sendKeys(email_ids);
				}
				else
				{
					count=count+1;
					
				}
			}
			System.out.println("count is "+count);
			System.out.println("count_empty is "+count_empty);
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-800)", "");
			Thread.sleep(2000);
			process_button.click();
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='holdon-message']")));
			driver.navigate().to(customer_url);
			windowHandle();
			communication_tab.click();
			String replacing=email_ids.replace(",","; ");
			String emailids_in_customer=email_ids_in_customer_record.getText();
			System.out.println("email id's after replacing "+replacing );
			System.out.println("email id's in customer record "+emailids_in_customer );
			if(replacing.equals(emailids_in_customer))
			{
				System.out.println("email details are displayed in customer record communication tab");
				System.out.println("one invoice is sent to multiple id's");
				test.pass("One invoice is sent to Multiple email id's");
			}
			else
			{
				System.out.println("One invoice is not sent to multiple email id's");
				test.fail("One invoice is not sent to multiple email id's");
			}
			
			
			
		}
		if (testcase.trim().equals("show excluded invoices")) {
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			to_date.clear();
			to_date.sendKeys(to_date1);
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("//span[@id='custpage_paidinfull_fs']")).getAttribute("class")
					.contains("checkbox_ck")) 
			{
				show_only_open_invoices.click();
			}
			Thread.sleep(3000);
			search_button.click();
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 200);
//			wait.until(ExpectedConditions.visibilityOf(unmark_all));
//			Actions action=new Actions(driver);
//			action.moveToElement(unmark_all).build().perform();
			unmark_all.click();
			Thread.sleep(1000);
			select_invoices.get(0).click();
			WebElement excluded_invoice = doc_nr.get(0);
			String excluded_invoice_text = excluded_invoice.getText();
			System.out.println("Excluded invoice is " + excluded_invoice_text);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-350)", "");
			exclue_selected_invoices_checkbox.click();
			process_button.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='holdon-message']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@name='custpage_excludeemail_send']//following-sibling::img")));
		//	search_button.click();
//			int doc_count=0;
//			for(int j = 0; j<doc_nr.size(); j++)
//			{
//				WebElement excluded_invoice1 = doc_nr.get(j);
//				String excluded_invoice_text1 = excluded_invoice1.getText();
//				if (excluded_invoice_text.equals(excluded_invoice_text1))
//				{
//					doc_count=doc_count+1;
//				}
//			}
//			if(doc_count==doc_nr.size())
//			{
//				System.out.println("Excluded invoices is not displaying in the invoice list");
//			}
			show_excluded_invoices.click();
			search_button.click();
			Thread.sleep(3000);
			unmark_all.click();
			System.out.println("The size of docs are "+doc_nr.size());
			int count2=0;
			for(int i = 0; i<doc_nr.size(); i++)
			{
				WebElement excluded_invoice1 = doc_nr.get(i);
				String excluded_invoice_text1 = excluded_invoice1.getText();
				if (excluded_invoice_text.equals(excluded_invoice_text1))
				{
					System.out.println("Excluded invoice after checking show excluded invoices checkbox "
							+excluded_invoice_text1);
					test.pass("Excluded invoice after checking show excluded invoices checkbox "
							+excluded_invoice_text1);
					System.out.println("Exluded invoice checkbox is working");
					test.pass("Exluded invoice checkbox is working");
					break;
				}
				else
				{
					count2=count2+1;
					if(count2==doc_nr.size())
					{
					
					System.out.println("Exclude invoice checkbox is not working");
					test.fail("Exclude invoice checkbox is not working");
					}
				}
			}

		}

	}
	public boolean isAlertPresent_() {
		try {
			Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
			if (a != null) {
				System.out.println("Alert is present");
				return true;
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			System.err.println("Alert isn't present!!");
			return false;
		}

	}
	public boolean isAlertPresent() throws InterruptedException
	{
		
		Actions action=new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		if(isAlertPresent_()==true)
		{
		return true;
		}
		else
		{
			
			return false;
		}
	}
	
	public void verify_date_validations(ExtentTest test,String alert_text)
	{
	
		test.pass(alert_text);
	}
	public void date_validations(String alphabets,String numbers,String special_chars,String alpha_numerics,String alpha_special_chars,String numbers_special_chars,String testcase,String to_date_less_than_three_digits,String to_date_greater_than_two_digits,ExtentTest test) throws InterruptedException
	{
		String alert_message=null;
		String alert_not_messagee=null;
		Actions action=new Actions(driver);
		if(testcase.trim().equals("form date validation"))
		{
		form_date.clear();
		Thread.sleep(2000);
		to_date.clear();
		Thread.sleep(2000);
		search_button.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			test.pass("Date entered is "+alphabets+": "+alert.getText());
			alert.accept();
		}
		else
		{
			test.fail("Alert is not displaying");
		}
		Thread.sleep(5000);
		form_date.clear();
		form_date.sendKeys(alphabets);
		if(isAlertPresent()==true)
		{
		Alert alert=driver.switchTo().alert();
		test.pass("Date entered is "+numbers+": "+alert.getText());
		alert.accept();
		}
		Thread.sleep(7000);
		form_date.clear();
		form_date.sendKeys(special_chars);
		if(isAlertPresent()==true)
		{
		Alert alert=driver.switchTo().alert();
		test.pass("Date entered is "+special_chars+": "+alert.getText());
		alert.accept();
		}
		Thread.sleep(7000);
		form_date.clear();
		form_date.sendKeys(alpha_numerics);
		if(isAlertPresent()==true)
		{
		Alert alert=driver.switchTo().alert();
		test.pass("Date entered is "+alpha_numerics+": "+alert.getText());
		alert.accept();
		}
		Thread.sleep(7000);
		form_date.clear();
		form_date.sendKeys(alpha_special_chars);
		if(isAlertPresent()==true)
		{
		Alert alert=driver.switchTo().alert();
		test.pass("Date entered is "+alpha_special_chars+": "+alert.getText());
		alert.accept();
		}
		Thread.sleep(7000);
		form_date.clear();
		form_date.sendKeys(numbers_special_chars);
		if(isAlertPresent()==true)
		{
		Alert alert=driver.switchTo().alert();
		test.pass("Date entered is "+numbers_special_chars+": "+alert.getText());
		alert.accept();
		}
		Thread.sleep(7000);
		form_date.clear();
		form_date.sendKeys(to_date_less_than_three_digits);
		if(isAlertPresent()==true)
		{
		Alert alert=driver.switchTo().alert();
		test.pass("Date entered is "+to_date_less_than_three_digits+": "+alert.getText());
		alert.accept();
		}
		form_date.clear();
		Thread.sleep(7000);
		form_date.sendKeys(to_date_greater_than_two_digits);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		System.out.println("system is taking some other date: " +form_date.getText());
		test.pass("Date entered is: "+to_date_greater_than_two_digits+": System is taking some other date");

		
	}
		if(testcase.trim().equals("to date validation"))
		{
			to_date.clear();
			to_date.sendKeys(alphabets);
			if(isAlertPresent()==true)
			{
			Alert alert=driver.switchTo().alert();
			test.pass("Date entered is "+alphabets+": "+alert.getText());
			alert.accept();
			}			
			Thread.sleep(7000);
			to_date.clear();
			to_date.sendKeys(special_chars);
			if(isAlertPresent()==true)
			{
			Alert alert=driver.switchTo().alert();
			test.pass("Date entered is "+special_chars+": "+alert.getText());
			alert.accept();
			}
			Thread.sleep(7000);
			to_date.clear();
			to_date.sendKeys(alpha_numerics);
			if(isAlertPresent()==true)
			{
			Alert alert=driver.switchTo().alert();
			test.pass("Date entered is "+alpha_numerics+": "+alert.getText());
			alert.accept();
			}
			Thread.sleep(7000);
			to_date.clear();
			to_date.sendKeys(alpha_special_chars);
			if(isAlertPresent()==true)
			{
			Alert alert=driver.switchTo().alert();
			test.pass("Date entered is "+alpha_special_chars+": "+alert.getText());
			alert.accept();
			}
			Thread.sleep(7000);
			to_date.clear();
			to_date.sendKeys(numbers_special_chars);
			if(isAlertPresent()==true)
			{
			Alert alert=driver.switchTo().alert();
			test.pass("Date entered is "+numbers_special_chars+": "+alert.getText());
			alert.accept();
			}
			Thread.sleep(7000);
			to_date.clear();
			to_date.sendKeys(to_date_less_than_three_digits);
			if(isAlertPresent()==true)
			{
			Alert alert=driver.switchTo().alert();
			test.pass("Date entered is "+to_date_less_than_three_digits+": "+alert.getText());
			alert.accept();
			}
			to_date.clear();
			Thread.sleep(7000);
			to_date.sendKeys(to_date_greater_than_two_digits);
			action.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(1000);
			alert_message="System is taking some other date";
			System.out.println("system is taking some other date");
			test.pass("Date entered is "+to_date_greater_than_two_digits+": "+alert_message);
		
		}

}
	public void two_filters(String customer_name1,String subsidiary1,String department1,String class1,String location1,String from_date1,String to_date1,String testcase,String due_date,ExtentTest test) throws Exception
	{
	
		Actions action =new Actions(driver);
		if(testcase.trim().equals("from date greater than to date"))
		{
			to_date.clear();
			to_date.sendKeys(to_date1.trim());
			Thread.sleep(2000);
			form_date.clear();
			form_date.sendKeys(from_date1);
			Thread.sleep(2000);
			action.sendKeys(Keys.TAB).build().perform();
			if(isAlertPresent_()==true)
			{
			Alert alert=driver.switchTo().alert();
			confirm_message="The error message is "+alert.getText();
			test.pass("The error message is "+alert.getText());
			System.out.println("The error message is "+alert.getText());
			}
			else
			{
				System.out.println("Alert is not displaying");
				test.fail("Alert message is not displaying");
			}
		}
		else
		{
		form_date.clear();
		form_date.sendKeys(from_date1);
		Thread.sleep(2000);
		to_date.clear();
		to_date.sendKeys(to_date1);
		Thread.sleep(2000);
		if(testcase.trim().equals("due date greater than from and to date"))
		{ 
			due_datee.clear();
			due_datee.sendKeys(due_date);
			if(isAlertPresent()==true)
			{
			Alert alert=driver.switchTo().alert();
			test.pass("The error message is:"+alert.getText());
			alert.accept();
			}
		}
		else
		{
		customer_name.sendKeys(customer_name1);
		department.sendKeys(department1);
		Thread.sleep(1000);
		location.sendKeys(location1);
		search_button.click();
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		doc_nr.get(0).sendKeys(selectLinkOpeninNewTab);
		windowHandle();
		String customer_text=customer_name_in_invoice.getText();
		String dept_text=dept_in_invoice.getText();
		String class_text=class_in_invoice.getText();
		String loc_text=loc_in_invoice.getText();
		driver.switchTo().window(parentWindow);
		if(testcase.trim().equals("Invoices with customername and department"))
		{
		if((customer_text.equals(customer_name1))&&(dept_text.equals(department1)))
				{
					confirm_message="Invoices are displayed for same customer and department";
					System.out.println("Invoices are displayed for same customer and department");
					test.pass(confirm_message);
				}
		else
		{
			confirm_not="Invoices are not displayed for same customer and department";
			System.out.println(confirm_not);
			test.fail(confirm_not);
		}
		}
		if(testcase.trim().equals("Invoices with customername and class"))
		{
			if((customer_text.equals(customer_name1))&&(class_text.equals(class1)))
					{
						confirm_message="Invoices are displayed for same customer and class";
						System.out.println("Invoices are displayed for same customer and class");
						test.pass(confirm_message);
					}
			else
			{
				confirm_not="Invoices are displayed for same customer and class";
				System.out.println(confirm_not);
				test.fail(confirm_not);
			}
		}
		if(testcase.trim().equals("invoices with customername and location"))
		{
			if((customer_text.equals(customer_name1))&&(loc_text.equals(location1)))
					{
						confirm_message="Invoices are displayed for given customer and location";
						System.out.println("Invoices are displayed for same customer and location");
						test.pass(confirm_message);
					}
			else
			{
				confirm_not="Invoices are not displayed for given customer and location";
				System.out.println(confirm_not);
				test.fail(confirm_not);
			}
		}
		if(testcase.trim().equals("invoices with multiple filters"))
		{
			if((customer_text.equals(customer_name1)&&(dept_text.equals(department1))&&(class_text.equals(class1))&&(loc_text.equals(location1))))
					{
						confirm_message="Invoices are displayed with multiple filters";
						System.out.println("Invoices are displayed with multiple filters");
						test.pass(confirm_message);
						
					}
			else
			{
				confirm_not="Invoices are not displayed with multiple filters";
				System.out.println(confirm_not);
				test.fail(confirm_not);
			}
		}
		if(testcase.trim().equals("unmark all functionality testing"))
		{
			int unmark_all_count=0;
			unmark_all.click();
		for(int i=0;i<select_checkbox_checking.size();i++)
		{
			WebElement select_index=select_checkbox_checking.get(i);
			if(select_index.getAttribute("class").contains("checkbox_unck"))
			{
				unmark_all_count=unmark_all_count+1;
			}

		}
		System.out.println("unmark all count is " +unmark_all_count);
		System.out.println("size of checkboxes "+select_checkbox_checking.size());
		if(unmark_all_count==select_checkbox_checking.size())
		{
			confirm_message="Unmark all functionality is working";
			System.out.println("unmark all is working");
			test.pass(confirm_message);
		}
		else
		{
			confirm_not="Unmark all functionality is not working";
			test.fail(confirm_not);
		}
		
		}
		if(testcase.trim().equals("mark all functionality testing"))
		{
			int mark_all_count=0;     
			mark_all.click();
			for(int i=0;i<select_checkbox_checking.size();i++)
			{
				WebElement select_index=select_checkbox_checking.get(i);
				if(select_index.getAttribute("class").contains("checkbox_ck"))   
				{
					mark_all_count=mark_all_count+1;
				}
			}
			System.out.println("unmark all count is " +mark_all_count);
			System.out.println("size of checkboxes "+select_checkbox_checking.size());
			if(mark_all_count==select_checkbox_checking.size())
			{
				confirm_message="Mark all functionality is working";
				System.out.println("mark all is working");
				test.pass(confirm_message);
			}
			else
			{
				confirm_not="Mark all functionality is not working";
				System.out.println(confirm_not);
				test.fail(confirm_not);
			}
			
		}
		
		}
		}
	}
	public void consolidate_invoices(ExtentTest test) throws InterruptedException
	{
		String invoices=null;
		String customer=null;
		int invoices_count=0;
		String invoice_number_final=null;
		@SuppressWarnings("deprecation")
		WebDriverWait wait=new WebDriverWait(driver,30);
		required_account("Administrator", "Tvarana Dev Test", "PRODUCTION");
		Thread.sleep(5000);
		navigate_to_consolidate_customer_invoice();
		for(int i=0;i<consolidate_invoice_checkbox.size();i++)
		{
			if(i==1)
			break;
			consolidate_invoice_checkbox.get(i).click();
			WebElement no_of_invoices=consolidate_no_invoices.get(i);
			invoices=no_of_invoices.getText();
			invoices_count=Integer.parseInt(invoices);
			WebElement customer_name=consolidate_customer.get(i);
			 customer=customer_name.getText();
			Thread.sleep(5000);
			submit_consolidate.click();
			wait.until(ExpectedConditions.visibilityOf(consolidate_link));
			consolidate_link.click();
		}
		System.out.println("customer is "+customer);
		System.out.println("invoice count is "+invoices_count);
		test.pass("Invoice count is: "+invoices_count);
		String invoice_split[]=new String[invoices_count];
		Thread.sleep(3000);
		consolidate_arrow.click();
		for(int j=0;j<consolidate_dropdown.size();j++)
			{
				WebElement recently=consolidate_dropdown.get(j);
				if(recently.getText().trim().equals("Recently Created"))
				{
					recently.click();
					break;
				}
			}
			Thread.sleep(5000);
			driver.navigate().refresh();
			for(int i=0;i<consolidate_invoice_after.size();i++)
			{
				if(i==1)
					break;
				WebElement customer_af=consolidate_customer_after.get(i);
				WebElement invoice_af=consolidate_invoice_after.get(i);
				if(i==0)
				{
					if(invoices_count==1)
					{
						invoice_number_final=invoice_af.getText().replace("CustInvc-", "").trim();
						System.out.println("one invoice final is "+invoice_number_final);
						test.pass("Invoice is: "+invoice_number_final);
						break;
					}
					if(invoices_count>1)
					{
						invoice_number_final=invoice_af.getText().replace("CustInvc-", "").trim();
						for(int j=0;j<invoice_split.length;j++)
						{
						invoice_split=invoice_number_final.split(",");						
						}
						for(int j=0;j<invoice_split.length;j++)
						{
							System.out.println("Multiple final invoices are "+invoice_split[j]);
							test.pass("invoice "+j+" is "+invoice_split[j]);
						}
					
					}
					
				}
				
			}
			required_account("BEI-AR", "Tvarana Dev Test", "PRODUCTION");
			authPage=new AuthPageNavigation();
			authPage.navigatetoBEI();
			customer_name.sendKeys(customer);
			form_date.clear();
			form_date.sendKeys("10/12/2017");
			to_date.clear();
			to_date.sendKeys("11/12/2020");
			search_button.click();
			int count4=0;
			if(invoices_count==1)
			{
			for(int i=0;i<doc_nr.size();i++)
			{
				WebElement invoicess=doc_nr.get(i);
				if(!invoice_number_final.equals(invoicess.getText()))
				{
					count4=count4+1;
				}
			}
			if(count4==doc_nr.size())
			{
				System.out.println("consolidated invoices are not displaying");
				test.pass("Consolidated invoices are not displaying");

			}
			}
			int count3=0;
			int final_count=0;
			if(invoices_count>1)
			{
				for(int i=0;i<invoice_split.length;i++)
				{
					count3=0;
					for(int j=0;j<doc_nr.size();j++)
					{
						WebElement invoicess=doc_nr.get(j);
						if(!invoice_split[i].equals(invoicess.getText()))
						{
							count3=count3+1;
						}
					}
					if(count3==doc_nr.size())
					{
						final_count=final_count+1;
						System.out.println("Final count is: "+final_count);
					}
				}
				if(final_count==invoices_count)
				{
					System.out.println("consolidated invoices are not displaying");
					test.pass("Consolidated invoices are not displaying");
				}
				
				}
				
			}
	
	public void highest_dates(String from_date1,String to_date1,String testcase,ExtentTest test) throws InterruptedException     
	{
		form_date.clear();
		form_date.sendKeys(from_date1);
		Thread.sleep(2000);
		to_date.clear();
		to_date.sendKeys(to_date1);
		Thread.sleep(2000);
		if(testcase.trim().equals("Invalid Email Template"))
		{
			search_button.click();
			email_template_input.sendKeys("Checkout Errors 10/15/18 11:44:20 PM");
			unmark_all.click();
			select_invoices.get(0).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)", ""); 
			Thread.sleep(3000);
			process_button.click();
			if(isAlertPresent_()==true)
			{
			Alert alert=driver.switchTo().alert();
			confirm_message=alert.getText();
			System.out.println("The error message is "+confirm_message);
			test.pass("The error message is "+confirm_message);
			alert.accept();
			}
			else
			{
				confirm_not="Alert message is not displaying when we select invalid email template";
				System.out.println(confirm_not);
				test.fail(confirm_not);
			}
		}
		if(testcase.trim().equals("Month value greater than 13"))
		{
		customer_name.click();
		to_date.click(); 
		String tdate_text=to_date.getAttribute("value");
		System.out.println("to date is " +tdate_text);
		String fdate_text=form_date.getAttribute("value");
		System.out.println("from date is " +fdate_text);
		String [] highest_from_month=fdate_text.split("/");
		for(int i=0;i<highest_from_month.length;i++)
		{
			System.out.println("dates are after splitting "+highest_from_month[i]);
		}
		String [] highest_to_month=tdate_text.split("/");
		for(int j=0;j<highest_to_month.length;j++)
		{
			System.out.println("dates after splitting "+highest_to_month[j]);
		}
		if((highest_from_month[0].equals("12"))&&(highest_to_month[0].equals("12")))
		{
			confirm_message="Month value is taking as highest month value when we give month value greater than 12";
			System.out.println("Month value is taking as highest month value when we give month value greater than 12");
			test.pass(confirm_message);
		}
		else
		{
			confirm_not="Month value is not taking as highest month value when we give month value greater than 12";
			System.out.println(confirm_not);
			test.fail(confirm_not);
		}
		}
	
	}
	public void navigate_to_config(String days_before_due_date,String days_after_due_date,String testcase,ExtentTest test) throws InterruptedException, ParseException
	{
		String [] bulk_email_date=new String[2];
		int before_date=Integer.parseInt(days_before_due_date);
		int after_date=Integer.parseInt(days_after_due_date);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String formatted = df.format(new Date());
		System.out.println("Todays date is "+formatted);
		String dt = "2008-01-01";  // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(formatted)); 
		if(testcase.trim().equals("sending auto email before due date")||(testcase.trim().equals("sending email to partially paid invoices")))
		{
		c.add(Calendar.DATE, before_date);  // number of days to add
		dt = sdf.format(c.getTime()); 
		System.out.println("tomorrow's date is "+dt);
		}
		String dt1 = "2008-01-01";  // Start date
		c.setTime(sdf.parse(formatted)); 
		if(testcase.trim().equals("sending auto email after due date"))
		{
		c.add(Calendar.DATE, -(after_date));  // number of days to add
		dt1 = sdf.format(c.getTime()); 
		System.out.println("Yesterday's date is :"+dt1 );
		}
		@SuppressWarnings("deprecation")
		WebDriverWait wait=new WebDriverWait(driver, 20);
		Actions action=new Actions(driver);
		required_account("Administrator", "Tvarana Dev Test", "PRODUCTION");
		Thread.sleep(5000);
		if(testcase.trim().equals("sending email to partially paid invoices"))
		{
		wait.until(ExpectedConditions.visibilityOf(setup));
		action.moveToElement(setup).build().perform();
		Thread.sleep(2000);
		if(arrow.isDisplayed())
		action.moveToElement(arrow).build().perform();
		Thread.sleep(4000);
		action.moveToElement(bulk_email_invoice).build().perform();
		Thread.sleep(2000);
		action.moveToElement(configuration_page).build().perform();
		configuration_page.click();
		before_email_arrow.click();
		dropdown_email_after_before.get(0).click();
		submit_config.click();
		Alert alert=driver.switchTo().alert();
		System.out.println("The error is "+alert.getText());
		ExtentTest test1=test.createNode("sending emails to customer after the due date without selecting email template");
		test1.pass("The error is "+alert.getText());
		alert.accept();
		after_email_arrow.click();
		dropdown_email_after_before.get(0).click();
		submit_config.click();
		driver.switchTo().alert();
		System.out.println("The error message is "+alert.getText());
		ExtentTest test2=test.createNode("sending emails to customer before the due date without selecting email template");
		test2.pass("The error is "+alert.getText());
		alert.accept();	
		no_of_days_after_due_date.clear();
		no_of_days_after_due_date.sendKeys("1");
		before_email_arrow.click();
		for(WebElement template :dropdown_email_after_before)
		{
			if(template.getText().trim().equals("Invoice Email Template"))
					{
						template.click();
						break;
					}
		}
		Thread.sleep(7000);
		if(after_email_arrow.isDisplayed())
		after_email_arrow.click();
		for(WebElement template :dropdown_email_after_before)
		{
			if(template.getText().trim().equals("CI Dunning - Level 1"))
					{
						template.click();
						break;
					}
		}
		
		submit_config.click();
		}
		String invoice_url=null;
		String partial_url=null;
		if(testcase.trim().equals("sending email to partially paid invoices"))
		{
			driver.navigate().to("https://tstdrv939178.app.netsuite.com/app/common/search/searchresults.nl?searchid=884&saverun=T&whence=");
			for(int i=0;i<partially_paid_invoices.size();i++)
			{
				WebElement open_invoices=partially_paid_invoices.get(i);
				open_invoices.click();
				partial_url=driver.getCurrentUrl();
				break;
			}
			edit_invoice.click();
			due_date_in_invoice_record.clear();
			due_date_in_invoice_record.sendKeys(dt);
			Thread.sleep(5000);
			save_invoice.click();
			@SuppressWarnings("deprecation")
			WebDriverWait wait4=new WebDriverWait(driver,50);
			wait4.until(ExpectedConditions.visibilityOf(amount_due));
			String amountTopay=amount_due.getText().replace(",", "");
			System.out.println("amount is "+amountTopay);
			double j=Double.parseDouble(amountTopay);
			Thread.sleep(3000);
			String ref_no_inv=reference_no_in_invoice.getText().trim();
			System.out.println("reference no in invoice "+ref_no_inv);
			wait4.until(ExpectedConditions.visibilityOf(accept_payment));
			accept_payment.click();
			for(int i=0;i<ref_no_in_payment.size();i++)
			{
				WebElement ref=ref_no_in_payment.get(i);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true);",ref);
				if(ref.getText().trim().equals(ref_no_inv))
				{	
					if (j > 101.00) {
						j = j - 100.00;
						payment_amount_click.get(i).click();
						Thread.sleep(3000);
						payment_amount.get(i).clear();
						Thread.sleep(2000);
						payment_amount.get(i).sendKeys(Double.toString(j));
						Thread.sleep(2000);
						wait.until(ExpectedConditions.visibilityOf(payment_save));
						break;
						
					}
					 if (j <= 100 && j > 10) {
						j = j - 10.00;
						payment_amount_click.get(i).click();
						Thread.sleep(3000);
						payment_amount.get(i).clear();
						Thread.sleep(2000);
						payment_amount.get(i).sendKeys(Double.toString(j));
						Thread.sleep(2000);
						wait.until(ExpectedConditions.visibilityOf(payment_save));
						break;

					}
					 if(j <= 10 && j > 2) {
						j = j - 1;
						payment_amount_click.get(i).click();
						Thread.sleep(3000);
						payment_amount.get(i).clear();
						Thread.sleep(2000);
						payment_amount.get(i).sendKeys(Double.toString(j));
						Thread.sleep(2000);
						wait.until(ExpectedConditions.visibilityOf(payment_save));
						break;

					}
				
				}	
				
			}
			payment_save.click();
			Thread.sleep(5000);
			driver.navigate().to("https://tstdrv939178.app.netsuite.com/app/common/scripting/scriptrecord.nl?id=3690");
			script_edit.click();
			action.moveToElement(edit_expand).build().perform();
			save_and_execute.click();
			if(isAlertPresent_()==true)
			{
				Alert alert1=driver.switchTo().alert();
				alert1.accept();
			}
			Thread.sleep(5000);
			for(int i=0;i<10;i++) 
			{
			driver.navigate().refresh();
			}
			if(testcase.trim().equals("sending email to partially paid invoices"))
			{
				driver.navigate().to(partial_url);
			}
			driver.findElement(By.xpath("//td[@id='custom502lnk']")).click();
			String auto_email_senddate=driver.findElement(By.xpath("//span[@id='custbody_tss_bei_sent_date_fs_lbl_uir_label']//following-sibling::span")).getText();
			if(auto_email_senddate.trim().equals(""))
			{
				confirm_message="Auto Email is not sent to partially paid invoices";
				System.out.println("Auto Email is not sent to partially paid invoices");
				test.pass(confirm_message);
			}
			else
			{
				confirm_not="Auto Email is sent to partially paid invoices so test case is failed";
				test.fail(confirm_message);
			}
			
			
		}
		else
		{
		action.moveToElement(Transactions).build().perform();
		Thread.sleep(2000);
		action.moveToElement(sales).build().perform();
		Thread.sleep(2000);
		action.moveToElement(create_invoices).build().perform();
		Thread.sleep(7000);
		invoice_list.click();
		recently_arrow.click();
		for(int i=0;i<recenty_drop.size();i++)
		{
			WebElement drop_index=recenty_drop.get(i);
			if(drop_index.getText().equals("Recently Created"))
			{
				drop_index.click();
				break;
			}
		}
		Thread.sleep(6000);
		if (driver.findElement(By.xpath("//span[@class='ns-icon ns-filters-onoff-button']")).getAttribute("aria-expanded")
				.contains("false"))
		{
			driver.findElement(By.xpath("//span[@class='ns-icon ns-filters-onoff-button']")).click();
			driver.findElement(By.xpath("//img[@id='inpt_Transaction_LISTSTATUS3_arrow']")).click();
			List<WebElement> drop_down=driver.findElements(By.xpath("//div[@class='dropdownDiv']//div"));
		
			for(int i=0;i<drop_down.size();i++)
			{
			
			WebElement drop_index=drop_down.get(i);
			if(drop_index.getText().equals("Open"))
			{
				drop_index.click();
				break;
			}
			}
			
		}
		Thread.sleep(7000);
		for(int i=1;i<=status_in_invoice_list.size();i++)
		{
			WebElement status_index=status_in_invoice_list.get(i);
			String status=status_index.getText();
			if(status_index.getText().equals("Open"))
			{
				if(testcase.trim().equals("sending auto email before due date"))
				{
				view_in_invoice_list.get(i-1).click();
				break;
				}
				if(testcase.trim().equals("sending auto email after due date"))
				{
					view_in_invoice_list.get(i).click();
					break;
				}
				
			}
		}
		 invoice_url=driver.getCurrentUrl();
		edit_invoice.click();
		due_date_in_invoice_record.clear();
		if(testcase.trim().equals("sending auto email before due date"))
		{
		due_date_in_invoice_record.sendKeys(dt);
		Thread.sleep(5000);
		}
		if(testcase.trim().equals("sending auto email after due date"))
		{
			due_date_in_invoice_record.sendKeys(dt1);
			Thread.sleep(2000);
		}
		
		
		save_invoice.click();
		if(isAlertPresent_()==true)
		{
			Alert alert2=driver.switchTo().alert();
			alert2.accept();
		}
		@SuppressWarnings("deprecation")
		WebDriverWait wait2=new WebDriverWait(driver,100);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@id='tdbody_acceptpayment']")));
	
		driver.navigate().to("https://tstdrv939178.app.netsuite.com/app/common/scripting/scriptrecord.nl?id=3690");
		script_edit.click();
		action.moveToElement(edit_expand).build().perform();
		save_and_execute.click();
		if(isAlertPresent_()==true)
		{
			Alert alert3=driver.switchTo().alert();
			alert3.accept();
		}
		Thread.sleep(5000);
		for(int i=0;i<10;i++) 
		{
		driver.navigate().refresh();
		}
		
		driver.navigate().to(invoice_url);
		
		driver.findElement(By.xpath("//td[@id='custom502lnk']")).click();
		String auto_email_senddate=driver.findElement(By.xpath("//span[@id='custbody_tss_bei_sent_date_fs_lbl_uir_label']//following-sibling::span")).getText();
		if(auto_email_senddate.equals(formatted.replace("/0", "/")))
		{
			confirm_message="The auto email is sent successfully ";
			System.out.println("The auto email is sent successfully");
			test.pass(confirm_message);
		}
		if(auto_email_senddate.trim().equals(""))
		{
			confirm_not="Auto email is not  sending";
			System.out.println("Auto email is not sending");
			test.fail(confirm_not);
		}
		for(int i=0;i<bulk_email_send_date.size();i++)
		{
			WebElement bulk_index=bulk_email_send_date.get(i);
			String bulk_text=bulk_index.getText();
			bulk_email_date=bulk_text.split(" ");
			System.out.println("The date array is "+bulk_email_date[i]);
			if(bulk_email_date[0].equals(formatted.replace("/0", "/")))
			{
				WebElement customer_index=customer_statement.get(i);
				if(customer_index.getText().equals("Yes"))
				{
					System.out.println("customer statement is included");
					test.pass("customer statement is included");
					break;
				}
				else
				{
					System.out.println("customer statement is not included");
					test.fail("cutomer statement is not included");
				}
			}
		}
			
		}
		

		
		
	}
	public void dashboard(String from_date1,String to_date1,String testcase,ExtentTest test) throws Exception
	{
		if(testcase.trim().equals("invoices followed up through bei"))
		{
			Actions action=new Actions(driver);
			dashboard.click();
			if(over_total.isDisplayed()==true)
			{
			over_total.click();
			Thread.sleep(7000);
			String follow_up_invoices=total_invoices_followed_up.getText().trim();
			if(!follow_up_invoices.equals(""))
			{
				confirm_message="The total invoices followed up through bei is "+follow_up_invoices;
				System.out.println("The total invoices followed up through bei is "+follow_up_invoices);
				test.pass(confirm_message);
			}	
			}
			else
			{
			Thread.sleep(4000);
			WebElement follow_up=driver.findElement(By.xpath("//h2[@title='Total Amount Followed Up']"));
			action.moveToElement(follow_up).build().perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@id='ns-component-9188733075148785-2036142779']")).click();
			String follow_up_invoices=total_invoices_followed_up.getText().trim();
			if(!follow_up_invoices.equals(""))
			{
				confirm_message="The total invoices followed up through bei is "+follow_up_invoices;
				System.out.println("The total invoices followed up through bei is "+follow_up_invoices);
				test.pass(confirm_message);
			}
			else
			{
				confirm_not="The total invoices followed up through bei is not displayed";
				test.fail(confirm_not);
			}
			}
		
		}
		else if(testcase.trim().equals("no of open days of invoice"))
		{
			dashboard.click();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",bei_comparsion);
			int opendays[]=new int[Customer_open_days_in_bei.size()];
			int open_days_customer=0;
			for(int i=0;i<Customer_open_days_in_bei.size();i++)
			{
				WebElement cus=Customer_open_days_in_bei.get(i);
				String name=cus.getText().trim();
				if(cus.getText().trim().equals("Test Cust1"))
				{
					System.out.println("Open days are "+customer_open_days.get(i).getText());
					String open_days=customer_open_days.get(i).getText();
					String open_days_after_replacing=open_days.replace(",","");
					open_days_customer=Integer.parseInt(open_days_after_replacing);
					System.out.println("Open days are "+open_days_customer);
					test.pass("Open days are "+open_days_customer);
					cus.click();
					break;
				}
			}
			List<Integer> prices = new ArrayList<>();
			List<WebElement> tags = driver.findElements(By.xpath("//table[@id='div__bodytab']//tbody//td[count(//td[@data-label='Days Open']//preceding-sibling::td)+1]"));
			System.out.println("The size is "+tags.size());
			int max=0;
			for(int i=1;i<tags.size()-1;i++)
			{
				WebElement open_days_=tags.get(i);
				System.out.println("open days are  "+open_days_.getText().replace(",", "")+" "+i);
			    prices.add(Integer.parseInt(open_days_.getText().replace(",", "")));
			    max=Collections.max(prices);
			}
			if(open_days_customer==max)
			{
				confirm_message="Open days are correct";
				System.out.println("The open days are correct");
				test.pass("Open days are displayed correct: "+max);
			}
			else
			{
				confirm_not="Open days are not correct";
				test.fail("Open days are not correct: "+max);
				
			}
		
		}
		else
		{
		String customer_name=null;
		String customer_url=null;
		String invoice_url=null;
		String doc_texttt=null;
		int count=0,count_empty=0;
		form_date.clear();
		form_date.sendKeys(from_date1);
		Thread.sleep(2000);
		to_date.clear();
		to_date.sendKeys(to_date1);
		Thread.sleep(2000);
		search_button.click();
		Thread.sleep(2000);
		email_template_input.click();
		email_template_input.sendKeys("Invoice Email Template");
		unmark_all.click();
		int size=email_to.size();
		for(int i=0;i<size;i++)
		{
	
			if(count==1)
			break;
			System.out.println(size);
			WebElement email_index=email_to.get(i);
			char c= email_index.getText().charAt(0);
			boolean empty_or_not= false;
			if(c ==' ')
			{
				empty_or_not = true;
			}
			if(empty_or_not)
			{
				count_empty=count_empty+1;
			}
			else
			{
				
				count=count+1;
				WebElement doc_text=doc_nr.get(i);
				doc_texttt=doc_text.getText();
				select_invoices.get(i).click();
				WebElement customer_index=customer_names.get(i);
				customer_name=customer_index.getText().replace("  "," ");
				System.out.println("customer name is "+customer_name);
			}

	}
		int invoices_before = 0;
		String no_of_invoices1;
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).click(dashboard).keyUp(Keys.CONTROL).build().perform();
		windowHandle();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,300)", "");
		total_count_bei.click();
		String bei_url=null;
		for(int i=0;i<bei_comparison_customers.size();i++)
		{
			WebElement bei_customer_index=bei_comparison_customers.get(i);
			String customer=bei_customer_index.getText();
			if(customer_name.equals(customer))
			{
				WebElement no_of_invoices=no_of_emails_sent_through_bei.get(i);
				no_of_invoices1=no_of_invoices.getText().replace(",","");
			invoices_before=Integer.parseInt(no_of_invoices1);
			System.out.println("no_of_invcoies before sending email "+invoices_before);
			test.pass("no_of_invcoies before sending email "+invoices_before);
			bei_url=driver.getCurrentUrl();
			System.out.println("url is :"+bei_url);
			break;
			}
		}
		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);
		System.out.println("count is "+count);
		System.out.println("count_empty is "+count_empty);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)", "");
		Thread.sleep(5000);
		WebElement other_menu=driver.findElement((By.xpath("//li[@id='ns-header-menu-main-item1']")));
		action.moveToElement(other_menu).build().perform();
		action.moveToElement(process_button).build().perform();
		process_button.click();
		Thread.sleep(10000);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfAllElements(hold_on_message));
		if (hold_on_message.getText().trim().equals("Please wait until the process completes...")) {
			System.out.println("processing message is displayed correctly");
			ExtentTest test1=test.createNode("Processing Message Testing");
			test1.pass("processing message is displayed correctly");
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='holdon-message']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@name='custpage_resendemail_send']//following-sibling::img")));

		show_emailed_invoices.click();
		search_button.click();
		for(int i=0;i<doc_nr.size();i++)
		{
			WebElement doc_index=doc_nr.get(i);
			if(doc_index.getText().equals(doc_texttt))
			{
				System.out.println("show only emailed invoices checkbox is verified");
				test.pass("show only emailed invoices checkbox is verified");
				break;
			}
		} 
		driver.navigate().to(bei_url);
		for(int i=0;i<bei_comparison_customers.size();i++)
		{
			WebElement bei_customer_index=bei_comparison_customers.get(i);
			String customer=bei_customer_index.getText();
			if(customer_name.equals(customer))
			{
				WebElement no_of_invoices=no_of_emails_sent_through_bei.get(i);
				String no_of_invoices_after=no_of_invoices.getText().replace(",","");
				int invoices=Integer.parseInt(no_of_invoices_after);
				System.out.println("no of invoices after sending email "+invoices);
				test.pass("no of invoices after sending email "+invoices);
				if(invoices>invoices_before)
				{
					System.out.println("no of invoices sent is verified");
					test.pass("no of invoices sent is verified");
					break;
				}
			}
		}
	}
	}
	
	public void email_sourcing(String from_date1,String to_date1,String testcase,String customername,ExtentTest test) throws Exception
	{
		String emailc=null;
		String emailb=null;
		String c_b=null;
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		form_date.clear();
		Thread.sleep(2000);
		form_date.sendKeys(from_date1);
		Thread.sleep(2000);
		to_date.clear();
		Thread.sleep(2000);
		to_date.sendKeys(to_date1);
		Thread.sleep(2000);
		if(!testcase.trim().equals("parent customer email id's"))
		credit_memos.click();
		Actions action=new Actions(driver);
		action.moveToElement(search_button).build().perform();
		if(testcase.trim().equals("parent customer email id's"))
		{
		customer_name.sendKeys(customername);
		show_parent_emails.click();
		}
		search_button.click();
		int count=0;
		int count_empty=0;
		if(testcase.trim().equals("parent customer email id's"))
		{
			unmark_all.click();
			for(int i=0;i<email_to.size();i++)
			{
				if(count==1)
				break;
				System.out.println(email_to.size());
				WebElement email_index=email_to.get(i);
				char c= email_index.getText().charAt(0);
				boolean empty_or_not= false;
				if(c ==' ')
				{
					empty_or_not = true;
				}
				if(empty_or_not)
				{
					count_empty=count_empty+1;
				}
				else
				{
					count=count+1;
					WebElement doc_text=doc_nr.get(i);
					String doc_texttt=doc_text.getText();
					WebElement email=email_to.get(i);
					String email_id=email.getText();
					customer_link.get(i).sendKeys(selectLinkOpeninNewTab);	
					windowHandle();
					String email_id_p=null;
					if(parent_company.isDisplayed()==true)
					{
						parent_company_value.click();
						email_id_p=email_fiels_in_customer.getText();
					}
					
					if(email_id.trim().equals(email_id_p.trim()))
					{
						confirm_message="Parent email is displayed in BEI";
						System.out.println("Parent email is displayed in BEI");
						test.pass(confirm_message);
					}
					else
					{
						confirm_not="Parent email is not displayed in BEI";
						System.out.println(confirm_not);
						test.fail(confirm_not);
					}
					

				}
			}
		}
		if(testcase.trim().equals("sourcing of emails from customer record to credit memo"))
		{
			for(int i=0;i<tran_type.size();i++)
			{
				WebElement tran_index=tran_type.get(i);
				if(tran_index.getText().trim().equals("Credit Memo"))
				{
					customer_link.get(i).sendKeys(selectLinkOpeninNewTab);	
					windowHandle();
					if(!email_fiels_in_customer.getText().equals(""))
						{
						System.out.println("not empty");
						emailc=email_fiels_in_customer.getText();
						System.out.println("The email filed is "+emailc);
						communication_tab.click();
						emailb=bulk_email_addresses.getText();
						if(bulk_email_addresses.getText().trim()!="")
						{
						System.out.println("The bulk email address is "+emailb.replace(",", ", "));
						c_b=emailc.concat(",").concat(" ").concat(emailb.replace(",", ", "));
						System.out.println("The id's after concating is "+c_b);
						}
						else
						{
							c_b=emailc;
						}
						driver.switchTo().window(parentWindow);
						
						String c_b_1=emailc.concat(",").concat("").concat(emailb);
						WebElement email_to_index=email_to.get(i);
						if(c_b_1.trim().equals(email_to_index.getText().trim()))
						{
							System.out.println("email id's are sourced correctly from customer record to bei to be emailed field");
							test.pass("email id's are sourced correctly from customer record to bei to be emailed field");
						}
						doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
						windowHandle();
						communication_tab_in_credit_memo.click();
						System.out.println("To be emailed id's are "+to_be_emailed.getText());
						if(c_b.equals(to_be_emailed.getText()))
								{
									confirm_message="Email id's are sourced correctly";
									System.out.println("email id's are sourced correctly");
									test.pass(confirm_message);
								}
						else
						{
							confirm_not="Email id's are not correctly sourced";
							System.out.println(confirm_not);
							test.fail(confirm_not);
						}
						break;
						
					}
					else
					{
						communication_tab.click();
						emailb=bulk_email_addresses.getText();
						driver.switchTo().window(parentWindow);
						doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
						windowHandle();
						communication_tab_in_invoice.click();
						if(emailb.trim().equals(to_be_emailed.getText().trim()))
						{
							confirm_message="Email id's are sourced correctly";
							System.out.println("email id's are sourced correctly");
							test.pass(confirm_message);
							
						}
						else
						{
							confirm_not="Email id's are not correctly sourced";
							System.out.println(confirm_not);
							test.fail(confirm_not);
						}
					}
					
				}
			}
			
		}
		else
		{
		for(int i=0;i<customer_link.size();i++)
		{
			if(i==1)
				break;
			customer_link.get(i).sendKeys(selectLinkOpeninNewTab);	
			windowHandle();
			if(!email_fiels_in_customer.getText().equals(""))
			{
				System.out.println("not empty");
				emailc=email_fiels_in_customer.getText();
				System.out.println("The email filed is "+emailc);
				communication_tab.click();
				emailb=bulk_email_addresses.getText();
				System.out.println("bulk email address is"+emailb.trim()+"....");
				if(!emailb.trim().equals(""))
				{
				System.out.println("The bulk email address is "+emailb);
				c_b=emailc.concat(",").concat(" ").concat(emailb);
				System.out.println("The id's after concating is "+c_b);
				driver.switchTo().window(parentWindow);
				String c_b_1=emailc.concat(",").concat("").concat(emailb);
				WebElement email_to_index=email_to.get(i);
				if(c_b_1.trim().equals(email_to_index.getText().trim()))
				{
					System.out.println("email id's are sourced correctly from customer record to bei to be emailed field");
					test.pass("email id's are sourced correctly from customer record to bei to be emailed field");
				}
				}
				else
				{
					c_b=emailc;
					driver.switchTo().window(parentWindow);
					WebElement email_to_index=email_to.get(i);
					if(c_b.trim().equals(email_to_index.getText().trim()))
					{
						System.out.println("email id's are sourced correctly from customer record to bei to be emailed field");
						test.pass("email id's are sourced correctly from customer record to bei to be emailed field");
					}


				}
				doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
				windowHandle();
				communication_tab_in_invoice.click();
				System.out.println("To be emailed id's are "+to_be_emailed.getText());
				if(c_b.equals(to_be_emailed.getText()))
						{
							confirm_message="Email id's are sourced correctly";
							System.out.println("email id's are sourced correctly");
							test.pass(confirm_message);
						}

			}
			else
			{
				communication_tab.click();
				emailb=bulk_email_addresses.getText();
				driver.switchTo().window(parentWindow);
				doc_nr.get(i).sendKeys(selectLinkOpeninNewTab);
				windowHandle();
				communication_tab_in_invoice.click();
				if(emailb.trim().equals(to_be_emailed.getText().trim()))
				{
					confirm_message="Email id's are sourced correctly";
					System.out.println("email id's are sourced correctly");
					test.pass(confirm_message);
				}
			}
			
		}
		
		}
	}
} 