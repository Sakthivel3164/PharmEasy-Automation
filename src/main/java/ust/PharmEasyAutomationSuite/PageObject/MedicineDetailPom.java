
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
    WebDriver driver;
    ReusableFunctions rf;

    public MedicineDetailPom(WebDriver driver) {
        this.driver = driver;
        this.rf = new ReusableFunctions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    List<WebElement> medList;
    @FindBy(tagName = "h1")
    WebElement mednamElement;
    @FindBy(xpath = "(//h1)[1]")
    WebElement firstmedElement;
    @FindBy(xpath = "//img[@alt='img']")
    WebElement imgElement;
    @FindBy(xpath = "//h1[@class=\"MedicineOverviewSection_medicineName__dHDQi\"]")
    WebElement medTitlElement;
    @FindBy(className = "MedicineOverviewSection_brandName__rJFzE")
    WebElement labnamElement;
    @FindBy(className = "PriceInfo_striked__Hk2U_")
    WebElement pricElement;
    @FindBy(className = "PriceInfo_gcdDiscountPercent__xhETH")
    WebElement offerElement;
    @FindBy(xpath = "//button[contains(text(), 'Add To Cart')]")
    private WebElement addToCartButton;

    public String chooseMed() {
        rf.clickOnElement(firstmedElement);
        return rf.ReturnGetText(firstmedElement);
    }

    public boolean isMedicineImageDisplayed() {
        try {
            return imgElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLabNameDisplayed() {
        return labnamElement.isDisplayed();
    }

    public boolean isMRPDisplayed() {
        return pricElement.isDisplayed();
    }

    public boolean isOfferMRPDisplayed() {
        return offerElement.isDisplayed();
    }

    public boolean isAddToCartButtonDisplayed() {
        return addToCartButton.isDisplayed();
    }
    private String takemedName() {
		return rf.ReturnGetText(mednamElement);
	}
    public boolean allmedDetails() {
        int totalMedElements = driver.findElements(By.tagName("h1")).size();
        System.out.println(totalMedElements);

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

            // Check if the image element is present
            try {
                isImageDisplayed = isMedicineImageDisplayed();
            } catch (NoSuchElementException e) {
                // Handle NoSuchElementException
                String errorMessage = "Medicine Image Element not found";
                unavailableElements.add(errorMessage);
            }

            // Check if other elements are present
            if (isImageDisplayed) {
                try {
                    isLabNameDisplayed = isLabNameDisplayed();
                    isMRPDisplayed = isMRPDisplayed();
                    isOfferMRPDisplayed = isOfferMRPDisplayed();
                    isAddToCartButtonDisplayed = isAddToCartButtonDisplayed();
                } catch (NoSuchElementException e) {
                    // Handle NoSuchElementException
                    String errorMessage = "Some details not found for Element " + i + "\n";
                    unavailableElements.add(errorMessage);
                }
            }

            // Check if any detail is not displayed
            if (!isImageDisplayed || !isLabNameDisplayed || !isMRPDisplayed || !isOfferMRPDisplayed
                    || !isAddToCartButtonDisplayed) {
                String unavailableElementDetails = "Medicine Details for " + takemedName() + ":\n";
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
   

	private boolean writeLogToFile(List<String> unavailableElements) {
        try {
            FileWriter writer = new FileWriter(System.getProperty("user.dir")+"/log/MedicineDetailsLog.txt");
            writer.write("Details of Unavailable Elements:\n\n");
            for (String details : unavailableElements) {
                writer.write(details);
            }
            writer.close();
            System.out.println("Log file 'log.txt' created successfully!");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
  
}