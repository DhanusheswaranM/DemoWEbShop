package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage extends BasePage{
	public HomePage(WebDriver dvr) {
		super(dvr);
	}
	
	@FindBy(xpath=("//a[contains(text(),'Register')]"))
	public WebElement register ;
	
	@FindBy(xpath=("//div[@class=\"topic-html-content-body\"]//p[1]"))
	public WebElement homePageText ;
	
	String expectedHomePageText = "Welcome to the new Tricentis store!";
	
	public String getHomePageText() {
		return homePageText.getText();
	}
	public String getExpectedHomePageText() {
		return expectedHomePageText ;
	}
}
