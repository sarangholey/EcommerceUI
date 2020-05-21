package com.qa.amazonin.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amazonin.base.BasePage;
import com.qa.amazonin.utils.AppConstants;
import com.qa.amazonin.utils.ElementActions;

public class LandingPage extends BasePage {

	WebDriver driver;
	Properties prop;
	ElementActions elementActions;

	// Constructor of page class:
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);

	}

	// Locators
	private By amazonLogo = By.xpath("//div[@id='nav-logo']");

	public String verifyTitle() {
		return elementActions.doGetPageTitle(AppConstants.LANDING_PAGE_TITLE);
	}
	
	public boolean verifyLogo()
	{
		return elementActions.doIsDisplayed(amazonLogo);
	}

	

}
