package ust.PharmEasyAutomationSuite.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ust.PharmEasyAutomationSuite.Base.DynamicLocaters;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class HomePagePom extends DynamicLocaters {
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

	@FindBy(xpath = "//div[@class='c-PJLV c-bXbWpx c-bXbWpx-ilbtusb-css']/div/div[@id='cat-6']")
	WebElement skinCare;

	@FindBy(css = "div[id='companyBenefit--We Believe in ‘Simplifying Healthcare, Impacting Lives!’--6']")
	WebElement scroll;
	
	@FindBy(linkText = "Careers")
	WebElement careers;

	public ElderlyCarePom scrollUp() {
		rf.scrollToElement(shopByCategories);
		rf.clickOnElement(elderlyCare);
		return new ElderlyCarePom(driver, rf);

	}

	public SkinCarePom clickSkinCare() {
		rf.scrollToElement(shopByCategories);
		rf.clickOnElement(skinCare);
		return new SkinCarePom(driver, rf);

	}
/*
 * linkText - contains link text of each footer links
 * link - corresponding actual url of the links
 * dynamic xpath is used here to locate each links using link text
 * 
 */
	public boolean clickLinksOnFooter(String linkText,String link) {
		rf.scrollToElement(scroll);
		rf.clickOnElement(footerLinks(driver, linkText));
		boolean flag = driver.getCurrentUrl().equals(link);
		driver.navigate().back();
		return flag;
	}

}
