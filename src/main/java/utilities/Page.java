package utilities;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// parent

public abstract class Page {

	// Singleton
	// private String pathToChromeDriver =
	// "C:\\drivers\\chromedriver_80\\chromedriver.exe";
	private static WebDriver driver = null;
	private final int MAX_TIMEOUT = 60000;
	public String pageElements = null;
	private final String PAGE_ELEMENTS_FILE = "src\\main\\resources\\selectors\\pageElements.json";

	public Page() {
		/*
		 * Default declarations By default, work with ChromeDriver
		 */
		// System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
		try {
			WebDriverManager.chromedriver().setup(); // .version("77.0.3865.40").
			driver = getDriver();
			driver.manage().window().maximize();
			// Read from JSON file
			pageElements = new String(Files.readAllBytes(Paths.get(PAGE_ELEMENTS_FILE).toAbsolutePath()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private WebDriver getDriver() {
		if (driver != null && driver instanceof WebDriver) { // driver has already been instantiated; reuse this driver
			return driver;
		}

		// return new EdgeDriver();
		// return new InternetExplorerDriver();
		return new ChromeDriver();
	}

	public void open(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void go() {
		String className = this.getClass().getSimpleName();
		String pageName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length()); // timestamps
																												// ->
																												// timestamps
		System.out.println("pageName: " + pageName);
		String url = new JsonParcer().getValue(pageElements, "timestamps.url"); // "timestamps.url"
		open(url);
		pause(1000);
	}

	public enum SelectorType {
		xpath, className, id, cssSelector, name, linkText, partialLinkText, tagName
	}

	private WebElement getElement(SelectorType type, String selector) throws Exception {

		switch (type) {
		case xpath:
			return driver.findElement(By.xpath(selector));
		case className:
			return driver.findElement(By.className(selector));
		case id:
			return driver.findElement(By.id(selector));
		case cssSelector:
			return driver.findElement(By.cssSelector(selector));
		case name:
			return driver.findElement(By.name(selector));
		case linkText:
			return driver.findElement(By.linkText(selector));
		case partialLinkText:
			return driver.findElement(By.partialLinkText(selector));
		case tagName:
			return driver.findElement(By.tagName(selector));
		default:
			return driver.findElement(By.xpath(selector));
		}

	}

	public WebElement getElement(String pageElement) {
		WebElement element = null; // by default, element not found
		try {
			// Parse JSON and get required value
			String selFromFile = new JsonParcer().getValue(pageElements, pageElement);
			String selector = selFromFile != null ? selFromFile : pageElement;
			// JSONParser.parseJson(pageElements, pageElement, "");
			int elapsedTime = 0;
			int intervalTime = 250;
			while (element == null && elapsedTime < MAX_TIMEOUT) {
				for (SelectorType selectorType : SelectorType.values()) {
					try {
						element = getElement(selectorType, selector);
						System.out.println("Page Element, " + pageElement + " (\"" + selector + "\"), found using "
								+ selectorType);
						break;
					} catch (Exception e) {
						elapsedTime += intervalTime;
						pause(intervalTime);
						if (elapsedTime >= MAX_TIMEOUT) {
							System.out.println("Max timeout of " + MAX_TIMEOUT + " ms reached...");
							System.out.println(
									"Page Element, " + pageElement + " (\"" + selector + "\"), is not detected");
							System.out.println(e.getMessage());
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return element;
	}

	public void pause(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will go back to previous page
	 */
	public void goBack() {
		driver.navigate().back();
	}

	/**
	 * This method will navigate back to the previous page by n count
	 * 
	 * @param n
	 */
	public void goBack(int n) {
		for (int i = 0; i < n; i++) {
			goBack();
		}
	}

	public void quit() {
		try {
			System.out.println("Closing driver...");
			driver.close();
			System.out.println("Driver successfully closed...");
			System.out.println("Quitting driver...");
			driver.quit();
			System.out.println("Driver successful quit...");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean click(String selector) {
		boolean res = false;
		try {
			getElement(selector).click();
			res = true;
			pause(1000);
		} catch (Exception e) {
			System.out.println("An error occurred! " + this);
		}
		System.out.println("Clicked element? " + res);
		return res;
	}

	public String get_text(String selector) {
		String res = null;
		try {
			res = getElement(selector).getText();
		} catch (Exception e) {
			System.out.println("An error occurred! " + this);
		}
		System.out.println("find_text : " + res);
		return res;

	}

	public void clear_text(String selector) {

		try {
			getElement(selector).clear();
		} catch (Exception e) {
			System.out.println("An error occurred! " + this);
		}

	}
	public void alert(String selector, String text) {
		WebElement res = null;
		try {
			 Alert confirmationAlert = driver.switchTo().alert();
//			res = getElement(selector);
//			 ((JavascriptExecutor) driver).executeScript("arguments[0].click()", res);
//			 
			  String alertText = confirmationAlert.getText();
			  System.out.println("Alert text is " + alertText);
			if(text.toLowerCase().contains("ok") ) {
				confirmationAlert.accept();
			}else {
				confirmationAlert.dismiss();
			}
		} catch (Exception e) {
			System.out.println("An error occurred! " + this);
		}

	}

	public void enter_text(String selector, String text) {
		// String res = null;
		try {
			getElement(selector).sendKeys(text);
		} catch (Exception e) {
			System.out.println("An error occurred! " + this);
		}
		// System.out.println("find_text : " + res);

	}

	public boolean is_displayed(String selector) {
		boolean res = false;
		try {
			res = getElement(selector).isDisplayed();
		} catch (Exception e) {
			System.out.println("An error occurred! " + this);
		}
		if (res == true) {
			System.out.println(res ? "Assertion PASSED!" : "Assertion FAILED!");
		}
		return res;

	}

	public void AssertTest(String Actual, String Expected) {
		String result = null;
		if (Actual == Expected) {
			result = "pass";
		} else
			result = "Fail";

		return;
	}

}
