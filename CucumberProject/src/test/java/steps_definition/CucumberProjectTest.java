package steps_definition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_objs.CucumberProjectObjs;
import vacu.page.log.LogTrace;

public class CucumberProjectTest {
	
	WebDriver driver;
	UI ui;
	PF pf;
	CucumberProjectObjs objs;
	String url = null;
	public static  Logger logger= LogManager.getLogger(LogTrace.class);
	
	
	@Given("^I want to login$")
	public void i_want_to_login() throws Error {
		driver.get("https://amazon.com");
		Long loadtime =(Long) ((JavascriptExecutor) driver)
				.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		logger.info("Home page load time ms: " + loadtime);
		Long i = loadtime;
		
		if (i<15000) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,750)");
			System.out.println("Website working perfect!!!");
		}if (i<25000) {
			System.out.println("Homepage loaded longer than 25 seconds!!!");
		}if (i<30000) {
			System.err.println("Website loaded longer than 30 seconds!!!");
		}
		
		
	}
	
	@And("^I want to scroll the page$")
    public void i_want_to_scroll_the_page() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,750)");
    }
	

	@When("^I complete action$")
	public void i_complete_action() throws Throwable {
		objs = new CucumberProjectObjs(driver, ui, pf);
		objs.test1();
//		objs.test3();
	
		
		
		
	}

	@Then("^I validate the actions$")
	public void i_validate_the_actions() throws Throwable {
		System.out.println("Validate");
	}


	

}
