package page_objs;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import steps_definition.CucumberProjectTest;
import steps_definition.Hooks;
import steps_definition.PF;
import steps_definition.UI;
import vacu.page.log.LogTrace;

public class CucumberProjectObjs {
	public static WebDriver driver;
	public static UI ui;
	public static PF pf;
	public static  Logger logger= LogManager.getLogger(LogTrace.class);

			
	@FindBy(xpath = "//span[contains(text(),'Hello, Sign in')]") WebElement SignIn;
	@FindBy(xpath = "//input[@id='ap_email']")  WebElement UserName;
	@FindBy(xpath = "//input[@id='ap_password']")  WebElement Password;
	@FindBy(xpath = "//input[@id='signInSubmit']")  WebElement SubmitButton;

	public CucumberProjectObjs(WebDriver driver, UI ui, PF pf) {
		this.driver = Hooks.driver;
		this.ui = Hooks.ui;
		this.pf=Hooks.pf;
		PageFactory.initElements(driver, this);

	}

	public CucumberProjectTest test1() {
//		ui.move_to_element(SignIn);
		pf.clickByWebElement(SignIn);
//		ui.sendKeysByXpath(UserName, "nezam1983uddin@gmail.com");
		pf.enterText(UserName, "nezam1983uddin@gmail.com");
//		ui.sendKeysByXpath(Password, "S277292b");
		pf.enterText(Password, "S277292b");
		
		
		SignIn.click();
		UserName.sendKeys("nezam1983uddin@gmail.com");
		Password.sendKeys("S277292b");
		SubmitButton.click();
		return PageFactory.initElements(driver, CucumberProjectTest.class);
	}


}
