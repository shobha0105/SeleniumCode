package pageobjects;

import org.openqa.selenium.WebElement;

import generic.SeleniumBase.locators;

public class DynamicLoadingPage extends HomePage{
	String xpathStartbutton="//div[@id=\"start\"]/button";
	String xpathFirstLink="//a[@href=\"/dynamic_loading/1\"]";
	String xpathSecondLink="//a[@href=\"/dynamic_loading/2\"]";
	String xpathexpectedText="//*[@id=\"finish\"]/h4";
	
	
	public WebElement getText() {
		return this.IdentifyElement(locators.xpath, xpathexpectedText);	
	}
	
	
	public WebElement getStartbutton() {
		return this.IdentifyElement(locators.xpath, xpathStartbutton);
	}
		
	public WebElement getFirstLink() {
		return this.IdentifyElement(locators.xpath, xpathFirstLink);
	}
	public WebElement getSecondLink() {
		return this.IdentifyElement(locators.xpath, xpathSecondLink);
	}
	
}

