package com.qa.pages;

import java.beans.Visibility;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestBase;

public class AuthPageNavigation extends TestBase {
	@FindBy(xpath="//td[@class='smalltextnolink']//following-sibling::td")
	WebElement question;
	@FindBy(css="tr td input[type='password'][name='answer']")
	WebElement answer;
	@FindBy(css="tr td input[type='submit'][name='submitter']")
	WebElement authsubmit;
	@FindBy(xpath="//div[@id='spn_cRR_d1']")
	WebElement roles;
	@FindBy(xpath="//li[@class='ns-menuitem ns-role-menuitem']")
	List<WebElement> accounts;
	@FindBy(xpath = "//a//preceding::div[@id='spn_cRR_d1']")
	WebElement view_roles;
	@FindBy(xpath = "//li[@class='ns-menuitem uir-menuitem-viewall']//a")
	WebElement view_all_roles;
	@FindBy(xpath = "//li[@data-title='Customers']")
	WebElement Customers;
	@FindBy(xpath = "//li[@data-title='Sales']")
	WebElement Sales;
	@FindBy(xpath = "//li[@data-title='Bulk Email Invoice']")
	WebElement BEI;
	@FindBy(xpath = "//li[@class='ns-menuitem ns-role-menuitem']//a//span[@class='ns-role-menuitem-text']")
	List<WebElement> beilink;
	@FindBy(xpath = "//a[@class='ns-scroll-button ns-scroll-button-bottom']")
	WebElement arrow;
	@FindBy(xpath = "//a[@href='?role_switch=256701912']")
	WebElement choose_role;
	public AuthPageNavigation()
	{
		PageFactory.initElements(driver, this);
	}
	@SuppressWarnings("deprecation")
	public void navigatetoBEI() throws InterruptedException
	{
		
		Actions action=new Actions(driver);
		Thread.sleep(10000);
		action.moveToElement(Customers).build().perform();
		Thread.sleep(2000);
		action.moveToElement(Sales).build().perform();
		Thread.sleep(1000);
		action.moveToElement(BEI).build().perform();
		BEI.click();
	}
	public void  choose_role()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",choose_role);
		choose_role.click();
	}
	public void SelectBEIrole() throws InterruptedException
	{
		Actions action=new Actions(driver);
		action.moveToElement(view_roles).build().perform();
		Thread.sleep(2000);
		if(arrow.isDisplayed())
		{
			action.moveToElement(arrow).build().perform();
		}
		for(int i=0;i<beilink.size();i++) {
			WebElement roleElement = beilink.get(i);
			String roleValue = roleElement.getText().trim();
			if(roleValue.equals("Tvarana Dev Production  -  BEI-AR")) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			WebElement aTagElement = (WebElement)executor.executeScript("return arguments[0].parentNode;", roleElement);
			WebElement liTagElement = (WebElement)executor.executeScript("return arguments[0].parentNode;", aTagElement);
			String id = liTagElement.getAttribute("id");
			try {
			String roleType = driver.findElement(By.xpath("//li[@id='"+id+"']/a/span[@class='ns-role-accounttype']")).getText();
			if(roleType.equals("RP")) {
			driver.findElement(By.xpath("//li[@id='"+id+"']/a/span[@class='ns-role-menuitem-text']")).click();
			break;
			}
			}
			catch(NoSuchElementException e) {
			System.out.println("Role Type not matched");
			}
			}
			}
	
	}
	public String validateAuthPageTitle()
	{
		return driver.getTitle();
	}
	public String authquestion()  
	{
		return question.getText();
	}
	public void enterAuthCode(String code)
	{
		answer.sendKeys(code);
		authsubmit.click();
	}
	
	
	

}
