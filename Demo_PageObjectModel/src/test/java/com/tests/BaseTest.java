package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	public static WebDriver dvr ;
 
  @BeforeMethod
  public void tearUp() {
	  dvr = new ChromeDriver();
	  dvr.manage().window().maximize();
	  dvr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  dvr.get("https://demowebshop.tricentis.com/");
	  
  }

  @AfterMethod
  public void tearDown() {
	  dvr.quit();
  }

}
