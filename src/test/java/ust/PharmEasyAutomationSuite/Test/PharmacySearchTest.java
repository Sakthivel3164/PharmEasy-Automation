package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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
	public void testWebsiteURL() {
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("url"));
	}

	@Test(priority = 2)
	public void testSearchOptionIsAvailable() {
		assertTrue(searchPom.searchElemnt(), "Search option is not available");
	}

	@Test(priority = 3)
	public void testSearchSuggestions() {
		assertTrue(searchPom.search("Dolo", "Dolo 650mg Strip Of 15 Tablets"));
	}

	@Test(priority = 4)
	public void testSearchSuggestionsForRandomString() {
		assertTrue(searchPom.randomInput("xyz123ABC"), "Expected suggestions to be present for random string query");
	}

	@Test(priority = 5)
	public void testSearchSuggestionsWithSpecialCharacters() {
		assertFalse(searchPom.randomInput("-"), "Expected no suggestions for a query with special characters");
	}

	@Test(priority = 6)
	public void testEmptySearch() {
		assertTrue(searchPom.emptyInput("Frequently Searched Items"),
				"Expected Frequently Searched suggestions for an empty search");
	}

	@Test(priority = 7)
	public void testSearchAndSelectProduct() {
		String medName = "Dolo 650mg Strip Of 15 Tablets";
		assertEquals(searchPom.search(medName), "Showing all results for " + medName);
	}

	@Test(priority = 8)
	public void testURLValidation() {
		// Expected URL to validate against
		String expectedURL = rf.getPropertyValue("url")+"search/all?name=Dolo%20650mg%20Strip%20Of%2015%20Tablets";
		// Get the current URL from the WebDriver
		String currentURL = driver.getCurrentUrl();
		// Assert that the current URL matches the expected URL
		assertEquals(currentURL, expectedURL, "Current URL does not match the expected URL");
	}

}
