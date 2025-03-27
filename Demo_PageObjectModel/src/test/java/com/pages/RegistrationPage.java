package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
	public RegistrationPage(WebDriver dvr) {
		super(dvr);
	}
	WebDriverWait wait = new WebDriverWait(dvr,Duration.ofSeconds(10));
	
	@FindBy(xpath=("//div[@class='page-title']/h1"))
	public WebElement registerPageText ;
	public String ExpectedRegisterPagetext = "Register"; 
	
	@FindBy(xpath=("//div[@class='gender'][1]/input"))
	public WebElement male ;
	
    @FindBy(xpath=("//div[@class='gender'][2]/input"))
    public WebElement female ;
    
    @FindBy(xpath=("//div[@class='page-body']/div[2]/div[2]/div[2]/input"))
    public WebElement fname ;
    
    @FindBy(xpath=("//div[@class='page-body']/div[2]/div[2]/div[3]/input"))
    public WebElement lname ;
    
    @FindBy(xpath=("//div[@class='page-body']/div[2]/div[2]/div[4]/input"))
    public WebElement email ;

    @FindBy(xpath=("//div[@class='page-body']/div[3]/div[2]/div[1]/input"))
    public WebElement pwd ;
    
    @FindBy(xpath=("//div[@class='page-body']/div[3]/div[2]/div[2]/input"))
    public WebElement conpwd ;
    
    @FindBy(xpath=("//*[@id='register-button']"))
    public WebElement regbtn ;
    
    @FindBy(xpath=("//div[@class='result']"))
    public WebElement RegComTxt ;
    public String expectedRegisterCompletedText = "Your registration completed" ; 
    
    @FindBy(xpath=("//div[@class='page-body']/div[2]/div[2]/div[4]/span[2]/span"))
    public WebElement emailRequired ;
//    public WebElement emailRequired = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-body']/div[2]/div[2]/div[4]/span[2]/span")));
    
    @FindBy(xpath=("//div[@class='page-body']/div/div/ul/li"))
    public WebElement existingEmail ;
//    public WebElement existingEmail  = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='page-body']/div/div/ul/li")));
    

}
