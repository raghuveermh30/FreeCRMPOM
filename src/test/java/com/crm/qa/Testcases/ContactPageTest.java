package com.crm.qa.Testcases;

import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	
	
	/*@CacheLookUp--it will increase the performnce of the framewrok and execution wil be high
	but if the page is refreshed or DOM structure got changed then Cache memory wil be crashed
	*/
	
	public ContactPageTest() {
		super();
	}
	
	LoginPage loginPage ;
	HomePage homePage ;
	ContactPage contactsPage;
	TestUtil testUtil ;
	
	
	public static void delay()  {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//TestUtil.runTimeInfo("error", "login successful");
		delay();
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();
	}
	
	/*@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactsPage.selectContactByName("dasdasd hfhfgfg");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactByName("dasdasd hfhfgfg");
		contactsPage.selectContactByName("ereeded xsaxa");

	}*/
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData("Contacts");
		return data;
	}
	
	
	@Test(dataProvider = "getCRMTestData" )
	public void validateCreateNewContact(String firstName, String lastName, String company, String pos){
		homePage.clickOnNewContact();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google","ASE");
	contactsPage.createNewContact(firstName, lastName, company, pos);
		
	}
	
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
