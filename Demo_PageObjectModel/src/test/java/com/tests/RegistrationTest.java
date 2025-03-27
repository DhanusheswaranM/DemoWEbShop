package com.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.RegistrationPage;
import com.utilities.TestData;

public class RegistrationTest extends BaseTest {
    
    RegistrationPage objRegistrationPage;
    HomePage objHomePage;

    @BeforeMethod
    public void setUp() {
        objRegistrationPage = new RegistrationPage(dvr);
        objHomePage = new HomePage(dvr);
    }

    @Test(dataProvider = "excelTestData", dataProviderClass = TestData.class) 
    public void registration(String gender, String fname, String lname, String email, String pwd, String confirmPwd) {
        Assert.assertTrue(objHomePage.getHomePageText().contains(objHomePage.getExpectedHomePageText()));
        
        objHomePage.register.click();
        
        Assert.assertTrue(objRegistrationPage.registerPageText.getText().equals(objRegistrationPage.ExpectedRegisterPagetext));

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

        WebDriverWait wait = new WebDriverWait(dvr, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(objRegistrationPage.emailRequired));
            Assert.assertTrue(objRegistrationPage.emailRequired.getText().contains("Email is required."));
            System.out.println(objRegistrationPage.emailRequired.getText());
        } catch (org.openqa.selenium.TimeoutException e) {
            try {
                wait.until(ExpectedConditions.visibilityOf(objRegistrationPage.existingEmail));
                Assert.assertTrue(objRegistrationPage.existingEmail.getText().contains("Email is already registered."));
                System.out.println(objRegistrationPage.existingEmail.getText());
            } catch (org.openqa.selenium.TimeoutException e1) {
                wait.until(ExpectedConditions.visibilityOf(objRegistrationPage.RegComTxt));
                Assert.assertTrue(objRegistrationPage.RegComTxt.getText().equals(objRegistrationPage.expectedRegisterCompletedText));
            }
        }
    }
}