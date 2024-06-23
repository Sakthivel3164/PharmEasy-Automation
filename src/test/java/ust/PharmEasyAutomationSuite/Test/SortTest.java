package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
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

	@Test(priority = 1)
	public void testIsSortByDropDownDisplayed() {
		assertTrue(carePom.clickSortBy(), "All dropdown elements are not present");
	}

	@Test(priority = 2)
	public void testSortPriceLowToHigh() throws InterruptedException {

//		 clickOnDropdownElements accept index for locating dropdown elements using dynamic xpath

		carePom.clickOnDropdownElements(2);
		assertTrue(carePom.clickPriceLowToHigh());
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("pricelowtohigh"));
	}

	@Test(priority = 3)
	public void testSortPriceHighToLow() throws InterruptedException {
		testIsSortByDropDownDisplayed();
		carePom.clickOnDropdownElements(3);
		assertTrue(carePom.clickPriceHighToLow());
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("pricehightolow"));

	}

	@Test(priority = 4)
	public void testDiscount() throws InterruptedException {
		testIsSortByDropDownDisplayed();
		carePom.clickOnDropdownElements(4);
		assertTrue(carePom.clickDiscount());
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("pricediscount"));

	}
	
//	passing path to screenshot method in reusable function
	@AfterMethod
	public void takeScreenshot() {
		rf.takeScreenShot(System.getProperty("user.dir") + "//screenshot");
	}

}
