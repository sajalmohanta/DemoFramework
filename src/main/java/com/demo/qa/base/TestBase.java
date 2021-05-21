/**
 * 
 */
package com.demo.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.demo.qa.util.TestUtil;
import com.demo.qa.util.WebEventListener;

/**
 * @author sajalmohanta
 *
 */
public class TestBase {
	protected static WebDriver driver;
	protected static Properties prop;
	protected static EventFiringWebDriver eventFireDriver;
	protected static WebEventListener eventListener;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/sajalmohanta/eclipse-workspace2/FreeCRM/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "../../../chromedriver");
			driver = new FirefoxDriver();

		}
		eventFireDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventFireDriver.register(eventListener);
		driver = eventFireDriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

	}
}
