package com.qa.amazonin.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazonin.base.BasePage;
import com.qa.amazonin.pages.LandingPage;
import com.qa.amazonin.utils.AppConstants;

public class LandingPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LandingPage landingPage;
	
	@BeforeMethod
	public void setUpLandingPageTest()
	{
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver();
		driver.get(prop.getProperty("url"));
		landingPage = new LandingPage(driver);
	}
	
	@Test
	public void verifyTitleTest()
	{
		Assert.assertEquals(landingPage.verifyTitle(), AppConstants.LANDING_PAGE_TITLE);
	}
	
	@Test
	public void verifyLogoTest()
	{
		Assert.assertEquals(landingPage.verifyLogo(), true);
	}
	
	@AfterMethod
	public void tearDownLandingPageTest()
	{
		driver.quit();
	}
	

}
