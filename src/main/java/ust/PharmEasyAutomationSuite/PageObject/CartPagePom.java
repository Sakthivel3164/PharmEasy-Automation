package ust.PharmEasyAutomationSuite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class CartPagePom {
     WebDriver driver;
     ReusableFunctions rf;

    // Constructor with WebDriver and ReusableFunctions dependency injection
    public CartPagePom(WebDriver driver, ReusableFunctions rf) {
        this.driver = driver;
        this.rf = rf;
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
    }

    // Locators for elements
    @FindBy(xpath = "//div[text()='Unlock discounts on medicines']")
    private WebElement popUpElement;

    @FindBy(xpath = "//div[@class='ClickableElement_clickable__ItKj2 style_close__F_E37']")
    private WebElement popupCloseButton;

    // Method to handle popup
    public boolean popup() {
        // Check if the popup element is displayed
    	rf.takeADelay(3);
        boolean isPopupDisplayed = rf.isDisplayed(popUpElement);
        System.out.println(popUpElement.getText()); // Print text of popup element
        rf.clickOnElement(popupCloseButton); // Click on the close button of the popup
        return isPopupDisplayed; // Return whether the popup was displayed or not
    }
}
