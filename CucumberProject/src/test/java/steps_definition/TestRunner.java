package steps_definition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "src/test/resources/Feature/CucumberLogin.feature"

		},
		glue="step_definition",
		plugin = { "pretty", "html:target/cucumber-html-report", "json:target/Destination/cucumber.json" }, 
		monochrome = true, 
		tags = {}

)

public class TestRunner {

}