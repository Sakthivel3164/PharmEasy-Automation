package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.DynamicLocaters;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class HomePagePom extends DynamicLocaters {
	WebDriver driver;
	ReusableFunctions rf;

	// creating constructor
	public HomePagePom(WebDriver driver, ReusableFunctions rf) {
		this.driver = driver;
		this.rf = rf;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "About Us")
	WebElement aboutUs;

//	2navigation links on top of the nav bar
	@FindBy(css = "div[class='Navigation_lhs__TFpyI']")
	WebElement navigationLinks;

	@FindBy(xpath = "//div[@class='Navigation_lhs__TFpyI']/div[1]")
	WebElement whatAreWe;

	@FindBy(xpath = "//div[@class='Navigation_lhs__TFpyI']/div[2]")
	WebElement coreValues;

	@FindBy(css = "div[class='AboutUs_whatIsPharmeasyWrapper__W0AKc']")
	WebElement whatIsPharmacyWrapper;

	@FindBy(xpath = "//div[@class='AboutUs_values__1drFG']/span/span/img")
	WebElement coreValueImage;

	@FindBy(xpath = "//div[@id='__next']/div[6]")
	WebElement coreValueWrapper;

	public AboutUsPagePom clickAboutUs() {
		rf.scrollByPixel(0, 2100);
		rf.clickOnElement(aboutUs);
		return new AboutUsPagePom(driver, rf);
	}

	public void clickWhatAreWe() {
		System.out.println("clickWhatAreWe");
		rf.takeADelay(3);
		rf.clickOnElement(whatAreWe);
	}

	public boolean isNavigationLinksDisplayed() {
		System.out.println("isNavigationLinksDisplayed");
		return navigationLinks.isDisplayed();
	}

	public boolean isWhatIsPharmacyWrapperDisplayed() {
		System.out.println("Inside isWhat..");
		return whatIsPharmacyWrapper.isDisplayed();
	}

	public void clickOnCoreValues() {
		System.out.println("core values");
		rf.clickOnElement(coreValues);
	}

	public boolean isCoreValueImageDisplayed() {
		return coreValueImage.isDisplayed();
	}

	public boolean isCoreValueWrapperDisplayed() {
		return coreValueWrapper.isDisplayed();
	}
	

//	dynamically click on links on the footer
	public void clickLinksOnFooter(String linkText) {
		
		rf.clickOnElement(footerLinks(driver, linkText));
	}

}
