package com.globant.PomDrpDwnWilAngel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends BasePage {
	
	@FindBy(css="#multi-select")
	private WebElement multiSelect; 

	public MainPage(WebDriver pDriver) {
		super(pDriver);
	
	}
	
	public void selectOneState() {
		
		getWait().until(ExpectedConditions.elementToBeClickable(multiSelect));
		
		Select multiselect = new Select(multiSelect);
		multiselect.selectByValue("Texas");
		
		
	}
	
	

}
