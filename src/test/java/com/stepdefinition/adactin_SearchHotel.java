package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.Base_class;
import com.helper.fileReaderManager;
import com.pom.adactin_homePage;
import com.pom.adaction_selecthotelpage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class adactin_SearchHotel extends Base_class {

	adactin_homePage page2;
	adaction_selecthotelpage page3;
	Select s;

	@When("User select location option")
	public void user_select_location_option() throws IOException {
		page2 = new adactin_homePage(driver);
		WebElement location = page2.getLocation();
		dropdown_singleby_valueortext("value", location, fileReaderManager.getInstance().getCrInstance().location());
	}

	@When("User select the hotels")
	public void user_select_the_hotels() throws IOException {
		WebElement hotels = page2.getHotels();
		dropdown_singleby_valueortext("value", hotels, fileReaderManager.getInstance().getCrInstance().hotels());
	}

	@When("User select the room type")
	public void user_select_the_room_type() {
		WebElement room_type = page2.getRoom_type();
		dropdown_singleby_valueortext("value", room_type, "Super Deluxe");
	}

	@When("user select the number of rooms")
	public void user_select_the_number_of_rooms() {
		WebElement room_nos = page2.getRoom_nos();
		dropdown_singleby_valueortext("value", room_nos, "2");
	}

	@When("user select the check in date")
	public void user_select_the_check_in_date() {
		WebElement datepick_in = page2.getDatepick_in();
		datepick_in.clear();
		datepick_in.sendKeys("01/06/2022");

	}

	@When("user select the check out date")
	public void user_select_the_check_out_date() {
		WebElement datepick_out = page2.getDatepick_out();
		datepick_out.clear();
		datepick_out.sendKeys("06/06/2022");
	}

	@When("user select the adults per room")
	public void user_select_the_adults_per_room() {
		WebElement adult_room = page2.getAdult_room();
		dropdown_singleby_valueortext("value", adult_room, "2");
	}

	@When("user select the children per room")
	public void user_select_the_children_per_room() {
		WebElement child_room = page2.getChild_room();
		dropdown_singleby_valueortext("value", child_room, "1");
	}

	@When("user select the click the search button")
	public void user_select_the_click_the_search_button() {
		page2.getSubmit().click();
	}

	@Then("verify user is moved to next select hotel page")
	public void verify_user_is_moved_to_next_select_hotel_page() {
		page3 = new adaction_selecthotelpage(driver);
		boolean displayed = page3.getSelectHotel().isDisplayed();
		Assert.assertEquals(true, displayed);
	}
}
