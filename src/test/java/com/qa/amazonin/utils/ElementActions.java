package com.qa.amazonin.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementActions {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public ElementActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, AppConstants.DEFAULT_EXPLICIT_TIME_OUT);
		action = new Actions(this.driver);
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception occurred while creating the webelement : " + locator);
		}
		return element;
	}
	
	public List<WebElement> getElementsList(By locator) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(locator);
		} catch (Exception e) {
			System.out.println("some exception occurred while creating the webelement : " + locator);
		}
		return element;
	}

	/**
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doActionsClick(By locator) {
		action.click(getElement(locator)).build().perform();
	}
	
	public void dosActionMoveToElement(By locator) {
		action.moveToElement(getElement(locator)).build().perform();
	}
	

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doActionsSendKeys(By locator, String value) {
		action.sendKeys(getElement(locator), value).build().perform();
	}
	
	public void doMoveToElement(By locator){
		action.moveToElement(getElement(locator)).build().perform();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean doIsSelected(By locator) {
		return getElement(locator).isSelected();
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doGetcurrentURL() {
		return driver.getCurrentUrl();
	}
	

	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForFramePresentAndSwitchToIt(By locator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void waitForElementVisible(By locator) {
		WebElement ele = getElement(locator);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementClickable(By locator)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public String doGetPageTitle(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}
	
	public List<String> getWindowList(WebDriver driver)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		return windowHandlesList;
	}
	
	public void switchToWindowId(WebDriver driver, int windowNumber)
	{
		List<String> windowList = getWindowList(driver);
		driver.switchTo().window(windowList.get(windowNumber));
	}
	
	public List<WebElement> getTagCount(String htmlTagName, WebDriver driver)
	{
		List<WebElement> tagList = driver.findElements(By.tagName(htmlTagName));
		return tagList;
	}
	

}
	

