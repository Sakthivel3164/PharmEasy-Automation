package ust.PharmEasyAutomationSuite.Test;

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

	@Test
	public void test() throws MentionedProductCountAndAvailableProductCountNotSameException {
		carePom = pagePom.clickSkinCare();
		carePom.click();
	}
}
