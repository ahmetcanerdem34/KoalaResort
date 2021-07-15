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

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement manager;


























    TestBase testBase = new TestBase();
    MainPage mainPage = new MainPage();

    public void koalaResortLogin(){
        testBase.setupMethod();  // Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        mainPage.mainPageLoginLink.click();
        username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        loginButton.click();

    }


    public void loginTest() {
        //1-Kullanıcı Koala Resort ana sayfasına gider
//        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
//        //2-Ana sayfada sag ust kosede login butonuna tıklar
//        mainPage.mainPageLoginLink.click();
//        //3-Username text box' a gecerli bir username girer
//        username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
//        //4-Password text box'a gecerli bir password girer
//        password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
//        //5-Login butonuna tıklar
//        loginButton.click();
        testBase.setupMethod();  // Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        mainPage.mainPageLoginLink.click();
        username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        loginButton.click();

    }
    }

















