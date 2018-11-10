package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import generic.SeleniumBase;

public class HomePage extends SeleniumBase {
	String tagnameHomePageLinks="a"; //locator type, page, find what in variable name
	String linkTextHomePageLink="%s" ;
	
	//locating a specific link on home page
	public WebElement getSingleLink(String link_name) {
		linkTextHomePageLink=String.format(linkTextHomePageLink, link_name);
		return this.IdentifyElement(locators.linkText, linkTextHomePageLink); //how and what
	}
	
	
	public  List<WebElement> getLinks() {
		return this.IdentifyElements(locators.tagName, tagnameHomePageLinks);
	}
	public int getCountLinks() {
		return getLinks().size();
			
	}
  
}
