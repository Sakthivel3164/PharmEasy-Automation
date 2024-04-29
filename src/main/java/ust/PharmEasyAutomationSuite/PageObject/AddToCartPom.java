package ust.PharmEasyAutomationSuite.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.DynamicLocaters;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class AddToCartPom extends DynamicLocaters{
	WebDriver driver;
	ReusableFunctions rf;
	@FindBy(xpath = "//div[@class=\"c-PJLV c-bXbWpx c-bXbWpx-icOztnM-css\"]")
	WebElement searchBar;
	@FindBy(id = "topBarInput")
	WebElement searchBarElement;
	@FindBy(className = "Search_searchHeading__DWX9l")
	WebElement resultTitleElement;
	@FindBy(css = "div[class='LHS_container__mrQkM Search_fullWidthLHS__mteti']>div:nth-child(2)>div>div>a>div:nth-child(2)>div>div:nth-child(4)>div>div:last-child>div>div>div>div>button")
	WebElement addtoCartbuttonElement;

	@FindBy(className = "Navigation_notificationCountBubble__G4f_P")
	WebElement cartcountElement;

	public AddToCartPom(WebDriver driver) {
		this.driver = driver;
		this.rf = new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
	}

	public String search(String med) {
		rf.clickOnElement(searchBar);
		rf.setTextToInputFieldandEnter(searchBarElement, med);
		return rf.ReturnGetText(resultTitleElement);
	}

	public String addMed(String string) {
		rf.clickOnElement(addtoCartbuttonElement);
		rf.clickOnElement(addCountElement(driver, string));
		return rf.ReturnGetText(cartcountElement);//returning cart count eg.3
	}

	
}
