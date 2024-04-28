package ust.PharmEasyAutomationSuite.PageObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class MedicineDetailPom {
	private final WebDriver driver;
	private final ReusableFunctions rf;

	// Constructor to initialize WebDriver and ReusableFunctions
	public MedicineDetailPom(WebDriver driver) {
		this.driver = driver;
		this.rf = new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
	}

	// Web elements using @FindBy annotations
	@FindBy(tagName = "h1")
	private List<WebElement> medList;

	@FindBy(tagName = "h1")
	private WebElement medNameElement;

	@FindBy(xpath = "(//h1)[1]")
	private WebElement firstMedElement;

	@FindBy(xpath = "//img[@alt='img']")
	private WebElement imgElement;

	@FindBy(xpath = "//h1[@class=\"MedicineOverviewSection_medicineName__dHDQi\"]")
	private WebElement medTitleElement;

	@FindBy(className = "MedicineOverviewSection_brandName__rJFzE")
	private WebElement labNameElement;

	@FindBy(className = "PriceInfo_striked__Hk2U_")
	private WebElement priceElement;

	@FindBy(className = "PriceInfo_gcdDiscountPercent__xhETH")
	private WebElement offerElement;

	@FindBy(xpath = "//button[contains(text(), 'Add To Cart')]")
	private WebElement addToCartButton;

	// Method to get the text of the medicine name element
	private String getMedName() {
		return rf.ReturnGetText(medNameElement);
	}

	// Method to check if all details of all medicines are displayed
	public boolean allMedDetails() {
		int totalMedElements = driver.findElements(By.tagName("h1")).size();
		System.out.println("Total medicine elements: " + totalMedElements);

		// Create a list to store the details of unavailable elements
		List<String> unavailableElements = new ArrayList<>();

		// Check if no medicine elements found
		if (totalMedElements == 0) {
			System.out.println("No medicine elements found.");
			return false;
		}

		// Iterate through the list of medicine elements
		for (int i = 1; i <= totalMedElements; i++) {
			// Click on the medicine element
			WebElement medElement = driver.findElement(By.xpath("(//h1)[" + i + "]"));
			rf.clickOnElement(medElement);

			// Perform the checking for medicine details
			boolean isImageDisplayed = false;
			boolean isLabNameDisplayed = false;
			boolean isMRPDisplayed = false;
			boolean isOfferMRPDisplayed = false;
			boolean isAddToCartButtonDisplayed = false;

			// Check if other elements are present
			if (isImageDisplayed) {
				try {
					isImageDisplayed = isMedicineImageDisplayed();
					isLabNameDisplayed = isLabNameDisplayed();
					isMRPDisplayed = isMRPDisplayed();
					isOfferMRPDisplayed = isOfferMRPDisplayed();
					isAddToCartButtonDisplayed = isAddToCartButtonDisplayed();
				} catch (NoSuchElementException e) {
					// Handle NoSuchElementException
					String errorMessage = "Some details not found for " + getMedName() + "\n";
					unavailableElements.add(errorMessage);
				}
			}

			// Check if any detail is not displayed
			if (!isImageDisplayed || !isLabNameDisplayed || !isMRPDisplayed || !isOfferMRPDisplayed
					|| !isAddToCartButtonDisplayed) {
				String unavailableElementDetails = "Medicine Details for " + getMedName() + ":\n";
				unavailableElementDetails += "Medicine Image Displayed: " + isImageDisplayed + "\n";
				unavailableElementDetails += "Lab Name Displayed: " + isLabNameDisplayed + "\n";
				unavailableElementDetails += "MRP Displayed: " + isMRPDisplayed + "\n";
				unavailableElementDetails += "Offer MRP Displayed: " + isOfferMRPDisplayed + "\n";
				unavailableElementDetails += "Add To Cart Button Displayed: " + isAddToCartButtonDisplayed + "\n\n";
				unavailableElements.add(unavailableElementDetails);
			}

			// Navigate back to the previous page
			driver.navigate().back();
		}

		// Write the details of unavailable elements to log.txt
		if (!unavailableElements.isEmpty()) {
			if (writeLogToFile(unavailableElements)) {
				return true;
			} else {
				System.out.println("Failed to create log file!");
			}
		}

		return false;
	}

	// Method to check if the medicine image is displayed
	private boolean isMedicineImageDisplayed() {
		try {
			return imgElement.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// Method to check if the lab name is displayed
	private boolean isLabNameDisplayed() {
		return labNameElement.isDisplayed();
	}

	// Method to check if the MRP is displayed
	private boolean isMRPDisplayed() {
		return priceElement.isDisplayed();
	}

	// Method to check if the offer MRP is displayed
	private boolean isOfferMRPDisplayed() {
		return offerElement.isDisplayed();
	}

	// Method to check if the Add To Cart button is displayed
	private boolean isAddToCartButtonDisplayed() {
		return addToCartButton.isDisplayed();
	}

	// Method to write the details of unavailable elements to log.txt
	private boolean writeLogToFile(List<String> unavailableElements) {
		try {
			FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/log/MedicineDetailsLog.txt");
			writer.write("Details of Unavailable Elements:\n\n");
			for (String details : unavailableElements) {
				writer.write(details);
			}
			writer.close();
			System.out.println("Log file 'MedicineDetailsLog.txt' created successfully!");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
