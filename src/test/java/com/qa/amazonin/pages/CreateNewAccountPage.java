package com.qa.amazonin.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.amazonin.base.BasePage;
import com.qa.amazonin.utils.ElementActions;

public class CreateNewAccountPage extends BasePage {

	WebDriver driver;
	Properties prop;
	ElementActions elementActions;

//	String CustomerName = "dfvdvdf";
//	String CustomerMobileNumber = "9856457845";
//	String CustomerEmailID = "axsax@gmail.com";
//	String CustomerPassword = "45as56AS";

	// Constructor of page class:
	public CreateNewAccountPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);

	}

	// Locators
	private By helloSignInElement = By.xpath("//span[text()='Hello, Sign in']");
	private By startHereLink = By.xpath("//div[@id='nav-al-container']//a[text()='Start here.']");

	private By customerNameTextBox = By.id("ap_customer_name");
	private By customerPhoneNumberTextBox = By.id("ap_phone_number");
	private By customerEmailTextBox = By.id("ap_email");
	private By customerPasswordTextBox = By.id("ap_password");

	// Methods
	
	public void verifyNewAccountCreated(String CustomerName, String CustomerMobileNumber, String CustomerEmailID,String CustomerPassword) {
		elementActions.doIsDisplayed(helloSignInElement);
		elementActions.doMoveToElement(helloSignInElement);
		elementActions.doIsDisplayed(startHereLink);
		elementActions.doActionsClick(startHereLink);

		// sending Customer Name
		elementActions.doIsDisplayed(customerNameTextBox);
		elementActions.doSendKeys(customerNameTextBox, CustomerName);

		// sending Customer Mobile Number
		elementActions.doIsDisplayed(customerPhoneNumberTextBox);
		elementActions.doSendKeys(customerPhoneNumberTextBox, CustomerMobileNumber);

		// sending Customer Emailid
		elementActions.doIsDisplayed(customerEmailTextBox);
		elementActions.doSendKeys(customerEmailTextBox, CustomerEmailID);

		// sending Customer Emailid
		elementActions.doIsDisplayed(customerPasswordTextBox);
		elementActions.doSendKeys(customerPasswordTextBox, CustomerPassword);

	}

}
