package ust.PharmEasyAutomationSuite.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class sapmle {

	WebDriver driver;
	ReusableFunctions rf;
	
	@BeforeClass
	public void invokeBrowser(String brwoser) {

		driver = ReusableFunctions.invokeBrowser();
//		driver = DriverSetup.browserSetup(brwoser);
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
	}


	
	
}
