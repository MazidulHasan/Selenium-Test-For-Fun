package com.petdiseasealerts.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.petdiseasealerts.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(css = "iframe[src='https://api.capcvet.org/api/embed/forecast/n0vA38xpQ4J7Tcv4PA4v3NXtr4yo41AQVYaUQ7qr?iframe=1']")
	WebElement iframe;
	
	@FindBy(id = "california")
	WebElement california;

	@FindBy(css = "#florida>.rpath>path")
	WebElement florida;

	@FindBy(id = "new-york")
	WebElement newYork;

	@FindBy(id = "maryland")
	WebElement maryland;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public WebElement getIframe(){
		return iframe;
	}

	public WebElement getCalifornia(){
		return california;
	}

	public WebElement getflorida(){
		return florida;
	}

	public WebElement getnewYork(){
		return newYork;
	}

	public WebElement getmaryland(){
		return maryland;
	}

}
