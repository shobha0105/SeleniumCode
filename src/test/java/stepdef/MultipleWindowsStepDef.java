package stepdef;

import cucumber.api.java.en.*;
import pageobjects.MultipleWindowsPage;

public class MultipleWindowsStepDef extends MultipleWindowsPage {

	@Then("^switch to window with \"([^\"]*)\" as \"([^\"]*)\"$")
	public void switch_to_window_with_as(String extra_param, String value) {
		this.performAction(null, "windows", value, extra_param);
	}
	
	@Then("^click on \"([^\"]*)\" link of multiple windows page$")
	public void click_on_link_of_multiple_windows_page(String arg1) {
	   this.performAction(this.getClickHerelink(arg1), "click", null);    
	}
	
@Then("^verify \"([^\"]*)\" text$")
public void verify_text(String value){
	this.performAction(this.getTextonNewwindow(),"text",value);
	
	    
	}
}
