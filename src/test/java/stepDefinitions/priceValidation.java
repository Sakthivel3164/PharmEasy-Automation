package stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import PageObject.PriceValidationPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ust.PharmEasyAutomationSuite.Base.ReusableFunctions;

public class priceValidation {
	private final WebDriver driver = Hooks.driver;
	PriceValidationPOM pricePom = new PriceValidationPOM(driver);
	ReusableFunctions rf = new ReusableFunctions(driver);

	@Given("user is on the Phareasy website")
	public void user_is_on_the_phareasy_website() {
	}

	@Then("the user verifies the URL of the Phareasy website page")
	public void the_user_verifies_the_url_of_the_phareasy_website_page() {
		assertEquals(driver.getCurrentUrl(), rf.getPropertyValue("url"));
	}

	@When("the user navigates to the Value Store section")
	public void the_user_navigates_to_the_value_store_section() {
		pricePom.valueStore();
	}

	@Then("the user validate the value store title")
	public void the_user_validate_the_value_store_title() {
		assertEquals(pricePom.valueStoreTitle(),"Value Store");
	}

	@When("the user scrolls to the price section")
	public void the_user_scrolls_to_the_price_section() {
		pricePom.scrollToPrice();
	}

	@Then("the user should check the price text displayed")
	public void the_user_should_check_the_price_text_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should see the following price range options:")
	public void the_user_should_see_the_following_price_range_options(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}

}
