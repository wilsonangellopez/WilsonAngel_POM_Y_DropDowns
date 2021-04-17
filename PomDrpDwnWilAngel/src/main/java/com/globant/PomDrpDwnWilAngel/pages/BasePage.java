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

	public BasePage(WebDriver pDriver){

		PageFactory.initElements(pDriver, this);
		wait = new WebDriverWait(pDriver, 20);
		driver = pDriver;

	}

	public WebDriverWait getWait(){return wait;}

	protected WebDriver getDriver() {return driver;}	

	public  void findElementVisible(String element) {
		getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector(element))));
	}

	public String getText(String element) {
		getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.cssSelector(element))));
		return  getDriver().findElement(By.cssSelector(element)).getText();
	}

	public String getText(WebElement element) {

		getWait().until(ExpectedConditions.visibilityOf(element));

		String[] arrSplit= element.getText().split(":");

		String str= "";
		str = arrSplit[arrSplit.length-1];
		str= str.replaceAll("\\s","");

		return str;
	}

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


	public boolean validateText(String obtain, String expected) {

		return obtain.equalsIgnoreCase(expected)?true:false;
	}


	public void selectGenericList(WebElement element, String state) {

		getWait().until(ExpectedConditions.elementToBeClickable(element));

		Select multiselect = new Select(element);
		multiselect.selectByValue(state);

	}


	public void dispose() {

		if(driver!=null) {
			driver.quit();
		}

	}
}
