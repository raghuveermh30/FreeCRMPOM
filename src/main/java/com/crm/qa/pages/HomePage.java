package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(), 'User: raghuveer Hanumantharaya')] ")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement deals;
	
	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement tasks;
	
	@FindBy (xpath  = "//a[contains(text(), 'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(), 'New Deal')]")
	WebElement newDealsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Full Search Form	')]")
	WebElement fullSearchForm;

	
	//Initialisng the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactPage clickContactsLink() {
		contactsLink.click();
		return new ContactPage();
	}
	
	public DealsPage clickOnDeals() {
		deals.click();
		return new DealsPage();
	}

	public TaskPage clickOnTask() {
		tasks.click();
		return new TaskPage();
	}
	
	public boolean verifyUserName() {
		return 	userNameLabel.isDisplayed();
		
	}
	
	public void clickOnNewContact() {
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).perform();
		newContactLink.click();
		
	}
	
	public void clickOnNewDeal() {
		Actions act = new Actions(driver);
		act.moveToElement(deals).perform();
		newDealsLink.click();
	}
	
	public void clickOnFullSearchForm() {
		Actions act = new Actions(driver);
		act.moveToElement(deals).perform();
		fullSearchForm.click();
	}
}
