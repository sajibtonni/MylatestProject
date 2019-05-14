package steps_definition;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UI {
	
	
	public static WebDriver driver;
	private List<String> windowsHandles = new ArrayList<>();
	private final int LOCATOR_ID = 0;
	private final int LOCATOR_NAME = 1;
	private final int LOCATOR_CLASSNAME = 2;
	private final int LOCATOR_CSSSELECTOR=3;
	private final int LOCATOR_XPATH=4;
	
	private final int ELEMENT_CONDITION_IS_VISIBLE = 0;
	private final int ELEMENT_CONDITION_IS_CLICKABLE=1;
	private final int ELEMENT_CONDITION_TEXT_IS_PRESENT=2;
	
	public UI (WebDriver driver) {
		this.driver=driver;
	}

	private WebElement wait_for_element(int element_condition, WebElement element, String... text) {
		WebDriverWait wait= new WebDriverWait(driver, 60);
		switch (element_condition) {
		case ELEMENT_CONDITION_IS_VISIBLE:
			wait.until(ExpectedConditions.visibilityOf(element));
			break;
		case ELEMENT_CONDITION_IS_CLICKABLE:
			wait.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case ELEMENT_CONDITION_TEXT_IS_PRESENT:
			wait.until(ExpectedConditions.textToBePresentInElement(element, text[0]));
			break;
		}
		return element;
}
	private WebElement find_element(int locator, String value) {
		WebElement e = null;
		switch (locator) {
		case LOCATOR_ID:
			e= driver.findElement(By.id(value));
			break;
		case LOCATOR_NAME:
			e= driver.findElement(By.name(value));
			break;
		case LOCATOR_CLASSNAME:
			e= driver.findElement(By.className(value));
			break;
		case LOCATOR_CSSSELECTOR:
			e= driver.findElement(By.cssSelector(value));
		case LOCATOR_XPATH:
			e= driver.findElement(By.xpath(value));
			break;

		default:
			throw new RuntimeException("Invalid locator was given " + locator);
		}
		move_to_element(wait_for_element(ELEMENT_CONDITION_IS_VISIBLE, e));
		return e;
	}
	
	//open url
	public void openUrl(String url) {
		driver.get(url);
		windowsHandles.add(driver.getWindowHandle());
	}
	// window handling
	public void swith_to_window(int windowNumber) {
		if (windowNumber>= windowsHandles.size()) {
			throw new RuntimeException("Invalid window number was given to switch");
						
		}
		driver.switchTo().window(windowsHandles.get(windowNumber));
	}
	public void swith_to_main_window() {
		driver.switchTo().window(windowsHandles.get(0));
	}
	
	
	// frame handling
	
	public void switch_to_frame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	public void switch_to_frame(int index) {
		driver.switchTo().frame(index);
	}
	
	// move to element
	
	public void move_to_element(WebElement e) {
		Actions actions = new Actions(driver);
		actions.moveToElement(e).build().perform();
	}
	
	// find
	public WebElement fine_element_by_id(String id) {
		return find_element(LOCATOR_ID, id);
	}
	
	//click
	
	private void click (WebElement e) {
		e.click();
		Set<String> handles = driver.getWindowHandles();
		handles.forEach((str)->{
			if (!windowsHandles.contains(str)) {
				windowsHandles.add(str);
				
			}
		});
		
	}
	
	
	public void click_by_id(String id) {
		click(find_element(LOCATOR_ID, id));
	}
	
	public void click_by_name(String name) {
		click(find_element(LOCATOR_NAME, name));
	}
	public void click_by_className(String className) {
		click(find_element(LOCATOR_NAME, className));
	}
	
	public void click_by_cssSelector(String cssSelector) {
		click(find_element(LOCATOR_NAME, cssSelector));
	}
	public void click_by_xpath(String xpath) {
		click(find_element(LOCATOR_NAME, xpath));
	}
	
	// All senkyKeys
	
	public WebElement sendKeysById(WebElement e, String typeByText) {
		find_element(LOCATOR_ID, typeByText);
		return e;
	}
	
	public WebElement sendKeysByName(WebElement e, String typeByText) {
		find_element(LOCATOR_NAME, typeByText);
		return e;
	}
	
	public WebElement sendKeysByCssSelector(WebElement e, String typeByText) {
		find_element(LOCATOR_CSSSELECTOR, typeByText);
		return e;
	}
	
	public WebElement sendKeysByXpath(WebElement e, String typeByText) {
		find_element(LOCATOR_XPATH, typeByText);
		return e;
	}
	
	// wait
	
	
	
	public void wait_for_element_clickable(WebElement e) {
		wait_for_element(ELEMENT_CONDITION_IS_CLICKABLE, e);
	}
	
	public void wait_for_element_visible(WebElement e) {
		wait_for_element(ELEMENT_CONDITION_IS_VISIBLE, e);
	}
	 
	public void wait_for_element_to_be_present_in_element(WebElement e, String text) {
		wait_for_element(ELEMENT_CONDITION_TEXT_IS_PRESENT, e, text);
	}
	
	
	// drop down
	
	private Select get_select_object(WebElement e) {
		return new Select(e);
	}
	public void select_by_id_by_visible_text(String id, String valueToSelect) {
		get_select_object(fine_element_by_id(id)).selectByVisibleText(valueToSelect);
	}
	public void select_by_visible_text_(WebElement selectElement, String valueToSelect) {
		get_select_object(selectElement).selectByVisibleText(valueToSelect);
	}
	

	// Verification 

	
	
	
	}


