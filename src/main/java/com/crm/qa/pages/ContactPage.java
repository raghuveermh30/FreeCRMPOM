package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactPage extends TestBase{
	
	
	
	@FindBy(xpath = "//td[contains(text(), 'Contacts')] ")
	WebElement contactsLabel;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy (name = "client_lookup")
	WebElement company;
	
	@FindBy(id = "company_position")
	WebElement position;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	
	// Initializing the Page Objects:
		public ContactPage() {
			PageFactory.initElements(driver, this);
		}
		
	public boolean verifyContactsLabel() {
	boolean flasg =	contactsLabel.isDisplayed();
		return flasg;
	}
	
	public void selectContactByName(String name) {	
	driver.findElement(By.xpath("//a[contains(text(), '"+name+"')]//parent::td//preceding-sibling::td//input[@name = 'contact_id']")).click();
	}

	
	public void createNewContact( String ftName, String ltName, String comp, String pos){
		/*Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		*/
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		position.sendKeys(pos);
		saveBtn.click();
		
	}
	
	public static void delay() {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			
		}
	}
	
	
	
}
