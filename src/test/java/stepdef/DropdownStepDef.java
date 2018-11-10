package stepdef;

import cucumber.api.java.en.*;
import pageobjects.DropdownPage;

public class DropdownStepDef extends DropdownPage{
	
	@Then("^select \"([^\"]*)\" from dropdown by \"([^\"]*)\"$")
	public void select_from_dropdown_by(String value, String type) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		this.performAction(this.getDropdown(), "dropdown", value, type);
		//this.selectFromDropdown(this.getDropdown(), value, type);
	}

}
