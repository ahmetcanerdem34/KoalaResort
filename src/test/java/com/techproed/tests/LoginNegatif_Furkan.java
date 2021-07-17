package com.techproed.tests;

import com.techproed.pages.LoginPage;
import com.techproed.pages.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegatif_Furkan {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();


    @Test
    public void testCase01() {
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
        mainPage.mainPageLoginLink.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("invalid_manager_id"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
        Assert.assertEquals(loginPage.errorMessage2.getText(),ConfigReader.getProperty("invalidLoginErrorMessage"));



    }
    @Test
    public void testCase02() {
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
        mainPage.mainPageLoginLink.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("invalid_manager_pass"));
        loginPage.loginButton.click();
        Assert.assertEquals(loginPage.errorMessage2.getText(),ConfigReader.getProperty("invalidLoginErrorMessage"));



    }

    @Test
    public void testCase03() {
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
        mainPage.mainPageLoginLink.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("invalid_manager_id"));
        loginPage.password.sendKeys(ConfigReader.getProperty("invalid_manager_pass"));
        loginPage.loginButton.click();
        Assert.assertEquals(loginPage.errorMessage2.getText(),ConfigReader.getProperty("invalidLoginErrorMessage"));



    }



}