package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class PriceValidationPOM {
	WebDriver driver;
	ReusableFunctions rf;

	// creating constructer
	public PriceValidationPOM(WebDriver driver) {
		this.driver = driver;
		this.rf = new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Value Store")
	WebElement valueStorElement;
	@FindBy(xpath = "//h1")
	WebElement valueStoreTitlElement;
	

	public void valueStore() {
		rf.clickOnElement(valueStorElement);
	}

	public String valueStoreTitle() {
	return	rf.ReturnGetText(valueStoreTitlElement);
	}

	public void scrollToPrice() {
		
	}

}
