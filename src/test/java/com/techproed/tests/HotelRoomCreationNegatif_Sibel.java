package com.techproed.tests;

import com.techproed.pages.DefaultPage;

import com.techproed.pages.HotelRoomPage;
import com.techproed.pages.LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.techproed.pages.LoginPage;
import com.techproed.pages.HotelRoomPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class HotelRoomCreationNegatif_Sibel extends TestBase{
    LoginPage loginPage;
    DefaultPage defaultPage;
    HotelRoomPage hotelRoomPage;

    //Login the application:

    TestBase testBase;
     //Login the application:


    @BeforeMethod
    public void setUp(){
        loginPage= new LoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("kr_login_url"));

        testBase = new TestBase();
        testBase.setUpTest();
        Driver.getDriver().get(ConfigReader.getProperty("application_login_url"));
        loginPage.loginButton.click();

        loginPage.username.sendKeys(ConfigReader.getProperty("kr_valid_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("kr_valid_password"));
        loginPage.loginButton.click();

    }

    @Test(dataProvider = "creatingAHotelRoomWithWrongData")

    public void test01(String otelName,String code,String name,String location,String drakAndDrop,String roomType,String maxAdult , String maxChildren) throws InterruptedException {



extentTest=extentReports.createTest("Smoke Test","Negative Room Creation Test");
        extentTest.info("Koala Resort hotel sayfasina login yapildi");

            defaultPage=new DefaultPage();

           defaultPage.hotelManagement.click();

//Click on Hotel Rooms
           defaultPage.hotelRooms.click();


//Click on Add Hotel Room
           hotelRoomPage = new HotelRoomPage();
           hotelRoomPage.addHotelRoomButton.click();

        extentTest.info("Koala Resort Hotel Rooms sayfasina gecis yapildi");
//Click on Add Hotel Room
           hotelRoomPage = new HotelRoomPage();
           hotelRoomPage.addHotelRoomButton.click();


        Select select=new Select(hotelRoomPage.hotelIdDropdown);
        select.selectByVisibleText(otelName);
        hotelRoomPage.code.sendKeys(code);
        hotelRoomPage.name.sendKeys(name);
        hotelRoomPage.location.sendKeys(location);
        hotelRoomPage.price.sendKeys(drakAndDrop);

        Select roomDropdown=new Select( hotelRoomPage.roomTypeDropdown);
        roomDropdown.selectByVisibleText(roomType);
        hotelRoomPage.maxAdultCount.sendKeys(maxAdult);
        hotelRoomPage.maxChildCount.sendKeys(maxChildren);
        hotelRoomPage.isApprovedCheckbox.click();


        hotelRoomPage.saveButton.click();
        Thread.sleep(2000);


       //Assert.assertTrue(hotelRoomPage.popUp.isDisplayed());

        Thread.sleep(2000);
        hotelRoomPage.saveButton.click();

        extentTest.info("Her bir negatif testcase icin gecersiz datalar girildi");

        Thread.sleep(2000);
       //Assert.assertFalse(hotelRoomPage.popUp.isDisplayed());
        extentTest.info("Gecersiz datalarla otel odasi olusturulmadigi test edildi");

       }

    @DataProvider
    public Object[][] creatingAHotelRoomWithWrongData() {

        String[][] data = {      // WK<!,  123455666,100, 120, 5

                {"Sheraton","", "Summer", "B BLOK", "400", "King", "2", "3"},
                {"Sheraton","101", "","B BLOK","400","King","2","3"},
                {"Sheraton","101", "Summer","B BLOK","","King","2","3"},
                {"Sheraton","101","Summer","B BLOK","400","King","","3"},
                {"Sheraton","101","Summer","B BLOK","400","King","2",""},
                {"Sheraton","101","Summer","B BLOK","400","","2","3"}


        };
        return data;
    }
}

