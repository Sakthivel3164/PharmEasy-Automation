package ust.PharmEasyAutomationSuite.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class HomePagePom {
	WebDriver driver;
	WebDriverWait wait;
	ReusableFunctions rf;

	public HomePagePom(WebDriver driver, ReusableFunctions rf) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.rf = rf;

	}

//	shop by categories heading
	@FindBy(xpath = "//h2[@class='c-bjPTlu c-bjPTlu-idqwete-css']")
	WebElement shopByCategories;

	@FindBy(xpath = "//div[@class='c-PJLV c-bXbWpx c-bXbWpx-ilbtusb-css']/div/div[@id='cat-2']")
	WebElement elderlyCare;

	public ElderlyCarePom scrollUp() {
		rf.scrollToElement(shopByCategories);
		rf.clickOnElement(elderlyCare);
		return new ElderlyCarePom(driver, rf);
		
	}

}
