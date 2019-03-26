package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory --Object Repository -- creation of the object Reop
	
	@FindBy(name = "username")
	WebElement username;
	
	
	@FindBy(name = "password")
	WebElement  password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement loginBtn;
	
	@FindBy(linkText = "Sign Up")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//img[@alt = 'free crm logo']")
	WebElement crmLogo;
	
	//Initialising the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this); //initalise the elements by init using pagefcatory class
		// this is pointing to the current object	
	}
	
	
	public String validateLoginPageTitle() {
	return	driver.getTitle();
	}
	
	public boolean validateCrmImg() {
	return	crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pwd) {
		username.clear();
		username.sendKeys(uname);
		password.clear();
		password.sendKeys(pwd);
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		loginBtn.click();
		return new HomePage();
		
	}
	
	
	

}
