package ust.PharmEasyAutomationSuite.PageObject;

import java.util.List;

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
	@FindBy(xpath = "//span[contains(@class, 'c-kkmdlQ-igObevR-css')]")
	List<WebElement> suggestionElements;

	public boolean isSearchOptionAvailable() {
		rf.clickOnElement(searchButton);
		return (searchBarElement != null && searchButton != null);
	}

	public boolean searchSuggestion(String partialValue, String result) {
	    rf.setTextToInputField(searchBarElement, partialValue);
	    rf.takeADelay(3);
	    return suggestionElements.stream()
	            .map(WebElement::getText)
	            .anyMatch(text -> text.equals(result));
	}
}
