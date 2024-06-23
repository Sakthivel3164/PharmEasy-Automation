package PageObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.DynamicLocaters;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class PriceValidationPOM {
	WebDriver driver;
	ReusableFunctions rf;

	// creating constructor
	public PriceValidationPOM(WebDriver driver) {
		this.driver = driver;
		this.rf = new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Value Store")
	WebElement valueStorElement;
	@FindBy(xpath = "//h1")
	WebElement valueStoreTitlElement;
	@FindBy(xpath = "(//div[@class=\"FilterSection_heading__0G3io\"])[3]")
	WebElement scrollElement;
	@FindBy(xpath = "(//div[@class=\"FilterSection_heading__0G3io\"])[4]")
	WebElement priceTitlElement;

	public void valueStore() {
		rf.clickOnElement(valueStorElement);
	}

	public String valueStoreTitle() {
		return rf.ReturnGetText(valueStoreTitlElement);
	}

	public void scrollToPrice() {
		rf.scrollToElement(scrollElement);
	}

	public String priceHeading() {
		return rf.ReturnGetText(priceTitlElement);
	}

	public Collection<?> priceRangeOption() {
		List<String> list = new ArrayList<String>();
		for (int i = 5; i < 10; i++) {
			String text = rf.ReturnGetText(DynamicLocaters.filterPrice(driver, i)).split("\\(")[0].trim();
			list.add(text);
		}
		return list;
	}

}
