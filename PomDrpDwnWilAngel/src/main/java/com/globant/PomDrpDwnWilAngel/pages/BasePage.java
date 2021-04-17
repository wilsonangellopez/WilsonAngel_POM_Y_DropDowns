package com.globant.PomDrpDwnWilAngel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import sun.security.util.Length;

public class BasePage {

	private WebDriver driver;
	private WebDriverWait wait;

	/**
	 * Base page with common methods
	 * @param pDriver
	 */

	public BasePage(WebDriver pDriver){

		PageFactory.initElements(pDriver, this);
		wait = new WebDriverWait(pDriver, 20);
		driver = pDriver;

	}

	/**
	 * Method to allow to selenium get explicits Waits
	 * @return: wait
	 */
	public WebDriverWait getWait(){return wait;}

	/**
	 * Get driver selenium
	 * @return: driver
	 */
	protected WebDriver getDriver() {return driver;}	



	/**
	 * Method to wait a element to be visible
	 * @param element
	 */

	public  void findElementVisible(String element) {
		getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector(element))));
	}

	/**
	 * Generic Method to get text from a web element
	 * @param element
	 * @return String
	 */

	public String getText(String element) {
		getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector(element))));
		return  getDriver().findElement(By.cssSelector(element)).getText();
	}


	/**
	 * Generic Method to get text from a web element
	 * @param element
	 * @return String
	 */

	public String getText(WebElement element) {

		getWait().until(ExpectedConditions.visibilityOf(element));

		String[] arrSplit= element.getText().split(":");

		String str= "";
		str = arrSplit[arrSplit.length-1];
		str= str.replaceAll("\\s","");

		return str;
	}

	/**
	 * Generic Method to get text from a web element
	 * @param element
	 * @param option
	 * @return
	 */

	public String getText(WebElement element, String option) {


		getWait().until(ExpectedConditions.visibilityOf(element));
		String str= "";

		if(option.equalsIgnoreCase("Texas")) {

			String[] arrSplit= element.getText().split(":");	

			str = arrSplit[arrSplit.length-1];
			str= str.replaceAll("\\s","");
			return str;	

		}
		else {

			String[] arrSplit= element.getText().split("-");	

			str = arrSplit[arrSplit.length-1];
			str= str.replaceAll("\\s","");
			return str;	
		}

	}

	/**
	 * Generic Method to compare text
	 * @param obtain
	 * @param expected
	 * @return
	 */
	public boolean validateText(String obtain, String expected) {

		return obtain.equalsIgnoreCase(expected)?true:false;
	}

	/**
	 * Generic Method to select a list or multi select web element
	 * @param element
	 * @param state
	 */
	public void selectGenericList(WebElement element, String state) {

		getWait().until(ExpectedConditions.elementToBeClickable(element));

		Select multiselect = new Select(element);
		multiselect.selectByValue(state);

	}

	/**
	 * Kill driver
	 */
	public void dispose() {

		if(driver!=null) {
			driver.quit();
		}

	}
}
