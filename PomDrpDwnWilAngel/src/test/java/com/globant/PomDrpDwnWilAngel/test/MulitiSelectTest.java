package com.globant.PomDrpDwnWilAngel.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globant.PomDrpDwnWilAngel.pages.MainPage;

public class MulitiSelectTest extends BaseTest{
	
	MainPage mainPage;
	
	
	
	
	@Parameters({"browser"})
	@Test()
	public void selectOneState() {
		mainPage.selectOneState();
		
	
	}

	
	
}
