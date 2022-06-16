package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {
	public static WebDriver driver;
	public static Actions act;
	public static JavascriptExecutor js;
	public static Robot robo;
	public static TakesScreenshot ss;
	public static FileInputStream file;
	public static Alert alert;
	public static Select s;
	public static Scanner scan;
	public static Set<String> windowHandles;

	// Open Chrome
	public static void chrome_open(long Seconds) {
//		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Seconds));
	}

	// Open edge
	public static void edge_open(long Seconds) {
		System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Seconds));
	}

	// To load URl
	public static String To_load_URL(String URL) {
		driver.get(URL);
		return URL;
	}

	// To find element by driver method
	static String Locatorname_ID = "ID";
	static String Locatorname_name = "name";
	static String Locatorname_classname = "classname";
	static String Locatorname_linkedtext = "linkedtext";
	static String Locatorname_partiallinked = "partiallinkedtext";
	static String Locatorname_xpath = "xpath";

	public static WebElement findElement(String inspected_elementtype, String inspected_value) {
		try {
			if (inspected_elementtype.equalsIgnoreCase(Locatorname_ID)) {
				return driver.findElement(By.id(inspected_value));
			} else if (inspected_elementtype.equalsIgnoreCase(Locatorname_name)) {
				return driver.findElement(By.name(inspected_value));
			} else if (inspected_elementtype.equalsIgnoreCase(Locatorname_classname)) {
				return driver.findElement(By.className(inspected_value));
			} else if (inspected_elementtype.equalsIgnoreCase(Locatorname_linkedtext)) {
				return driver.findElement(By.linkText(inspected_value));
			} else if (inspected_elementtype.equalsIgnoreCase(Locatorname_partiallinked)) {
				return driver.findElement(By.partialLinkText(inspected_value));
			} else if (inspected_elementtype.equalsIgnoreCase(Locatorname_xpath)) {
				return driver.findElement(By.xpath(inspected_value));
			}
		} catch (Exception e) {
			System.err.println("May be you done a mistake in your locator value please do check it");
			System.err.println(e.getMessage());
		}
		return null;
	}

	// To find element's by driver method
	public static List<WebElement> findElements(String inspected_elementtype, String inspected_value) {
		try {
			if (inspected_elementtype.equalsIgnoreCase(Locatorname_ID)) {
				return driver.findElements(By.id(inspected_value));
			} else if (inspected_elementtype.equalsIgnoreCase(Locatorname_name)) {
				return driver.findElements(By.name(inspected_value));
			} else if (inspected_elementtype.equalsIgnoreCase(Locatorname_classname)) {
				return driver.findElements(By.className(inspected_value));
			} else if (inspected_elementtype.equalsIgnoreCase(Locatorname_linkedtext)) {
				return driver.findElements(By.linkText(inspected_value));
			} else if (inspected_elementtype.equalsIgnoreCase(Locatorname_partiallinked)) {
				return driver.findElements(By.partialLinkText(inspected_value));
			} else if (inspected_elementtype.equalsIgnoreCase(Locatorname_xpath)) {
				return driver.findElements(By.xpath(inspected_value));
			}
		} catch (Exception e) {
			System.err.println("May be you done a mistake in your locator value please do check it");
			System.err.println(e.getMessage());
		}
		return null;
	}

	// driver method

	public static void close_or_quit(String closing) {
		switch (closing) {
		case "close": {
			driver.close();
			break;
		}
		case "quit": {
			driver.quit();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + closing);
		}
	}

	// driver method return string
	public static String getTitle() {
		return driver.getTitle();
	}

	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public static String getPageSource() {
		return driver.getPageSource();
	}

	public static String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public static Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}
	// driver method- manage

	public static void manage(String manage_name) {
		switch (manage_name) {
		case "fullscreen": {
			driver.manage().window().fullscreen();
			break;
		}
		case "minimize": {
			driver.manage().window().minimize();
			break;
		}
		case "position": {
			driver.manage().window().getPosition();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + manage_name);
		}
	}

	// driver method-

	public static void navigate(String navigate_value) {
		switch (navigate_value) {
		case "to": {
			driver.navigate().to(navigate_value);
			break;
		}
		case "back": {
			driver.navigate().back();
			break;
		}
		case "forward": {
			driver.navigate().forward();
			break;
		}
		case "refresh": {
			driver.navigate().refresh();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + navigate_value);
		}
	}

	// To webelement action only void
	public static String method_clear = "clear";
	public static String method_sendKeys = "sendKeys";
	public static String method_click = "click";
	public static String method_isDisplayed = "isDisplayed";
	public static String method_isEnabled = "isEnabled";
	public static String method_isSelected = "isSelected";
	public static String method_submit = "submit";
	public static String method_getText = "getText";
	public static String method_getTagName = "getTagName";
	public static String method_getAttribute = "getAttribute";

	public static void Webelement_method(WebElement element, String action_name) {
		if (action_name.equalsIgnoreCase(method_clear)) {
			element.clear();
		} else if (action_name.equalsIgnoreCase(method_click)) {
			element.click();
		} else if (action_name.equalsIgnoreCase(method_submit)) {
			element.submit();
		}
	}

	// To webelement action for sending value(Send key, getAttribute)
	public static String Webelement_method_sendingvalue(WebElement element, String action_name, String value) {

		if (action_name.equalsIgnoreCase(method_sendKeys)) {
			element.sendKeys(value);
		} else if (action_name.equalsIgnoreCase(method_getAttribute)) {
			element.getAttribute(value);
		}
		return value;
	}
	// To webelement action for boolean value

	public static boolean Webelement_method_booleanvalue(WebElement element, String action_name) {
		if (action_name.equalsIgnoreCase(method_isDisplayed)) {
			element.isDisplayed();
		} else if (action_name.equalsIgnoreCase(method_isEnabled)) {
			element.isEnabled();
		} else if (action_name.equalsIgnoreCase(method_isSelected)) {
			element.isSelected();
		}
		return false;
	}

	// To webelement action for getText
	public static String getText(WebElement element, String action_name) {
		if (action_name.equalsIgnoreCase(method_getText)) {
			element.getText();
		}
		return element.getText();
	}

	// To webelement action for getTagName
	public static String getTagName(WebElement element, String action_name) {
		if (action_name.equalsIgnoreCase(method_getTagName)) {
			element.getTagName();
		}
		return element.getText();
	}

	// switch-frame

	public static void switch_framewith_WebElement(WebElement WebElement) {
		driver.switchTo().frame(WebElement);
	}

	public static void switch_framewith_index(int frameint) {
		driver.switchTo().frame(frameint);
	}

	public static void switch_framewith_nameorId(String nameorId) {
		driver.switchTo().frame(nameorId);
	}
	// switch- frameout

	public static void switch_frameout(String direct_Or_Onebyone) {
		if (direct_Or_Onebyone.equalsIgnoreCase("direct")) {
			driver.switchTo().defaultContent();
		} else if (direct_Or_Onebyone.equalsIgnoreCase("onebyone")) {
			driver.switchTo().parentFrame();
		} else {
			System.err.println("Please to Check Your's Syntax");
		}
	}

	// Actions-mouseover

	public static void actions_mouseover(WebElement WebElement, String mouseover_action) {
		act = new Actions(driver);
		switch (mouseover_action) {
		case "moveToElement": {
			act.moveToElement(WebElement).perform();
			break;
		}
		case "click": {
			act.click(WebElement).perform();
			break;
		}
		case "contextClick": {
			act.contextClick(WebElement).perform();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + mouseover_action);
		}
	}

	// Actions-DD
	public static void actions_drag_drop(WebElement source, WebElement target) {
		act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	// Actions-DD by value
	public static void actions_drag_drop_by(WebElement source, int addingvalue) {
		act = new Actions(driver);
		Point location = source.getLocation();
		int x = location.getX();
		int y = location.getY();
		act.dragAndDropBy(source, x + addingvalue, y + addingvalue);
	}

	// Actions-JavaScriptExecutor for scroll
	static String scrollby_element = "elementScroll";
	static String scroll_tobottom = "bottomScroll";
	static String scroll_totop = "topScroll";

	public static void JavascriptExecutor_withelement(WebElement element) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	// Actions-JavaScriptExecutor for scroll with element
	public static void JavascriptExecutor_withoutelement(String scroll_value) {
		js = (JavascriptExecutor) driver;
		if (scroll_value.equalsIgnoreCase(scroll_tobottom)) {
			js.executeScript("window.scrollTo(0,document.body.scrollHeight");
		} else if (scroll_value.equalsIgnoreCase(scroll_totop)) {
			js.executeScript("window.scrollTo(0,0)");
		}
	}

	// robot

	public static void robot(int noOfTimes) {
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		for (int i = 1; i <= noOfTimes; i++) {
			robo.keyPress(KeyEvent.VK_DOWN);
		}
		robo.keyPress(KeyEvent.VK_ENTER);
	}

	// takescreenshot

	public static void takescreenshot(String location) {
		ss = (TakesScreenshot) driver;
		File screenshotAs = ss.getScreenshotAs(OutputType.FILE);
		File target = new File(location);
		try {
			FileHandler.copy(screenshotAs, target);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	// property file

	public static String propertyfile(String location_value, String file_keyvalue) {
		try {
			file = new FileInputStream(location_value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		Properties property = new Properties();
		try {
			property.load(file);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return property.getProperty(file_keyvalue);
	}

	// Alert
	public static void Alert_withouttext(String alerttype) {
		switch (alerttype) {
		case "simplealert": {
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			break;
		}
		case "confirmaccept": {
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			break;
		}
		case "confirmcancel": {
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.dismiss();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + alerttype);
		}
	}

	public static void Alert_withtext_promptbox(String prompt_confirm_or_cancel, String sendalerttext) {
		switch (prompt_confirm_or_cancel) {
		case "confirm": {
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.sendKeys(sendalerttext);
			alert.accept();
			break;
		}
		case "cancel": {
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.sendKeys(sendalerttext);
			alert.dismiss();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + prompt_confirm_or_cancel);
		}
	}

	// drop down
	// single DD
	public static void dropdown_singleby_index(WebElement element, int index_value) {
		s = new Select(element);
		s.selectByIndex(index_value);
	}

	public static void dropdown_singleby_valueortext(String findby_valueortext, WebElement element,
			String valueortext) {
		switch (findby_valueortext) {
		case "value": {
			s = new Select(element);
			s.selectByValue(valueortext);
			break;
		}
		case "text": {
			s = new Select(element);
			s.selectByVisibleText(valueortext);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + findby_valueortext);
		}
	}

	// DD function
	public static void dropdown_functions(WebElement element, String option) {
		switch (option) {
		case "printoption": {
			s = new Select(element);
			List<WebElement> DD_options = s.getOptions();
			for (WebElement webElement : DD_options) {
				String text = webElement.getText();
				System.out.println(text);
			}
			break;
		}
		case "sizeoption": {
			s = new Select(element);
			List<WebElement> DD_options = s.getOptions();
			int size = DD_options.size();
			System.out.println(size);
		}
			break;
		case "deselectall": {
			s = new Select(element);
			s.deselectAll();
		}
			break;
		case "getAllSelectedOptions": {
			s = new Select(element);
			List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
			for (WebElement selectedoption : allSelectedOptions) {
				System.out.println(selectedoption.getText());
			}
		}
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}

	
	// DD_select by user index value
	public static void dropdown_selectingby_Coderindexvalue(WebElement element) {
		s = new Select(element);
		List<WebElement> alloptions = s.getOptions();
		int alloptions_size = alloptions.size();
		System.out.println(alloptions_size);
		System.out.println("Enter the index value need to select from drop_down");
		scan = new Scanner(System.in);
		int nextInt = scan.nextInt();
		for (int i = 0; i <= alloptions_size; i++) {
			if (i == nextInt) {
				s.selectByIndex(i);
			}
		}
	}
	// Windowhandling

	public static void Windowhandling() {
		windowHandles = driver.getWindowHandles();
		for (String windowtab : windowHandles) {
			driver.switchTo().window(windowtab);
			String tabtitle = driver.getTitle();
			System.out.println(windowtab + ":-" + tabtitle);
		}
	}
//	public static  void Windowhandling_switchto_value() {
//		scan= new Scanner(System.in);
//		System.out.println("Enter the index value of window handle to switch the window:");
//		int nextInt = scan.nextInt();
//		List<String> list= new ArrayList<>();
//		list.addAll(windowHandles);
//		driver.switchTo().window(list.get(nextInt));
//	}

	public static void Windowhandling_switchto_value(int index) {
		List<String> l = new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(index));
	}

	public static void explicitWait(int time, WebElement element, String name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		switch (name) {
		case "Click": {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			break;
		}
		case "select": {
			wait.until(ExpectedConditions.elementToBeSelected(element));
			break;
		}
		case "visible": {
			wait.until(ExpectedConditions.visibilityOf(element));
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + name);
		}
	}

}
