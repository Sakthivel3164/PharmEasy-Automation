package ust.PharmEasyAutomationSuite.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class LabTestSearchResultPom {
	WebDriver driver;
	WebDriverWait wait;
	ReusableFunctions rf;

	public LabTestSearchResultPom(WebDriver driver, ReusableFunctions rf) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.rf = rf;

	}

//	labtest name
	@FindBy(id = "test-name-pdp")
	WebElement testName;

//	Nav bar
	@FindBy(xpath = "//div[@class='sc-f32db17d-0 sc-f93c7f36-1 sc-cdc5aa74-6 cXEndW drwycA jTblsw']")
	WebElement navbar;

//	Book test button
	@FindBy(id = "book-test-btn-pdp")
	WebElement bookTestButton;

//	select no of patients 
	@FindBy(id = "patient-3")
	WebElement noOfPatients;

//	single patient test price
	@FindBy(id = "item-price-pdp")
	WebElement testPricePerPerson;

//	no of patients popup box
	@FindBy(id = "modal")
	WebElement patientPopupBox;

	public boolean isNavbarDisplayed() {
		return navbar.isDisplayed();
	}

//	name of the selected test
	public String getTestName() {
		return rf.ReturnGetText(testName);
	}

//	when we click book button, no of patients pop up box is displayed
	public boolean clickBookButton() {
		rf.clickOnElement(bookTestButton);
		rf.waitForElementToDisplay(patientPopupBox);
		return patientPopupBox.isDisplayed();
	}

//	click on number of patients to book labtest
	public LabTestCartPom clickNumberOfPatients() {
		rf.clickOnElement(noOfPatients);
		return new LabTestCartPom(driver, rf);
	}

}
