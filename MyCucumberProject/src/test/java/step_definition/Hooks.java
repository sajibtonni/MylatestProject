package step_definition;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.objects.UI;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	public static UI ui;
	
	
	@Before
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C://Users//sajib//myproject//MyCucumberProject//lib//chromedriver.exe");
		driver= new ChromeDriver();
		
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addExtensions(new File(System.getProperty("")));
//		return new ChromeDriver(chromeOptions);
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	
	@After
	public void closeBrowser() {
		
		driver.quit();
	}
	
	
	
	
	

}
