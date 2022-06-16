package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;

import com.base.Base_class;
import com.helper.fileReaderManager;
import com.pom.adactin_homePage;
import com.pom.adactin_loginpage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class adactin_login extends Base_class {

//	adactin_loginpage page1;
//	adactin_homePage page2;
//	
//@Given("user launch the hotel application")
//public void user_launch_the_hotel_application() throws IOException {
//	String passing_URl = fileReaderManager.getInstance().getCrInstance().Passing_URl();
//	To_load_URL(passing_URl);
//}
//
//@When("user enter the below data for login")
//public void user_enter_the_below_data_for_login(DataTable dataTable) {
//  List<Map<String, String>> asMaps = dataTable.asMaps(String.class,String.class);
//  String username = asMaps.get(0).get("Username");
//  String password = asMaps.get(0).get("Password");
//}
//
//@When("user click login button")
//public void user_click_login_button() {
//	page1.getLogin().click();
//}

	adactin_loginpage page1;
	adactin_homePage page2;

	@Before
	public void beforeHooks(Scenario scenario) {
		String scenario_name = scenario.getName();
		System.out.println("Scenario name:" + scenario_name);
	}

	@After
	public void afterhooks(Scenario scenario) throws IOException {
		Status status = scenario.getStatus();
		System.out.println("Scenario status:" + status);
		if (scenario.isFailed()) {
			takescreenshot("./Screenshot/error.png");
		}
	}

	@Given("User is on correct URL")
	public void user_is_on_correct_url() throws IOException {
		String passing_URl = fileReaderManager.getInstance().getCrInstance().Passing_URl();
		To_load_URL(passing_URl);
	}

	@Then("^Enter (.*) and (.*)$")
	public void enter_id_and_pass(String fullname1, String password1) {
		page1 = new adactin_loginpage(driver);
		page1.getUsername().sendKeys(fullname1);
		page1.getPassword().sendKeys(password1);
	}

	@Then("click login button")
	public void click_login_button() {
		page1.getLogin().click();
	}

	@Then("check user is move to homepage")
	public void check_user_is_move_to_homepage() {
		page2 = new adactin_homePage(driver);
		boolean displayed = page2.getUsername_show().isDisplayed();
		Assert.assertEquals(true, displayed);
	}

	@Then("check user is got error message")
	public void check_user_is_got_error_message() throws IOException {
		String displayed_messgae = page1.getError_messgae().getText();
		Assert.assertEquals(fileReaderManager.getInstance().getCrInstance().expected_error_message(),
				displayed_messgae);
	}

}
