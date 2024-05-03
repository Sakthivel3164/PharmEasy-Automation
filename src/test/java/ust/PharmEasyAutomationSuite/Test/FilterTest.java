package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.PageObject.HomePagePom;
import ust.PharmEasyAutomationSuite.PageObject.SkinCarePom;
import ust.PharmEasyAutomationSuite.exception.MentionedProductCountAndAvailableProductCountNotSameException;

public class FilterTest {
	WebDriver driver;
	ReusableFunctions rf;
	HomePagePom pagePom;
	SkinCarePom carePom;

	@BeforeClass
	public void invokeBrowser() {

		driver = ReusableFunctions.invokeBrowser();
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
		pagePom = new HomePagePom(driver, rf);

	}

	@Test(priority = 0)
	public void test() throws MentionedProductCountAndAvailableProductCountNotSameException {
		carePom = pagePom.clickSkinCare();
		assertTrue(carePom.verifyBrandFilter());

	}
}
