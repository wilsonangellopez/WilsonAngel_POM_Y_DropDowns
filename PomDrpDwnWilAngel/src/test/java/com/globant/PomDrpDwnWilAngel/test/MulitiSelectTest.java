package com.globant.PomDrpDwnWilAngel.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globant.PomDrpDwnWilAngel.pages.MainPage;

public class MulitiSelectTest extends BaseTest{
	
	MainPage mainPage;
	
	
	
	@BeforeTest
	public void setUp() {
		mainPage= new MainPage(driver);
	}
	
	
	
	
	@Parameters({"browser"})
	@Test(dataProvider="myData")
	public void selectOneState(String state) {
		System.out.println("si llego el dato???" + state);
		
		mainPage.selectOneState(state);
	}
	
	@DataProvider(name="myData")
	public Object[][] getData(){
		
		return new Object[][] {{"Texas"}};
	}
	
	@AfterClass
	public void afterClass() {
		//driver.close();
	}

	
	
}
