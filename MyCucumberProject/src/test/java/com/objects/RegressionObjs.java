package com.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegressionObjs {

	WebDriver driver;
	UI ui;

//	@FindBy(xpath="");
//	WebElement Login;

	public RegressionObjs(WebDriver driver, UI ui) {
		this.driver = driver;
		this.ui = ui;
		PageFactory.initElements(driver, this);
	}

	public void test1() {

	}

	public void test2() {

	}

	public void test3() {

	}

}
