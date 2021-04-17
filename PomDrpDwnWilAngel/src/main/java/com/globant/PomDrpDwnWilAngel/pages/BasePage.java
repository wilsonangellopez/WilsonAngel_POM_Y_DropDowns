package com.globant.PomDrpDwnWilAngel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	

	public void dispose() {

		if(driver!=null) {
			driver.quit();
		}

	}
}
