package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.PageObject.AddToCartPom;

/**
 * Test class to verify Add to Cart functionality.
 */
public class AddToCartTest {
	WebDriver driver;
	ReusableFunctions rf;
	AddToCartPom addToCartPom;

	/**
	 * Method to set up the test environment.
	 */
	@BeforeClass
	public void setUp() {
		// Initialize WebDriver, ReusableFunctions, and AddToCartPom
		driver = ReusableFunctions.invokeBrowser();
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
		addToCartPom = new AddToCartPom(driver);
	}

	/**
	 * Test to verify the website URL.
	 */
	@Test(priority = 1)
	public void verifyWebsiteURL() {
		Assert.assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("url"));
	}

	/**
	 * Test to search for a product and select it.
	 */
	@Test(priority = 2)
	public void searchAndSelectProduct() {
		String medName = "Dolo 650mg Strip Of 15 Tablets";
		Assert.assertEquals(addToCartPom.search(medName), "Showing all results for " + medName);
	}

	/**
	 * Test to add a product to the cart and verify the toast message.
	 */
	@Test(priority = 3)
	public void testAddToCartAndVerifyAddToast() {
		Assert.assertEquals(addToCartPom.addMed(), "5"); // test with quantity 5
		Assert.assertEquals(addToCartPom.testToastMessage(), "Added to your cart");
	}

	/**
	 * Test to verify the text displayed in the cart.
	 */
	@Test(priority = 4)
	public void verifyCartItemText() {
		Assert.assertEquals(addToCartPom.getCartText(), "5 Items in Cart");
	}

	/**
	 * Test to remove a product from the cart and verify the toast message.
	 */
	@Test(priority = 5)
	public void testRemoveItemAndVerifyRemoveToast() {
		Assert.assertEquals(addToCartPom.removeQuantity(), "Please add item(s) to proceed");
		Assert.assertEquals(addToCartPom.testToastMessage(), "Removed from your cart");
	}

	/**
	 * Test to add a product to the cart again and verify the updated toast message.
	 */
	@Test(priority = 6)
	public void testAddToCartAndUpdateToast() {
		Assert.assertEquals(addToCartPom.addMed(), "5"); // test with quantity 5
		Assert.assertEquals(addToCartPom.testToastMessage(), "Updated in your cart");
	}
	
	 @Test(priority = 7)
	    public void testAddToCartButtonsAvailability() {
	        Assert.assertTrue(addToCartPom.isHeaderAddToCartButtonAvailableAndClickable(), "Header Add to Cart button is not available or clickable");
	        Assert.assertTrue(addToCartPom.isHeaderAddToCartButtonAvailableAndClickable(), "Body Add to Cart button is not available or clickable");
	    }
	@Test(priority = 8)
	public void testCartWithEmptyItem()
	{
		assertEquals(addToCartPom.HeaderCart(),"0 Items in your Cart");
		driver.navigate().back();
	}
}
