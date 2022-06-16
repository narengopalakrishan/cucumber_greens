package com.stepdefinition;

import org.junit.Assert;

import com.base.Base_class;
import com.pom.adactin_bookingconfirmationpage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class adactin_bookingconfirmation extends Base_class {
	
	adactin_bookingconfirmationpage page5;
	
	@When("user click on Itinerary button")
	public void user_click_on_itinerary_button() {
	    page5= new adactin_bookingconfirmationpage(driver);
	    page5.getMy_itinerary().click();
	}

	@When("user clicks on logout to exit the application")
	public void user_clicks_on_logout_to_exit_the_application() {
	    page5.getLogout().click();
	    
	}

	@Then("verify user logged out successfully")
	public void verify_user_logged_out_successfully() {
	    boolean displayed = page5.getLogout_message().isDisplayed();
	    Assert.assertEquals(true, displayed);
	}

}
