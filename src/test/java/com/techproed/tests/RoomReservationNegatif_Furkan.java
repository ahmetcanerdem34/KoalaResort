package com.techproed.tests;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.pages.MainPage;
import com.techproed.pages.RoomReservationPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RoomReservationNegatif_Furkan {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
    RoomReservationPage roomReservationPage = new RoomReservationPage(Driver.getDriver());




    @Test
    public void testCase13() {
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
        mainPage.mainPageLoginLink.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));
        loginPage.loginButton.click();
        defaultPage.hotelManagement.click();
        defaultPage.roomReservations.click();
        roomReservationPage.addRoomReservationButton.click();
        Select idUser = new Select(roomReservationPage.idUser);
        idUser.selectByVisibleText("manager");
        Select hotelRoom = new Select(roomReservationPage.idHotelRoom);
        hotelRoom.selectByVisibleText("Double with Child Room");
        roomReservationPage.price.sendKeys(("10000"));
        roomReservationPage.dateStart.sendKeys(("09/14/2023"));
        roomReservationPage.dateEnd.sendKeys(("09/15/2023"));
        roomReservationPage.adultAmount.sendKeys(("1"));
        roomReservationPage.childrenAmount.sendKeys(("1"));
        roomReservationPage.nameAndSurname.sendKeys(("furkan"));
        roomReservationPage.contactPhone.sendKeys(("1234567890"));
        roomReservationPage.notes.sendKeys(("hello"));
        roomReservationPage.approved.click();
        roomReservationPage.isPaid.click();
        roomReservationPage.saveButton.click();

        Assert.assertEquals(roomReservationPage.contactEmailErrorMessage.getText(),ConfigReader.getProperty("invalidContactEmail"));





    }

}