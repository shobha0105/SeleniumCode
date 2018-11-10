package stepdef;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import pageobjects.HomePage;


public class HomeStepDef extends HomePage {
	@Given("^launch \"([^\"]*)\" browser and url as \"([^\"]*)\"$")
	public void launch_browser_and_url_as(String browser, String url)  {
	    // Write code here that turns the phrase above into concrete actions
		this.launchApplication(browser, url); //(this will call childs method)
		//super.launchApplication(browser, url); //(super will call childs method)
	    
}
	
	@Given("^close application$")
	public void close_application()  {
	    // Write code here that turns the phrase above into concrete actions
	    this.closeApplication(false);
	}
	



@Then("^verify page  by \"([^\"]*)\"   \"([^\"]*)\"$")
public void verify_page(String type, String expected_value)  {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String actual_value=this.getpageDetails(type);
		this.compareValue(actual_value, expected_value);
		
		
	}

	@Then("^verify link count is (\\d+)$")
	public void verify_link_count_is(int expected_value)  {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		int actual_count=this.getCountLinks();
		this.compareValue(actual_count, expected_value);
	}

	@Then("^click on \"([^\"]*)\" link$")
	public void click_on_link(String link_name)  {
	    // Write code here that turns the phrase above into concrete actions
	   //this.clickLink(this.getSingleLink(link_name));
		this.performAction(this.getSingleLink(link_name), "click", null);
	}

}
