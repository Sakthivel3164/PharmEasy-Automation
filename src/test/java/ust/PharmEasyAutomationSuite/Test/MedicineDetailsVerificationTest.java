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
       medPom.allMedDetails();
    }
}