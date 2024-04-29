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
	@FindBy(xpath = "//div[@class='c-PJLV c-bXbWpx c-bXbWpx-icBTies-css']")
	List<WebElement> nosuggestionElements;
	@FindBy(className ="Search_searchHeading__DWX9l")
	WebElement resultTitleElement;
	
	

	public boolean searchElemnt() {
		rf.clickOnElement(searchButton);
		return (searchBarElement != null && searchButton != null);
	}

	public boolean search(String partialValue, String result) {
		rf.setTextToInputField(searchBarElement, partialValue);
		rf.takeADelay(3);
		return suggestionElements.stream().map(WebElement::getText).anyMatch(text -> text.equals(result));
	}
	
	public String search(String med) {
		rf.setTextToInputFieldandEnter(searchBarElement, med);
		return rf.ReturnGetText(resultTitleElement);
	}

	public boolean randomInput(String string) {
	    rf.setTextToInputField(searchBarElement, string);
	    rf.takeADelay(3);
	    return suggestionElements.size() > 1;
	}

	public boolean emptyInput(String result) {
		rf.refresh();
		rf.clickOnElement(searchButton);
		rf.takeADelay(3);
		return nosuggestionElements.stream().map(WebElement::getText).anyMatch(text -> text.equals(result));	}

}
