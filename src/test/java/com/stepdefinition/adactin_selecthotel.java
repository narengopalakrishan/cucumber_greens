package com.stepdefinition;

import org.junit.Assert;

import com.base.Base_class;
import com.pom.adaction_bookhotel;
import com.pom.adaction_selecthotelpage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class adactin_selecthotel extends Base_class {
	
	adaction_selecthotelpage page3;
	adaction_bookhotel page4;

	@When("User click on select radion buttton")
	public void user_click_on_select_radion_buttton() {
	    page3 =  new adaction_selecthotelpage(driver);
	    page3.getRadiobutton().click();
	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {
	    page3.getContinue_button().click();
	    
	}

	@Then("check user is moved to book a hotel page")
	public void check_user_is_moved_to_book_a_hotel_page() {
	    page4 =  new adaction_bookhotel(driver);
	    boolean displayed = page4.getBookHotel().isDisplayed();
	    Assert.assertEquals(true, displayed);
	    
	}
}
