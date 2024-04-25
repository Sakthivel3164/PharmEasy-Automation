package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class MedicineDetailsVerificationTest {
	WebDriver driver;
	ReusableFunctions rf;
//	MedicineDetailPom

	@BeforeClass
	public void invokeBrowser() {

		driver = ReusableFunctions.invokeBrowser();
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
	}

	@Test(priority = 1)
	public void validateWebsiteURL() {
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("url"));
	}

	@Test(priority = 2)
	private void testSearchOptionPresence() {
//		assertTrue(searchPage.isSearchOptionPresent());
	}
}