package com.techproed.tests;

import com.techproed.pages.HotelListCreation;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HtmlRaporDuzenleme extends TestBase {

    @Test
    public void hotelListPositiveTest() throws InterruptedException {

        extentTest = extentReports.createTest("Smoke", "Dogru datalarla giris yapma");

        Driver.getDriver().get(ConfigReader.getProperty("kr_url"));
        extentTest.info("Koala resort sayfasina gidildi");


        LoginPage loginPage = new LoginPage();
        loginPage.koalaResortLogin();
        extentTest.info("Login yapildi");

       HotelListCreation hotelListCreation = new HotelListCreation();
        hotelListCreation.hotelManangement();
        extentTest.info("Hotel Manangment butonuna tiklandi");
        hotelListCreation.hotelList();
        extentTest.info("Hotel List'e tiklandi");
        hotelListCreation.addHotel.click();
        extentTest.info("Add hotel butonuna tiklandi");

        Actions actions = new Actions(Driver.getDriver());
        actions.click(hotelListCreation.code)
                .sendKeys(ConfigReader.getProperty("kr_code"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("kr_customer_name"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("kr_customer_adress"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("kr_customer_phone"))
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("kr_customer_email"))
                .perform();


        Select select = new Select(hotelListCreation.selectGroup);
        select.selectByVisibleText(ConfigReader.getProperty("kr_dropdown_value"));
        extentTest.info("Dogru datalar girildi");

        Thread.sleep(2000);

        hotelListCreation.saveButton.click();
        extentTest.info("Save butonuna tiklandi");

        Thread.sleep(2000);
        Assert.assertTrue(hotelListCreation.successfullYazisi.isDisplayed());
        extentTest.info("Dogru datalarla basarili giris yapildigi test edildi");
        //  Assert.assertEquals(hotelListCreation.successfullYazisi.getText(),ConfigReader.getProperty("kr_successfull_yazisi"));
        hotelListCreation.OKButtonu.click();
        extentTest.info("OK butonuna tiklandi");


    }
}
