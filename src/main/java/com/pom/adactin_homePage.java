package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adactin_homePage {

	WebDriver driver2;

	public adactin_homePage(WebDriver driver) {
		this.driver2 = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement username_show;

	public WebElement getUsername_show() {
		return username_show;
	}

	@FindBy(id = "location")
	private WebElement location;

	public WebElement getLocation() {
		return location;
	}

	@FindBy(id = "hotels")
	private WebElement hotels;

	public WebElement getHotels() {
		return hotels;
	}

	@FindBy(id = "room_type")
	private WebElement room_type;

	public WebElement getRoom_type() {
		return room_type;
	}

	@FindBy(id = "room_nos")
	private WebElement room_nos;

	public WebElement getRoom_nos() {
		return room_nos;
	}

	@FindBy(id = "datepick_in")
	private WebElement datepick_in;

	public WebElement getDatepick_in() {
		return datepick_in;
	}

	@FindBy(id = "datepick_out")
	private WebElement datepick_out;

	public WebElement getDatepick_out() {
		return datepick_out;
	}

	@FindBy(id = "adult_room")
	private WebElement adult_room;

	public WebElement getAdult_room() {
		return adult_room;
	}

	@FindBy(id = "child_room")
	private WebElement child_room;

	public WebElement getChild_room() {
		return child_room;
	}

	@FindBy(id = "Submit")
	private WebElement Submit;

	public WebElement getSubmit() {
		return Submit;
	}

}
