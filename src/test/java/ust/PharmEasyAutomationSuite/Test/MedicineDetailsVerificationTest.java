package ust.PharmEasyAutomationSuite.Test;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.PageObject.MedicineDetailPom;
import ust.PharmEasyAutomationSuite.PageObject.PharmEasySearchPom;

public class MedicineDetailsVerificationTest {
    WebDriver driver;
    ReusableFunctions rf;
    PharmEasySearchPom searchPom;
    MedicineDetailPom medPom;
    String medName = "Dolo 650mg Strip Of 15 Tablets";

    @BeforeClass
    public void invokeBrowser() {
        // Invoke the browser and open the website
        driver = ReusableFunctions.invokeBrowser();
        rf = new ReusableFunctions(driver);
        rf.openWebsite("url");
        searchPom = new PharmEasySearchPom(driver);
    }

    @Test(priority = 1)
    public void validateWebsiteURL() {
        // Verify if the website URL matches the expected URL
        assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("url"));
    }

    @Test(priority = 2)
    public void testSearchAndSelectProduct() {
        // Perform a search and verify if the correct results are displayed
        searchPom.searchElemnt();
        assertEquals(searchPom.search(medName), "Showing all results for " + medName);
        medPom = new MedicineDetailPom(driver);
    }
    
    @Test(priority = 3)
    public void testProducts() {
        // Perform a search and verify if the correct results are displayed
       medPom.allmedDetails();
    }
//
//    @Test(priority = 3)
//    public void testSelectMedicineAndVerifyTitle() {
//        // Select a medicine and verify if the correct medicine details page is opened
//        // Verify if the selected medicine name matches the expected medicine name
//        assertEquals(medPom.chooseMed(), medName,
//                "Selected medicine name does not match the expected name: " + medName);
//    }
//
//    @Test(priority = 4)
//    public void testVerifyMedicineImage() {
//        // Verify if the medicine image is displayed
//        assertTrue(medPom.isMedicineImageDisplayed(), "Medicine image is not displayed");
//    }
//
//    @Test(priority = 5)
//    public void testVerifyLabName() {
//        // Verify if the lab name is displayed
//        assertTrue(medPom.isLabNameDisplayed(), "Lab name is not displayed");
//    }
//
//    @Test(priority = 6)
//    public void testVerifyMRP() {
//        // Verify if the MRP is displayed
//        assertTrue(medPom.isMRPDisplayed(), "MRP is not displayed");
//    }
//
//    @Test(priority = 7)
//    public void testVerifyOfferMRP() {
//        // Verify if the offer MRP is displayed
//        assertTrue(medPom.isOfferMRPDisplayed(), "Offer MRP is not displayed");
//    }
//
//    @Test(priority = 8)
//    public void testVerifyAddToCartButton() {
//        // Verify if the Add to Cart button is displayed
//        assertTrue(medPom.isAddToCartButtonDisplayed(), "Add to Cart button is not displayed");
//    }
}
