package step_definition;

import org.openqa.selenium.WebDriver;

import com.objects.RegressionObjs;
import com.objects.UI;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegresstionTest {

	WebDriver driver;
	UI ui;
	String url = "google.com";
	RegressionObjs obj;

	@Given("")

	public void navigation_link() {
		driver = Hooks.driver;
		ui = Hooks.ui;
		driver.get(url);
	}

	@When("")
	public void all_action() {

		obj = new RegressionObjs(driver, ui);
		obj.test1();
		obj.test2();
		obj.test3();
	}

	@Then("")
	public void validation() {
		System.out.println("এখানে asseration করে ভ্যালিডেশন করবো");
	}

}
