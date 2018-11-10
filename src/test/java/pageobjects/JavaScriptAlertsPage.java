package pageobjects;

import org.openqa.selenium.WebElement;

import generic.SeleniumBase;

public class JavaScriptAlertsPage extends SeleniumBase {
	String xpathJSAlert = "//button[@onclick=\"jsAlert()\"]";
	String xpathJSConfirm = "//button[@onclick=\"jsConfirm()\"]";
	String xpathJSPrompt = "//button[@onclick=\"jsPrompt()\"]";

	public WebElement getJSAlert() {
		return this.IdentifyElement(locators.xpath, xpathJSAlert);
	}

	public WebElement getJSConfirm() {
		return this.IdentifyElement(locators.xpath, xpathJSConfirm);
	}

	public WebElement getJSPrompt() {
		return this.IdentifyElement(locators.xpath, xpathJSPrompt);
	}
}
