package com.techproed.smoketest;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.pages.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KoalaResortPositifTest {
    MainPage mainPage;
    LoginPage loginPage;
    DefaultPage defaultPage;
    @BeforeMethod
    public void setUp(){
        //        Go to the application URL
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
    }
    @Test
    public void positiveTest(){
        //        Go to the login page
        mainPage=new MainPage();
        mainPage.mainPageLoginLink.click();


//        Send username password click on login button
        loginPage=new LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty("admin_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));
        loginPage.loginButton.click();

//        find a core object in the default login page And verify if the log in successful
//        WebElement addUserButton=Driver.getDriver().findElement(By.xpath("//span[@class='hidden-480']"));
//        Assert.assertTrue(addUserButton.isDisplayed());
        defaultPage=new DefaultPage();
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());

    }

}
