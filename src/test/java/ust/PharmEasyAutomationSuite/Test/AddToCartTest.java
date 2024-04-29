package ust.PharmEasyAutomationSuite.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.PageObject.AddToCartPom;

public class AddToCartTest {
	 WebDriver driver;
	    ReusableFunctions rf;
	    AddToCartPom addTocartPom;
	    @BeforeClass
	    public void setUp() {
	        // Initialize WebDriver, ReusableFunctions, and HeaderPom
	        driver = ReusableFunctions.invokeBrowser();
	        rf = new ReusableFunctions(driver);
	        rf.openWebsite("url");
	        addTocartPom = new AddToCartPom(driver);
	    }
	    @Test(priority = 1)
		public void testWebsiteURL() {
		Assert.assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("url"));
		}
		@Test(priority = 2)
		public void testSearchAndSelectProduct() {
			String medName = "Dolo 650mg Strip Of 15 Tablets";
		  Assert.assertEquals(addTocartPom.search(medName), "Showing all results for " + medName);
		}
		@Test(priority = 3)
		private void testAddToCart() {
			  Assert.assertEquals(addTocartPom.addMed("3"),"3");
		}
		
		@Test(priority = 4)
		private void testRemoveItem() {
			  Assert.assertEquals(addTocartPom.addMed("1"),"0");
		}

		
		
		@Test(priority = 5)
		private void testWithDifferentQuantity() {
			  Assert.assertEquals(addTocartPom.addMed("7"),"7");
		}
	    
		
	    
}
