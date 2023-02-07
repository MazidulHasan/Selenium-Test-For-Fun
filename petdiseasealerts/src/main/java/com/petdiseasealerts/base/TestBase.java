package com.petdiseasealerts.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v101.input.model.DragData;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;
import com.petdiseasealerts.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	public static WebDriver driver; //static driver will be same for this class to access all places the same thing
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;

	
	public static void initialization() {
		String browserName = "chrome";
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		driver = e_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		
	}

	public void waitForElementToBeDisplayed(WebElement webElement, WebDriver driver){
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
			wait.until(ExpectedConditions.visibilityOf(webElement));
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			System.out.println("Element is not visible");
		}
	}

	public void clickElement(WebElement webElement, WebDriver driver){
		try {
			waitForElementToBeDisplayed(webElement, driver);
			webElement.click();
		} catch (Exception e) {
			System.out.println("Element is not clickable");
		}
	}

	public void switchToFrame(WebElement iframe,WebDriver driver) {
		waitForElementToBeDisplayed(iframe,driver);
		driver.switchTo().frame(iframe);
	}

	public void clickAttheBottomOfElement(WebElement webElement, WebDriver driver) {
		waitForElementToBeDisplayed(webElement,driver);
		int halfOfwidth = webElement.getSize().getWidth()/2;
		int offset = halfOfwidth - 25;

		Actions actions = new Actions(driver);
		actions
			.moveToElement(webElement)
			.moveByOffset(offset, 0)
			.click()
			.build()
			.perform();
	}
}
