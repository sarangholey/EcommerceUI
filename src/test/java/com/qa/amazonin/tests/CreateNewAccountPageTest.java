package com.qa.amazonin.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.amazonin.base.BasePage;
import com.qa.amazonin.pages.CreateNewAccountPage;
import com.qa.amazonin.utils.ExcelUtil;

public class CreateNewAccountPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	CreateNewAccountPage createNewAccountPage;
		
	@BeforeMethod
	@Parameters("browserName")
	public void setUpCreateNewAccountPageTest(@Optional("Chrome")String bName)
	{
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(bName);
		driver.get(prop.getProperty("url"));
		createNewAccountPage = new CreateNewAccountPage(driver);
	}
	
	//public void verifyNewAccountCreatedTest(String CName, String CMobileNumber, String CMobileNuber, String CPassword)
	
	@Test(dataProvider = "NewCustomerData")
	public void verifyNewAccountCreatedTest(String CustomerName, String CustomerMobileNumber, String CustomerEmailID, String CustomerPassword)
	{
		createNewAccountPage.verifyNewAccountCreated(CustomerName, CustomerMobileNumber, CustomerEmailID, CustomerPassword);
	}
	
	@DataProvider(name = "NewCustomerData")
	public Object[][] getNewCustomerData()
	{
		Object customerData[][] = ExcelUtil.getTestData("CData");
		return customerData;
	}
	
	@AfterMethod
	public void tearDownCreateNewAccountPageTest()
	{
		driver.quit();
	}

}
