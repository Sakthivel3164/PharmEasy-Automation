package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.PageObject.HeaderPom;

public class HeaderTest {
    WebDriver driver;
    ReusableFunctions rf;
    HeaderPom headerPom;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver, ReusableFunctions, and HeaderPom
        driver = ReusableFunctions.invokeBrowser();
        rf = new ReusableFunctions(driver);
        rf.openWebsite("url");
        headerPom = new HeaderPom(driver);
    }

    @Test(priority = 1, description = "Verify website URL")
    public void testWebsiteURL() {
        // Verify the current URL matches the expected URL
        assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("url"));
    }
    
    @Test(priority = 2, description = "Verify presence of all header elements")
    public void testAllElementsPresence() {
    	rf.takeADelay(3);
        // Verify if all header elements are present
        assertTrue(headerPom.areAllElementsPresent(), "Not all header elements are present");
    }

    @Test(priority = 3, description = "Verify logo is clickable")
    public void testLogoClickable() {
        // Verify if the logo is clickable
        assertTrue(headerPom.isLogoClickable(), "Logo is not clickable");
    }

    @Test(priority = 4, description = "Verify Download App button is clickable")
    public void testDownloadAppButtonClickable() {
        // Verify if the Download App button is clickable
        assertTrue(headerPom.isDownloadAppButtonClickable(), "Download app button is not clickable");
    }

    @Test(priority = 5, description = "Verify Quick Login link is clickable")
    public void testQuickLoginLinkClickable() {
        // Verify if the Quick Login link is clickable
        assertTrue(headerPom.isQuickLoginLinkClickable(), "Quick login link is not clickable");
    }

    @Test(priority = 6, description = "Verify Pharmeasy Offer link is clickable")
    public void testPharmeasyOfferLinkClickable() {
        // Verify if the Pharmeasy Offer link is clickable
        assertTrue(headerPom.isPharmeasyOfferLinkClickable(), "Pharmeasy offer link is not clickable");
    }

    @Test(priority = 7, description = "Verify Add To Cart button is clickable")
    public void testAddToCartButtonClickable() {
        // Verify if the Add To Cart button is clickable
        assertTrue(headerPom.isAddToCartButtonClickable(), "Add to cart button is not clickable");
    }

    // Add other test methods for functionality, accessibility, etc.

    @AfterClass
    public void tearDown() {
        // Close the browser after all tests
        driver.quit();
    }
}
