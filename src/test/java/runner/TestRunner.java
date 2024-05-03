package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "classpath:features/" }, glue = { "classpath:stepDefinitions" })
public class TestRunner extends AbstractTestNGCucumberTests {

}
