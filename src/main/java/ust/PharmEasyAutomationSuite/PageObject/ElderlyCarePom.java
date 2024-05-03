package ust.PharmEasyAutomationSuite.PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ust.PharmEasyAutomationSuite.Base.DynamicLocaters;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class ElderlyCarePom extends DynamicLocaters {
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

//	List of prices of medicines
	@FindBy(xpath = "//span[@class='ProductCard_salePrice__iLWF7 ProductCard_otcListingSalePrice__x8Y_C']")
	List<WebElement> prices;

	@FindBy(xpath = "//h2")
	WebElement footer;

//	view more button on left side 
	@FindBy(xpath = "//div[contains(text(),'Price')]")
	WebElement priceHeading;

//	discount
	@FindBy(className = "ProductCard_discountPercent__hcWbO")
	List<WebElement> discount;

//	check if page heading is displayed
	public boolean isPageHeadingDisplayed() {
		return heading.isDisplayed();
	}

	/*
	 * click on sortby button. dropdown with 4options are there the four options
	 * will be stored in list 'options' list 'actual contains actual values of
	 * dropdown so both list are compared to check whether elements are present
	 */
	public boolean clickSortBy() {
		rf.clickOnElement(sortByOption);
		List<String> options = new ArrayList<String>();
//		sortByText is a method in Dynamic locators class which returns elements using dynamic xpath
//		this class inherits dynamic locator classF
		options.add(sortByText(driver, 1));
		options.add(sortByText(driver, 2));
		options.add(sortByText(driver, 3));
		options.add(sortByText(driver, 4));

		String[] arr = { "Popularity", "Price low to high", "Price high to low", "Discount" };
		List<String> actual = Arrays.asList(arr);
		return actual.equals(options);

	}

	/*
	 * click elements in dropdown according to the index It is done using dynamic
	 * xpath index 2 - price low to high index 3 - price high to low index 4 - price
	 * discount
	 */
	public void clickOnDropdownElements(int index) throws InterruptedException {
		rf.clickOnElement(sortByDropDown(driver, index));
		Thread.sleep(2000);
		rf.scrollByPixel(0, 2600);
		Thread.sleep(4000);
	}

	/*
	 * click price low to high in sort by dropdown webelements prices will be stored
	 * in a list prices will be compared whether it is ordered in ascending order or
	 * not
	 * 
	 */
	public boolean clickPriceLowToHigh() {

		List<String> priceList = new ArrayList<String>();

		int flag = 0;

		for (WebElement e : prices) {
			priceList.add(e.getText().split("₹")[1]);
		}
		for (int i = 0; i < priceList.size() - 1; i++) {
			if (priceList.size() != 0)
				flag = 1;
			if (Double.parseDouble(priceList.get(i)) > Double.parseDouble(priceList.get(i + 1))) {
				flag = -1;
				break;

			}

			rf.scrollByPixel(0, -2600);

		}
		return flag == 1;
	}

	/*
	 * click price low to high in sort by dropdown webelements prices will be stored
	 * in a list prices will be compared whether it is ordered in descending order
	 * or not
	 * 
	 */
	public boolean clickPriceHighToLow() throws InterruptedException {

		List<String> priceList = new ArrayList<String>();
		int flag = 0;

		for (WebElement e : prices) {
			priceList.add(e.getText().split("₹")[1]);
		}
		for (int i = 0; i < priceList.size() - 1; i++) {
			if (priceList.size() != 0)
				flag = 1;
			if (Double.parseDouble(priceList.get(i)) < Double.parseDouble(priceList.get(i + 1))) {
				flag = -1;
			}

		}
		rf.scrollByPixel(0, -2600);
		return flag == 1;

	}

	/*
	 * click discount in sort by dropdown webelements prices will be stored in a
	 * list prices will be compared whether it is ordered in descending order or not
	 * 
	 */
	public boolean clickDiscount() throws InterruptedException {

		List<String> discountList = new ArrayList<String>();
		int flag = 0;

		for (WebElement e : discount) {
			discountList.add(e.getText().split("%")[0]);
		}
		for (int i = 0; i < discountList.size() - 1; i++) {
			if (discountList.size() != 0)
				flag = 1;
			if (Double.parseDouble(discountList.get(i)) < Double.parseDouble(discountList.get(i + 1))) {
				flag = -1;
			}

		}
		rf.scrollByPixel(0, -2600);
		return flag == 1;

	}

}
