package com.crm.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	
	public DealsPageTest() {
		super();
	}
	
	LoginPage loginPage ;
	HomePage homePage ;
	DealsPage dealsPage;
	TestUtil testUtil ;
	
	public static void delay() {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		dealsPage = new DealsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//TestUtil.runTimeInfo("error", "login successful");
		delay();
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDeals();
		delay();
		 
	}
	
	
	@Test
	
	public void test() {
		homePage.clickOnNewDeal();
	Assert.assertTrue(dealsPage.verifyDealsLabel());
	delay();
	}
	
	@Test
	
	public void update() {
		homePage.clickOnNewDeal();
		dealsPage.updateDealsFields();
		dealsPage.clickSave();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
