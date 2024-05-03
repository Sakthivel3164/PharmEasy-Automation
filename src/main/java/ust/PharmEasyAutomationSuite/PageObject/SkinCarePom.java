package ust.PharmEasyAutomationSuite.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.PharmEasyAutomationSuite.Base.DynamicLocaters;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;
import ust.PharmEasyAutomationSuite.exception.BrandNameNotSameException;
import ust.PharmEasyAutomationSuite.exception.MentionedProductCountAndAvailableProductCountNotSameException;

public class SkinCarePom extends DynamicLocaters {
	WebDriver driver;
	ReusableFunctions rf;

	public SkinCarePom(WebDriver driver, ReusableFunctions rf) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.rf = rf;

	}

//	brand view more button
	@FindBy(xpath = "//div[@class='Filters_wrapper__msOd7']/div[4]/div[3]")
	WebElement brandViewMore;

//	filter apply button
	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	WebElement applyButton;

//	product names 
	@FindBy(className = "ProductCard_productName__5Z65V")
	List<WebElement> products;

	public boolean verifyBrandFilter() throws MentionedProductCountAndAvailableProductCountNotSameException {
		
		boolean flagBrandName = true;
		boolean flagProductCount = true;
		
		rf.scrollByPixel(0, 500);
		rf.clickOnElement(brandViewMore);
		/*
		 * The loop will execute till the number of brands in filter option
		 */
		for (int i = 45; i <= 50; i++) {
			/*
			 * filter and filterBrandName are user defined methods in Dynamic locators class
			 * filter method dynamically locates the number of products a brand have with respect to the loop
			 * filterBrandName method dynamically locates the name of each brands with respect to the loop
			 */
			rf.clickOnElement(filterBrandCheckBox(driver, i));
			
			/*
			 * num varible stores the number of items a brand have in String type
			 * brandName variable stores the name of brand from the floating window
			 * productCount contains the integer type of num variable
			 */
			String num = rf.ReturnGetText(filterBrandCheckBox(driver, i)).replaceAll("[^0-9]", "");
			String brandName = filterBrandName(driver, i).getText().split("\\n")[0];
			int productCount = Integer.parseInt(num);

			/*
			 * after selecting a brand click apply button and the filter will be applied
			 * takeADelay is used to wait till the products get laoded
			 * ScrollByPixel is used to scroll down and back to the to to load all the products
			 */
			
			rf.clickOnElement(applyButton);
			rf.takeADelay(2);
			rf.scrollByPixel(0, 2000);
			rf.takeADelay(3);
			rf.scrollByPixel(0, -2000);
			
			/*
			 * products is a list which contains all the product names of a brand
			 * using for each loop we can check if all the products are of same branch
			 * if brand name not same, throw a custom  BrandNameNotSameException
			 * handle the exception to know for which branch the error is occured
			 * 
			 * 
			 */

			for (WebElement e : products) {
				try {
				if(!e.getText().contains(brandName))
				{
					flagBrandName = false;
					throw new BrandNameNotSameException();					
				}
				}
				catch(BrandNameNotSameException b)
				{
					b.printStackTrace();
					System.out.println("For "+brandName+", all the listed products are not of the same branch");
				}
			}
			
			/*
			 * if brand name not same, throw a custom  BrandNameNotSameException
			 * handle the exception to know for which branch the error is occured
			 */

			try {
			if(productCount!=products.size())
			{
				flagProductCount = false;
				throw new MentionedProductCountAndAvailableProductCountNotSameException();
			}
			}
			catch (MentionedProductCountAndAvailableProductCountNotSameException e) {
				e.printStackTrace();
				System.out.println(brandName+"'s mentioned count and available count are not same");
				System.out.println("Expected product count: "+productCount);
				System.out.println("Actual product count: "+products.size());

			}
			/*
			 * Again click on view more option to select next brand to check all brands
			 * Again click on checkbox to de-select to check next brand filter
			 */

			rf.clickOnElement(brandViewMore);
			rf.takeADelay(1);
			rf.clickOnElement(filterBrandCheckBox(driver, i));

		}
		return flagBrandName == true && flagProductCount == true;
	}

}
