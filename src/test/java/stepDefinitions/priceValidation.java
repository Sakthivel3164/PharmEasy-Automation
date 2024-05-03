package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import PageObject.PriceValidationPOM;
import io.cucumber.datatable.DataTable;
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
		assertEquals(pricePom.valueStoreTitle(), "Value Store");
	}

	@When("the user scrolls to the price section")
	public void the_user_scrolls_to_the_price_section() {
		pricePom.scrollToPrice();
	}

	@Then("the user should check the price text displayed")
	public void the_user_should_check_the_price_text_displayed() {
		assertEquals(pricePom.priceHeading(), "Price");
	}

	@Then("the user should see the following price range options:")
	public void the_user_should_see_the_following_price_range_options(DataTable dataTable) {
		// Convert the DataTable to a list of lists of strings
		List<List<String>> data = dataTable.asLists(String.class);
		// Flatten the list of lists into a single list
		List<String> flattenedData = new ArrayList<>();
		for (List<String> row : data) 
			flattenedData.addAll(row);		
		assertEquals(flattenedData, pricePom.priceRangeOption());
	}

}
