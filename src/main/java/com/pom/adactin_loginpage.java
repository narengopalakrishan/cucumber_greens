package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adactin_loginpage {

	WebDriver driver1;

	public adactin_loginpage(WebDriver driver) {

		this.driver1 = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	private static WebElement username;

	public static WebElement getUsername() {
		return username;
	}

	@FindBy(id = "password")
	private static WebElement password;

	public static WebElement getPassword() {
		return password;
	}

	@FindBy(id = "login")
	private static WebElement login;

	public static WebElement getLogin() {
		return login;
	}

	@FindBy(xpath = "//b[text()='Invalid Login details or Your Password might have expired. ']")
	private WebElement error_messgae;

	public WebElement getError_messgae() {
		return error_messgae;
	}

}
