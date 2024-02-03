package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	public WelcomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(id = "small-searchterms")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButton;

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
}
