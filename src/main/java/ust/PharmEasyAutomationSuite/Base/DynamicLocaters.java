package ust.PharmEasyAutomationSuite.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicLocaters {
	
	 public WebElement addCountElement(WebDriver driver, String i) {

	        WebElement element = driver.findElement(By.xpath("//li[@data-value='" + i + "']"));
	        return element;
	    }
}
