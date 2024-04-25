package ust.PharmEasyAutomationSuite.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class TestLabTest {

	WebDriver driver;
	ReusableFunctions rf;
	@Test
	@BeforeClass
	public void invokeBrowser() {

		driver = ReusableFunctions.invokeBrowser();
//		driver = DriverSetup.browserSetup(brwoser);
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
	}


	
	
}
