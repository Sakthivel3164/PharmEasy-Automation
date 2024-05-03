package ust.PharmEasyAutomationSuite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class CartPagePom {
	WebDriver driver;
	ReusableFunctions rf;

	public CartPagePom(WebDriver driver, ReusableFunctions rf) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.rf = rf;
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

}
