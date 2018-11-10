package pageobjects;

import org.openqa.selenium.WebElement;

public class MultipleWindowsPage extends HomePage {
	String xpathTextOnNew="//div[@class=\"example\"]/h3";
	public WebElement getClickHerelink(String link_name) {
		return this.IdentifyElement(locators.linkText, link_name);
	}

	public WebElement getTextonNewwindow()
	{
		return this.IdentifyElement(locators.xpath, xpathTextOnNew);
	}
}
