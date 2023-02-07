package com.petdiseasealerts.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.petdiseasealerts.base.TestBase;
import com.petdiseasealerts.pages.HomePage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();

		
		switchToFrame(homePage.getIframe(), driver);
	}
	
	// @Test(priority = 1)
	// public void homePageTitleTest() {
	// 	String homePageTitle = homePage.validateHomePageTitle();
	// 	Assert.assertEquals(homePageTitle, "Pet Disease Alerts");
	// }

	@Test(priority = 2)
	public void getCaliforniaTest() {
		clickElement(homePage.getCalifornia(), driver);
	}

	@Test(priority = 2)
	public void getfloridaTest() {
		clickAttheBottomOfElement(homePage.getflorida(), driver);
	}

	@Test(priority = 2)
	public void getnewYorkTest() {
		clickElement(homePage.getnewYork(), driver);
	}

	@Test(priority = 2)
	public void getmarylandTest() {
		clickElement(homePage.getmaryland(), driver);
	}
	// @AfterMethod
	// public void tearDown() {
	// 	driver.quit();
	// }
	
}
