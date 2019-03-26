package com.crm.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage ;
	HomePage homePage;
	ContactPage contactsPage;
	TestUtil testUtil ;
	
	public HomePageTest() {
		super();
	}
	
	
	// test cases sould be independent each other
	//test cases should be separated -- independent with each other
		//before each test case -- launch the browser and login
		//@test -- execute test case
		//after each test case -- close the browser
		
		@BeforeMethod
		public void setUp() {
			initialization();
			testUtil = new TestUtil();
			contactsPage = new ContactPage();
			loginPage = new LoginPage();
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
		
		
		@Test(priority=1)
		public void verifyHomePageTitleTest(){
			String homePageTitle = homePage.verifyHomePageTitle();
			Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
		}
		
		@Test(priority=2)
		public void verifyUserNameTest(){
			testUtil.switchToFrame();
			Assert.assertTrue(homePage.verifyUserName());
		}
		
		@Test(priority=3)
		public void verifyContactsLinkTest(){
			testUtil.switchToFrame();
			contactsPage = homePage.clickContactsLink();
		}
		
		
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
	
	public static void delay()  {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
