package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class AboutUsPagePom {
	WebDriver driver;
	ReusableFunctions rf;

	// creating constructor
	public AboutUsPagePom(WebDriver driver, ReusableFunctions rf) {
		this.driver = driver;
		this.rf = rf;
		PageFactory.initElements(driver, this);

	}

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


}
