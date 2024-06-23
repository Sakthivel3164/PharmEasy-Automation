package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.PageObject.HomePagePom;
import ust.PharmEasyAutomationSuite.PageObject.SkinCarePom;
import ust.PharmEasyAutomationSuite.exception.MentionedProductCountAndAvailableProductCountNotSameException;

public class FilterTest {
	WebDriver driver;
	ReusableFunctions rf;
	HomePagePom pagePom;
	SkinCarePom carePom;
	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void invokeBrowser() {

		driver = ReusableFunctions.invokeBrowser();
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
		pagePom = new HomePagePom(driver, rf);

	}

//	@BeforeClass
//	public void startReport() {
//		reports = ReusableFunctions.generateReport("ExtendReport.html");
//	}
//
//	@AfterMethod
//	public void getTestResult(ITestResult result) {
//		rf.getTestResult(result, test);
//	}

	@Test
	public void testFilter() throws MentionedProductCountAndAvailableProductCountNotSameException {
//		test = reports.createTest("Filter test");
		carePom = pagePom.clickSkinCare();
		assertTrue(carePom.verifyBrandFilter());

	}

//	passing path to screenshot method in reusable function
	@AfterMethod
	public void takeScreenshot() {
		rf.takeScreenShot(System.getProperty("user.dir") + "//screenshot");
	}
}
