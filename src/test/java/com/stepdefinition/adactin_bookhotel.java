package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.Base_class;
import com.pom.adactin_bookingconfirmationpage;
import com.pom.adaction_bookhotel;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class adactin_bookhotel extends Base_class {

	adaction_bookhotel page4;
	adactin_bookingconfirmationpage page5;
	Select s;

	@When("user enter the first name")
	public void user_enter_the_first_name() {
		page4 = new adaction_bookhotel(driver);
		page4.getFirst_name().sendKeys("Naren");
	}

	@When("user enter the last name")
	public void user_enter_the_last_name() {
		page4.getLast_name().sendKeys("Gopalakrishnan");
	}

	@When("user enter the address")
	public void user_enter_the_address() {
		page4.getAddress().sendKeys("No: 123, Abcd road, Qwerty nagar, India");
	}

	@When("user enter the credit card number")
	public void user_enter_the_credit_card_number() {
		page4.getCc_num().sendKeys("1234567890987654");
	}

	@When("user enter the credit card type")
	public void user_enter_the_credit_card_type() {
		WebElement cc_type = page4.getCc_type();
		dropdown_singleby_valueortext("value", cc_type, "AMEX");
	}

	@When("user enter the expiry date_month")
	public void user_enter_the_expiry_date_month() {
		WebElement cc_exp_month = page4.getCc_exp_month();
		dropdown_singleby_valueortext("value", cc_exp_month, "6");
	}

	@When("user enter the expiry date_year")
	public void user_enter_the_expiry_date_year() {
		WebElement cc_exp_year = page4.getCc_exp_year();
		dropdown_singleby_valueortext("value", cc_exp_year, "2017");
	}

	@When("user enter the CVV number")
	public void user_enter_the_cvv_number() {
		page4.getCc_cvv().sendKeys("1234");
		
	}

	@When("user click the book button")
	public void user_click_the_book_button() {
		page4.getBook_now().click();
	}

	@Then("verify user moved to booking confirmation page")
	public void user_moved_to_booking_confirmation_page() {
		page5 = new adactin_bookingconfirmationpage(driver);
		boolean displayed = page5.getBooking_confirmation().isDisplayed();
		Assert.assertEquals(true, displayed);
	}
}
