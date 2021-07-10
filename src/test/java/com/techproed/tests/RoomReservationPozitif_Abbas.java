package com.techproed.tests;

import com.techproed.pages.DefaultPage;
import com.techproed.pages.LoginPage;
import com.techproed.pages.RoomReservationPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.JSUtils;
import com.techproed.utilities.ReusableMethods;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoomReservationPozitif_Abbas extends TestBase {

    RoomReservationPage roomReservationPage;
    DefaultPage defaultPage;
    LoginPage loginPage;

    @Test(dataProvider = "getData")
    public void positieveRoomReservationCreate (String price,String dateStart,String dateEnd,String adultAmount,
                                                String childrenAmount,String contactNameSurname,String contactPhone,
                                                String contactEmail, String notes) throws InterruptedException {
        extentTest=extentReports.createTest("Smoke", "Gecerli bilgilerle test");
        loginPage= new LoginPage();
        loginPage.koalaResortLogin();
        extentTest.info("KoalaResort Hotel'e login yapildi.");

        defaultPage =new DefaultPage();
        defaultPage.hotelManagement.click();
        defaultPage.roomReservations.click();
        roomReservationPage = new RoomReservationPage(driver);
        roomReservationPage.addRoomReservationButton.click();
        extentTest.info("HotelRoomReservation sayfasina gecis yapildi.");

        WebElement dropDownMenu = roomReservationPage.idUser;

        Select options = new Select(roomReservationPage.idUser);
        options.selectByIndex(1); //Option 1 manager
        System.out.println(options.getFirstSelectedOption().getText());

        Select options2 =new Select(roomReservationPage.idHotelRoom);
        options2.selectByVisibleText(ConfigReader.getProperty("roomreservationpage_select_hotel"));
//        Thread.sleep(1000);

        roomReservationPage.price.sendKeys(price);
        roomReservationPage.dateStart.sendKeys(dateStart);
        roomReservationPage.dateEnd.sendKeys(dateEnd);
        roomReservationPage.adultAmount.sendKeys(adultAmount);
        roomReservationPage.childrenAmount.sendKeys(childrenAmount);
        roomReservationPage.nameAndSurname.sendKeys(contactNameSurname);
        roomReservationPage.contactPhone.sendKeys(contactPhone);
        roomReservationPage.contactEmail.sendKeys(contactEmail);
        roomReservationPage.notes.sendKeys(notes);


        roomReservationPage.approved.click();
        roomReservationPage.isPaid.click();
        //Save button click
        roomReservationPage.saveButton.submit();
        extentTest.info("HotelRoomReservation sayfasinda basarili bir sekilde room reservation olusturuldu");

        //Explicitely Wait for succes message
        ReusableMethods.waitForVisibility(roomReservationPage.actualSuccessMessage,5 );
        //Ok button click
        roomReservationPage.okSuccesButton.click();

        //Assert
        String expectedSuccessMessage =ConfigReader.getProperty("roomreservationpage_expectedSuccessMessage");
        System.out.println(roomReservationPage.actualSuccessMessage.getText());
        System.out.println(ConfigReader.getProperty("roomreservationpage_expectedSuccessMessage"));
        Assert.assertEquals(roomReservationPage.actualSuccessMessage.getText(),expectedSuccessMessage );
        extentTest.info("Basarili bir sekilde room reservation olusturulduguna dair success mesaji alindi");

        //remove buton click with JSExecutor
        //Some elements may not be visible or cannot be easily clicked using selenium click() method
        WebElement clickRemoveButton= roomReservationPage.removeButtonRoomReservationPage;
        ReusableMethods.waitForVisibility(clickRemoveButton,5 );
        JSUtils.clickElementByJS(clickRemoveButton);
        extentTest.info("HotelRoomReservation sayfasi remove edildi, yeni bir bos sayfa gorundu");

    }

    @DataProvider
    public Object[][] getData(){
        String [][] managerProfile= {
                {ConfigReader.getProperty("roomreservationpage_price"),
                        ConfigReader.getProperty("roomreservationpage_dateStart"),
                        ConfigReader.getProperty("roomreservationpage_dateEnd"),
                        ConfigReader.getProperty("roomreservationpage_adultAmount"),
                        ConfigReader.getProperty("roomreservationpage_childrenAmount"),
                        ConfigReader.getProperty("roomreservationpage_contactNameSurname"),
                        ConfigReader.getProperty("roomreservationpage_contactPhone"),
                        ConfigReader.getProperty("roomreservationpage_contactEmail"),
                        ConfigReader.getProperty("roomreservationpage_notes")},
        };
        return managerProfile;
    }
}
