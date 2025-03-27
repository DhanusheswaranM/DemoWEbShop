package com.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.HomePage;
import com.pages.RegistrationPage;
import com.utilities.TestData;

public class RegistrationTest extends BaseTest {
    
    RegistrationPage objRegistrationPage;
    HomePage objHomePage;

    @BeforeMethod
    public void setUp() {
        objRegistrationPage = new RegistrationPage(getDriver());
        objHomePage = new HomePage(getDriver());
    }

    @Test(dataProvider = "excelTestData", dataProviderClass = TestData.class) 
    public void registration(String gender, String fname, String lname, String email, String pwd, String confirmPwd) {
       
        
        objHomePage.register.click();
        
        Assert.assertTrue(objRegistrationPage.registerPageText.getText().contains("Register"));

        if (gender.equalsIgnoreCase("male")) {
            objRegistrationPage.male.click();
        } else if (gender.equalsIgnoreCase("female")) {
            objRegistrationPage.female.click();
        }

        objRegistrationPage.fname.sendKeys(fname);
        objRegistrationPage.lname.sendKeys(lname);
        objRegistrationPage.email.sendKeys(email);
        objRegistrationPage.pwd.sendKeys(pwd);
        objRegistrationPage.conpwd.sendKeys(confirmPwd);

        objRegistrationPage.regbtn.click();
        
        SoftAssert soft = new SoftAssert();
        
        soft.assertTrue(driver.get().getPageSource().contains("Your registration completed"));
    }
}