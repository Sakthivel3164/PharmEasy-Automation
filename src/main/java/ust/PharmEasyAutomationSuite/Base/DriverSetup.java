package ust.PharmEasyAutomationSuite.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSetup {
	public static WebDriver browserSetup(String s) {

		if (s.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			options.addArguments("--disable-notifications");
//			options.addArguments("--headless");
			options.addArguments("guest");

			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			return driver;
		} else if (s.equalsIgnoreCase("edge")) {

			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
//			options.addArguments("--headless");
			options.addArguments("guest");
			WebDriver driver = new EdgeDriver(options);
			driver.manage().window().maximize();
			return driver;
		}

		else {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			WebDriver driver = new FirefoxDriver(firefoxOptions);
			return driver;

		}

	}

}
