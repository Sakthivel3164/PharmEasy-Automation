package ust.PharmEasyAutomationSuite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class PharmEasySearchPom {
	WebDriver driver;
	ReusableFunctions rf;

	public PharmEasySearchPom(WebDriver driver) {
		this.driver = driver;
		this.rf = new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "topBarInput")
	WebElement searchBarElement;
	@FindBy(css = ".c-kkmdlQ-dWajWX-structure-subTitle1.c-kkmdlQ-ieAinwS-css")
	private WebElement searchButton;

	public boolean isSearchOptionAvailable() {
		return (searchBarElement != null && searchButton != null);
	}

}
