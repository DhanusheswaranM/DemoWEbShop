package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	public static final ThreadLocal<WebDriver>driver = new ThreadLocal<>();
 
  @BeforeMethod
  public void tearUp() {
	  driver.set(new ChromeDriver());
	  driver.get().manage().window().maximize();
	  driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get().get("https://demowebshop.tricentis.com/");
	  
  }

  @AfterMethod
  public void tearDown() {
	  driver.get().quit();
  }
  public WebDriver getDriver() {
	  return driver.get();
  }
}
