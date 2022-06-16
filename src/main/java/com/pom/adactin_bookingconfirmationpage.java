package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adactin_bookingconfirmationpage {

	WebDriver driver5;
	public adactin_bookingconfirmationpage(WebDriver driver) {
		this.driver5= driver;
		PageFactory.initElements(driver, this);
	}
	 @FindBy(xpath = "//td[text()='Booking Confirmation ']") private WebElement Booking_confirmation;
	public WebElement getBooking_confirmation() {
		return Booking_confirmation;
	}
	 
	@FindBy(id = "my_itinerary") private WebElement my_itinerary;
	@FindBy(id = "logout")private WebElement logout;
	@FindBy(xpath = "//td[text()='Booked Itinerary']") private WebElement BookedItinerary;
	@FindBy(xpath = "//td[text()='You have successfully logged out. ']") private WebElement logout_message;
	public WebElement getMy_itinerary() {
		return my_itinerary;
	}
	public WebElement getBookedItinerary() {
		return BookedItinerary;
	}
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getLogout_message() {
		return logout_message;
	}
}
