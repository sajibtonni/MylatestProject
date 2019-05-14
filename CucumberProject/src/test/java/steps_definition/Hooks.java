package steps_definition;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import page_objs.CucumberProjectObjs;

public class Hooks {

	public static WebDriver driver;
	public static UI ui;
	public static PF pf;
	public static ChromeOptions chromeOptions;
	public static Logger log = Logger.getLogger(Hooks.class.getName());
//	public static ChromeDriver obj;

	@Before(order = 1)
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib//chrome74.exe");
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nezam\\eclipse-workspace\\CucumberProject\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addExtensions(new File(System.getProperty("\\lib\\Xpath-Finder_v1.6.0.exe")));
//		driver=new ChromeDriver(chromeOptions);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		ui = new UI(driver);
		pf = new PF(driver);
		ui.openUrl("https://amazon.com");

		
	}

	public void embedScreenshot(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			try {
				String screenShotLocation = "\\Users\\nezam\\eclipse-workspace\\CucumberProject\\ScreenShot";
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String currentTime = dateFormat.format(date);
				System.out.println("----------------" + currentTime);
				TakesScreenshot scrShot = ((TakesScreenshot) driver);
				File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile = new File(screenShotLocation + "testCaseName" + "_" + currentTime + ".png");
				FileUtils.copyFile(SrcFile, DestFile);

			} catch (WebDriverException wde) {
				System.out.println(wde.getMessage());
			} catch (ClassCastException cee) {
				cee.printStackTrace();

			}

		}
		log.info("browser successfully closed");
		driver.close();
		log.info("driver is quiting");
		driver.quit();

		System.out.println("4th");
	}

}
