package ust.PharmEasyAutomationSuite.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class LabTestPom {

	WebDriver driver;
	WebDriverWait wait;
	ReusableFunctions rf;
	String price;

	public LabTestPom(WebDriver driver, ReusableFunctions rf) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.rf = rf;

	}

//	Lab test link below the nav bar
	@FindBy(linkText = "Lab Tests")
	WebElement labTest;

//	Lab test page nav bar
	@FindBy(className = "SbvHK")
	WebElement nav;

//	pin code field in labtest page
	@FindBy(className = "_1disc")
	WebElement pincode;

//	Choose your location text in pincode floating window
	@FindBy(className = "_2lVBb")
	WebElement chooseLocText;

//	check button in pincode flaoting window
	@FindBy(xpath = "//button[@class='_2FE4Z _2Jc-Z _2Jc-Z _10CzH _3LBfS']")
	WebElement checkButton;

//	input field for pincode 
	@FindBy(css = "input[type='number']")
	WebElement pincodeInputField;

//	labtest search field
	@FindBy(css = "input[class='jss27 _9Rsw_ undefined _2Saml']")
	WebElement labTestSearchField;

//	labtest search dropdown select
	@FindBy(className = "_1D9rC")
	WebElement searchDropdown;

//	click on lab test link. It will check if lab test nav bar is displayed or not
	public boolean clickLabtest() {
		rf.clickOnElement(labTest);
		rf.waitForElementToDisplay(nav);
		return nav.isDisplayed();
	}

//	click pincode and floating window to enter pincode will be displayed
	public String clickPinCode() {
		rf.clickOnElement(pincode);
		return rf.ReturnGetText(chooseLocText);
	}

//	check button displayed or not
	public boolean isCheckButtonDisplayed() {
		return checkButton.isDisplayed();
	}

//	pincode input field displayed or not
	public boolean isPincodeInputDisplayed() {
		return pincodeInputField.isDisplayed();
	}

//	Enter pincode in pincode input field and click check button
//	The method returns the text of corresponding location and pincode
	public String enterPincode() throws InterruptedException {
		rf.setTextToInputField(pincodeInputField, "560002");
		rf.clickOnElement(checkButton);
		rf.waitForElementToDisplay(pincode);
		Thread.sleep(1000);
		return pincode.getText();
	}

//	search a lab test in the search field and select it from dropdown
	public LabTestSearchResultPom searchLabTest(String searchInput) {
		rf.setTextToInputField(labTestSearchField, searchInput);
		rf.clickOnElement(searchDropdown);
		return new LabTestSearchResultPom(driver, rf);
	}

}
