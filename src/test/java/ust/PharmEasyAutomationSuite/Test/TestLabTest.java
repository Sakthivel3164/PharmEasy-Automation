package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ExcelHandling;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.PageObject.LabTestCartPom;
import ust.PharmEasyAutomationSuite.PageObject.LabTestPom;
import ust.PharmEasyAutomationSuite.PageObject.LabTestSearchResultPom;

public class TestLabTest {

	WebDriver driver;
	ReusableFunctions rf;
	LabTestPom labTestPom;
	LabTestSearchResultPom labTestSearchResultPom;
	LabTestCartPom cartPom;

	@BeforeClass
	public void invokeBrowser() {

		driver = ReusableFunctions.invokeBrowser();
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
		labTestPom = new LabTestPom(driver, rf);

	}

//	test the home page is opened	
	@Test(priority = 0)
	public void testUrl() {
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("url"));
	}

	/*
	 * check whether lab test page is opened using the url check whether lab test
	 * nav bar is present
	 */
	@Test(priority = 1)
	public void testClickLabTest() {
		assertTrue(labTestPom.clickLabtest(), "Nav bar in not displayed");
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("labtesturl"));
	}


	/*
	 * after clicking pincode check whether pincode floating window is opened by
	 * validating the text, check button displayed and whether pincode input field
	 * is displayed
	 */
	@Test(priority = 2)
	public void testIsPincodeFloatingWindowDisplayed() {

		assertEquals(labTestPom.clickPinCode(), "Choose your Location");
		assertTrue(labTestPom.isCheckButtonDisplayed());
		assertTrue(labTestPom.isPincodeInputDisplayed());

	}

//	verify the entered pincode and its corresponding loc is displayed properly
	@Test(priority = 3)
	public void testSelectedPincodeAndLocationIsDisplayed() throws InterruptedException {
		assertEquals(labTestPom.enterPincode(), "560002, Bengaluru");
	}

//	to get data from excel
	@DataProvider(name = "searchLabTest")
	public String[][] getValidData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/pharmEasy.xlsx";
		String sheetName = "LabTestInput";
		return ExcelHandling.getExcelData(path, sheetName);
	}

	@Test(priority = 4, dataProvider = "searchLabTest")
	public void testSerachLabTest(String searchInput) {

		labTestSearchResultPom = labTestPom.searchLabTest(searchInput);
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("labtestresulturl"));
		assertTrue(labTestSearchResultPom.isNavbarDisplayed());
	}

//	The method will validate whether patient pop up is displayed or not
//	while clicking book test button
	@Test(priority = 5)
	public void testIsPatientPopupDisplayed() {
		assertTrue(labTestSearchResultPom.clickBookButton());
	}

//	after clicking booktest button, number of patients should be selected
//	validate whether it navigates to test cart page
//	Validate the number of patients,price price test,name of test
	@Test(priority = 6, dataProvider = "searchLabTest")
	public void testAddLabTestToCart(String testTitle) {
		cartPom = labTestSearchResultPom.clickNumberOfPatients();
		assertEquals(cartPom.getCartPageHeading(), "Lab Tests Cart");
		assertEquals(cartPom.getTestTitle(), testTitle);
		assertEquals(cartPom.getNoOfPatients(), "3 patients");
		assertTrue(cartPom.compareTestPriceAndOrderTotal(), "Test Price not equal");

	}

}
