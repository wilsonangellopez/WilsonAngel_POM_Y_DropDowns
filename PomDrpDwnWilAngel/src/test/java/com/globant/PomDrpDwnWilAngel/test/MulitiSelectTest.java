package com.globant.PomDrpDwnWilAngel.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.globant.PomDrpDwnWilAngel.pages.MainPage;

public class MulitiSelectTest extends BaseTest{
	
	MainPage mainPage;
	Assertion myAssert = new Assertion();
	
	
	
	@BeforeTest
	public void setUp() {
		mainPage= new MainPage(driver);
	}
	
	
	
	
	@Parameters({"browser"})
	@Test(dataProvider="stateToSend", priority=1)
	public void selectOneState(String option) {
		
		mainPage.selectOneList(option);
		myAssert.assertEquals(mainPage.clickFirstSelectedBtn(), true);
		myAssert.assertTrue(mainPage.verifyText(option), "The string doesn't match");
	}
	
	
	
	@Parameters({"browser"})
	@Test(dataProvider="dayToSend", priority=2)
	public void selectOneDay(String option) {
		
		mainPage.selectOneList(option);		
		myAssert.assertTrue(mainPage.verifyText(option), "The string doesn't match");
	}
	
	
	
	
	
	
	
	@DataProvider(name="stateToSend")
	public Object[][] getStates(){
		
		return new Object[][] {{"Texas"}};
	}
	
	@DataProvider(name="dayToSend")
	public Object[][] getDays(){
		
		return new Object[][] {{"Monday"}};
	}
	
	
	
	
	@AfterClass
	public void afterClass() {
		//driver.close();
	}

	
	
}
