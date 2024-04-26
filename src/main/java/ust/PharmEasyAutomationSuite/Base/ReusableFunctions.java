package ust.PharmEasyAutomationSuite.Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReusableFunctions {
	static ExtentSparkReporter htmlReporter;
	static ExtentReports reports;
	ExtentTest test;

	private static WebDriver driver;
	private WebDriverWait wait;
	public static Properties properties;

	public ReusableFunctions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		properties = FileIO.getProperties();

	}

	public static  WebDriver invokeBrowser() {
		if (properties == null)
			properties = FileIO.getProperties();
		String browser_choice = properties.getProperty("browser");
//		

		return DriverSetup.browserSetup(browser_choice);
	}

//**********open website*********/
	public  void openWebsite(String url) {
		if (properties == null) {
			properties = FileIO.getProperties();
		} else {
			driver.get(properties.getProperty(url));
		}

	}

//***************get from  property file **************
	public String getPropertyValue(String s) {
		if (properties == null) {
			properties = FileIO.getProperties();
		}
		return properties.getProperty(s);
	}

	public void waitForElementToDisplay(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/******** send search element ***************/
	public void setTextToInputField(WebElement element, String text) {
		waitForElementToDisplay(element);
		element.clear();
		element.sendKeys(text);
	}

	// *********************click elemet***********************
	public void clickOnElement(WebElement element) {
		waitForElementToDisplay(element);
		element.click();
	}

	// ********************* Get Text ***********************
	public String ReturnGetText(WebElement element) {
		waitForElementToDisplay(element);
		return element.getText();

	}

	// ********************** Action *******************

	public void HoldTheElement(WebElement element, WebElement newoption) {
		waitForElementToDisplay(element);
		element.click();
		waitForElementToDisplay(newoption);
		newoption.click();

	}

	public void clearInput(WebElement element) {
		waitForElementToDisplay(element);
		element.clear();
	}

	public boolean isDisaplayed(WebElement element) {
		waitForElementToDisplay(element);
		return element.isDisplayed();
	}

	/************** Take screenshot ****************/
	public static void takeScreenShot(String filepath) {
		System.out.println("filepath:  " + filepath);
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		// Generate a timestamp
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		// Append the timestamp to the filename
		String fileNameWithTimestamp = "screenshot_" + timestamp + ".png";

		// Construct the destination file path with the unique filename
		File destFile = new File(filepath + File.separator + fileNameWithTimestamp);

		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ExtentReports report(String string) {
		htmlReporter = new ExtentSparkReporter("stringssssss");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		// add environtment variables
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("user", "shebin");

		// configuration look
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEE,MMM dd, yyyy, hh:mm a '('zzz')'");
		return reports;

	}

	public void clickTwoButton(WebElement element, WebElement element2) {
		waitForElementToDisplay(element);
		element.click();
		waitForElementToDisplay(element2);
		element2.click();
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void takeADelay(int i) {
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void refresh() {
driver.navigate().refresh();		
	}

	public void setTextToInputFieldandEnter(WebElement element, String text) {
		waitForElementToDisplay(element);
		element.clear();
		element.sendKeys(text);
	    element.sendKeys(Keys.ENTER); // Press "Enter" key after sending text

	}

}
