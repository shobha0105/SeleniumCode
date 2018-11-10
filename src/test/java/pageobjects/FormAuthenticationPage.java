package pageobjects;

import org.openqa.selenium.WebElement;

public class FormAuthenticationPage extends HomePage {
	String IDUsername="username";
	String IDPassword="password";
	String xpathLogin="//*[@id=\"login\"]/button";
	String xpathLogout="//*[@id=\"content\"]/div/a/i";
	public WebElement getUsername() {
		return this.IdentifyElement(locators.id, IDUsername);
	}
	
	public WebElement getPassword() {
		return this.IdentifyElement(locators.id, IDPassword);
	}
	
	public WebElement getLoginButton() {
		return this.IdentifyElement(locators.xpath,xpathLogin);
		
	}
	
	public WebElement getLogoutButton() {
		return this.IdentifyElement(locators.xpath,xpathLogout);
		
	}
}
