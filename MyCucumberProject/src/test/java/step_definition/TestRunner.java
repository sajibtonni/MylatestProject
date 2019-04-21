package step_definition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {
				"src/test/resources/Feature/login.feature"
				
		},
		plugin= {"pretty", "html:target:cucumber-html-report", "json:target/Destination/cucumber.json"},
		monochrome=true,
		tags= {}
		
		)


public class TestRunner {

}
