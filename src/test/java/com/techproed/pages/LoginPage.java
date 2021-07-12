package com.techproed.pages;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="UserName")
    public WebElement username;

    @FindBy(id="Password")
    public WebElement password;

    @FindBy(id="btnSubmit")
    public WebElement loginButton;

    @FindBy(id="divMessageResult")
    public WebElement errorMessage;


























    TestBase testBase = new TestBase();
    MainPage mainPage = new MainPage();

    public void koalaResortLogin(){
        testBase.setupMethod();  // Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        mainPage.mainPageLoginLink.click();
        username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        loginButton.click();

    }



}
