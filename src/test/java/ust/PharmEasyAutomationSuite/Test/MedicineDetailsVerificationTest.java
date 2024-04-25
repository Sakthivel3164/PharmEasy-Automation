package ust.PharmEasyAutomationSuite.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class MedicineDetailsVerificationTest {
	WebDriver driver;
	ReusableFunctions rf;

	@BeforeClass
	public void invokeBrowser() {

		driver = ReusableFunctions.invokeBrowser();
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
	}
	@Test(priority = 1)
	private void start() {
System.out.println("Website started");
	}
}