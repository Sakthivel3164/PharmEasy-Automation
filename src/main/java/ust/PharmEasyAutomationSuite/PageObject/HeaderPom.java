package ust.PharmEasyAutomationSuite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class HeaderPom {
    WebDriver driver;
    ReusableFunctions rf;

    public HeaderPom(WebDriver driver) {
        this.driver = driver;
        this.rf = new ReusableFunctions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='pharmeasy-logo']")
    private WebElement logoImage;

    @FindBy(xpath  = "(//span)[5]")
    private WebElement locationOption;

    @FindBy(linkText  = "Download App")
    private WebElement downloadAppButton;

    @FindBy(xpath = "(//a)[5]")
    private WebElement quickLogin;

    @FindBy(xpath = "(//a)[6]")
    private WebElement pharmeasyOfferLink;

    @FindBy(xpath = "(//a)[7]")
    private WebElement addToCartButton;

    // Method to check if all elements are present
    public boolean areAllElementsPresent() {
        return logoImage.isDisplayed() &&
               locationOption.isDisplayed() &&
               downloadAppButton.isDisplayed() &&
               quickLogin.isDisplayed() &&
               pharmeasyOfferLink.isDisplayed() &&
               addToCartButton.isDisplayed();
    }

    // Method to check if the logo image is clickable
    public boolean isLogoClickable() {
        return logoImage.isEnabled();
    }

    // Method to check if the download app button is clickable
    public boolean isDownloadAppButtonClickable() {
        return downloadAppButton.isEnabled();
    }

    // Method to check if the quick login link is clickable
    public boolean isQuickLoginLinkClickable() {
        return quickLogin.isEnabled();
    }

    // Method to check if the Pharmeasy offer link is clickable
    public boolean isPharmeasyOfferLinkClickable() {
        return pharmeasyOfferLink.isEnabled();
    }

    // Method to check if the add to cart button is clickable
    public boolean isAddToCartButtonClickable() {
        return addToCartButton.isEnabled();
    }
}
