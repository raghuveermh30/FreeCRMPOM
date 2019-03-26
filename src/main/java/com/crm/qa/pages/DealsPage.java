package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	
	@FindBy(xpath = "//legend[contains(text(), 'Deal')] ")
	WebElement deals;
	
	
	@FindBy(id = "title")
	WebElement title;
	
	@FindBy(xpath = "//input[@name = 'client_lookup']")
	WebElement company;
	
	@FindBy(xpath = "//input[@name = 'contact_lookup']")
	WebElement primaryContact;
	
	@FindBy(id = "amount")
	WebElement amount;
	
	@FindBy(id = "probability")
	WebElement probability;
	
	@FindBy(id= "commission")
	WebElement commission;
	
	@FindBy(xpath = "//input[@name = 'identifier']")
	WebElement identifier;
	
	@FindBy(id = "tags")
	WebElement tags;
	
	@FindBy(id = "description")
	WebElement description;
	
	@FindBy(id = "next_step")
	WebElement nextStep;
	
	@FindBy(xpath = "//form[@id = 'contactForm']//input[@value = 'Save']")
	WebElement save;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyDealsLabel() {
	boolean flag =	deals.isDisplayed();
	return flag;
	}
	
	public void updateDealsFields() {
		title.clear();
		title.sendKeys("Flash Deal");
		company.clear();
		company.sendKeys("CGI");
		primaryContact.clear();
		primaryContact.sendKeys("dsdsd");
		amount.clear();
		amount.sendKeys("2223232");
		probability.clear();
		probability.sendKeys("3");
		commission.sendKeys("2");
		identifier.sendKeys("dsdsd");
			
	}
	
	
	public void  clickSave() {
		save.click();
	}
	
	
}
