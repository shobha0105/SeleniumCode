package stepdef;

import cucumber.api.java.en.*;
import pageobjects.DynamicLoadingPage;

public class DynamicLoadingStepDef extends DynamicLoadingPage {

	@Then("^click on \"([^\"]*)\" link of dynamic loading page$")
	public void click_on_link_of_dynamic_loading_page(String arg1) {
		if (arg1.contains("hidden")) {
			this.performAction(this.getFirstLink(), "click", null);
		} else
			this.performAction(this.getSecondLink(), "click", null);
	}

	
	@Then("^click on Start button$")
	public void click_on_Start_button() {
	    // Write code here that turns the phrase above into concrete actions
		this.performAction(this.getStartbutton(), "click", null);
	}
	
	@Then("^verify text as \"([^\"]*)\"$")
	public void verify_text_as(String value){
	    // Write code here that turns the phrase above into concrete actions
	    this.performAction(this.getText(), "text", value);
	}


}
