package ust.PharmEasyAutomationSuite.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicLocaters {

	public WebElement addCountElement(WebDriver driver, String i) {

		WebElement element = driver.findElement(By.xpath("//li[@data-value='" + i + "']"));
		return element;
	}

	public String sortByText(WebDriver driver, int i) {
		WebElement element = driver.findElement(By.xpath("//ul[@role='listbox']/li[" + i + "]"));
		return element.getText();
	}

	public WebElement sortByDropDown(WebDriver driver, int i) {
		WebElement element = driver.findElement(By.xpath("//ul[@role='listbox']/li[" + i + "]"));
		return element;
	}

	public WebElement filterBrandCheckBox(WebDriver driver, int i) {
		WebElement element = driver.findElement(
				By.xpath("//div[@class='FilterDrawer_wrapper__DzNlm']/div[3]/label[" + i + "]/span[2]/div/span"));
		return element;
	}
	
	public WebElement filterBrandName(WebDriver driver, int i) {
		WebElement element = driver.findElement(
				By.xpath("//div[@class='FilterDrawer_wrapper__DzNlm']/div[3]/label[" + i + "]/span[2]/div"));
		return element;
	}
	
	public static WebElement filterPrice(WebDriver driver, int i) {
		WebElement element = driver.findElement(
				By.xpath("(//div[@class='FilterItem_filterTitle__n7zYh'])[" + i + "]"));
		return element;
	}
	
	
	
	
}
