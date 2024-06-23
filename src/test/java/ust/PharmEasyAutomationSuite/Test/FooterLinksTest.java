package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ExcelHandling;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.PageObject.HomePagePom;

public class FooterLinksTest {

	WebDriver driver;
	ReusableFunctions rf;
	HomePagePom homePagePom;

	@BeforeClass
	public void invokeBrowser() {

		driver = ReusableFunctions.invokeBrowser();
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
		homePagePom = new HomePagePom(driver, rf);

	}

//	to get data from excel
	@DataProvider(name = "footerLinks")
	public String[][] getValidData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/pharmEasy.xlsx";
		String sheetName = "LinkText";
		return ExcelHandling.getExcelData(path, sheetName);
	}

/*
 * 
 */
	@Test(dataProvider = "footerLinks")
	public void testFooterLinks(String linkText,String links) {
		assertTrue(homePagePom.clickLinksOnFooter(linkText,links));
	}
	
//	passing path to screenshot method in reusable function
	@AfterMethod
	public void takeScreenshot() {
		rf.takeScreenShot(System.getProperty("user.dir") + "//screenshot");
	}
}
