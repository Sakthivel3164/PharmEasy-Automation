package ust.PharmEasyAutomationSuite.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.PageObject.AddToCartPom;
import ust.PharmEasyAutomationSuite.PageObject.CartPagePom;

public class AddToCartTest {
	WebDriver driver;
	ReusableFunctions rf;
	AddToCartPom addToCartPom;
	CartPagePom cartPom;

	@BeforeClass
	public void setUp() {
		// Initialize WebDriver, ReusableFunctions, and Page Objects
		driver = ReusableFunctions.invokeBrowser();
		rf = new ReusableFunctions(driver);
		rf.openWebsite("url");
		addToCartPom = new AddToCartPom(driver);
	}
	

	@Test(priority = 1)
	public void verifyWebsiteURL() {
		// Verify that the current URL matches the expected URL
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("url"));
	}

	@Test(priority = 2)
	public void searchAndSelectProduct() {
		// Search for a product and verify the search result
		String medName = "Dolo 650mg Strip Of 15 Tablets";
		assertEquals(addToCartPom.search(medName), "Showing all results for " + medName);
	}

	@Test(priority = 3)
	public void addToCartAndVerifyAddToast() {
		// Add a product to the cart and verify the toast message
		assertEquals(addToCartPom.addMed(), "5");
		assertEquals(addToCartPom.testToastMessage(), "Added to your cart");
	}

	@Test(priority = 4)
	public void verifyCartItemText() {
		// Verify the text displayed in the cart
		assertEquals(addToCartPom.getCartText(), "5 Items in Cart");
	}

	@Test(priority = 5)
	public void removeItemAndVerifyRemoveToast() {
		// Remove a product from the cart and verify the toast message
		assertEquals(addToCartPom.removeQuantity(), "Please add item(s) to proceed");
		assertEquals(addToCartPom.testToastMessage(), "Removed from your cart");
	}

	@Test(priority = 6)
	public void addToCartAndUpdateToast() {
		// Add a product to the cart again and verify the updated toast message
		assertEquals(addToCartPom.addMed(), "5");
		assertEquals(addToCartPom.testToastMessage(), "Updated in your cart");
	}

	@Test(priority = 7)
	public void testAddToCartButtonsAvailability() {
		// Test the availability and clickability of both "Add to Cart" buttons
		assertTrue(addToCartPom.isHeaderAddToCartButtonAvailableAndClickable());
		assertTrue(addToCartPom.isBodyAddToCartButtonAvailableAndClickable());
	}

	@Test(priority = 8)
	public void testCartWithEmptyItem() {
		// Test the cart with an empty item and navigate back
		assertEquals(addToCartPom.headerCart(), "0 Items in your Cart");
		driver.navigate().back();
	}

	@Test(priority = 9)
	public void testStoreMedDetails() {
		addToCartPom.storeDetails();

	}

	
	@Test(priority = 10)
	public void testCartURL() {
		// Initialize CartPagePom object before accessing its methods
		cartPom = new CartPagePom(driver, rf);
		// Retrieve the cart details
		addToCartPom.cartDetails();
		// Verify the URL of the cart page
		assertEquals(rf.getPropertyValue("cartUrl"), driver.getCurrentUrl());
	}

	@Test(priority = 11)
	public void testDiscountPopup() {
		// Test the cart URL by verifying the URL of the cart page
		assertTrue(cartPom.popup());
	}

}
