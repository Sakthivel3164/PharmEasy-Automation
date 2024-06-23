package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import PageObject.AboutUsPagePom;
import PageObject.HomePagePom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class AboutPageNavigation {
	static WebDriver driver = Hooks.driver;
	ReusableFunctions rf;
	HomePagePom homePagePom;
	AboutUsPagePom aboutUsPagePom;

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		rf = new ReusableFunctions(driver);
		homePagePom = new HomePagePom(driver, rf);
	}

	@When("user clicks on the About link")
	public void user_clicks_on_the_about_link() {
		 homePagePom.clickAboutUs();
	}

	@Then("user is navigated to the About page")
	public void user_is_navigated_to_the_about_page() {
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("aboutusurl"));
		assertTrue(homePagePom.isNavigationLinksDisplayed());
	}

	@When("user clicks on what are we link")
	public void user_clicks_on_what_are_we_link() {
		System.out.println("stepdef what we are");
		homePagePom.clickWhatAreWe();
	}

	@Then("what is pharmeasy wrapper should be displayed")
	public void what_is_pharmeasy_wrapper_should_be_displayed() {
		assertTrue(homePagePom.isWhatIsPharmacyWrapperDisplayed());
	}

	@When("user clicks on core values link")
	public void user_clicks_on_core_values_link() {
		homePagePom.clickOnCoreValues();
	}

	@Then("core values of pharmeasy should be displayed")
	public void core_values_of_pharmeasy_should_be_displayed() {
		homePagePom.isCoreValueImageDisplayed();
		homePagePom.isCoreValueWrapperDisplayed();
	}

	@When("user clicks on Order medicines & healthcare products online dropdown")
	public void user_clicks_on_order_medicines_healthcare_products_online_dropdown() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Order Medicines Now button should be displayed")
	public void order_medicines_now_button_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on Order Medicines Now button")
	public void user_clicks_on_order_medicines_now_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("browser should navigate to the Order Medicine page")
	public void browser_should_navigate_to_the_order_medicine_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user navigates back to the About page")
	public void user_navigates_back_to_the_about_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("user should be back on the About page")
	public void user_should_be_back_on_the_about_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on Book diagonostics test online dropdown")
	public void user_clicks_on_book_diagonostics_test_online_dropdown() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Book a Lab Test Now button should be displayed")
	public void book_a_lab_test_now_button_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on Book a Lab Test Now button")
	public void user_clicks_on_book_a_lab_test_now_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Lab test booking window should be displayed")
	public void lab_test_booking_window_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on  Authoritative & Trustworthy Content dropdown")
	public void user_clicks_on_authoritative_trustworthy_content_dropdown() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Know more about our Editorial Policy button should be displayed")
	public void know_more_about_our_editorial_policy_button_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on Know more about our Editorial Policy button")
	public void user_clicks_on_know_more_about_our_editorial_policy_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("privacy policy window should be displayed")
	public void privacy_policy_window_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user scrolls down to the press coverage section")
	public void user_scrolls_down_to_the_press_coverage_section() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("images of news paper should be displayed")
	public void images_of_news_paper_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}