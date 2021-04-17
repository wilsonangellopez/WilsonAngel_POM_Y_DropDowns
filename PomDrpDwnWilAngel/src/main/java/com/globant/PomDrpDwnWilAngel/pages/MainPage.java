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

	@FindBy(css="p.getall-selected")
	private WebElement MultiSelectText; 


	@FindBy(id="select-demo")
	private WebElement selectListDay;

	@FindBy(css="p.selected-value")
	private WebElement selectedTextDay;



	public MainPage(WebDriver pDriver) {
		super(pDriver);

	}

	public void selectOneList(String option) {


		if(option.equalsIgnoreCase("Texas")) {
			selectGenericList(multiSelect, option);	

		}else {
			selectGenericList(selectListDay, option);
		}



	}

	public boolean clickFirstSelectedBtn() {

		getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("printMe")));
		
		if(firstBtnSelected.isDisplayed()&& firstBtnSelected.isEnabled()) {
			firstBtnSelected.click();
			return true;	
		}
		return false;

	}

	public boolean verifyText(String option) {


		if(option.equalsIgnoreCase("Texas")) {

			return validateText(getText(MultiSelectText,option), option);


		}else {

			return validateText(getText(selectedTextDay,option), option);
		}




	}








}
