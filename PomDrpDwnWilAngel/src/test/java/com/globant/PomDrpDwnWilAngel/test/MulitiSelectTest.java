package com.globant.PomDrpDwnWilAngel.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.globant.PomDrpDwnWilAngel.pages.MainPage;

/**
 * 
 * @author wilson.angel
 *
 */
public class MulitiSelectTest extends BaseTest{

	MainPage mainPage;
	Assertion myAssert = new Assertion();

	/**
	 * Init base page
	 */

	@BeforeTest
	public void setUp() {
		mainPage= new MainPage(driver);
	}


	/**
	 * Test to select a multiSelect list and verify the selected text
	 * @param browser
	 * @param state of EEUU
	 */
	@Parameters({"browser"})
	@Test(dataProvider="stateToSend", priority=1)
	public void selectOneState(String option) {

		mainPage.selectOneList(option);
		myAssert.assertEquals(mainPage.clickFirstSelectedBtn(), true);
		myAssert.assertTrue(mainPage.verifyText(option), "The string doesn't match");
	}



	/**
	 * Test to select a list and verify the selected text
	 * @param Browser
	 * @param day of the week
	 */
	@Parameters({"browser"})
	@Test(dataProvider="dayToSend", priority=2)
	public void selectOneDay(String option) {

		mainPage.selectOneList(option);		
		myAssert.assertTrue(mainPage.verifyText(option), "The string doesn't match");
	}


	/**
	 * Data provider
	 * @return array
	 */

	@DataProvider(name="stateToSend")
	public Object[][] getStates(){

		return new Object[][] {{"Texas"}};
	}


	/**
	 * Data provider
	 * @return array 
	 */
	@DataProvider(name="dayToSend")
	public Object[][] getDays(){

		return new Object[][] {{"Monday"}};
	}

	/**
	 * Close the driver when the test class finish
	 */


	@AfterClass
	public void afterClass() {
		driver.close();
	}



}
