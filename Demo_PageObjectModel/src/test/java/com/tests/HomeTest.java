package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.HomePage;

public class HomeTest extends BaseTest {
	HomePage objHomePage ;
	
	@Test
	public void VerifyHomePage() {
		objHomePage = new HomePage(getDriver());
		Assert.assertTrue(objHomePage.getHomePageText().contains(objHomePage.getExpectedHomePageText()));
	}
	
}
