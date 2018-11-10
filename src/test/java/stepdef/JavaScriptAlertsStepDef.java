package stepdef;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.en.*;
import pageobjects.JavaScriptAlertsPage;

public class JavaScriptAlertsStepDef extends JavaScriptAlertsPage {

	@Then("^click on Click for JS Alert button$")
	public void click_on_Click_for_JS_Alert_button() {
		this.performAction(this.getJSAlert(), "click", null);
	}

	@Then("^switch to alert pop up and accept it$")
	public void switch_to_alert_pop_up_and_accept_it() {
		this.performAction(null, "alert", null, "accept");
	}

	@Then("^click on Click for JS Confirm button$")
	public void click_on_Click_for_JS_Confirm_button() {
		this.performAction(this.getJSConfirm(), "click", null);
	}

	@Then("^switch to alert pop up and cancel it$")
	public void switch_to_alert_pop_up_and_cancel_it() {
		this.performAction(null, "alert", null, "cancel");
	}

	@Then("^click on Click for JS Prompt button$")
	public void click_on_Click_for_JS_Prompt_button() {
		this.performAction(this.getJSPrompt(), "click", null);
	}

	@Then("^switch to alert pop up and settext as \"([^\"]*)\" and cancel it$")
	public void switch_to_alert_pop_up_and_settext_as_and_cancel_it(String value) {

		this.performAction(null, "alert", value, "settext");
		this.performAction(null, "alert", null, "cancel");
	}

}
