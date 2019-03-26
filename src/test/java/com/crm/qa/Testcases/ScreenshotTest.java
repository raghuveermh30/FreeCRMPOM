/**
 * 
 */
package com.crm.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.util.CustomListner;
import com.crm.qa.util.ScreenshotBase;

/**
 * @author raghuveer.mh
 *
 */
@Listeners(CustomListner.class)
public class ScreenshotTest extends ScreenshotBase{
	
	@BeforeMethod
	public void setUp() {
		initialisation();
	}
	
	
	@Test
	public void takescreenshot() {
		Assert.assertEquals(true, false);
	}

	@Test
	public void dsdsds() {
		Assert.assertEquals(true, false);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
