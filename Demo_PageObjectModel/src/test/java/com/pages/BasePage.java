	package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BasePage {

	public WebDriver dvr ;
	
	public BasePage(WebDriver dvr) {
		this.dvr = dvr ;
		PageFactory.initElements(dvr, this);
	}
	
}
