package ust.PharmEasyAutomationSuite.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class LabTestCartPom {
	WebDriver driver;
	WebDriverWait wait;
	ReusableFunctions rf;

	public LabTestCartPom(WebDriver driver, ReusableFunctions rf) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.rf = rf;

	}

//	labtest cart heading
	@FindBy(id = "cart-labStrip-title")
	WebElement labTestHeading;

//	test title
	@FindBy(id = "cart-card-0-title")
	WebElement testTitle;

//	number of patients
	@FindBy(xpath = "//p[@class='sc-446652e5-6 iriSoZ']")
	WebElement noOfPatients;

//	test price
	@FindBy(id = "cart-card-0-price")
	WebElement testPrice;

//	order total test price
	@FindBy(id = "cart-summary-orderTotal-value")
	WebElement orderTotal;

	public String getTestTitle() {
		return rf.ReturnGetText(testTitle);
	}

	public String getNoOfPatients() {
		return rf.ReturnGetText(noOfPatients);
	}

	public String getCartPageHeading() {
		return rf.ReturnGetText(labTestHeading);
	}

	public boolean compareTestPriceAndOrderTotal() {
		return testPrice.getText().equals(orderTotal.getText().split("\\.")[0]);
	}

}
