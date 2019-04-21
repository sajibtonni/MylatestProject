package com.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UI {
	public static WebDriver driver;
	
	public UI (WebDriver driver) {
		this.driver=driver;
	}
	
	public void openURl (String url) {
		driver.get(url);
	}
	private Actions getActions() {
		return new Actions(driver);
	}
	
	//Wait
	
	private WebDriverWait get_web_driver_wait() {
		return new WebDriverWait(driver, 60);
	}
	
	public WebElement wait_until_element_to_be_visible(By locator) {
		WebDriverWait wait = get_web_driver_wait();
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
}
