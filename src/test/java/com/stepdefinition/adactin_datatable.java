package com.stepdefinition;

import io.cucumber.java.en.*;

public class adactin_datatable {
	@Given("user launch the hotel application")
	public void user_launch_the_hotel_application() {
		System.out.println("hi");
	}

	@When("user enter the below data for login")
	public void user_enter_the_below_data_for_login(io.cucumber.datatable.DataTable dataTable) {
	   
	}

	@When("user click login button")
	public void user_click_login_button() {
	   
	}
}
