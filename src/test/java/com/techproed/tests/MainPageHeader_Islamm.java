package com.techproed.tests;

import com.techproed.pages.MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;

public class MainPageHeader_Islamm extends TestBase {

    MainPage mainPage;
    Actions actions;

    @Test
    public void tc_001() {
        // CHECK-IN DATE basligini gorur
        mainPage = new MainPage();
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        mainPage.check_in_Date.isDisplayed();
        //    CHECK-IN DATE tarih secimine tiklar
        mainPage.check_in_Date.click();
    }

    @Test
    public void tc_002() {
        //    CHECK-OUT DATE basligini gorur
        mainPage=new MainPage();
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        mainPage.check_out_Date.isDisplayed();
        //    CHECK-OUT DATE tarih secimine tiklar
        mainPage.check_out_Date.click();
    }

    @Test
    public void tc_003() throws InterruptedException {

        //    Check kisminda ROOM basligini gorur
        mainPage=new MainPage();
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                perform();
        mainPage.roomType.isDisplayed();
        //    Room Type dropDown menuye tiklar
        mainPage.roomType.click();
        Thread.sleep(10000);
    }

    @Test
    public void tc_004() {
        //    Check kisminda CUSTOMER basligini gorur
        mainPage=new MainPage();
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                perform();
        mainPage.adultCount.isDisplayed();
        //    Customer dropDown menuye tiklar
        mainPage.adultCount.click();
    }

    @Test
    public void tc_005() {
        //    check-availability linkini gorur
        mainPage=new MainPage();
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        mainPage.checkAvailable.isDisplayed();
        //    Check-Availability linkini tiklar
        mainPage.checkAvailable.click();
    }
}
