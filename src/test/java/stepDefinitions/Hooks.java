package stepDefinitions;

import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class Hooks {
	public static WebDriver driver;

	private ExtentReports extent;
	private ExtentTest test;

	@BeforeAll
	public static void openBrowser() {
		String appUrl = "https://pharmeasy.in/";
		EdgeOptions options = new EdgeOptions();
		options.addArguments("guest");
		options.addArguments("--start-maximized");
		driver = new EdgeDriver(options);
		ReusableFunctions rf = new ReusableFunctions(driver);
		driver.get(appUrl);

	}

	@Before
	public void report() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		// create a new test
		test = extent.createTest("DemoBlaze");
	}

	@After
	public void closeBrowser(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take the screenshot
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// Add it to the report
			test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
		} else {
			// Take the screenshot
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// Add it to the report
			test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
			test.pass("Test passed");
		}
		extent.flush();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterAll
	public static void quit()
	{
//		driver.quit();
	}

}
