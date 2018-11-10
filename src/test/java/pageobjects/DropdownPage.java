package pageobjects;

import org.openqa.selenium.WebElement;

public class DropdownPage extends HomePage {
	String IDDropdown="dropdown";
	
	public WebElement getDropdown()
	{
		return this.IdentifyElement(locators.id, IDDropdown);
	}

}
