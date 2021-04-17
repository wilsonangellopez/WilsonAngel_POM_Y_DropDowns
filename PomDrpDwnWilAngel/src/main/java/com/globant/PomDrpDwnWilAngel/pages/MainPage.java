package com.globant.PomDrpDwnWilAngel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends BasePage {
	
	@FindBy(css="#multi-select")
	private WebElement multiSelect; 
	
	@FindBy(id="printMe")
	private WebElement firstBtnSelected;

	public MainPage(WebDriver pDriver) {
		super(pDriver);
	
	}
	
	public void selectOneState(String state) {
		
		System.out.println("state:"+ state);
		
		getWait().until(ExpectedConditions.elementToBeClickable(multiSelect));
		
		Select multiselect = new Select(multiSelect);
		 multiselect.selectByValue(state);
		 
		
	}
	
	
	
	

}
