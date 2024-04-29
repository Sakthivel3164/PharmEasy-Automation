package ust.PharmEasyAutomationSuite.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class ElderlyCarePom {
	WebDriver driver;
	WebDriverWait wait;
	ReusableFunctions rf;

	public ElderlyCarePom(WebDriver driver, ReusableFunctions rf) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.rf = rf;

	}

//	page heading
	@FindBy(className = "HeadingBarWithSorter_categoryName__HDGVi")
	WebElement heading;
	
//	sort by option
	@FindBy(className = "MuiInput-formControl")
	WebElement sortByOption;
	

//	check if page heading is displayed
	public boolean isPageHeadingDisplayed() {
		return heading.isDisplayed();
	}
	public void clickSortBy()
	{
		rf.clickOnElement(sortByOption);
	}

}
