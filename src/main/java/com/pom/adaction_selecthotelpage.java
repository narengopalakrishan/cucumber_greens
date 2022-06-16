package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adaction_selecthotelpage {

	WebDriver driver3;

	public adaction_selecthotelpage(WebDriver driver) {
		this.driver3 = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr//td[text()='Select Hotel ']")
	private WebElement selectHotel;

	public WebElement getSelectHotel() {
		return selectHotel;
	}
	
	@FindBy(id = "radiobutton_0") private WebElement radiobutton;

	public WebElement getRadiobutton() {
		return radiobutton;
	}
	@FindBy(id = "continue") private WebElement continue_button;

	public WebElement getContinue_button() {
		return continue_button;
	}
	
	
	
	
	
	

}
