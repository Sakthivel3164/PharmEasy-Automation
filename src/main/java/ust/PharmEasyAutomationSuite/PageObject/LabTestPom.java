package ust.PharmEasyAutomationSuite.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class LabTestPom {
	
	WebDriver driver;
	WebDriverWait wait;
	ReusableFunctions rf;

	public LabTestPom(WebDriver driver,ReusableFunctions rf) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.rf = rf;

	}

}
