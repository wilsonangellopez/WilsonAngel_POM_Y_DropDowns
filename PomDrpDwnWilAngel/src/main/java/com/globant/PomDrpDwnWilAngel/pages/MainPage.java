package com.globant.PomDrpDwnWilAngel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
/**
 *  Main class to map the elements, methods to campare, select lists and buttons and call the base page to init web elements
 * @author wilson.angel
 *
 */
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


/**
 * Main class to map the elements and call the base page to init web elements
 * 
 * @author wilson.angel
 * @param pDriver
 */
	public MainPage(WebDriver pDriver) {
		super(pDriver);

	}

	
	/**
	 * Generic method to select list and multi select elements
	 * @param option
	 */
	
	public void selectOneList(String option) {


		if(option.equalsIgnoreCase("Texas")) {
			selectGenericList(multiSelect, option);	

		}else {
			selectGenericList(selectListDay, option);
		}
	}

	/**
	 * Method to select button from multiSelect web element 
	 * @return
	 */
	public boolean clickFirstSelectedBtn() {

		getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("printMe")));
		
		if(firstBtnSelected.isDisplayed()&& firstBtnSelected.isEnabled()) {
			firstBtnSelected.click();
			return true;	
		}
		return false;

	}

	/**
	 * Generic Method to obtain and verify the text from select or multi select  
	 * @param option
	 * @param webElement
	 * @return boolean
	 */
	public boolean verifyText(String option) {


		if(option.equalsIgnoreCase("Texas")) {

			return validateText(getText(MultiSelectText,option), option);


		}else {

			return validateText(getText(selectedTextDay,option), option);
		}

	}

}
