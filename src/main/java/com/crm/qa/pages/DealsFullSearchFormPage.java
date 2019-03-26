/**
 * 
 */
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

/**
 * @author raghuveer.mh
 *
 */
public class DealsFullSearchFormPage extends TestBase{

	@FindBy(name = "cs_keyword")
	WebElement title;
	
	@FindBy(xpath = "//input[@name = 'cs_closed' and @value = 'N']")
	WebElement open;
	
	@FindBy(xpath = "//input[@name = 'cs_closed' and @value = 'Y']")
	WebElement closed;
	
	@FindBy(xpath = "//Select[@name = 'cs_type']")
	WebElement type;
	
	@FindBy(xpath = "//Select[@name = 'cs_source']")
	WebElement source;
	
	@FindBy(xpath = "//input[@name = 'tag']")
	WebElement tag;
	
	@FindBy(xpath = "//textarea[@name = 'cs_notes']")
	WebElement notes;
	
	@FindBy(xpath = "//textarea[@name = 'cs_next_step']")
	WebElement nextStep;
	
	@FindBy(xpath = "//input[@name = 'cs_extended']")
	WebElement extendedFields;
	
	@FindBy(xpath = "//input[@name = 'cs_contact_name']")
	WebElement contactName;
	
	@FindBy(xpath = "//input[@name = 'cs_company_name']")
	WebElement companyName;
	
	@FindBy(xpath = "//input[@name = 'cs_identifier']")
	WebElement identifer;
	
	@FindBy(xpath = "//input[@name = 'cs_probability']")
	WebElement probability;
	
	@FindBy(name = "cs_amount_operator")
	WebElement amountDropdown;
	
	@FindBy(name = "cs_amount")
	WebElement amount;
	
	@FindBy(name = "cs_commission")
	WebElement commission;
	
	public DealsFullSearchFormPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void getTitle() {
		driver.getTitle();
	}
	
	public boolean verifyFullFormPage() {
		boolean flag = title.isDisplayed();
		return flag;
	}
	
	public void upDateFullFormDetails() {
		title.clear();
		title.sendKeys("Full Search Form");
		
	}
	
	
	
	
	
	
	
	
	}
