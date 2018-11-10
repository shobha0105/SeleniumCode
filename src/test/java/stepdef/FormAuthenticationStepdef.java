package stepdef;

import cucumber.api.java.en.*;
import pageobjects.FormAuthenticationPage;

public class FormAuthenticationStepdef extends FormAuthenticationPage {

	@Then("^enter username as \"([^\"]*)\"$")
	public void enter_username_as(String value) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		//this.getUsername().sendKeys(value);
		this.performAction(this.getUsername(), "settext", value);
	}

	@Then("^enter password as \"([^\"]*)\"$")
	public void enter_password_as(String value) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		this.performAction(this.getPassword(), "settext", value);	
	}
	
	@Then("^click on Login button$")
	public void click_on_Login_button(){
	    // Write code here that turns the phrase above into concrete actions
		this.performAction(this.getLoginButton(), "click", null);
	}
	
	@Then("^click on Logout button$")
	public void click_on_Logout_button(){
	    // Write code here that turns the phrase above into concrete actions
		this.performAction(this.getLogoutButton(), "click", null);
	}

}
