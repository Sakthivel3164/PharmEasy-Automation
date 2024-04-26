package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.PageObject.PharmEasySearchPom;

public class PharmacySearchTest {
	WebDriver driver;
	ReusableFunctions rf;
	PharmEasySearchPom searchPom;

	@BeforeClass
	public void invokeBrowser() {

		driver = ReusableFunctions.invokeBrowser();
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
		searchPom = new PharmEasySearchPom(driver);
	}

	@Test(priority = 1)
	public void testWebsiteURLandNavbar() {
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("url"));
	}

	@Test(priority = 2)
	public void testSearchOptionIsAvailable() {
		assertTrue(searchPom.isSearchOptionAvailable(), "Search option is not available");
	}

	@Test(priority = 3)
	public void testSearchSuggestions() {
		assertTrue(searchPom.searchSuggestion("Dolo", "Dolo 650mg Strip Of 15 Tablets"));
	}

}
