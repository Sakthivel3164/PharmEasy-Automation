package ust.PharmEasyAutomationSuite.PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.DynamicLocaters;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class AddToCartPom{
	WebDriver driver;
	ReusableFunctions rf;
	List<String> medDetailList=new ArrayList<String>();//to store the med details

	// WebElements
	@FindBy(xpath = "//div[@class=\"c-PJLV c-bXbWpx c-bXbWpx-icOztnM-css\"]")
	WebElement searchBar;
	@FindBy(id = "topBarInput")
	WebElement searchBarElement;
	@FindBy(className = "Search_searchHeading__DWX9l")
	WebElement resultTitleElement;
	@FindBy(xpath = "(//button[contains(@class, 'Button_container__okgob')])[1]")
	WebElement addtoCartbuttonElements;
	@FindBy(xpath = "//li[@data-value='5']")
	WebElement medQuantityElement;
	@FindBy(className = "Navigation_notificationCountBubble__G4f_P")
	WebElement cartcountElement;
	@FindBy(xpath = "//div[contains(@class, 'QuantitySelector_selectStyle__Ts3i3')]")
	WebElement qty5Element;
	@FindBy(xpath = "//li[@data-value='0']")
	WebElement removeItem;
	@FindBy(className = "CartStatusTile_desktopMessage__QwTIf")
	WebElement qntyTextDisplayElement;
	@FindBy(className = "PEToast_messageWrapper__jvsqE")
	WebElement toastElement;
	@FindBy(xpath = "//span[@class='Navigation_linkText__TfNW4' and text()='Cart']")
	WebElement headerCartElement;
	@FindBy(xpath = "//span[ text()='View Cart']")
	WebElement bodyCartElement;
	@FindBy(xpath = "//span[text()='0 Items in your Cart']")
	WebElement emptyTextCartElement;
	@FindBy(xpath = "(//div[@class=\"ProductCard_medicineUnitContentWrapper__8thFe\"])[1]")
	WebElement medDetailsElement;
	
	

	// Constructor
	public AddToCartPom(WebDriver driver) {
		this.driver = driver;
		this.rf = new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
	}

	// Method to search for a medicine
	public String search(String med) {
		rf.clickOnElement(searchBar);
		rf.setTextToInputFieldandEnter(searchBarElement, med);
		return rf.ReturnGetText(resultTitleElement);
	}

	// Method to add a medicine to the cart
	public String addMed() {
		rf.clickOnElement(addtoCartbuttonElements);
		rf.clickOnElement(medQuantityElement);
		return rf.ReturnGetText(cartcountElement); // returning cart count eg.5
	}

	// Method to remove a medicine quantity from the cart
	public String removeQuantity() {
		rf.clickOnElement(qty5Element);
		rf.clickOnElement(removeItem);
		return getCartText();
	}

	// Method to get the text displayed in the cart
	public String getCartText() {
		return rf.ReturnGetText(qntyTextDisplayElement);
	}

	public String testToastMessage() {
		return rf.ReturnGetText(toastElement);
	}

	public boolean isHeaderAddToCartButtonAvailableAndClickable() {
		return rf.isDisplayed(headerCartElement) && rf.isEnabled(headerCartElement);
	}

	public boolean isBodyAddToCartButtonAvailableAndClickable() {
//		addMed();
		return rf.isDisplayed(bodyCartElement) && rf.isEnabled(bodyCartElement);
	}

	
	public String headerCart() {
		removeQuantity();
		rf.clickOnElement(headerCartElement);
		return rf.ReturnGetText(emptyTextCartElement);
	}

	public CartPagePom cartDetails() {
		addMed();
		rf.takeADelay(1);
		rf.clickOnElement(headerCartElement);
		return new CartPagePom(driver,rf);
	}

	public void storeDetails() {
		System.out.println(rf.ReturnGetText(medDetailsElement));
	}
	
	
}
