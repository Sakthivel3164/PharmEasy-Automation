package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.PageObject.ElderlyCarePom;
import ust.PharmEasyAutomationSuite.PageObject.HomePagePom;

public class SortTest {
	WebDriver driver;
	ReusableFunctions rf;
	HomePagePom homePagePom;
	ElderlyCarePom carePom;

	@BeforeClass
	public void invokeBrowser() {

		driver = ReusableFunctions.invokeBrowser();
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
		homePagePom = new HomePagePom(driver, rf);

	}

	@Test(priority = 0)
	public void testIsElderlyCarePageDisplayed() {
		carePom = homePagePom.scrollUp();
		assertTrue(carePom.isPageHeadingDisplayed());
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("elderlycareurl"));

	}

}
