package com.globant.PomDrpDwnWilAngel.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.globant.PomDrpDwnWilAngel.utils.MyDriver;

public class BaseTest {
	
	protected MyDriver mydriver;
	protected WebDriver driver;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})	
	public void beforeSuite(String browser) {

		mydriver= new MyDriver(browser);
		driver= mydriver.getDriver();
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
	}
}
